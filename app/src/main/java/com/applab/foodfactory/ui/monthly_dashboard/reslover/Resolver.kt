package com.applab.foodfactory.ui.monthly_dashboard.reslover

import com.applab.shared.monthlydashboard.model.CellMonthlyDashboardItem
import com.applab.shared.monthlydashboard.model.Error
import com.applab.shared.monthlydashboard.model.Loading
import com.applab.shared.monthlydashboard.model.MonthlyDashboardCellState
import com.applab.shared.monthlydashboard.model.Success
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.channelFlow
import kotlinx.coroutines.launch

fun resolveAfdi(
//    okHttpClient: OkHttpClient,
    dashboardCell: CellMonthlyDashboardItem,
    params: Map<String, String>?
): Flow<MonthlyDashboardCellState> = channelFlow {
//    check(dashboardCell is EventCellDefinition)
    launch(Dispatchers.IO) {
        try {
            dashboardCell.cellState = Loading
            delay(3000L)
           /* val stringData = CachedHomeOverviewApi.getHomeOverviewResponse(okHttpClient)
            if (stringData == Nil){
                trySend(Error(Exception("No data")))
                return@launch
            }

            val data = JSONObject(stringData)
            val dataJson = data.optJSONObject(Data)*/
            dashboardCell.cellState = Success
            trySend(dashboardCell.cellState)


        } catch (ex: Exception) {
            dashboardCell.cellState = Error(ex)
            trySend(dashboardCell.cellState)
        }
    }
}
