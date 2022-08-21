package com.example.myapplication.key

import com.example.myapplication.ui.viewmodle.Record

class QuaternionOperatorKey(private val operationID: OperationID) : Key {
    override fun exercise(record: Record,justSetSymbol: Boolean): Record {
        if (justSetSymbol) {
            return record.copy(opt = operationID)
        }

        if (record.opt != OperationID.NON/*todo 考虑同操作符类型*/) {
            record.offsetOne()
            record.result = record.opt.arithmetic.execute(record)
            return record.copy(
                factor1 = record.factor2,
                opt = operationID,
                factor2 = record.result,
                display = record.result.toString(),
                shouldReset = true
            )
        } else {
            record.offsetOne()
            return record.copy(
                opt = operationID,
                shouldReset = true
            )
        }

    }


    override fun getSymbol(): String {
        return operationID.symbol
    }
}