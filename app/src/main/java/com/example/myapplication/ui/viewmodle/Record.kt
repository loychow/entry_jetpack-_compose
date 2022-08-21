package com.example.myapplication.ui.viewmodle

import com.example.myapplication.key.OperationID

data class Record(
    var factor1: Double,

    var opt: OperationID,

    var factor2: Double,

    var result: Double,
//
    var display: String,

    var shouldReset:Boolean
) {
    override fun toString(): String {
        return "$factor1 ${opt.symbol} $factor2 = $result; display=$display"
    }

    companion object {
        fun default(): Record {
            return Record(0.0, OperationID.NON, 0.0, 0.0, "0",false)
        }
    }

    fun removeDecimals(numStr: String): String {
        return if (numStr.endsWith(".0")) {
            numStr.replace(".0", "")
        } else {
            numStr
        }
    }

    fun offsetOne(){
        factor1 = factor2
        factor2 = display.toDouble()
    }
//    override fun toString():String{
//        return "factor1=$factor1,opt$opt,factor2=$factor2,result=$result,display$display}"
//    }
}
