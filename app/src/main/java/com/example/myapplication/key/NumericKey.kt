package com.example.myapplication.key

import androidx.compose.ui.graphics.Color
import com.example.myapplication.ui.viewmodle.Record

class NumericKey(
    private val color: Color,
    private val symbol: String = "0.0"
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
            symbol
        } else {
            display + symbol
        }
    }

    override fun getColor(): Color {
        return color
    }
}