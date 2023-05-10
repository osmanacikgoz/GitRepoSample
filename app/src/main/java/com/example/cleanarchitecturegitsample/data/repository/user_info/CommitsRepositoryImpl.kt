package com.example.cleanarchitecturegitsample.data.repository.user_info

import com.anthony.net.sample.github.data.remote.dto.user_info.CommitDto
import com.anthony.net.sample.github.domain.entity.user_info.Commit
import com.example.cleanarchitecturegitsample.data.remote.Resource
import com.example.cleanarchitecturegitsample.data.remote.handleException
import com.example.cleanarchitecturegitsample.data.remote.services.user_info.CommitServices

class CommitsRepositoryImpl(private val commitServices: CommitServices) : CommitsRepository {
    override suspend fun getCommits(userName: String, repo: String): Resource<List<Commit>> {
        return try {

            val origindata = commitServices.getCommits(userName, repo)

            val dataMapping = origindata.map { commitDto ->
                mapCommitDtoToCommit(commitDto)
            }
            Resource.Success(dataMapping)
        } catch (e: Exception) {
            handleException(e)
        }
    }

}

private fun mapCommitDtoToCommit(commitDto: CommitDto): Commit {
    return Commit(
        nodeId = commitDto.node_id,
        userName = commitDto.commit.committer.name,
        date = commitDto.commit.committer.date,
        message = commitDto.commit.message
    )
}