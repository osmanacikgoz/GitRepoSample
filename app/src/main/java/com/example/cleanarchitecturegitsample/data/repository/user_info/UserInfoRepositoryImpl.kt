package com.example.cleanarchitecturegitsample.data.repository.user_info

import com.anthony.net.sample.github.data.remote.dto.login.RepositoryDto
import com.example.cleanarchitecturegitsample.data.remote.Resource
import com.example.cleanarchitecturegitsample.data.remote.handleException
import com.example.cleanarchitecturegitsample.data.remote.services.user_info.UserInfoServices
import com.example.cleanarchitecturegitsample.domain.entity.login.Repository

class UserInfoRepositoryImpl(private val userInfoServices: UserInfoServices) : UserInfoRepository {
    override suspend fun getRepositories(loginName: String): Resource<List<Repository>> {
        return try {

            val originData = userInfoServices.getRepositories(loginName)
            val dataMapping = originData.map { repositoryDto ->
                mapRepositoryDtoToRepository(repositoryDto)
            }
            Resource.Success(dataMapping)
        } catch (e: Exception) {
            handleException(e)
        }
    }
}

private fun mapRepositoryDtoToRepository(repositoryDto: RepositoryDto): Repository {
    return Repository(
        id = repositoryDto.id,
        avatarUrl = repositoryDto.owner.avatar_url,
        stargazersCount = repositoryDto.stargazers_count,
        forksCount = repositoryDto.forks_count,
        repositoryOwner = repositoryDto.owner.login,
        repositoryName = repositoryDto.name,
        repositoryDescription = repositoryDto.description.orEmpty(),
        repositoryLanguage = repositoryDto.language.orEmpty()
    )
}