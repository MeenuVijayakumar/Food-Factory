package com.applab.foodfactory

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.applab.foodfactory.ui.sila.home.SilaHomeScreen
import com.applab.foodfactory.ui.theme.FoodFactoryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FoodFactoryTheme {
                //HomeScreen()
//                MonthlyDashboard()
                SilaHomeScreen()
            }
        }
    }
}
