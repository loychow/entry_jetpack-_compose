package com.example.myapplication.key

import com.example.myapplication.ui.viewmodle.Record

class CalculationKey(private val symbol: String = "=") : Key {
    override fun exercise(record: Record,justSetSymbol: Boolean): Record {
        record.offsetOne()
        val r: Double = record.opt.arithmetic.execute(record)
        return record.copy(
            result = r,
            display = r.toString(),
            shouldReset = true
        )
    }

    override fun getSymbol(): String {
        return symbol
    }
}