package com.loban.diceroller

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.loban.diceroller.ui.theme.DiceRollerTheme

class LemonadeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiceRollerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    LemonadeRecipe()
                }
            }
        }
    }
}

@Composable
fun LemonadeRecipe() {
    var order by remember { mutableIntStateOf(1) }

    val imageResource = when (order) {
        1 -> R.drawable.lemon_tree
        2 -> R.drawable.lemon_squeeze
        3 -> R.drawable.lemon_drink
        else -> R.drawable.lemon_restart
    }

    val imageDescriptionResource = when (order) {
        1 -> R.string.lemonade_first_step_description
        2 -> R.string.lemonade_second_step_description
        3 -> R.string.lemonade_third_step_description
        else -> R.string.lemonade_fourth_step
    }

    val descriptionResource = when (order) {
        1 -> R.string.lemonade_first_step
        2 -> R.string.lemonade_second_step
        3 -> R.string.lemonade_third_step
        else -> R.string.lemonade_fourth_step
    }

    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painter = painterResource(id = imageResource),
            contentDescription = stringResource(id = imageDescriptionResource),
            modifier = Modifier
                .requiredSize(200.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(color = colorResource(id = R.color.lemonade_image_background))
                .clickable {
                    if (order == 4) {
                        order = 1
                        return@clickable
                    }
                    order++
                },
        )
        Spacer(modifier = Modifier.size(16.dp))
        Text(
            text = stringResource(id = descriptionResource),
            fontSize = 16.sp,
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun LemonadeRecipePreview() {
    DiceRollerTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background,
        ) {
            LemonadeRecipe()
        }
    }
}
