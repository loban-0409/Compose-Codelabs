package com.loban.basics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.loban.basics.ui.theme.BasicsTheme

class BusinessCardActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = colorResource(id = R.color.business_card_background),
                ) {
                    HeadLine(
                        profileImage = painterResource(id = R.drawable.android_logo),
                        name = "Sang Hyun Moon",
                        position = "Android developer",
                    )
                    Contact()
                }
            }
        }
    }
}

@Composable
fun HeadLine(profileImage: Painter, name: String, position: String, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(16.dp),
    ) {
        Image(
            painter = profileImage,
            contentDescription = null,
            modifier = Modifier
                .size(100.dp)
                .background(color = colorResource(id = R.color.business_card_profile_image_background)),
        )
        Text(
            text = name,
            fontSize = 40.sp,
            fontWeight = FontWeight.Light,
        )
        Text(
            text = position,
            color = colorResource(id = R.color.business_card_position),
            fontWeight = FontWeight.Bold,
        )
    }
}

@Composable
fun Contact() {
    Column(
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        ContactContent(
            icon = Icons.Filled.Call,
            content = "+82 10-0000-0000",
        )
        ContactContent(
            icon = Icons.Filled.Share,
            content = "@AndroidDev",
        )
        ContactContent(
            icon = Icons.Filled.Email,
            content = "no1msh1217@gmail.com",
        )
        Spacer(modifier = Modifier.size(40.dp))
    }
}

@Composable
fun ContactContent(icon: ImageVector, content: String, modifier: Modifier = Modifier) {
    Row(modifier.padding(4.dp).width(240.dp)) {
        Icon(
            icon,
            contentDescription = null,
            tint = colorResource(id = R.color.business_card_position),
        )
        Spacer(modifier = Modifier.width(20.dp))
        Text(text = content)
    }
}

@Preview(showSystemUi = true)
@Composable
fun HeadLinePreview() {
    BasicsTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = colorResource(id = R.color.business_card_background),
        ) {
            HeadLine(
                profileImage = painterResource(id = R.drawable.android_logo),
                name = "Sang Hyun",
                position = "Android developer",
            )
            Contact()
        }
    }
}
