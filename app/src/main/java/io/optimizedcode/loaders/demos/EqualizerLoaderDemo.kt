package io.optimizedcode.loaders.demos

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.optimizedcode.loaders.R
import io.optimizedcode.loaders.loaders.EqualizerLoader
import io.optimizedcode.loaders.ui.theme.LoadersTheme

/*
**************************************************************
 * www.optimizedcode.io 
 * Kotlin
 *
 * @author Ehtisham Ahmad Qureshi
 * @package io.optimizedcode.loaders.demos
 * @date 04-Dec-2023
 * @copyright 2023 Optimized code (https://www.optimizedcode.io)
 * @license Open source
 ***************************************************************
 */

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun EqualizerLoaderDemo() {
    var bars by remember { mutableIntStateOf(10) }
    var height by remember { mutableIntStateOf(25) }
    var width by remember { mutableIntStateOf(50) }

    var barText by remember { mutableStateOf(bars.toString()) }
    var heightText by remember { mutableStateOf(height.toString()) }
    var widthText by remember { mutableStateOf(width.toString()) }


    LoadersTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White),
            verticalArrangement = Arrangement.spacedBy(
                space = 20.dp,
                alignment = Alignment.CenterVertically
            ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            EqualizerLoader(height = height, width = width, bars = bars)
            Text("Number of bars")
            TextField(
                value = barText,
                onValueChange = { newText ->
                    barText = newText
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                colors = TextFieldDefaults.textFieldColors(containerColor = Color.White)
            )
            Text("Widget Height")
            TextField(
                value = heightText,
                onValueChange = { newText ->
                    heightText = newText
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                colors = TextFieldDefaults.textFieldColors(containerColor = Color.White)
            )

            Text("Widget Width")
            TextField(
                value = widthText,
                onValueChange = { newText ->
                    widthText = newText
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                colors = TextFieldDefaults.textFieldColors(containerColor = Color.White)
            )
            ElevatedButton(
                onClick = {
                    bars = barText.toInt()
                    height = heightText.toInt()
                    width = widthText.toInt()
                },
                colors = ButtonDefaults.buttonColors(colorResource(id = R.color.color5))
            ) {
                Text("Play with bars")
            }
        }
    }
}