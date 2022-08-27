package com.example.myapplication.key

import androidx.compose.ui.graphics.Color
import com.example.myapplication.ui.viewmodle.Record

class CalculationKey(
    private val color: Color,
    private val symbol: String = "=",
    private val isLand: Boolean = false
) :
    Key {
    override fun exercise(record: Record, justSetSymbol: Boolean): Record {
        record.offsetOne()
        val r: Double = record.opt.arithmetic.execute(record)
        return record.copy(
            result = r,
            display = r.toString(),
            shouldDisplayReset = true
        )
    }

    override fun getSymbol(): String {
        return symbol
    }

    override fun isLandKey(): Boolean {
        return isLand
    }

    override fun getColor(): Color {
        return color
    }
}