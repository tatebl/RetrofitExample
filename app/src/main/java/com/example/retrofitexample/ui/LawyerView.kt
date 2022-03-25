package com.example.retrofitexample.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import com.example.retrofitexample.viewmodel.LawyerViewModel

@Composable
fun LawyerView(viewModel: LawyerViewModel) {


    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Button(onClick = {
            viewModel.lawyers()
        }) {
            Text("Get Lawyer List")
        }
    }


}