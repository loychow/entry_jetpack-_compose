package com.example.myapplication.key

import com.example.myapplication.ui.viewmodle.Record


class ClearOrClearAllKey(private var symbol: String = "AC") : ShiftKey, Key {
    override fun exercise(record: Record, state: KeyState): Record {
        return if (state == KeyState.DEFAULT) (
                Record.default()
                ) else {
            record.copy(display = "0")
        }
    }

    override fun getSymbol(state: KeyState): String {
        return if (state == KeyState.DEFAULT) (
                "AC"
                ) else {
            "C"
        }
    }

    override fun getSymbol(): String {
        return symbol
    }

}