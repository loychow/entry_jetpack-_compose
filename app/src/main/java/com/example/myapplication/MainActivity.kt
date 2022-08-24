package com.example.myapplication

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.*

import com.example.myapplication.ui.viewmodle.Record
import com.example.myapplication.ui.viewmodle.RecordViewModel
import androidx.compose.runtime.livedata.observeAsState
import com.example.myapplication.ui.layout.Calculator
import com.example.myapplication.ui.layout.constraintLayoutScreen
import com.example.myapplication.ui.layout.secrendRow

class MainActivity : ComponentActivity() {
    private val recordViewModel by viewModels<RecordViewModel>()
    var flag = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            constraintLayoutScreen()


            CalculatorLayout()
        }
    }

    @Composable
    private fun CalculatorLayout() {
        val recordState: Record by recordViewModel.record.observeAsState(Record.default())
        Calculator(recordState, onRecordChange = { recordViewModel.onStateChanged(it) })
    }

    override fun onConfigurationChanged(newConfig: Configuration) {

        if(newConfig.orientation==Configuration.ORIENTATION_LANDSCAPE){
            setContent {
                constraintLayoutScreen()
            }
        }else{
            setContent {
                secrendRow()
            }

        }

        super.onConfigurationChanged(newConfig)
    }
}

