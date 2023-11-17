package com.example.cryptoclicker.upgradesPage

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun UpgradesPage(modifier: Modifier = Modifier) {
    Column(Modifier.background(Color.Transparent)) {
        Spacer(modifier = Modifier.height(65.dp))
        Row(
            Modifier
                .fillMaxHeight(0.9f)
                .fillMaxWidth()
                .background(Color.Green)
        ) {

        }

    }
}