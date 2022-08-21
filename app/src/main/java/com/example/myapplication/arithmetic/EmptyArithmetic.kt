package com.example.myapplication.arithmetic

import com.example.myapplication.ui.viewmodle.Record

class EmptyArithmetic : Arithmetic {
    override fun execute(record: Record): Int {
        return 0
    }
}