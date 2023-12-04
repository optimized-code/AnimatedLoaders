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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

// This is an infinite progress indicator with 3 pulsing dots that grow and shrink.
@Composable
fun Dot(
    scale: State<Float>,
    color: Color = Color.Red
) {
    Box(
        Modifier
            .padding(5.dp)
            .size(20.dp)
            .graphicsLayer {
                scaleX = scale.value
                scaleY = scale.value
            }
            .background(color, shape = CircleShape)
    )
}

@Preview
@Composable
fun PulsingDotsLoader(
    color: Color = Color.Red
) {
    val infiniteTransition = rememberInfiniteTransition(label = "a")
    val scale1 = infiniteTransition.animateFloat(
        0.2f,
        1f,
        // No offset for the 1st animation
        infiniteRepeatable(tween(600), RepeatMode.Reverse), label = "b"
    )
    val scale2 = infiniteTransition.animateFloat(
        0.2f,
        1f,
        infiniteRepeatable(
            tween(600), RepeatMode.Reverse,
            // Offsets the 2nd animation by starting from 150ms of the animation
            // This offset will not be repeated.
            initialStartOffset = StartOffset(offsetMillis = 150, StartOffsetType.FastForward)
        ), label = "c"
    )
    val scale3 = infiniteTransition.animateFloat(
        0.2f,
        1f,
        infiniteRepeatable(
            tween(600), RepeatMode.Reverse,
            // Offsets the 3rd animation by starting from 300ms of the animation. This
            // offset will be not repeated.
            initialStartOffset = StartOffset(offsetMillis = 300, StartOffsetType.FastForward)
        ), label = "d"
    )
    Row {
        Dot(scale1)
        Dot(scale2)
        Dot(scale3)
    }
}