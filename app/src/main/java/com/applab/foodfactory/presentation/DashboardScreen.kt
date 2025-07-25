package com.applab.foodfactory.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.produceState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.applab.foodfactory.practices.User
import com.applab.foodfactory.ui.theme.LocalTheme

@Composable
fun DashboardScreen(viewModel: DashboardViewModel = viewModel()) {
    Column(modifier = Modifier.fillMaxSize()) {
        val searchText by viewModel.searchQuery.collectAsState()
        val searchResults by viewModel.resultForSearch.collectAsState()
        val productList by viewModel.userList.collectAsState()


        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp),
            value = searchText,
            onValueChange = { viewModel.updateSearchQuery(it) },
            label = { Text("Search") })

        Spacer(modifier = Modifier.height(40.dp))

        if (searchResults.isNotEmpty())
            LazyColumn {
                items(searchResults) {
                    Text(it)
                }
            } else Text("No data")
        Text("Combine Example", style = TextStyle(color = LocalTheme.current.textColor))

        LazyColumn {
            items(productList) {
                Text("${it.name}'s price is ${it.price} for ${it.quantity}items")
            }
        }

    }
}

@Preview
@Composable
private fun PreviewDashBoard() {
    DashboardScreen()
}