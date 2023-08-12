package com.ks.virtualchatmate.authorization

import android.content.Intent
import android.widget.Toast
import androidx.activity.compose.ManagedActivityResultLauncher
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.ks.virtualchatmate.R
import com.ks.virtualchatmate.navigation.Screen
import com.ks.virtualchatmate.ui.theme.TurquoiseColor
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

@Composable
fun AuthorizationScreen(
    navController: NavHostController
) {
    var user by remember { mutableStateOf(Firebase.auth.currentUser) }
    val token = stringResource(R.string.default_web_client_id)
    val errorMessage = stringResource(R.string.default_error_message)
    val context = LocalContext.current
    val launcher = rememberFirebaseAuthLauncher(
        onAuthComplete = { result ->
            user = result.user
            navController.navigate(route = Screen.Chat.route)
        },
        onAuthError = {
            user = null
            Toast.makeText(context, errorMessage, Toast.LENGTH_LONG).show()
        }
    )
    val googleSignInOptions = remember {
        GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(token)
            .requestEmail()
            .build()
    }

    AuthorizationContent(
        onAuthButtonClick = {
            val googleSignInClient = GoogleSignIn.getClient(context, googleSignInOptions)
            launcher.launch(googleSignInClient.signInIntent)
        }
    )
}

@Composable
private fun AuthorizationContent(
    onAuthButtonClick: () -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        AuthWithGoogleButton(
            modifier = Modifier
                .padding(horizontal = 24.dp, vertical = 24.dp)
                .align(Alignment.BottomCenter),
            onClick = onAuthButtonClick,
        )
    }
}

@Composable
private fun AuthWithGoogleButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    Row(
        modifier = modifier.height(56.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Button(
            onClick = onClick,
            colors = ButtonDefaults.buttonColors(containerColor = TurquoiseColor)
        ) {
            Image(
                modifier = Modifier.padding(horizontal = 6.dp, vertical = 10.dp),
                painter = painterResource(id = R.drawable.ic_google),
                contentDescription = null
            )
            Text(stringResource(id = R.string.continue_with_google))
        }
    }
}

@Composable
private fun rememberFirebaseAuthLauncher(
    onAuthComplete: (AuthResult) -> Unit,
    onAuthError: (Throwable) -> Unit
): ManagedActivityResultLauncher<Intent, ActivityResult> {
    val scope = rememberCoroutineScope()
    return rememberLauncherForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
        scope.launch {
            try {
                val account = task.getResult(ApiException::class.java)!!
                val credential = GoogleAuthProvider.getCredential(account.idToken!!, null)
                val authResult = Firebase.auth.signInWithCredential(credential).await()
                onAuthComplete(authResult)
            } catch (exception: Throwable) {
                onAuthError(exception)
            } catch (cancellationException: CancellationException) {
                throw cancellationException
            }
        }
    }
}

@Preview
@Composable
private fun AuthorizationContent_Preview() {
    AuthorizationContent(
        onAuthButtonClick = { },
    )
}