package com.loban.diceroller

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class LemonadeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {


        }
    }
}

@Composable
fun LemonadeImageAndText(modifier: Modifier = Modifier) {
    var result by remember { mutableIntStateOf(1) }
    var (imageResource, stringResource, contentResource) = when (result) {
        1 -> Triple(R.drawable.lemon_tree, R.string.select_lemon, R.string.lemon_tree)
        2 -> Triple(R.drawable.lemon_squeeze, R.string.squeeze_lemon, R.string.lemon_squeeze)
        3 -> Triple(R.drawable.lemon_drink, R.string.drink_lemonade, R.string.lemon_drink)
        else -> Triple(R.drawable.lemon_restart, R.string.start_again, R.string.lemon_restart)
    }
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Button(
            onClick = { result = if(result == 3) 0 else result + 1 },
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(id = R.color.lemon_background),
                disabledContainerColor = colorResource(id = R.color.lemon_background_disabled)
            ),
            shape = RoundedCornerShape(30.dp),
        ) {
            Image(
                painter = painterResource(id = imageResource),
                contentDescription = stringResource(id = contentResource),
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = stringResource(id = stringResource), fontSize = 18.sp)
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LemonadePreview() {
    LemonadeImageAndText(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    )
}
