package com.example.myapplication.key

import com.example.myapplication.ui.viewmodle.Record

class NumericKey(private val symbol: String = "0.0") : Key {
    override fun exercise(record: Record, justSetSymbol: Boolean): Record {
        var currentDisplay: String = record.display
        if (record.shouldReset) {
            currentDisplay = "0.0"
            record.shouldReset = false
        }
        return record.copy(display = count(currentDisplay))
    }

    override fun getSymbol(): String {
        return symbol
    }

    private fun count(display: String): String {
        return if (display == "0.0"||display == "0") {
            symbol
        }
        //存在小数点
        else if (symbol == "." && display.contains(".")) {
            display
        } else {
            display + symbol
        }
    }
}