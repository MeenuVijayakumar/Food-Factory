package com.applab.foodfactory.ui.sila.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.RoundRect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.compose.LocalLifecycleOwner
import com.applab.foodfactory.ui.sila.components.HomeBottomMenuItem
import com.applab.foodfactory.ui.sila.components.HomePageBanner
import com.applab.foodfactory.ui.sila.components.SearchBar1
import com.applab.foodfactory.ui.sila.components.ServiceItem
import com.applab.foodfactory.ui.sila.model.HomeBottomMenu
import com.applab.foodfactory.ui.theme.HomeBackground1
import com.applab.foodfactory.ui.theme.HomeBackground2
import com.applab.foodfactory.ui.views.fontFamily
import kotlinx.coroutines.delay

suspend fun Abc() {
    delay(100L)
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SilaHomeScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize()

    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(350.dp)
                    .background(
                        brush = Brush.linearGradient(
                            listOf(
                                HomeBackground1, HomeBackground1, HomeBackground2
                            )
                        )
                    )
            ) { }
            Column(
                modifier = Modifier
                    .safeDrawingPadding()
                    .padding(top = 20.dp),
            ) {
                val pagerState = rememberPagerState { 5 }
                var searchText by remember { mutableStateOf("") }
                HorizontalPager(
                    state = pagerState,
                    pageSpacing = 10.dp,
                    contentPadding = PaddingValues(horizontal = 20.dp)
                ) {
                    HomePageBanner()
                }
                Spacer(
                    Modifier.height(20.dp)

                )
                Text("pager indicator here...", color = Color.White)
                Spacer(
                    Modifier.height(20.dp)

                )
                var boxSize by remember { mutableStateOf(IntSize.Zero) }
                Box {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(color = Color.Transparent)
                            .padding(top = 20.dp)
                            .onGloballyPositioned {
                                boxSize = it.size
                            }
                            .drawBehind {
                                val cornerRadius = CornerRadius(50f, 50f)
                                val path = Path().apply {
                                    addRoundRect(
                                        RoundRect(
                                            rect = Rect(
                                                offset = Offset(0f, 0f),
                                                size = Size(size.width, size.height)
                                            ),
                                            topLeft = cornerRadius,
                                            topRight = cornerRadius,
                                        )
                                    )
                                }
                                drawPath(path, Color.LightGray)
                            }

                    ) {
                        LaunchedEffect(Unit) {
                            Abc()
                        }

                    }
                    Column(modifier = Modifier.fillMaxSize()) {
                        SearchBar1(
                            Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 20.dp)
                                .background(color = Color.White, shape = CircleShape),
                            "Where to go?"
                        )
                        Spacer(Modifier.height(10.dp))
                        Text(
                            "Transport Services",
                            modifier = Modifier.padding(horizontal = 14.dp),
                            fontFamily = fontFamily,
                        )
                        LazyHorizontalGrid(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(color = Color.White),
                            contentPadding = PaddingValues(horizontal = 10.dp),
                            rows = GridCells.Fixed(2),
                            horizontalArrangement = Arrangement.spacedBy(10.dp),
                            verticalArrangement = Arrangement.spacedBy(10.dp)

                        ) {
                            items(7) {
                                ServiceItem()
                            }

                        }
                    }

                }


            }
        }
        BottomAppBar(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.White),
            contentPadding = PaddingValues(horizontal = 0.dp),
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                HomeBottomMenu.entries.forEach {
                    HomeBottomMenuItem(it) {

                    }
                }
            }

        }


    }
}

@Preview
@Composable
private fun PreviewSilaHomeScreen() {
    SilaHomeScreen()
}