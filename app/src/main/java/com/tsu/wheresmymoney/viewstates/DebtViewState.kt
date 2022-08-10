package com.tsu.wheresmymoney.viewstates

import androidx.compose.runtime.Immutable
import com.tsu.wheresmymoney.models.Debt

@Immutable
sealed class DebtViewState: ViewState {
    object DebtLoadingState : DebtViewState()
    object DebtNoItemsState : DebtViewState()
    class DebtLoadedState(debts: List<Debt>): DebtViewState()
    class DebtErrorState(message: String): DebtViewState()
}