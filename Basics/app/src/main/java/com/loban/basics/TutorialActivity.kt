package com.loban.basics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.loban.basics.ui.theme.BasicsTheme

class TutorialActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    val image = painterResource(id = R.drawable.bg_compose_background)
                    val title = stringResource(id = R.string.tutorial_title)
                    val firstContent = stringResource(id = R.string.tutorial_first_content)
                    val secondContent = stringResource(id = R.string.tutorial_second_content)
                    Tutorial(
                        background = image,
                        title = title,
                        firstContent = firstContent,
                        secondContent = secondContent,
                    )
                }
            }
        }
    }
}

@Composable
fun BackgroundImage(image: Painter) {
    Image(
        painter = image,
        contentDescription = null,
    )
}

@Composable
fun TitleText(text: String) {
    Text(
        text = text,
        fontSize = 24.sp,
        modifier = Modifier
            .padding(16.dp),
    )
}

@Composable
fun FirstContentText(text: String) {
    Text(
        text = text,
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp),
        textAlign = TextAlign.Justify,
    )
}

@Composable
fun SecondContentText(text: String) {
    Text(
        text = text,
        modifier = Modifier.padding(16.dp),
        textAlign = TextAlign.Justify,
    )
}

@Composable
fun Tutorial(
    background: Painter,
    title: String,
    firstContent: String,
    secondContent: String,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier) {
        BackgroundImage(image = background)
        TitleText(text = title)
        FirstContentText(text = firstContent)
        SecondContentText(text = secondContent)
    }
}

@Preview(showSystemUi = true)
@Composable
fun TutorialPreview() {
    BasicsTheme {
        val image = painterResource(id = R.drawable.bg_compose_background)
        val title = stringResource(id = R.string.tutorial_title)
        val firstContent = stringResource(id = R.string.tutorial_first_content)
        val secondContent = stringResource(id = R.string.tutorial_second_content)
        Tutorial(
            background = image,
            title = title,
            firstContent = firstContent,
            secondContent = secondContent,
        )
    }
}
