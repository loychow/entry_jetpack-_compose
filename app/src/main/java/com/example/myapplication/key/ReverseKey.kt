package com.example.myapplication.key

import com.example.myapplication.ui.viewmodle.Record

class ReverseKey(private val symbol: String) : Key {
    override fun exercise(record: Record, justSetSymbol: Boolean): Record {
        return if (record.display == "0.0" || record.display == "0") {
            record
        }
        //已经存在小数点的情况
        else if (record.display.startsWith("-")) {
            record.copy(display = record.display.substring(1))
        } else {
            record.copy(display = "-" + record.display)
        }
    }

    override fun getSymbol(): String {
        return symbol
    }
}