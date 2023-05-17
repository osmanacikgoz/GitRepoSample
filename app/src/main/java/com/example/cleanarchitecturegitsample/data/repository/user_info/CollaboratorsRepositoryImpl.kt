package com.example.cleanarchitecturegitsample.data.repository.user_info

import com.example.cleanarchitecturegitsample.data.remote.dto.user_info.CollaboratorDto
import com.anthony.net.sample.github.domain.entity.user_info.Collaborator
import com.example.cleanarchitecturegitsample.data.remote.Resource
import com.example.cleanarchitecturegitsample.data.remote.handleException
import com.example.cleanarchitecturegitsample.data.remote.services.user_info.CollaboratorsServices

class CollaboratorsRepositoryImpl(private val collaboratorsServices: CollaboratorsServices) :
    CollaboratorsRepository {
    override suspend fun getCollaborators(
        owner: String,
        repo: String
    ): Resource<List<Collaborator>> {
        return try {
            val originalData = collaboratorsServices.getCollaborators(owner, repo)
            val dataMapping = originalData.map { collaboratorDto ->
                mapCollaboratorDtoToCollaborator(collaboratorDto)

            }
            Resource.Success(dataMapping)
        } catch (e: Exception) {
            handleException(e)
        }
    }

}

private fun mapCollaboratorDtoToCollaborator(collaboratorDto: CollaboratorDto): Collaborator {
    return Collaborator(
        id = collaboratorDto.id,
        avatarUrl = collaboratorDto.avatar_url,
        collaboratorName = collaboratorDto.login
    )
}