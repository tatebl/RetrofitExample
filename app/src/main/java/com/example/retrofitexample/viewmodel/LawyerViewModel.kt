package com.example.retrofitexample.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofitexample.network.Lawyer
import com.example.retrofitexample.network.repository.RetrofitHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LawyerViewModel: ViewModel() {

    private val loginRequestLiveData=MutableLiveData<List<Lawyer>>() // make list of Lawyer


    fun lawyers() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val lawyerService= RetrofitHelper.getLawyerService()

                val responseService=lawyerService.getLawyerList()   //

                if(responseService.isSuccessful) {
                    //if you recieve a response from server
                    responseService.body()?.let { lawyers ->
                        Log.d("Logging","Response token $lawyers")
                    }
                } else {

                    responseService.errorBody()?.let { error ->
                        Log.d("Retrieval Error", "Response Token $error")
                        error.close()
                    }
                }


                loginRequestLiveData.postValue(responseService.body())
            } catch(e:Exception) {
                Log.d("LawyerSearch", "Exception")
            }
        }


    }

}