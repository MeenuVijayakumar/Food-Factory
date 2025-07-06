package com.applab.foodfactory.ui.monthly_dashboard.overview

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.applab.foodfactory.ui.monthly_dashboard.components.MetricCell
import com.applab.foodfactory.ui.monthly_dashboard.model.monthlyDashboardCellDefinitions

@Composable
fun OverviewScreen(modifier: Modifier = Modifier) {

    Column(modifier = Modifier.fillMaxSize()) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            verticalArrangement = Arrangement.spacedBy(4.dp),
            horizontalArrangement = Arrangement.spacedBy(4.dp), modifier = Modifier.fillMaxSize()
        ) {

            items(monthlyDashboardCellDefinitions, key = { it.viewType }) {
                MetricCell(it)
            }
        }
    }
}

@Preview
@Composable
private fun PreviewOverviewScreen() {
    OverviewScreen()
}