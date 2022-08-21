package com.example.myapplication.key

import com.example.myapplication.ui.viewmodle.Record

class PercentageKey(private val symbol: String = "%") : Key {

    override fun exercise(record: Record, justSetSymbol: Boolean): Record {
        return record.copy(display = percentage(record.display))
    }

    override fun getSymbol(): String {
        return symbol
    }

    fun percentage(str: String): String {
        return (str.toDouble() * 0.01).toString()
    }
}