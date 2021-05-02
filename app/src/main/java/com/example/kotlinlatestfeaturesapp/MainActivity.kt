package com.example.kotlinlatestfeaturesapp

import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlinlatestfeaturesapp.Adapter.PostAdapter
import com.example.kotlinlatestfeaturesapp.Util.ApiState
import com.example.kotlinlatestfeaturesapp.ViewModel.MainViewModel
import com.example.kotlinlatestfeaturesapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var postAdapter: PostAdapter
    private val mainViewModel:MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerview()
        mainViewModel.getPost()
        /*
        It will give me error here coz collect is coroutines function
        so it should be called from suspend function only
         */
       /* mainViewModel._postStateFlow.collect{

        }*/
        //so adding following code
        lifecycleScope.launchWhenCreated {
            mainViewModel._postStateFlow.collect{ it->
                when(it){
                    is ApiState.Loading->{
                        binding.recyclerview.isVisible = false
                        binding.progressBar.isVisible = true
                    }
                    is ApiState.Failure->{
                        binding.recyclerview.isVisible = false
                        binding.progressBar.isVisible = false
                        Log.d("main","onCreate: ${it.msg}")
                    }
                    is ApiState.Success->{
                        binding.recyclerview.isVisible = true
                        binding.progressBar.isVisible = false
                        postAdapter.setData(it.data)
                    }
                    is ApiState.Empty->{

                    }
                }
            }
        }
    }


    private fun initRecyclerview() {
        postAdapter = PostAdapter(ArrayList())
        binding.recyclerview.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = postAdapter
        }
    }
}