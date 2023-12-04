package io.optimizedcode.loaders

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

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.optimizedcode.loaders.loaders.EqualizerLoader
import io.optimizedcode.loaders.loaders.PulsingDotsLoader
import io.optimizedcode.loaders.ui.theme.LoadersTheme

typealias ComposableFun = @Composable () -> Unit

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoadersTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.White)
                ) {
                    Demo()
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun Demo(
    composableFun: ArrayList<ComposableFun> = arrayListOf(
        { EqualizerLoader(height = 60, width = 90) },
        { PulsingDotsLoader() },
        { ComingSoon() },
        { ComingSoon() },
        { ComingSoon() },
        { ComingSoon() },
        { ComingSoon() },
        { ComingSoon() },
        { ComingSoon() },
        { ComingSoon() },
        { ComingSoon() },
        { ComingSoon() },
        { ComingSoon() },
        { ComingSoon() },
        { ComingSoon() },
        { ComingSoon() },
        { ComingSoon() },
        { ComingSoon() },
        { ComingSoon() },
        { ComingSoon() },
        { ComingSoon() }
    )
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(items = composableFun) {
            ElevatedCard(
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .size(100.dp),
                elevation = CardDefaults.cardElevation(6.dp),
                colors = CardDefaults.cardColors(
                    containerColor = colorResource(id = R.color.shadow),
                )
            ) {
                Column(
                    modifier = Modifier.fillMaxSize().padding(8.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    it.invoke()
                }
            }
        }
    }
}

@Composable
fun ComingSoon() {
    Text("Coming Soon")
}
