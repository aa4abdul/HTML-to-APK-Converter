package com.htmltoapk.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.htmltoapk.data.model.Project
import com.htmltoapk.data.model.ProjectFile

@Database(
    entities = [Project::class, ProjectFile::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun projectDao(): ProjectDao
    abstract fun projectFileDao(): ProjectFileDao

    companion object {
        const val DATABASE_NAME = "htmltoapk_db"
    }
}