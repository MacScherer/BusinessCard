package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = colorResource(R.color.background_app)
                ) {
                    CenterElementData()
                    //BottomElementData()
                    BottomElementData()
                }
            }
        }
    }
}

@Composable
fun CenterElementCard(
    imagePainter: Painter, nameString: String, titleString: String, modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(colorResource(R.color.background_app)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painter = imagePainter,
            contentDescription = null,
            modifier = modifier
                .size(150.dp)
                .background(
                    colorResource(R.color.android_background),
                )
        )
        Text(text = nameString, fontSize = 35.sp)
        Text(
            text = titleString,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            color = colorResource(
                R.color.title
            )
        )
    }
}

@Composable
fun CenterElementData() {
    CenterElementCard(
        imagePainter = painterResource(R.drawable.android_logo),
        nameString = stringResource(R.string.vinicius_scherer),
        titleString = stringResource(R.string.android_developer_extraordinaire)
    )
}

@Composable
fun BottomElementCard(
    imagePainter: Painter, textInfo: String, modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .then(Modifier.fillMaxWidth())
            .padding(8.dp)
    ) {
        Row(
            modifier = modifier
                .padding(8.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                painter = imagePainter,
                contentDescription = null,
                tint = colorResource(R.color.icon)
            )
            Text(text = textInfo, fontSize = 16.sp)
        }
    }
}

@Composable
fun BottomElementData() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 50.dp),
        verticalArrangement = Arrangement.Bottom
    ) {
        BottomElementCard(
            imagePainter = painterResource(R.drawable.baseline_phone_24), textInfo = stringResource(
                R.string.vinicius_scherer
            )
        )
        BottomElementCard(
            imagePainter = painterResource(R.drawable.baseline_share_24), textInfo = stringResource(
                R.string.macscherer
            )
        )
        BottomElementCard(
            imagePainter = painterResource(R.drawable.baseline_mail_24), textInfo = stringResource(
                R.string.vscherer86_gmail_com
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CenterElementPreview() {
    BusinessCardTheme {
        CenterElementData()
    }
}

@Preview(showBackground = true)
@Composable
fun BotTomElementPreview() {
    BusinessCardTheme {
        BottomElementData()
    }
}

