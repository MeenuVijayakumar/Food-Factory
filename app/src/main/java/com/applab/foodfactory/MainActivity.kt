package com.applab.foodfactory

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.viewmodel.compose.viewModel
import com.applab.foodfactory.presentation.DashBoardScreen
import com.applab.foodfactory.presentation.LoginScreen
import com.applab.foodfactory.presentation.LoginViewModel
import com.applab.foodfactory.ui.sila.home.SilaHomeScreen
import com.applab.foodfactory.ui.theme.FoodFactoryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val vm: LoginViewModel = viewModel()
            FoodFactoryTheme {
                //HomeScreen()
//                MonthlyDashboard()
//                SilaHomeScreen()
//                LoginScreen(vm)
                DashBoardScreen()
            }
        }
    }
}
