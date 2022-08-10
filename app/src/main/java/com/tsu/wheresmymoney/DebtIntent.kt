package com.tsu.wheresmymoney

import androidx.compose.runtime.Immutable

@Immutable
sealed class DebtIntent {
    object DebtFetch : DebtIntent()
    class DebtOnClick(val debtId: Int): DebtIntent()
}