package com.example.weather

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weather.Adapters.DayItem

class MainViewModel : ViewModel() {
    val liveDataCurrent = MutableLiveData<DayItem>()
    val liveDataList = MutableLiveData<List<DayItem>>()
}