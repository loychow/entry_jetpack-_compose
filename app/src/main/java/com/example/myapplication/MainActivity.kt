package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.*

import com.example.myapplication.ui.viewmodle.Record
import com.example.myapplication.ui.viewmodle.RecordViewModel
import androidx.compose.runtime.livedata.observeAsState
import com.example.myapplication.ui.layout.Calculator

class MainActivity : ComponentActivity() {
    private val recordViewModel by viewModels<RecordViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            CalculatorLayout()
        }
    }

    @Composable
    private fun CalculatorLayout() {
        val recordState: Record by recordViewModel.record.observeAsState(Record.default())
        Calculator(recordState, onRecordChange = { recordViewModel.onStateChanged(it) })
    }

}

