package com.applab.foodfactory.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.applab.foodfactory.R

@Composable
fun DashBoardScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 40.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                modifier = Modifier.background(
                    shape = RoundedCornerShape(50.dp),
                    color = Color.Unspecified
                ),
                painter = painterResource(R.drawable.ic_pass),
                contentDescription = "profileimage",
            )
            Image(
                painter = painterResource(R.drawable.ic_pass),
                contentDescription = "profileimage"
            )
        }

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {

            Column {
                Text("Welcome Rajesh", modifier = Modifier.padding(horizontal = 20.dp))
                Text("How is it going today?", modifier = Modifier.padding(horizontal = 20.dp))
                Spacer(
                    modifier = Modifier
                        .height(20.dp)
                )
                Button(onClick = {}, modifier = Modifier.padding(start = 20.dp)) {
                    Text("Urgent care", modifier = Modifier.padding(horizontal = 20.dp))

                }
            }
            Column {
                Image(
                    modifier = Modifier.size(180.dp),
                    painter = painterResource(R.drawable.image),
                    contentDescription = "doctorimage"
                )
            }

        }

        Text(
            "Our Services",
            modifier = Modifier.padding(start = 20.dp),
            fontWeight = FontWeight.Bold
        )
        LazyRow {
            items(list) {
                ServiceItem(it)
            }
        }
    }
}

@Composable
fun ServiceItem(item: Service) {

    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            modifier = Modifier.background(
                shape = RoundedCornerShape(50.dp),
                color = Color.Unspecified
            ),
            painter = painterResource(item.image),
            contentDescription = "profileimage",
        )
        Text(item.name)
    }

}

val list = arrayListOf<Service>().apply {
    add(Service(1, "Consultation", R.drawable.ic_email))
    add(Service(2, "Medicine", R.drawable.ic_email))
    add(Service(1, "Ambulance", R.drawable.ic_email))
}

data class Service(
    var id: Int,
    var name: String,
    var image: Int
)

@Preview
@Composable
private fun PrevDashBoard() {
    DashBoardScreen()
}