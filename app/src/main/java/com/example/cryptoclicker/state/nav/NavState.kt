package com.example.cryptoclicker.state.nav

import androidx.compose.runtime.Composable

data class NavState(val name:String, val icon:@Composable () -> Unit) {
}