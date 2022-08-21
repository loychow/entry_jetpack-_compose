package com.example.myapplication.key

import android.util.Log
import com.example.myapplication.ui.viewmodle.Record

class CalculationKey(private val symbol: String = "=") : Key {
    override fun exercise(record: Record): Record {
        record.offsetOne()
        val r: Double = record.opt.arithmetic.execute(record)
        return record.copy(result = r, display = r.toString())
    }

    override fun getSymbol(): String {
        return symbol
    }
}