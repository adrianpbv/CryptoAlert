package com.example.android.cryptoalert.ui.base

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData

/**
 * Base class for View Models to declare the common LiveData objects in one place
 */
abstract class BaseViewModel constructor(app: Application): AndroidViewModel(app){
    val navigation: MutableLiveData<Event<NavigationCommand>> = MutableLiveData()
    val showSnackBar: MutableLiveData<Event<Int>> = MutableLiveData()
    val showToast: MutableLiveData<Event<Int>> = MutableLiveData()
    val showNoData: MutableLiveData<Event<Boolean>> = MutableLiveData()
    val showLoading: MutableLiveData<Event<Boolean>> = MutableLiveData()
}