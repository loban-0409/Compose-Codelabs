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
fun Quadrant() {
    Column {
        Row(modifier = Modifier.weight(1F)) {
            QuadrantBox(
                title = stringResource(id = R.string.fourth_quadrant_title),
                content = stringResource(id = R.string.fourth_quadrant_content),
                backgroundColor = colorResource(id = R.color.color1),
                modifier = Modifier.weight(1F).fillMaxSize(),
            )
            QuadrantBox(
                title = stringResource(id = R.string.first_quadrant_title),
                content = stringResource(id = R.string.first_quadrant_content),
                backgroundColor = colorResource(id = R.color.color2),
                modifier = Modifier.weight(1F).fillMaxSize(),
            )
        }

        Row(modifier = Modifier.weight(1F)) {
            QuadrantBox(
                title = stringResource(id = R.string.third_quadrant_title),
                content = stringResource(id = R.string.third_quadrant_content),
                backgroundColor = colorResource(id = R.color.color3),
                modifier = Modifier.weight(1F).fillMaxSize(),

            )
            QuadrantBox(
                title = stringResource(id = R.string.second_quadrant_title),
                content = stringResource(id = R.string.second_quadrant_content),
                backgroundColor = colorResource(id = R.color.color4),
                modifier = Modifier.weight(1F).fillMaxSize(),
            )
        }
    }
}

@Composable
fun QuadrantBox(
    title: String,
    content: String,
    backgroundColor: Color,
    modifier: Modifier = Modifier,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .background(backgroundColor)
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

@Preview(showSystemUi = true)
@Composable
fun QuadrantBoxPreview() {
    QuadrantBox(
        title = stringResource(id = R.string.first_quadrant_title),
        content = stringResource(id = R.string.first_quadrant_content),
        backgroundColor = colorResource(id = R.color.color1),
    )
}
