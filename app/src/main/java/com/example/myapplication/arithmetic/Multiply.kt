package com.example.myapplication.arithmetic

import com.example.myapplication.ui.viewmodle.Record

class Multiply : Arithmetic {
    override fun execute(record: Record): Double {
        return record.factor1 * record.factor2
    }
}