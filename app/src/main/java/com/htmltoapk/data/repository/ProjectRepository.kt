package com.htmltoapk.data.repository

import com.htmltoapk.data.dao.ProjectDao
import com.htmltoapk.data.dao.ProjectFileDao
import com.htmltoapk.data.model.Project
import com.htmltoapk.data.model.ProjectFile
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ProjectRepository @Inject constructor(
    private val projectDao: ProjectDao,
    private val projectFileDao: ProjectFileDao
) {
    fun getAllProjects(): Flow<List<Project>> = projectDao.getAllProjects()
    
    fun getProjectById(id: Int): Flow<Project?> = projectDao.getProjectById(id)
    
    suspend fun insertProject(project: Project): Long = projectDao.insertProject(project)
    
    suspend fun updateProject(project: Project) = projectDao.updateProject(project)
    
    suspend fun deleteProject(id: Int) = projectDao.deleteProject(id)
    
    fun getProjectFiles(projectId: Int): Flow<List<ProjectFile>> = 
        projectFileDao.getFilesByProjectId(projectId)
    
    fun getProjectFileByName(projectId: Int, fileName: String): Flow<ProjectFile?> =
        projectFileDao.getFileByName(projectId, fileName)
    
    suspend fun insertProjectFile(file: ProjectFile): Long = projectFileDao.insertFile(file)
    
    suspend fun updateProjectFile(file: ProjectFile) = projectFileDao.updateFile(file)
    
    suspend fun deleteProjectFile(id: Int) = projectFileDao.deleteFile(id)
    
    suspend fun deleteProjectFiles(projectId: Int) = projectFileDao.deleteFilesByProjectId(projectId)
}