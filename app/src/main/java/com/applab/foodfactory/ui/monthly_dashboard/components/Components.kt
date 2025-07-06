package com.applab.foodfactory.ui.monthly_dashboard.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.applab.foodfactory.R
import com.applab.foodfactory.ui.monthly_dashboard.model.monthlyDashboardCellDefinitions
import com.applab.foodfactory.ui.views.fontFamily
import com.applab.shared.monthlydashboard.model.CellMonthlyDashboardItem

@Composable
fun MetricCell(item:CellMonthlyDashboardItem) {
    val density = LocalDensity.current.density
    var padding by remember { mutableStateOf(0.dp) }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .background(color = colorResource(R.color.white), shape = RoundedCornerShape(4.dp))
            .padding(10.dp),
        contentAlignment = Alignment.Center
    ) {
        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            Text(
                item.title?:"",
                modifier = Modifier.weight(1f),
                fontWeight = FontWeight.SemiBold,
                fontFamily = fontFamily,
                onTextLayout = {
                    val lineCount = it.lineCount
                    val height = (it.size.height / density).dp

                    println("lineCount: $lineCount, Height: $height")
                    padding = if (lineCount > 1) 0.dp else height
                }
            )
            Column {
                Text("115/70", fontFamily = fontFamily)
                Spacer(modifier = Modifier.height(6.dp))
                Text("164.29%", fontFamily = fontFamily, color = Color.Green)
            }
        }
    }
}

@Preview
@Composable
private fun PreviewMetricCell() {
    MetricCell(monthlyDashboardCellDefinitions[0])
}