package com.applab.foodfactory.presentation

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.applab.foodfactory.domain.LoginResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun LoginScreen(viewModel: LoginViewModel) {
    val email by remember { viewModel.email }
    val password by remember { viewModel.password }
    val loginState by viewModel.loginState.collectAsState()
    var userInfo by remember { mutableStateOf(LoginResponse("", "", "")) }
    val coroutineScope = rememberCoroutineScope()
    var counter by remember { mutableIntStateOf(0) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = email,
            onValueChange = { viewModel.email.value = it },
            label = { Text("Email") })
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = password,
            onValueChange = { viewModel.password.value = it },
            label = { Text("Password") })
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { coroutineScope.launch(Dispatchers.IO) { viewModel.login()  }}) {
            Text("Login")
        }
        Button(onClick = {counter++}) {
            Text("Increment Counter")
        }
        SideEffect {
            Log.e("LoginScreen___", "LoginScreen___$counter ", )
        }
        Spacer(Modifier.height(40.dp))
        if (userInfo.username.isNotBlank())
            Text("Welcome, ${userInfo.username}", color = Color.Green)
        Text("Counter is $counter",color = Color.Green)

    }

    DisposableEffect(loginState) {
        val scope = CoroutineScope(Dispatchers.Default)
        val job = scope.launch {
            while (true) {
                delay(10)
                counter += 1
                Log.e("","Timer is still working ${counter}")
            }
        }

        if (loginState is LoginUiState.Success){
            job.cancel()
        }




        onDispose { job.cancel() }

    }
    val showButton by remember {
        derivedStateOf {
            counter > 0
        }
    }
    produceState(1) {
        viewModel.login()
        value = 10
    }

    when (loginState) {
        LoginUiState.Loading -> Text("Loading...", color = Color.Gray)
        is LoginUiState.Success -> {
            userInfo = (loginState as LoginUiState.Success).user
        }

        is LoginUiState.Error -> Text(
            "Error: ${(loginState as LoginUiState.Error).message}",
            color = Color.Red
        )

        LoginUiState.Idle -> {}
        else -> {}
    }



}

@Preview
@Composable
private fun LoginPreview() {
    LoginScreen(viewModel())
}