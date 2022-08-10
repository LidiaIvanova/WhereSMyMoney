package com.tsu.wheresmymoney

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import com.tsu.wheresmymoney.viewstates.DebtViewState
import com.tsu.wheresmymoney.viewstates.ViewState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class DebtListViewModel(initialState: ViewState, application: Application) :
    AndroidViewModel(application) {
    private val TAG = DebtListViewModel::class.java.simpleName
    private val debtRepository: DebtRepository = DebtRepositoryImpl(application.applicationContext)
    var state by mutableStateOf<ViewState>(initialState)

    fun obtainIntent(intent: DebtIntent) {
        when (intent) {
            DebtIntent.DebtFetch -> {
                fetchDebts()
            }
         //   DebtIntent.DebtOnClick(intent) -> {
                //TODO
           // }
            else -> {
                //TODO
            }
        }
    }

    private fun fetchDebts() {
        state = DebtViewState.DebtLoadingState
        CoroutineScope(Dispatchers.IO).launch {
            delay(1000)
            val debts = debtRepository.fetchDebts()
            state = if (debts.isEmpty()) {
                DebtViewState.DebtNoItemsState
            } else {
                DebtViewState.DebtLoadedState(debts)
            }
        }
    }
}