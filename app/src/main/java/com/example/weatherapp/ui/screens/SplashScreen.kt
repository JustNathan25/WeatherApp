package com.example.weatherapp.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.weatherapp.R
import com.example.weatherapp.ui.theme.Primary
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CardDefaults
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.ImageLoader
import androidx.navigation.NavController
import coil.decode.GifDecoder
import com.example.weatherapp.ui.theme.back


object BottomShape {
    val medium = RoundedCornerShape(16.dp) // Example shape
}


@Composable
fun SplashScreenUI(navController: NavHostController) {
    val annotatedString = AnnotatedString.Builder("Find your weather prediction in your City")
        .apply {
            addStyle(
                style = SpanStyle(
                    color = Primary, // Use imported Primary color
                    fontSize = 30.sp // Use imported sp unit
                ),
                start = 0, // Use named argument for start
                end = 4 // Use named argument for end
            )
        }
        .toAnnotatedString() // Convert to AnnotatedString

    // Use a Column to arrange the UI components vertically
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 40.dp),
        verticalArrangement = Arrangement.Center, // Center vertically
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Display the animated image
        Image(
            painter = rememberAsyncImagePainter(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(R.drawable.img3)
                    .build(),
                imageLoader = ImageLoader.Builder(LocalContext.current)
                    .components {
                        add(GifDecoder.Factory())
                    }
                    .build()
            ),
            contentDescription = "Animated GIF",
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 80.dp) // Adjust top padding
        )

        // Add the card with text and button

        Card(

            modifier = Modifier
                .clip(shape = BottomShape.medium)
                .fillMaxWidth()
                .height(350.dp)
                .shadow(elevation = 0.dp, shape = BottomShape.medium),
            // Set background color of the Card to match the background (Primary color)
            colors = CardDefaults.cardColors(containerColor = back)
        ) {

            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Spacer(modifier = Modifier.height(86.dp))
                Text(
                    text = annotatedString,
                    fontSize = 28.sp,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Easy steps to predict the weather",
                    fontSize = 13.sp,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Button to navigate
                Button(
                    onClick = { navController.navigate("home") },
                    colors = ButtonDefaults.buttonColors(containerColor = Primary),
                    contentPadding = PaddingValues(horizontal = 30.dp, vertical = 10.dp),
                    modifier = Modifier
                        .clip(shape = BottomShape.medium)
                        .padding(bottom = 16.dp) // Adjust bottom padding
                ) {
                    Text(text = "Get Started", fontSize = 15.sp)
                }
            }
        }
    }

}

