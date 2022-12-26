package com.imamfrf.counterappcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.imamfrf.counterappcompose.ui.theme.CounterAppComposeTheme

class MainActivity : ComponentActivity() {

    private var count by mutableStateOf(0)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CounterAppComposeTheme {
                MainPage(
                    count = count,
                    addCounter = {
                        count++
                    },
                    resetCounter = {
                        count = 0
                    }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainPage(count: Int = 0, addCounter: () -> Unit = {}, resetCounter: () -> Unit = {}) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceBetween
        ) {

            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 36.dp),
                text = "$count",
                style = TextStyle(fontSize = 30.sp, fontWeight = FontWeight.Bold),
                textAlign = TextAlign.Center
            )

            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                CircleCard {
                    addCounter()
                }

            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 36.dp),
                contentAlignment = Alignment.Center
            ) {
                Button(
                    onClick = { resetCounter() },
                ) {
                    Text(text = "Reset")
                }

            }
        }

    }
}

@Composable
fun CircleCard(onClick: () -> Unit = {}) {
    Card(
        modifier = Modifier
            .size(200.dp)
            .clickable {
                onClick.invoke()
            },
        shape = CircleShape,
        backgroundColor = Color.Gray,
        elevation = 5.dp
    ) {
        Box(contentAlignment = Alignment.Center) {
            Text(
                text = "Tap",
                color = Color.White,
                fontSize = 50.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CounterAppComposeTheme {
        MainPage()
    }
}