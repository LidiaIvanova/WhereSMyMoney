package com.tsu.wheresmymoney.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Debt(val isMyDebt: Boolean,
                val secondPersonName: String,
                val deadline: Long?,
                val sum: Int,
                @PrimaryKey(autoGenerate = true) val id: Int = 0)

