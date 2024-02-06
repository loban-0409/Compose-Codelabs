package com.loban.days30

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
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
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.loban.days30.model.Character
import com.loban.days30.model.CharacterRepository
import com.loban.days30.ui.theme.Days30Theme


@Composable
fun Days30App() {
    Scaffold(
        topBar = {
            Days30TopAppbar()
        }
    ) { it ->
        DayItems(characters = CharacterRepository.characters, paddingValues = it)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Days30TopAppbar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(title = {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(R.string.app_name),
                style = MaterialTheme.typography.displayLarge
            )
        }
    }, modifier = modifier)
}

@Composable
fun DayItems(
    characters: List<Character>,
    paddingValues: PaddingValues,
    modifier: Modifier = Modifier
) {
    LazyColumn(contentPadding = paddingValues) {
        items(characters) {
            DayCharacterItem(
                character = it,
                modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp)
            )
        }
    }
}

@Composable
fun DayCharacterItem(character: Character, modifier: Modifier = Modifier) {
    var expanded by remember {
        mutableStateOf(false)
    }
    Card(modifier = modifier) {
        Column {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                DayCount(day = character.day, modifier = Modifier.padding(bottom = 16.dp))
                DayCharacterName(name = character.name, modifier = Modifier.padding(bottom = 8.dp))
                DayCharacterImageButton(image = character.image, onClick = { expanded = !expanded })
            }
            if (expanded) {
                DayCharacterDialog(
                    dialog = character.dialog,
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp)
                )
            }
        }
    }
}

@Composable
fun DayCount(day: Int, modifier: Modifier = Modifier) {
    Text(
        stringResource(id = R.string.day_count, day),
        style = MaterialTheme.typography.displaySmall,
        modifier = modifier,
    )
}

@Composable
fun DayCharacterName(@StringRes name: Int, modifier: Modifier = Modifier) {
    Text(
        stringResource(id = name),
        style = MaterialTheme.typography.displayMedium,
        modifier = modifier
    )
}


@Composable
fun DayCharacterImageButton(
    @DrawableRes image: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Image(
        painter = painterResource(id = image),
        contentDescription = null,
        modifier = Modifier
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(5.dp))
            .clickable { onClick() },
        contentScale = ContentScale.Crop,
    )
}

@Composable
fun DayCharacterDialog(@StringRes dialog: Int, modifier: Modifier = Modifier) {
    Text(
        text = stringResource(id = dialog),
        style = MaterialTheme.typography.bodyLarge,
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun Days30ScreenPreview() {
    Days30Theme {
        Days30App()
    }
}
