package com.thk.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Insert
import androidx.room.Query
import androidx.room.RoomDatabase
import com.thk.data.model.NumberEntity
import kotlinx.coroutines.flow.Flow

@Database(entities = [NumberEntity::class], version = 1)
abstract class NumbersDatabase : RoomDatabase() {
    abstract fun dao(): NumbersDao
}

@Dao
interface NumbersDao {
    @Query("SELECT * FROM numbers")
    fun getNumbers(): LiveData<List<NumberEntity>>  // 쿼리 결과를 바로 LiveData 타입으로 리턴

    @Query("SELECT* FROM numbers")
    fun getNumbersAsFlow(): Flow<List<NumberEntity>>

    @Insert
    suspend fun insertNumber(number: NumberEntity)

    @Query("DELETE FROM numbers")
    suspend fun clearNumbers()
}