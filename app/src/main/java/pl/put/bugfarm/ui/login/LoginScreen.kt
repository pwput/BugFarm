package pl.put.bugfarm.ui.login

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import pl.put.bugfarm.ui.theme.BugfarmTheme

@Composable
fun LoginScreen(
    viewModel: LoginViewModel = hiltViewModel(),
    onLogInClick: () -> Unit,
    onSignUpClick: () -> Unit
) {
    val focusManager = LocalFocusManager.current
    Surface(modifier = Modifier
        .fillMaxSize()
        .clickable(
            indication = null,
            interactionSource = remember { MutableInteractionSource() }
        ) { focusManager.clearFocus() }) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.surface)
                .wrapContentSize(Alignment.Center)
                .padding(16.dp)


        ) {
            if (viewModel.isLogged.value){
                Log.d("signed IN","signed")
                LaunchedEffect(Unit) {
                    onLogInClick()
                }

            }
            val loginTextState = remember { mutableStateOf(TextFieldValue(text = "11")) }
            val passwordTextState = remember { mutableStateOf(TextFieldValue(text = "1111")) }
            val message = remember { mutableStateOf("") }
            val modif = Modifier
                .padding(16.dp)
                .align(Alignment.CenterHorizontally)
            Text(
                text = message.value, modifier = Modifier
                    .padding(8.dp)
                    .align(Alignment.CenterHorizontally), color = Color.Red
            )
            TextField(
                modifier = modif,
                value = loginTextState.value,
                onValueChange = { loginTextState.value = it },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions(onDone = { focusManager.clearFocus() }),
                label = { Text(text = "login") },
                singleLine = true,
            )
            TextField(
                modifier = modif,
                value = passwordTextState.value,
                onValueChange = { passwordTextState.value = it },
                label = { Text(text = "password") },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions(onDone = { focusManager.clearFocus() }),
                singleLine = true,
                visualTransformation = PasswordVisualTransformation()
            )
            TextButton(onClick = {
                viewModel.validateUser(loginTextState.value.text,passwordTextState.value.text)
            }, modifier = modif) {
                Text(text = "Login")
            }
            OutlinedButton(onClick = {onSignUpClick()}) {
                Text(text = "SignUp")
            }

        }
    }

}

@Preview(showSystemUi = true)
@Composable
fun LoginScreenPreview(){
    BugfarmTheme() {
        LoginScreen(onLogInClick = { }) {
        }
    }
}