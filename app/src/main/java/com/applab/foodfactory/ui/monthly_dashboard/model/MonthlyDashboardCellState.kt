package com.applab.shared.monthlydashboard.model

sealed class MonthlyDashboardCellState
data object Loading:MonthlyDashboardCellState()
data object Idle:MonthlyDashboardCellState()
data object Success:MonthlyDashboardCellState()
data class Error(val ex:Exception):MonthlyDashboardCellState()