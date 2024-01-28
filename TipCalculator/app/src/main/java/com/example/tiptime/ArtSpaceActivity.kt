package com.example.tiptime

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
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
                    color = MaterialTheme.colorScheme.background,
                ) {
                    ArtLayout("Android")
                }
            }
        }
    }
}

@Composable
fun ArtLayout(name: String, modifier: Modifier = Modifier) {
    var currentIndex by remember { mutableIntStateOf(1) }
    val currentArtwork = when (currentIndex) {
        1 -> R.drawable.first_artwork
        2 -> R.drawable.second_artwork
        else -> R.drawable.thrid_artwork
    }

    val currentArtworkTitle = when (currentIndex) {
        1 -> R.string.first_artwork_title
        2 -> R.string.second_artwork_title
        else -> R.string.third_artwork_title
    }

    val currentArtworkArtist = when (currentIndex) {
        1 -> R.string.first_artwork_artist
        2 -> R.string.second_artwork_artist
        else -> R.string.third_artwork_artist
    }

    Column(
        modifier = modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(
            modifier = Modifier.weight(1F),
        )
        ElevatedCard(elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)) {
            Image(
                painter = painterResource(id = currentArtwork),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier.fillMaxWidth().aspectRatio(1.0f).padding(20.dp),
            )
        }
        Spacer(
            modifier = Modifier.weight(1F),
        )
        ArtworkDescription(
            title = stringResource(id = currentArtworkTitle),
            artist = stringResource(id = currentArtworkArtist),
        )
        Spacer(
            modifier = Modifier.height(20.dp),
        )
        ButtonBox(
            previousOnClick = {
                currentIndex = (currentIndex - 1).coerceAtLeast(1)
            },
            nextOnClick = {
                currentIndex = (currentIndex + 1).coerceAtMost(3)
            },
        )
    }
}

@Composable
fun ArtworkDescription(title: String, artist: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.LightGray)
            .padding(16.dp),
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
        )
        Text(text = artist)
    }
}

@Composable
fun ButtonBox(previousOnClick: () -> Unit, nextOnClick: () -> Unit) {
    Row {
        Button(
            onClick = previousOnClick,
            modifier = Modifier.weight(1F)
                .padding(4.dp),
        ) {
            Text(text = "Previous")
        }
        Button(
            onClick = nextOnClick,
            modifier = Modifier.weight(1F).padding(4.dp),
        ) {
            Text(text = "Next")
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun ArtLayoutPreview() {
    ArtLayout(name = "")
}
