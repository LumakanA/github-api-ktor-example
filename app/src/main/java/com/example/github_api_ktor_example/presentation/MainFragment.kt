package com.example.github_api_ktor_example.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.github_api_ktor_example.R
import com.example.github_api_ktor_example.databinding.FragmentMainBinding
import com.example.github_api_ktor_example.domain.Repository

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private val viewModel: RepositoryViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.repositoryInfo.observe(viewLifecycleOwner) { repository ->
            if (repository != null) {
                showRepositoryInfo(repository)
            } else {
                binding.textView.text = R.string.error_loading_data.toString()
            }
        }

        viewModel.errorText.observe(viewLifecycleOwner) { errorText ->
            if (errorText != null) {
                Toast.makeText(requireContext(), errorText, Toast.LENGTH_SHORT).show()
            }
        }

        val owner = "LumakanA"
        val repo = "github-api-ktor-example"
        viewModel.fetchRepositoryInfo(owner, repo)
    }

    private fun showRepositoryInfo(repository: Repository) {
        binding.apply {
            val repositoryInfoText = """
                Owner: ${repository.owner}
                Repository URL: ${repository.repoUrl}
                Description: ${repository.description}
                Is Template: ${repository.isTemplate}
                Forks: ${repository.forks}
                Stars: ${repository.stars}
                Watchers: ${repository.watchers}
                Size: ${repository.size}
                Default Branch: ${repository.defaultBranch}
                Created at: ${repository.createdAt}
                Last Updated at: ${repository.lastUpdatedAt}
            """.trimIndent()

            textView.text = repositoryInfoText
        }
    }
}