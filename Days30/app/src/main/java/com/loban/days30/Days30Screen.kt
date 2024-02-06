package com.loban.days30

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.loban.days30.data.ArtworkRepository
import com.loban.days30.model.Artwork
import com.loban.days30.ui.theme.Days30Theme

@Composable
fun ArtWorkList(
    artworks: List<Artwork>,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp),
) {
    LazyColumn(contentPadding = contentPadding) {
        items(artworks) {
            ArtWorkCard(
                artwork = it,
                modifier = modifier
                    .padding(
                        horizontal = 16.dp,
                        vertical = 16.dp,
                    ),
            )
        }
    }
}

@Composable
fun ArtWorkCard(artwork: Artwork, modifier: Modifier = Modifier) {
    var expanded by remember { mutableStateOf(false) }

    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        modifier = modifier
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioNoBouncy,
                    stiffness = Spring.StiffnessMedium,
                ),
            )
            .fillMaxWidth(),

    ) {
        Column {
            Row(
                modifier = Modifier
                    .padding(
                        top = 8.dp,
                        start = 8.dp,
                        end = 8.dp,
                        bottom = 4.dp,
                    ),
            ) {
                Text(text = "day${artwork.day} ")
                Text(
                    text = stringResource(id = artwork.description),
                    style = MaterialTheme.typography.bodyLarge,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                )
            }

            Image(
                painter = painterResource(id = artwork.image),
                contentDescription = stringResource(id = artwork.detail),
                modifier = Modifier
                    .clickable { expanded = !expanded }
                    .padding(horizontal = 8.dp, vertical = 8.dp)
                    .clip(RoundedCornerShape(8.dp)),
            )

            if (expanded) {
                Text(
                    text = stringResource(id = artwork.detail),
                    modifier = Modifier
                        .padding(
                            top = 8.dp,
                            start = 16.dp,
                            end = 16.dp,
                            bottom = 16.dp,
                        ),
                )
            }
        }
    }
}

@Preview
@Composable
fun ArtWorkCardPreview() {
    Days30Theme {
        ArtWorkCard(
            artwork = ArtworkRepository.artworks.last(),
        )
    }
}
