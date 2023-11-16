package com.example.cryptoclicker.model

import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import com.example.cryptoclicker.state.logicState.Currency

class ClickerViewModel: ViewModel() {
    fun Exchange(currency1: Currency, currency2: Currency, size: MutableState<Double>): String {
        return 0.0.toString()
    }

}
