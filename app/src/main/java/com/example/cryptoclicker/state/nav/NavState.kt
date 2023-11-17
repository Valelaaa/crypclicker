package com.example.cryptoclicker.state.nav

import androidx.compose.runtime.Composable
import androidx.fragment.app.Fragment

data class NavState(val name: String, val icon: @Composable () -> Unit, val fragment: Fragment) {
}