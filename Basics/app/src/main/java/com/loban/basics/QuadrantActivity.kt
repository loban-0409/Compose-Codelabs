package com.loban.basics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.loban.basics.ui.theme.BasicsTheme

class QuadrantActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    Quadrant()
                }
            }
        }
    }
}

@Composable
fun Quadrant(modifier: Modifier = Modifier) {
    Column {
        Row(modifier = Modifier.weight(1f)) {
            QuadrantBox(
                title = stringResource(id = R.string.first_title),
                content = stringResource(
                    id = R.string.first_content,
                ),
                color = colorResource(id = R.color.first_color),
                modifier = Modifier.weight(1f),
            )
            QuadrantBox(
                title = stringResource(id = R.string.second_title),
                content = stringResource(
                    id = R.string.second_content,
                ),
                color = colorResource(id = R.color.second_color),
                modifier = Modifier.weight(1f),
            )
        }
        Row(modifier = Modifier.weight(1f)) {
            QuadrantBox(
                title = stringResource(id = R.string.third_title),
                content = stringResource(
                    id = R.string.third_content,
                ),
                color = colorResource(id = R.color.third_color),
                modifier = Modifier.weight(1f),
            )
            QuadrantBox(
                title = stringResource(id = R.string.fourth_title),
                content = stringResource(
                    id = R.string.fourth_content,
                ),
                color = colorResource(id = R.color.fourth_color),
                modifier = Modifier.weight(1f),
            )
        }
    }
}

@Composable
fun QuadrantBox(title: String, content: String, color: Color, modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .fillMaxSize()
            .background(color = color)
            .padding(16.dp),
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp),
        )
        Text(text = content, textAlign = TextAlign.Justify)
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun QuadrantPreview() {
    BasicsTheme {
        Quadrant()
    }
}
