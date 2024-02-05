package com.loban.superheroes

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.loban.superheroes.model.Hero
import com.loban.superheroes.model.HeroesRepository
import com.loban.superheroes.ui.theme.SuperheroesTheme


@Composable
fun HeroItems(
    heroes: List<Hero>,
    paddingValues: PaddingValues = PaddingValues(0.dp),
    modifier: Modifier = Modifier
) {
    LazyColumn(contentPadding = paddingValues) {
        items(heroes) {
            HeroItem(hero = it, modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp))
        }
    }
}

@Composable
fun HeroItem(hero: Hero, modifier: Modifier = Modifier) {
    Card(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        ),
        modifier = modifier
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            HeroDescription(
                heroName = hero.nameRes,
                heroDescription = hero.descriptionRes,
                modifier = Modifier.weight(1f)
            )
            Spacer(modifier = Modifier.width(16.dp))
            HeroIcon(heroIcon = hero.imageRes)
        }
    }
}

@Composable
fun HeroDescription(
    @StringRes heroName: Int,
    @StringRes heroDescription: Int,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        Text(text = stringResource(id = heroName), style = MaterialTheme.typography.displaySmall)
        Text(
            text = stringResource(id = heroDescription),
            style = MaterialTheme.typography.bodyLarge
        )
    }

}

@Composable
fun HeroIcon(@DrawableRes heroIcon: Int, modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(id = heroIcon),
        contentDescription = null,
        modifier = Modifier
            .size(72.dp)
            .clip(MaterialTheme.shapes.small),
        contentScale = ContentScale.Crop
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HeroItemsPreview() {
    SuperheroesTheme {
        HeroItems(HeroesRepository.heroes)
    }
}
