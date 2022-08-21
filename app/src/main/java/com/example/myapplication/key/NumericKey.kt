package com.example.myapplication.key

import com.example.myapplication.ui.viewmodle.Record

class NumericKey(private val symbol: String = "0") : Key {
    override fun exercise(record: Record): Record {
        var currentDisplay: String = record.display
        if (record.shouldReset) {
            currentDisplay = "0"
            record.shouldReset = false
        }
        return record.copy(display = count(currentDisplay))
    }

    override fun getSymbol(): String {
        return symbol
    }

    private fun count(display: String): String {
        return if (display == "0") {
            symbol
        } else {
            display + symbol
        }
    }
}