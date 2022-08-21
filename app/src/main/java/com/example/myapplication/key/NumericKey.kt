package com.example.myapplication.key

import com.example.myapplication.ui.viewmodle.Record

class NumericKey(private val symbol: String = "0") : Key {
    override fun exercise(record: Record): Record {
        var currentDisplay: Double = record.display.toDouble()
        if (record.shouldReset) {
            currentDisplay = 0.0
            record.shouldReset=false
        }
        return record.copy(display = count(currentDisplay).toString())
    }

    override fun getSymbol(): String {
        return symbol
    }

    private fun count(display: Double): Double {
        var displayNum = display
        displayNum = if (displayNum == 0.0) {
            symbol.toDouble()
        } else if (displayNum > 0) {
            displayNum * 10 + symbol.toDouble()
        } else {
            displayNum * 10 - symbol.toDouble()
        }
        return displayNum
    }
}