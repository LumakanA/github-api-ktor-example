package com.example.github_api_ktor_example.data

import io.ktor.client.HttpClient
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.request.get

class GithubRepositoryRemoteDataSource : GithubRepositoryDataSource {
    private val client = HttpClient {
        install(JsonFeature)
    }
    override suspend fun getRepositoryInfo(owner: String, repo: String): String {
        return client.use { client.get("https://api.github.com/repos/$owner/$repo") }
    }
}
