package com.applab.foodfactory.ui.sila.components

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.applab.foodfactory.R
import com.applab.foodfactory.ui.sila.model.HomeBottomMenu
import com.applab.foodfactory.ui.views.fontFamily


@Composable
fun HomePageBanner(modifier: Modifier = Modifier) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = MaterialTheme.colorScheme.primary, shape = RoundedCornerShape(6.dp)
            )
            .height(160.dp), verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(start = 20.dp)
        ) {
            Text(
                "Doha Metro",
                fontFamily = fontFamily,
                fontWeight = FontWeight.SemiBold,
                color = Color.White, style = TextStyle(fontSize = 14.sp)
            )
            Text(
                "Ramadan Timings",
                fontFamily = fontFamily,
                fontWeight = FontWeight.SemiBold,
                color = Color.Blue
            )
            Text(
                "8 am to 1 am",
                fontFamily = fontFamily,
                fontWeight = FontWeight.SemiBold,
                color = Color.White
            )
            Spacer(Modifier.height(4.dp))
            Row(
                modifier = Modifier
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(14.dp)
                    )
                    .padding(horizontal = 6.dp, vertical = 2.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Spacer(Modifier.width(6.dp))
                Text("View details", fontSize = 10.sp, fontFamily = fontFamily)
                Icon(
                    modifier = Modifier
                        .size(20.dp)
                        .padding(4.dp),
                    imageVector = Icons.AutoMirrored.Default.ArrowForward,
                    contentDescription = "forward arrow"
                )
            }


        }
        Image(
            modifier = Modifier.height(160.dp),
            painter = painterResource(R.drawable.image_home_banner),
            contentDescription = "banner image"
        )
    }
}

@Composable
fun HomeBottomMenuItem(
    menu: HomeBottomMenu,
    onMenuItemClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.clickable { onMenuItemClick() }) {
        Image(imageVector = menu.icon, contentDescription = "")
        Spacer(Modifier.height(2.dp))
        Text(menu.label, fontFamily = fontFamily)
    }
}

@Composable
fun ServiceItem(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .wrapContentSize()
            .background(color = Color.Blue, shape = CircleShape)
            .padding(6.dp)
    ) {
        Row {
            Icon(painter = painterResource(R.drawable.ic_pass), contentDescription = "services")
        }
    }
}


@Preview
@Composable
private fun PreviewServiceItem() {
    ServiceItem()
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun PreviewHomeBanner() {
    HomePageBanner()
}

@Preview(showBackground = true)
@Composable
private fun PreviewMenu() {
    HomeBottomMenuItem(menu = HomeBottomMenu.Account) {}
}