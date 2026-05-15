package com.htmltoapk.domain.usecase

import com.htmltoapk.data.repository.ProjectRepository
import javax.inject.Inject

class DeleteProjectUseCase @Inject constructor(
    private val repository: ProjectRepository
) {
    suspend operator fun invoke(projectId: Int) = repository.deleteProject(projectId)
}