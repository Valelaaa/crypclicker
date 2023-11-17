package com.example.cryptoclicker.state.nav

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import com.example.cryptoclicker.clickerPage.ClickerFragment
import com.example.cryptoclicker.earnPage.EarnFragment
import com.example.cryptoclicker.upgradesPage.UpgradesFragment

class NavStateUi {
    private val navFontSize = 12.sp

    val navStateItems: List<NavState> = NavStatesEnum.values().map { state ->
        NavState(state.name, fragment =
        when (state) {
            NavStatesEnum.EARN -> {
                EarnFragment.newInstance("param1","param2")
            }
            NavStatesEnum.SPOT ->{
                ClickerFragment.newInstance("param1","param2")
            }
            NavStatesEnum.UPGRADES ->{
                UpgradesFragment.newInstance("param1","param2")
            }
            else -> {
                Fragment()
            }
        }, icon = {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {

                when (state) {
                    NavStatesEnum.HOME -> {
                        Icon(Icons.Filled.Home, contentDescription = "home")
                        Text(text = NavStatesEnum.HOME.name, fontSize = navFontSize)
                    }

                    NavStatesEnum.EARN -> {
                        Icon(Icons.Filled.Star, contentDescription = "earn")
                        Text(text = NavStatesEnum.EARN.name, fontSize = navFontSize)
                    }

                    NavStatesEnum.SPOT -> {
                        Icon(Icons.Filled.ShoppingCart, contentDescription = "spot")
                        Text(text = NavStatesEnum.SPOT.name, fontSize = navFontSize)
                    }

                    else -> {
                        Icon(
                            Icons.Default.ArrowBack,
                            contentDescription = "upgrades",
                            modifier = Modifier
                                .rotate(90f)
                                .padding(end = 10.dp)
                        )
                        Text(text = NavStatesEnum.UPGRADES.name, fontSize = navFontSize)
                    }
                }
            }

        })
    }
    var currentNavState = mutableStateOf(0)
}