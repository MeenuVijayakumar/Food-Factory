package com.applab.foodfactory.ui.sila.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector

enum class HomeBottomMenu(val route: String, val icon: ImageVector, val label: String) {
    Home("home", Icons.Default.Home, "Home"),
    Explore("explore", Icons.Default.Search, "Explore"),
    Account("account", Icons.Default.Person, "Account"),
    Notification("notification", Icons.Default.Notifications, "Notification")
}