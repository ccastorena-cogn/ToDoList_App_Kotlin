package com.example.todolistappkotlin

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {

    @Query("SELECT * FROM note_table ORDER BY note ASC")
    fun getNotes() : Flow<List<Note>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(note: Note):Long

    @Query("DELETE FROM note_table")
     fun deleteAll()
}