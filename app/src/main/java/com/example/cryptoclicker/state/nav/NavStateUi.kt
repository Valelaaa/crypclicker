package com.example.cryptoclicker.state.nav

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale

class NavStateUi {
    val navStateItems: List<NavState> = NavStatesEnum.values().map { state ->
        NavState(state.name, icon = {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {

                when (state) {
                    NavStatesEnum.HOME -> {
                        Icon(Icons.Filled.Home, contentDescription = "home")
                        Text(text = NavStatesEnum.HOME.name)
                    }

                    NavStatesEnum.EARN -> {
                        Icon(Icons.Filled.Star, contentDescription = "earn")
                        Text(text = NavStatesEnum.EARN.name)
                    }

                    NavStatesEnum.SPOT -> {
                        Icon(Icons.Filled.ShoppingCart, contentDescription = "spot")
                        Text(text = NavStatesEnum.SPOT.name)
                    }

                    else -> {
                        Icon(
                            Icons.Default.ArrowBack,
                            contentDescription = "upgrades",
                            modifier = Modifier.rotate(90f)
                        )
                        Text(text = NavStatesEnum.UPGRADES.name)
                    }
                }
            }

        })
    }
    var currentNavState = mutableStateOf(0)
}