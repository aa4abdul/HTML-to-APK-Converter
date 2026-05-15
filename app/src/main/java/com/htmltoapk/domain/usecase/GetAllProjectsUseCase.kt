package com.htmltoapk.domain.usecase

import com.htmltoapk.data.model.Project
import com.htmltoapk.data.repository.ProjectRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllProjectsUseCase @Inject constructor(
    private val repository: ProjectRepository
) {
    operator fun invoke(): Flow<List<Project>> = repository.getAllProjects()
}