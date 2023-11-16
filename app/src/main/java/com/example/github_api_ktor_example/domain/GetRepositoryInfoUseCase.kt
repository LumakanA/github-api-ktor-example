package com.example.github_api_ktor_example.domain

import com.example.github_api_ktor_example.data.GithubRepositoryDataSource

class GetRepositoryInfoUseCase(private val dataSource: GithubRepositoryDataSource) {
    suspend fun execute(owner: String, repo: String): Repository {
        val rawData = dataSource.getRepositoryInfo(owner, repo)
        return RepositoryMapper.mapToDomain(rawData)
    }
}
