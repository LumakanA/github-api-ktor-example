package com.example.github_api_ktor_example.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import com.example.github_api_ktor_example.R
import com.example.github_api_ktor_example.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                val mainFragment = MainFragment()
                setReorderingAllowed(true)
                add(R.id.fragmentContainerActivity, mainFragment)
            }
        }
    }
}