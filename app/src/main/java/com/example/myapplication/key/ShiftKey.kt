package com.example.myapplication.key

import com.example.myapplication.ui.viewmodle.Record

interface ShiftKey : Key {
    fun exercise(record: Record, state: KeyState): Record
    fun shiftSymbol(): String
}