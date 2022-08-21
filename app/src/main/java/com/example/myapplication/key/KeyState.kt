package com.example.myapplication.key

enum class KeyState {
    DEFAULT() {
        override fun shift(): KeyState {
            return SHIFT
        }
    },
    SHIFT() {
        override fun shift(): KeyState {
            return DEFAULT
        }
    };

    open fun shift(): KeyState {
        return DEFAULT
    }


}