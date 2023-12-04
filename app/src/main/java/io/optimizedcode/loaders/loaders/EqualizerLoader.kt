package io.optimizedcode.loaders.loaders

/*
**************************************************************
 * www.optimizedcode.io
 * Kotlin
 *
 * @author ehtisham
 * @package com.feature.weather.ui.navigation.screen
 * @date 08-Oct-2023
 * @copyright 2023 Optimized code (https://www.optimizedcode.io)
 * @license Open source
 ***************************************************************
 */

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.StartOffset
import androidx.compose.animation.core.StartOffsetType
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.optimizedcode.loaders.R
import kotlin.random.Random

private const val INITIAL_VALUE = 0.1f
private const val MIN = 0.7f
private const val MAX = 1f
private const val DELAY_MIN = 100
private const val DELAY_MAX = 1800


//private val colorArray =
//    arrayListOf(R.color.color1, R.color.color2, R.color.color3, R.color.color4, R.color.color5)

fun getRandomColor(index: Int, lastColor: Int, colorArray: ArrayList<Int>): Int {
    return if (index >= colorArray.size) {
        var color = colorArray[(0 until colorArray.size).random()]
        while (lastColor == color) {
            colorArray.shuffle()
            color = colorArray[(0 until colorArray.size).random()]
        }
        color
    } else {
        colorArray[index]
    }
}

@Preview
@Composable
fun EqualizerLoader(
    bars: Int = 6,
    height: Int = 60,
    width: Int = 100,
    colors: ArrayList<Int> = arrayListOf(R.color.color1, R.color.color2, R.color.color3, R.color.color4, R.color.color5)
) {
    Row(
        modifier = Modifier
            .width(width.dp)
            .height(height.dp),
        verticalAlignment = Alignment.Bottom
    ) {

        val sizeOfEachBar = 1f / bars
        var lastColor = R.color.color1

        for (i in 1..bars) {
            lastColor = getRandomColor(i, lastColor, colors)
            Bar(
                modifier = Modifier,
                background = colorResource(id = lastColor),
                height = (MIN + Random.nextFloat() * (MAX - MIN)), // on scale of 0 to 1
                delay = (DELAY_MIN..DELAY_MAX).random(),
                width = sizeOfEachBar, // on scale of 0 to 1
                maxHeight = height.toFloat(),
                maxWidth = width.toFloat()
            )
        }
    }
}

//@Preview
@Composable
fun Bar(
    modifier: Modifier = Modifier,
    background: Color = Color.Red,
    delay: Int = 100,
    height: Float = 0.8f, // on scale of 0 to 1
    width: Float = .10f, // on scale of 0 to 1
    maxHeight: Float = 100f,
    maxWidth: Float = 60f
) {
    var calculateHeight = (height * maxHeight)
    if (height !in 0f..1f) {
        calculateHeight = maxHeight
    }

    var calculateWidth = width * maxWidth
    if (width !in 0f..1f) {
        calculateWidth = maxWidth
    }

    val infiniteTransition = rememberInfiniteTransition(label = "Bar")
    val floatAnimation by infiniteTransition.animateFloat(
        initialValue = INITIAL_VALUE,
        targetValue = height,
        animationSpec = infiniteRepeatable(
            animation = tween(),
            repeatMode = RepeatMode.Reverse,
            initialStartOffset = StartOffset(offsetMillis = delay, StartOffsetType.FastForward)
        ), label = "BarFloatInfiniteAnim"
    )

    Box(
        modifier = Modifier
            .graphicsLayer(
                transformOrigin = TransformOrigin(
                    0.5f, 1f
                ),
                scaleX = 1f,
                scaleY = floatAnimation
            )
            .height(calculateHeight.dp)
            .width(calculateWidth.dp)
            .background(background)
    )
}