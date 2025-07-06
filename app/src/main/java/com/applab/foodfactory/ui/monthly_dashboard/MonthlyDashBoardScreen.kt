package com.applab.foodfactory.ui.monthly_dashboard

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.applab.foodfactory.R
import com.applab.foodfactory.ui.monthly_dashboard.isr.ISRScreen
import com.applab.foodfactory.ui.monthly_dashboard.overview.OverviewScreen
import com.applab.foodfactory.ui.views.AppTabLayout
import com.applab.foodfactory.ui.views.TabMenus

@Composable
fun MonthlyDashboard(modifier: Modifier = Modifier) {
    val monthlyDashBoardTabList = arrayListOf(
        TabMenus("Overview", 1, R.drawable.ic_email),
        TabMenus("Investor &\nStakeholder\nRelations", 2, R.drawable.ic_pass),
        TabMenus("Marketing & Communications", 3, R.drawable.ic_email),
        TabMenus("Research & Policy", 4, R.drawable.ic_email),
        TabMenus("Strategy & Incentives", 5),
        TabMenus("Gateway", 6),
        TabMenus("Legal", 7, R.drawable.ic_pass),
        TabMenus("Projects", 7),
    )
    var selectedState by rememberSaveable { mutableIntStateOf(1) }
    Column(Modifier.fillMaxSize()) {
        AppTabLayout(
            Modifier.padding(top = 33.dp),
            monthlyDashBoardTabList,
            onTabClick = { tabSelected ->
                selectedState = tabSelected.id
            })
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 12.dp)
        ) {
            when (selectedState) {
                1 -> OverviewScreen()
                2 -> ISRScreen()
                else-> BlankScreen()
            }

        }
    }
}

@Preview
@Composable
private fun PrevMonthlyDashBoard() {
    MonthlyDashboard()
}