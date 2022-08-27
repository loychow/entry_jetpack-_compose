package com.example.myapplication.key

import androidx.compose.ui.graphics.Color
import com.example.myapplication.ui.viewmodle.Record


class ClearOrClearAllKey(
    private val color: Color,
    private val symbol: String = "AC",
) : ShiftKey {
    override fun exercise(record: Record, state: KeyState): Record {
        return if (state == KeyState.DEFAULT) (
                Record.default()
                ) else {
            record.copy(display = "0")
        }
    }

    override fun shiftSymbol(): String {
        return "C"
    }

    override fun getSymbol(): String {
        return symbol
    }

    override fun getColor(): Color {
        return color
    }
}