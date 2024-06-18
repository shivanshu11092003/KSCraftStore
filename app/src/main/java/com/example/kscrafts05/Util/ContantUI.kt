package com.example.kscrafts05.Util

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kscrafts05.R


@Preview
    @Composable
    fun CircularLoader(modifier: Modifier = Modifier) {
        val strokeWidth = 4.dp
        Column(modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {

            CircularProgressIndicator(
                modifier = Modifier
                    .drawBehind {
                        drawCircle(
                            Color.Black,
                            radius = (size.width / 2 - strokeWidth.toPx() / 2),
                            style = Stroke(strokeWidth.toPx())
                        )


                    }
                    .background(Color.White),
                color = Color.Black,
                strokeWidth = strokeWidth,

            )
        }
    }

    @Composable
    fun nodata(modifier: Modifier = Modifier) {
        Column(modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
            verticalArrangement = Arrangement.Center) {
            Image(painter = painterResource(id = R.drawable.nodata), contentDescription ="Nodata"
                , alignment = Alignment.TopCenter
            )

        }


    }
