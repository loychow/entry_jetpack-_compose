package com.example.myapplication.ui.viewmodle

import com.example.myapplication.arithmetic.OperationID

data class Record(
    var factor1: Int,

    var opt: OperationID,

    var factor2: Int,

    var result: Int,

    var display: String,
) {
    override fun toString(): String {
        return "$factor1 ${opt.symbol} $factor2 = $result; display=$display"
    }

    companion object {
        fun default(): Record {
            return Record(0, OperationID.NON, 0, 0, "0")
        }
    }

//    override fun toString():String{
//        return "factor1=$factor1,opt$opt,factor2=$factor2,result=$result,display$display}"
//    }
}
