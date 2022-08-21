package com.example.myapplication.ui.viewmodle


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RecordViewModel : ViewModel() {
    private val _record = MutableLiveData<Record>()
    val record: LiveData<Record> = _record
    fun onStateChanged(record: Record) {
        _record.value = record
    }
}