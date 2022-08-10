package com.tsu.wheresmymoney.dao

import androidx.room.Insert
import androidx.room.PrimaryKey
import androidx.room.Query
import com.tsu.wheresmymoney.models.Debt

interface DebtDao {
    @Query("SELECT * FROM debt")
    fun getAll(): List<Debt>

    @Insert
    fun insert(debt: Debt)
}