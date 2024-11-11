package com.example.weatherapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapp.R
import com.example.weatherapp.ui.theme.Primary

@Preview(showBackground = true)
@Composable
fun HomeScreenUI() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Search City",
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp),
            textAlign = TextAlign.Center,
        )

        SearchBox()
        Cards()
        MoreCitiesButton()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBox() {
    var text by remember { mutableStateOf("") }
    TextField(
        value = text,
        onValueChange = { text = it },
        label = null,
        placeholder = { Text(text = "Search") },
        colors = TextFieldDefaults.textFieldColors(
            containerColor = White,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        modifier = Modifier
            .fillMaxWidth(0.9f)
            .padding(vertical = 8.dp),
        leadingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.search),
                contentDescription = "",
                modifier = Modifier.size(20.dp)
            )
        }
    )
}


@Composable
fun Cards() {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(20.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp), // Spacing between cards
        verticalAlignment = Alignment.Top // Align cards at the top if they're of different heights
    ) {
        CardUI(
            temperature = "30°C",
            city = "BolocBoloc",
            resourceId = R.drawable.ic_weather2,
            humidity = "77%",
            wind = "3 km/h"
        )

        CardUI(
            temperature = "25°C",
            city = "Campangga",
            resourceId = R.drawable.ic_weather2,
            humidity = "45%",
            wind = "4 km/h"
        )
    }
}

@Composable
fun CardUI(temperature: String, city: String, resourceId: Int, humidity: String, wind: String) {
          Card(){
              Box(modifier = Modifier
                  .width(150.dp)
                  .padding(16.dp),
                  contentAlignment = Alignment.TopEnd
              ){
                  Image(painter = painterResource(id = resourceId), contentDescription = "")
              }
              Column(modifier = Modifier.padding(16.dp)) {
                  Text(text = temperature)
                  Text(text = city)

              }

          }
}
fun getTemperatureColor(temperature: String): AnnotatedString.Builder {
    val AnnotatedString = AnnotatedString.Builder(temperature)
        .apply {
            addStyle(
                SpanStyle(
                    fontSize = 19.sp,
                    baselineShift = BaselineShift.Subscript
                ), 2,3
            )
        }
    return AnnotatedString
}
@Composable
fun MoreCitiesButton() {
    Button(
        onClick = { },
        colors = ButtonDefaults.buttonColors(containerColor = Primary),
        contentPadding = PaddingValues(horizontal = 30.dp, vertical = 10.dp),
        modifier = Modifier
            .clip(shape = BottomShape.medium)
            .padding(bottom = 16.dp) // Adjust bottom padding

    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(text = "More Cities", fontSize = 14.sp)
            Spacer(Modifier.width(10.dp))

        }
    }
}


