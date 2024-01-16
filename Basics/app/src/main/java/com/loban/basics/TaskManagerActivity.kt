package com.loban.basics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.loban.basics.ui.theme.BasicsTheme

class TaskManagerActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    val image = painterResource(id = R.drawable.ic_task_completed)
                    val taskDoneMessage = stringResource(id = R.string.task_done)
                    val taskDoneComplimentMessage = stringResource(id = R.string.task_done_compliment)
                    TaskDoneNotification(image = image, message = taskDoneMessage, compliment = taskDoneComplimentMessage)
                }
            }
        }
    }
}

@Composable
fun TaskDoneNotification(image: Painter, message: String, compliment: String, modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier.fillMaxSize(),
    ) {
        TaskDoneImage(image = image)
        TaskDoneMessage(text = message)
        TaskDoneComplimentMessage(text = compliment)
    }
}

@Composable
fun TaskDoneImage(image: Painter) {
    Image(painter = image, contentDescription = null)
}

@Composable
fun TaskDoneMessage(text: String) {
    Text(text = text, fontWeight = FontWeight.Bold, modifier = Modifier.padding(top = 24.dp, bottom = 8.dp))
}

@Composable
fun TaskDoneComplimentMessage(text: String) {
    Text(text = text, fontSize = 16.sp)
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TaskDoneNotificationPreview() {
    BasicsTheme {
        val image = painterResource(id = R.drawable.ic_task_completed)
        val taskDoneMessage = stringResource(id = R.string.task_done)
        val taskDoneComplimentMessage = stringResource(id = R.string.task_done_compliment)
        TaskDoneNotification(image = image, message = taskDoneMessage, compliment = taskDoneComplimentMessage)
    }
}
