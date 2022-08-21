package com.example.myapplication.key

import com.example.myapplication.ui.viewmodle.Record

interface Key {

    fun exercise(record: Record): Record {
        return Record.default()
    }

    fun getSymbol(): String
}