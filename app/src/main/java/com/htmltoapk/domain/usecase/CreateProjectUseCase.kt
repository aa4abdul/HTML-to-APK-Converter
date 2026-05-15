package com.htmltoapk.domain.usecase

import com.htmltoapk.data.model.Project
import com.htmltoapk.data.repository.ProjectRepository
import javax.inject.Inject

class CreateProjectUseCase @Inject constructor(
    private val repository: ProjectRepository
) {
    suspend operator fun invoke(project: Project): Long = repository.insertProject(project)
}