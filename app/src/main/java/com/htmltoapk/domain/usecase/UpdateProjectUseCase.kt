package com.htmltoapk.domain.usecase

import com.htmltoapk.data.model.Project
import com.htmltoapk.data.repository.ProjectRepository
import javax.inject.Inject

class UpdateProjectUseCase @Inject constructor(
    private val repository: ProjectRepository
) {
    suspend operator fun invoke(project: Project) = repository.updateProject(project)
}