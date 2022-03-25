package com.example.retrofitexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import com.example.retrofitexample.network.Lawyer
import com.example.retrofitexample.ui.LawyerView
import com.example.retrofitexample.ui.theme.RetrofitExampleTheme
import com.example.retrofitexample.viewmodel.LawyerViewModel

class MainActivity : ComponentActivity() {
    private val viewModel:LawyerViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RetrofitExampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    LawyerView(viewModel)
                }
            }
        }
    }
}

