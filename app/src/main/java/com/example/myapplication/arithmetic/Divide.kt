package com.example.myapplication.arithmetic

import com.example.myapplication.ui.viewmodle.Record

class Divide : Arithmetic {
    override fun execute(record: Record): Double {
        return if (record.factor2 == 0.0) {
            0.0
        } else {
            record.factor1 / record.factor2
        }
    }
}