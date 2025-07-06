package com.applab.shared.monthlydashboard.model

import kotlinx.coroutines.flow.Flow

interface CellMonthlyDashboardItem {
    var title:String?
    var cellTypeIdentifier:String?
    var viewType:Int
    val resolver:((/*httpClient:OkHttpClient,*/cellDate:CellMonthlyDashboardItem,params:Map<String,String>?)->Flow<MonthlyDashboardCellState>)?
    var cellState:MonthlyDashboardCellState
}