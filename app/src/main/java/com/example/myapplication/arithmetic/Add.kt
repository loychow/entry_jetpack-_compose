package com.example.myapplication.arithmetic

import com.example.myapplication.ui.viewmodle.Record

class Add : Arithmetic {
    override fun execute(record: Record): Int {
        return record.factor1 + record.factor2
    }
}