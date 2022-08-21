package com.example.myapplication.key

import com.example.myapplication.ui.viewmodle.Record

interface Key {

    fun exercise(record: Record, justSetSymbol: Boolean = false): Record {
        return Record.default()
    }

    fun getSymbol(): String
}