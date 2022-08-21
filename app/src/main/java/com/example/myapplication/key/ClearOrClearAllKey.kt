package com.example.myapplication.key

import com.example.myapplication.ui.viewmodle.Record


class ClearOrClearAllKey(private var symbol: String = "AC") : Key, ShiftKey {
    override fun exercise(record: Record, flag: KeyState): Record {
        return  Record.default()
    }

    override fun getSymbol(): String {
        return symbol
    }

}