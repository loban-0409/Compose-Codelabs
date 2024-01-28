package com.example.tiptime

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tiptime.ui.theme.TipTimeTheme

class ArtSpaceActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TipTimeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                }
            }
        }
    }
}

@Composable
fun ArtSpace(modifier: Modifier = Modifier) {
    var artNumber by remember { mutableIntStateOf(0) }
    val artPictures = listOf(R.drawable.image1, R.drawable.image2, R.drawable.image3)
    val artTitles = listOf(R.string.image1_title, R.string.image2_title, R.string.image3_title)
    val artPainters =
        listOf(R.string.image1_painter, R.string.image2_painter, R.string.image3_painter)
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier.fillMaxSize()
    ) {
        Spacer(modifier = Modifier.weight(1f))
        ArtWall(picture = artPictures[artNumber])
        Spacer(modifier = Modifier.weight(1f))
        ArtInfo(title = artTitles[artNumber], painter = artPainters[artNumber])
        Spacer(modifier = Modifier.weight(1f))
        ArtSelectButton(
            previousClick = { artNumber = if (artNumber == 0) 0 else artNumber - 1 },
            nextClick = { artNumber = if (artNumber == 2) 2 else artNumber + 1 }
        )
        Spacer(modifier = Modifier.weight(1f))
    }
}

@Composable
fun ArtWall(modifier: Modifier = Modifier, @DrawableRes picture: Int) {
    Card(
        modifier = modifier
            .wrapContentWidth(),
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
        ),
        shape = RoundedCornerShape(0.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Image(
            painter = painterResource(id = picture),
            contentDescription = null,
            modifier = Modifier
                .size(300.dp, 360.dp)
                .padding(28.dp),
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun ArtInfo(modifier: Modifier = Modifier, @StringRes title: Int, @StringRes painter: Int) {
    Column(
        modifier = Modifier
            .width(300.dp)
            .wrapContentHeight()
            .background(color = Color.LightGray)
    ) {
        Text(
            text = stringResource(id = title),
            fontSize = 22.sp,
            fontWeight = FontWeight.Light,
            modifier = Modifier.padding(top = 16.dp, start = 10.dp, end = 10.dp)
        )
        Text(
            text = stringResource(id = painter),
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp, start = 10.dp, end = 10.dp)
        )
    }
}

@Composable
fun ArtSelectButton(
    previousClick: () -> Unit,
    nextClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.Bottom,
        modifier = modifier
    ) {
        Button(
            onClick = previousClick,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Gray,
                disabledContainerColor = Color.DarkGray,
            ),
            modifier = Modifier.width(120.dp)
        ) {
            Text(text = stringResource(id = R.string.previous), fontSize = 16.sp)
        }
        Spacer(modifier = Modifier.width(20.dp))
        Button(
            onClick = nextClick,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Gray,
                disabledContainerColor = Color.DarkGray,
            ),
            modifier = Modifier.width(120.dp)
        ) {
            Text(text = stringResource(id = R.string.next), fontSize = 16.sp)
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ArtSpacePreview() {
    TipTimeTheme {
        ArtSpace()
    }
}
