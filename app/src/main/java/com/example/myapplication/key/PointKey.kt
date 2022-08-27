package com.example.myapplication.key

import androidx.compose.ui.graphics.Color
import com.example.myapplication.ui.viewmodle.Record

class PointKey(
    private val color: Color,
    private val symbol: String

) : Key {
    override fun exercise(record: Record, justSetSymbol: Boolean): Record {
        var currentDisplay: String = record.display
        if (record.shouldDisplayReset) {
            currentDisplay = "0.0"
            record.shouldDisplayReset = false
        }
        return record.copy(display = count(currentDisplay))
    }

    override fun getSymbol(): String {
        return symbol
    }

    private fun count(display: String): String {
        return if (display == "0.0" || display == "0") {
            return "0."
        }//存在小数点
        else if (symbol == "." && display.contains(".")) {
            display
        } else {
            display + symbol
        }
    }

    override fun getColor(): Color {
        return color
    }
}