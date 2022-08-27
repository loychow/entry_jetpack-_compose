package com.example.myapplication.key

import androidx.compose.ui.graphics.Color
import com.example.myapplication.ui.viewmodle.Record

interface Key {

    fun exercise(record: Record, justSetSymbol: Boolean = false): Record {
        return record
    }
    //获取显示符
    fun getSymbol(): String

    //是否横屏显示的键
    fun isLandKey(): Boolean {
        return false
    }

    //按钮背景颜色
    fun getColor(): Color
    //按钮字体颜色
    fun getTextColor(): Color {
        return Color.White
    }
}