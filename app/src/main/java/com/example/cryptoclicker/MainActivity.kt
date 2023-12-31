package com.example.cryptoclicker

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.cryptoclicker.baselayout.CryptoClickerTopBar
import com.example.cryptoclicker.clickerPage.ClickerFragment
import com.example.cryptoclicker.earnPage.EarnFragment
import com.example.cryptoclicker.model.ClickerViewModel
import com.example.cryptoclicker.state.logicState.Currency
import com.example.cryptoclicker.state.logicState.AssetsState
import com.example.cryptoclicker.state.nav.NavStateUi
import com.example.cryptoclicker.ui.theme.CryptoclickerTheme
import com.example.cryptoclicker.upgradesPage.UpgradesFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CryptoclickerTheme {

                MaterialTheme {
                    // A surface container using the 'background' color from the theme
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        CryptoClickerApp(
                            navStateUi = NavStateUi(),
                            assetsState = AssetsState(),
                            supportFragmentManager = supportFragmentManager
                        )
                    }
                }
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CryptoClickerApp(
    viewModel: ClickerViewModel = viewModel(),
    assetsState: AssetsState,
    navStateUi: NavStateUi,
    modifier: Modifier = Modifier,
    supportFragmentManager: FragmentManager,
) {
    Scaffold(
        topBar = {
            CryptoClickerTopBar()
        },
        bottomBar = { CryptoClickerNavBar(navStateUi, supportFragmentManager) },
        content = {
            Column(
                modifier = Modifier
                    .padding(it)
                    .fillMaxSize()
                    .background(Color.LightGray),
                verticalArrangement = Arrangement.SpaceAround,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Column {
                    Column(
                        modifier
                            .background(Color.LightGray)
                            .padding(8.dp)
                    ) {

                        Text(
                            text = "Total Assets: ${assetsState.TotalAssets.value} BTC",
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp,
                            style = MaterialTheme.typography.titleLarge
                        )
                        Text(
                            text = "≈ ${
                                viewModel.Exchange(
                                    Currency.BTC,
                                    Currency.USD,
                                    assetsState.TotalAssets
                                )
                            } USD",
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp,
                        )
                    }
                    Text(
                        text = "APS: ${assetsState.assetsPerSecond.value}",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        modifier = Modifier.padding(8.dp)
                    )
                }
                Image(
                    painter = painterResource(id = R.drawable.bitcoin),
                    contentDescription = "clickMe",
                    modifier.scale(0.9f)
                )

            }

        })
}


@Composable
fun CryptoClickerNavBar(
    navStateUi: NavStateUi,
    supportFragmentManager: FragmentManager,
    modifier: Modifier = Modifier
) {
    NavigationBar(
        modifier = modifier
    ) {
        navStateUi.navStateItems.forEachIndexed { index, item ->
            NavigationBarItem(
                icon = item.icon,
                selected = navStateUi.currentNavState.value == index,
                onClick = { navStateUi.currentNavState.value = index }
            )
            supportFragmentManager.beginTransaction().replace(
                android.R.id.content, item.fragment
            ).commit()
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CryptoclickerTheme {
        Greeting("Android")
    }
}