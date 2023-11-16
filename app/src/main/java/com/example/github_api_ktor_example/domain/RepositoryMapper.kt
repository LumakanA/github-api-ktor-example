package com.example.github_api_ktor_example.domain

import org.json.JSONObject

object RepositoryMapper {
    fun mapToDomain(rawData: String): Repository {
        val json = JSONObject(rawData)
        val ownerJson = json.getJSONObject("owner")

        return Repository(
            name = json.getString("name"),
            description = json.getString("description"),
            owner = ownerJson.getString("login"),
            repoUrl = json.getString("html_url"),
            isTemplate = json.getBoolean("is_template"),
            forks = json.getInt("forks_count"),
            stars = json.getInt("stargazers_count"),
            watchers = json.getInt("watchers_count"),
            size = json.getInt("size"),
            defaultBranch = json.getString("default_branch"),
            createdAt = json.getString("created_at"),
            lastUpdatedAt = json.getString("updated_at"),
        )
    }
}

