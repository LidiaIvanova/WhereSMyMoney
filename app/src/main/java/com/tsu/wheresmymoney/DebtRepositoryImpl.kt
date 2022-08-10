package com.tsu.wheresmymoney

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.tsu.wheresmymoney.dao.DebtDao
import com.tsu.wheresmymoney.models.Debt

interface DebtRepository {
    suspend fun fetchDebts(): List<Debt>
    suspend fun addDebt(debt: Debt)
    suspend fun changeDebt(debt: Debt)
}

class DebtRepositoryImpl(applicationContext: Context): DebtRepository {

    private val db = Room.databaseBuilder(applicationContext,
        AppDatabase::class.java,
        DB_NAME).build()

    override suspend fun fetchDebts(): List<Debt> = db.debtDao().getAll()

    override suspend fun addDebt(debt: Debt) {
        db.debtDao().insert(debt)
    }

    override suspend fun changeDebt(debt: Debt) {
        TODO("Not yet implemented")
    }

    @Database(entities = [Debt::class], version = 1)
    private abstract class AppDatabase : RoomDatabase() {
        abstract fun debtDao(): DebtDao
    }

    companion object {
        private const val DB_NAME = "DebtDatabase"
    }
}