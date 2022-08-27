package com.example.myapplication.key

import androidx.compose.ui.graphics.Color

class OtherKey(
    private val color: Color,
    private val symbol: String = "-",
    private val isLand: Boolean = true,
) : Key {
    override fun getSymbol(): String {
        return symbol
    }

    override fun isLandKey(): Boolean {
        return isLand
    }

    override fun getColor(): Color {
        return color
    }
}