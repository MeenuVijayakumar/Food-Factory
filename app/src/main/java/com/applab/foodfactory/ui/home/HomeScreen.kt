package com.applab.foodfactory.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxSize()) {
        var counter by rememberSaveable { mutableIntStateOf(0) }
        val viewModel: HomeVm = viewModel()
        StatelessCounter(counter) { counter++ }
        CheckList(
            list = viewModel.listItems,
            onChecked = { isCheck, checkedItem -> viewModel.onCheckItem(checkedItem, isCheck) },
            onClose = { item -> viewModel.removeDummyItem(item) }

        )
    }
}

//state hoisting
@Composable
fun StatelessCounter(counter: Int, onCounterClicked: () -> Unit) {
    Text(text = "count increased by $counter")
    Button(
        modifier = Modifier.wrapContentSize(),
        onClick = { onCounterClicked() },
        enabled = counter < 10
    ) {
        Text("Click me")
    }
}

@Composable
fun CheckList(
    list: List<DummyItem>,
    onChecked: (Boolean, DummyItem) -> Unit,
    onClose: (DummyItem) -> Unit
) {
    LazyColumn {
        items(list, key = { item -> item.id }) { item ->
            CheckListItem(
                label = item.label,
                isChecked = item.checked,
                modifier = Modifier,
                onClose = { onClose(item) },
                onChanged = { checked -> onChecked(checked, item) }
            )
        }
    }
}

@Composable
fun CheckListItem(
    label: String,
    isChecked: Boolean,
    modifier: Modifier = Modifier,
    onClose: () -> Unit,
    onChanged: (Boolean) -> Unit
) {
    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        Text(
            text = label, modifier = Modifier
                .weight(1f)
                .padding(start = 16.dp)
        )
        Checkbox(checked = isChecked, onCheckedChange = { c -> onChanged(c) })
        IconButton(onClick = onClose) {
            Icon(Icons.Filled.Close, "close")
        }
    }

}

@Preview
@Composable
private fun PrevCheckListItem() {
    CheckListItem("Hi there", true, onClose = {}) {}
}