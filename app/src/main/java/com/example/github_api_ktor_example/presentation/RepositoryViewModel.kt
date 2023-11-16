package com.example.github_api_ktor_example.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.github_api_ktor_example.data.GithubRepositoryRemoteDataSource
import com.example.github_api_ktor_example.domain.GetRepositoryInfoUseCase
import com.example.github_api_ktor_example.domain.Repository
import kotlinx.coroutines.launch

class RepositoryViewModel : ViewModel() {

    private val getRepositoryInfoUseCase: GetRepositoryInfoUseCase =
        GetRepositoryInfoUseCase(GithubRepositoryRemoteDataSource())
    private val _repositoryInfo = MutableLiveData<Repository?>()
    private val _errorText = MutableLiveData<String?>()

    val repositoryInfo: LiveData<Repository?> get() = _repositoryInfo
    val errorText: LiveData<String?> get() = _errorText

    fun fetchRepositoryInfo(owner: String, repo: String) {
        viewModelScope.launch {
            try {
                val repository = getRepositoryInfoUseCase.execute(owner, repo)
                _repositoryInfo.value = repository
                _errorText.value = null
            } catch (e: Exception) {
                _repositoryInfo.value = null
                _errorText.value = "Data loading error: ${e.message}"
            }
        }
    }
}