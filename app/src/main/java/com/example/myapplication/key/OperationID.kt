package com.example.myapplication.key

import com.example.myapplication.arithmetic.*
import java.util.*

enum class OperationID(val symbol: String, val arithmetic: Arithmetic) {
    ADD("+", Add()),
    SUBTRACT("-", Subtract()),
    MULTIPLY("*", Multiply()),
    DIVIDE("÷", Divide()),
    NON("", EmptyArithmetic());

    fun ValueOf(optStr: String): OperationID {
        return when (optStr.uppercase(Locale.getDefault())) {
            ADD.symbol -> ADD
            SUBTRACT.symbol -> SUBTRACT
            MULTIPLY.symbol -> MULTIPLY
            DIVIDE.symbol -> DIVIDE
            else -> NON
        }
    }
}