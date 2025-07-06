package com.applab.foodfactory.ui.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.applab.foodfactory.R
import com.applab.foodfactory.ui.theme.LightGray
import com.applab.foodfactory.ui.theme.Primary

@Composable
fun AppTabLayout(
    modifier: Modifier = Modifier,
    menuList: ArrayList<TabMenus> = arrayListOf(),
    onTabClick: (TabMenus) -> Unit
) {

    TabLayoutItem(modifier = modifier,
        tabTitles = menuList,
        onTabSelected = {
            onTabClick(it)
        })
}

@Composable
fun TabLayoutItem(
    bgColor: Color = LightGray,
    selectedColor: Color = White,
    unSelectedTextColor: Color = Gray,
    selectedTextColor: Color = Primary,
    modifier: Modifier = Modifier,
    tabTitles: List<TabMenus>,
    onTabSelected: (TabMenus) -> Unit
) {
    var rememberSelectedTab by remember { mutableIntStateOf(0) }
    ScrollableTabRow(
        edgePadding = 4.dp,
        selectedTabIndex = rememberSelectedTab,
        modifier = modifier
            .fillMaxWidth(),
        containerColor = bgColor,
        indicator = {
            Box(
                modifier = Modifier
                    .tabIndicatorOffset(it[rememberSelectedTab])
                    .fillMaxSize().padding(vertical = 4.dp)
                    .background(color = selectedColor, RoundedCornerShape(6.dp))

            )
        }, divider = {}
    ) {
        tabTitles.forEachIndexed { index, item ->
            Tab(
                selected = rememberSelectedTab == index,
                onClick = {
                    rememberSelectedTab = index
                    onTabSelected(item)
                }, modifier = Modifier
                    .padding(horizontal = 14.dp, vertical = 4.dp)
                    .wrapContentSize()
                    .zIndex(1f)
            ) {
                /*Text(
                    modifier = Modifier.padding(vertical = 8.dp, horizontal = 22.dp),
                    text = item.title,
                    color = if (rememberSelectedTab == index) selectedTextColor else unSelectedTextColor,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold, fontFamily = fontFamily
                )*/

                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        /*.clip(RoundedCornerShape(10.dp))
                        .border(
                            border = BorderStroke(
                                width =if (rememberSelectedTab == index) 0.1.dp else 0.dp,
                                color = if (rememberSelectedTab == index) Primary else Gray
                            ),
                            shape = RoundedCornerShape(10.dp)
                        )*/
                        .fillMaxSize()
                ) {
                    item.icon?.let {
                        LoadIcon(
                            modifier = Modifier.size(24.dp),
                            painter = it,
                            tint = if (rememberSelectedTab == index) Primary else Gray,
                        )
                    }

                    Spacer(Modifier.width(8.dp))
                    Text(
                        modifier = Modifier.padding(vertical = 8.dp),
                        text = item.title,
                        color = if (rememberSelectedTab == index) selectedTextColor else unSelectedTextColor,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold, fontFamily = fontFamily
                    )
                }
            }
        }
    }
}

data class TabMenus(
    val title: String,
    val id: Int,
    var icon: Int? = null
)

@Composable
fun LoadIcon(
    modifier: Modifier = Modifier,
    painter: Int = R.drawable.ic_launcher_background,
    desc: String = "bb", tint:Color=Color.Unspecified
) {
    Icon(
        modifier = modifier,
        painter = painterResource(id = painter),
        tint = tint,
        contentDescription = desc
    )
}
val fontFamily = FontFamily(
    Font(R.font.brando_arabic_regular, FontWeight.Light),
    Font(R.font.brando_arabic_semibold, FontWeight.SemiBold),
)