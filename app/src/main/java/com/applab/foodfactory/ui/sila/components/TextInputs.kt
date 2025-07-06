package com.applab.foodfactory.ui.sila.components

import android.graphics.drawable.shapes.RoundRectShape
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.applab.foodfactory.ui.views.fontFamily

@Composable
fun SearchBar(modifier: Modifier = Modifier, placeHolder: String) {
    var searchInput by remember { mutableStateOf("") }
    TextField(value = searchInput, onValueChange = { searchInput = it }, placeholder = {
        Text(placeHolder, fontFamily = fontFamily, fontSize = 12.sp)
    }, modifier = Modifier
        .padding(16.dp)
        .fillMaxWidth()
        .border(1.dp, Color.LightGray, CircleShape),
        shape = CircleShape,
        textStyle = TextStyle(
            color = Color.Black,
            fontSize = 12.sp,
        ), maxLines = 1, singleLine = true, leadingIcon = {
            Icon(Icons.Default.Search, contentDescription = "search")
        }
    )
}

@Composable
fun SearchBar1(modifier: Modifier = Modifier, placeHolder: String) {
    var searchInput by remember { mutableStateOf("") }
    BasicTextField(
        value = searchInput,
        onValueChange = { searchInput = it },
        decorationBox = { innerTextField ->
            Box(
                modifier = modifier.background(shape = CircleShape, color = Color.White)
                    .border(1.dp, Color.LightGray, CircleShape)
            ) {
                Row(
                    modifier = Modifier.padding(10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(Icons.Default.Search, contentDescription = "search")
                    if (searchInput.isEmpty())
                        Text(text = placeHolder, fontFamily = fontFamily, color = Color.LightGray)
                    innerTextField()
                }
            }
        }
    )
}

@Preview(showBackground = false)
@Composable
private fun PreviewSearchBar() {
    SearchBar1(Modifier, "Search")
}