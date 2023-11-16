package com.example.github_api_ktor_example.data

interface GithubRepositoryDataSource {
    suspend fun getRepositoryInfo(owner: String, repo: String): String
}