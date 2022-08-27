package com.example.myapplication.key

import androidx.compose.ui.graphics.Color
import com.example.myapplication.ui.viewmodle.Record

class PercentageKey(
    private val color: Color,
    private val symbol: String = "%",
) : Key {

    override fun exercise(record: Record, justSetSymbol: Boolean): Record {
        return record.copy(display = percentAge(record.display))
    }

    override fun getSymbol(): String {
        return symbol
    }

    fun percentAge(str: String): String {
        return (str.toDouble() * 0.01).toString()
    }

    override fun getColor(): Color {
        return color
    }
}