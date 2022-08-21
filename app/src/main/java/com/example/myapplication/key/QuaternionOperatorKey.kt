package com.example.myapplication.key

import com.example.myapplication.arithmetic.OperationID
import com.example.myapplication.ui.viewmodle.Record

class QuaternionOperatorKey(private val operationID: OperationID) : Key {
    override fun exercise(record: Record): Record {
//        if (record.opt == OperationID.NON) {
//            record.factor1 = record.display.toInt()
//        }
        return record.copy(opt = operationID)
    }

    override fun getSymbol(): String {
        return operationID.symbol
    }
}