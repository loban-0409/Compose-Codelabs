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
                    val complimentMessage = stringResource(id = R.string.task_done_compliment)

                    TaskDoneNotification(
                        image = image,
                        taskDoneMessage = taskDoneMessage,
                        taskDoneComplimentMessage = complimentMessage,
                    )
                }
            }
        }
    }
}

@Composable
fun TaskDoneNotification(
    image: Painter,
    taskDoneMessage: String,
    taskDoneComplimentMessage: String,
    modifier: Modifier = Modifier,
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        TaskDoneImage(image = image)
        TaskDoneText(text = taskDoneMessage)
        TaskDoneComplimentText(text = taskDoneComplimentMessage)
    }
}

@Composable
fun TaskDoneImage(image: Painter) {
    Image(
        painter = image,
        contentDescription = null,
    )
}

@Composable
fun TaskDoneText(text: String) {
    Text(
        text = text,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(top = 24.dp, bottom = 8.dp),
    )
}

@Composable
fun TaskDoneComplimentText(text: String) {
    Text(
        text = text,
        fontSize = 16.sp,
    )
}

@Preview(showSystemUi = true)
@Composable
fun TaskDoneNotificationPreview() {
    BasicsTheme {
        val image = painterResource(id = R.drawable.ic_task_completed)
        val taskDoneMessage = stringResource(id = R.string.task_done)
        val taskDoneComplimentMessage = stringResource(id = R.string.task_done_compliment)

        TaskDoneNotification(
            image = image,
            taskDoneMessage = taskDoneMessage,
            taskDoneComplimentMessage = taskDoneComplimentMessage,
        )
    }
}
