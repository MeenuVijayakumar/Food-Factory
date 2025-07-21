package com.applab.foodfactory.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.applab.foodfactory.domain.LoginResponse
import com.applab.foodfactory.ui.views.fontFamily
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun LoginScreen(viewModel: LoginViewModel) {
    val email by remember { viewModel.email }
    val password by remember { viewModel.password }
    val loginState by viewModel.loginState.collectAsState()
    var userInfo by remember { mutableStateOf(LoginResponse("", "", "")) }
    val coroutineScope = rememberCoroutineScope()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.sweepGradient(
                    colors = listOf(
                        Color.DarkGray,
                        Color.Blue,
                        Color.Green
                    ),
                )
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(60.dp))
        Text(
            "Hello Sign in!",
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            fontFamily = fontFamily,
            fontWeight = FontWeight.Bold,
            style = TextStyle(fontSize = 24.sp, color = Color.White),
            textAlign = TextAlign.Start
        )
        Spacer(modifier = Modifier.height(60.dp))

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)
                )
                .padding(20.dp), contentAlignment = Alignment.Center
        ) {

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
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
                Button(
                    modifier = Modifier.background(
                        brush = Brush.sweepGradient(
                            colors = listOf(
                                Color.Green,
                                Color.Blue
                            )
                        )
                    ), onClick = { coroutineScope.launch(Dispatchers.IO) { viewModel.login() } }) {
                    Text("Login")
                }
                Spacer(Modifier.height(40.dp))
            }

        }

        if (userInfo.username.isNotBlank())
            Text("Welcome, ${userInfo.username}", color = Color.Green)

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