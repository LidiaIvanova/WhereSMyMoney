package com.tsu.wheresmymoney

import com.tsu.wheresmymoney.viewstates.DebtViewState

interface DebtListView {
    fun render(state: DebtViewState)
}