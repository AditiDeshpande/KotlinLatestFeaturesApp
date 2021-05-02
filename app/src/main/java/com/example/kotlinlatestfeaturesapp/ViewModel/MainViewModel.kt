package com.example.kotlinlatestfeaturesapp.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlinlatestfeaturesapp.Repository.MainRepository
import com.example.kotlinlatestfeaturesapp.Util.ApiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

/*
Responsibility of ViewModel is to take data from Repository and send it
to view
 */
@HiltViewModel
class MainViewModel
@Inject
constructor(private val mainRepository: MainRepository): ViewModel(){
    private val postStateFlow:MutableStateFlow<ApiState> =
        MutableStateFlow(ApiState.Empty)

    val _postStateFlow:StateFlow<ApiState> = postStateFlow

    fun getPost() = viewModelScope.launch {
        /*
        To get my data in MainActivity I need this viewModelScope.launch
         */
        /*
        Starting state should be loading
         */
        postStateFlow.value = ApiState.Loading
        mainRepository.getPost()
            .catch {
                e->
                postStateFlow.value = ApiState.Failure(e)
            }.collect {
                /*
                It will come here when there is no exception in catch
                 */
                data->
                postStateFlow.value = ApiState.Success(data)
            }
    }
}