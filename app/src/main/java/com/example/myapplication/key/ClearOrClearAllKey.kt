package com.example.myapplication.key

import com.example.myapplication.arithmetic.OperationID
import com.example.myapplication.ui.viewmodle.Record


class ClearOrClearAllKey(private var symbol: String = "AC") : Key, ShiftKey {
    override fun exercise(record: Record, flag: KeyState): Record {
        return  Record.default()
//        return if (flag == KeyState.DEFAULT/*AC 全清*/) {
//            Record.default()
//        } else /*C 清一个*/ {
//            symbol = "C"
//            if (record.opt == OperationID.NON) {
//                //todo result 不清零不知道会不会异常
//                record.copy(factor1 = 0, display = "0")
//            } else {
//                record.copy(factor2 = 0, display = "0")
//            }
//        }
    }

    override fun getSymbol(): String {
        return symbol
    }

}