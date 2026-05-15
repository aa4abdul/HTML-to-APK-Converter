package com.htmltoapk.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.htmltoapk.data.model.ProjectFile
import kotlinx.coroutines.flow.Flow

@Dao
interface ProjectFileDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFile(file: ProjectFile): Long

    @Update
    suspend fun updateFile(file: ProjectFile)

    @Delete
    suspend fun deleteFile(file: ProjectFile)

    @Query("SELECT * FROM project_files WHERE id = :id")
    suspend fun getFileById(id: Int): ProjectFile?

    @Query("SELECT * FROM project_files WHERE projectId = :projectId")
    fun getFilesByProjectId(projectId: Int): Flow<List<ProjectFile>>

    @Query("SELECT * FROM project_files WHERE projectId = :projectId AND fileType = :fileType")
    fun getFilesByType(projectId: Int, fileType: String): Flow<List<ProjectFile>>

    @Query("DELETE FROM project_files WHERE projectId = :projectId")
    suspend fun deleteFilesByProjectId(projectId: Int)

    @Query("DELETE FROM project_files WHERE id = :id")
    suspend fun deleteFileById(id: Int)

    @Query("SELECT * FROM project_files WHERE projectId = :projectId AND fileType = 'html' LIMIT 1")
    suspend fun getMainHtmlFile(projectId: Int): ProjectFile?
}