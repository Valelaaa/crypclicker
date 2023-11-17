package com.example.cryptoclicker.clickerPage

import android.annotation.SuppressLint
import android.widget.Space
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ClickerPage(modifier: Modifier = Modifier) {
    Column(Modifier.background(Color.Transparent)) {
        Spacer(modifier = Modifier.height(65.dp))
        Row(
            Modifier
                .fillMaxHeight(0.9f)
                .fillMaxWidth()
                .background(Color.Red)
        ) {

        }

    }
}