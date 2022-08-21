package com.example.myapplication.key

import com.example.myapplication.ui.viewmodle.Record

interface ShiftKey {
    fun exercise(record: Record, flag: KeyState): Record
}