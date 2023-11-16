package com.example.github_api_ktor_example.domain

data class Repository(
    val name: String,
    val description: String,
    val owner: String,
    val repoUrl: String,
    val isTemplate: Boolean,
    val forks: Int,
    val stars: Int,
    val watchers: Int,
    val size: Int,
    val defaultBranch: String,
    val createdAt: String,
    val lastUpdatedAt: String,
)

