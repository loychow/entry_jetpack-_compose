package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.*
import com.example.myapplication.ui.viewmodle.Record
import com.example.myapplication.ui.viewmodle.RecordViewModel
import androidx.compose.runtime.livedata.observeAsState
import com.example.myapplication.ui.layout.Calculator


class MainActivity : ComponentActivity() {
    private val recordViewModel by viewModels<RecordViewModel>()

    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val widthSizeClass = calculateWindowSizeClass(this).widthSizeClass
            CalculatorLayout(widthSizeClass)
        }
    }

    @Composable
    private fun CalculatorLayout(widthSizeClass: WindowWidthSizeClass) {
        //调试的机型为Pixel 4 XL API 29,这宽度判断不知道是否适配其他机型
        val isExpandedScreen = widthSizeClass == WindowWidthSizeClass.Expanded
        val recordState: Record by recordViewModel.record.observeAsState(Record.default())
        Calculator(
            recordState,
            isExpandedScreen,
            onRecordChange = { recordViewModel.onStateChanged(it) })
    }
}

