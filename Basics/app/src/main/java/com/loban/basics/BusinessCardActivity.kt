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
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
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
                }
            }
        }
    }
}

@Composable
fun BusinessCard() {
    BusinessCardHeadLine()
    BusinessCardInfo()
}

@Composable
fun BusinessCardHeadLine(modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Image(
            painter = painterResource(id = R.drawable.android_logo),
            contentDescription = null,
            modifier = modifier
                .height(120.dp)
                .width(120.dp)
                .background(color = colorResource(id = R.color.logo_background)),
        )
        Text(
            text = stringResource(id = R.string.business_card_name),
            fontSize = 40.sp,
            fontWeight = FontWeight.Light,
        )
        Text(
            text = stringResource(id = R.string.business_card_job),
            fontSize = 15.sp,
            modifier = Modifier.padding(top = 12.dp),
            fontWeight = FontWeight.Bold,
            color = colorResource(
                id = R.color.business_card_color,
            ),
        )
    }
}

@Composable
fun BusinessCardInfo(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(bottom = 40.dp),
    ) {
        BusinessCardInfoItem(
            Icons.Filled.Call,
            stringResource(id = R.string.business_card_phone_number),
        )
        Spacer(modifier = Modifier.height(16.dp))
        BusinessCardInfoItem(Icons.Filled.Share, stringResource(id = R.string.business_card_insta))
        Spacer(modifier = Modifier.height(16.dp))
        BusinessCardInfoItem(
            icon = Icons.Filled.Email,
            text = stringResource(id = R.string.business_card_email),
        )
    }
}

@Composable
fun BusinessCardInfoItem(icon: ImageVector, text: String, modifier: Modifier = Modifier) {
    Row(modifier = Modifier.width(240.dp)) {
        Icon(
            icon,
            contentDescription = null,
            tint = colorResource(id = R.color.business_card_color),
        )
        Spacer(modifier = Modifier.width(24.dp))
        Text(text = text, fontSize = 15.sp, modifier = Modifier.align(Alignment.CenterVertically))
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun BusinessCardPreview() {
    BasicsTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = colorResource(id = R.color.business_card_background),
        ) {
            BusinessCard()
        }
    }
}
