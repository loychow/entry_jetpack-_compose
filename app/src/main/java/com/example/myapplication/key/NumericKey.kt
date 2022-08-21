package com.example.myapplication.key

import com.example.myapplication.arithmetic.OperationID
import com.example.myapplication.ui.viewmodle.Record

class NumericKey(private val symbol: String = "0") : Key {
    override fun exercise(record: Record): Record {
        var display = if (record.result != 0) {
            0
        } else if (record.opt == OperationID.NON) {
            record.factor1
        } else {
            record.factor2
        }


//        var display = record.display.toInt()
        display =
            if (display == 0) {
                symbol.toInt();
            } else if (display > 0) {
                display * 10 + symbol.toInt()//todo 没考虑小数点
            } else {
                display * 10 - symbol.toInt()
            }
        if (record.opt == OperationID.NON) {
            record.factor1 = display
        } else {
            record.factor2 = display
        }
        return record.copy(display = display.toString())
    }

    override fun getSymbol(): String {
        return symbol
    }

}