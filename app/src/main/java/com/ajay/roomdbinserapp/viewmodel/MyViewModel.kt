package com.ajay.roomdbinserapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ajay.roomdbinserapp.repository.UserRepository
import com.ajay.roomdbinserapp.roomdatabase.User
import kotlinx.coroutines.launch

class MyViewModel(private val userRepository: UserRepository) : ViewModel() {



    var firstName = MutableLiveData<String?>()
    var lastName = MutableLiveData<String?>()
    var mobileNo = MutableLiveData<String?>()

    var saveData = MutableLiveData<String?>()
    var fetchData = MutableLiveData<String>()


    //TODO: Initializing values to any button or text view at first time
    init {
        //TODO: Setting value to Mutable Live Data
        saveData.value= "SAVE Data"
        fetchData.value= "Fetch Data"

    }


    fun saveDtaOnClick(){

        val fName = firstName.value!!
        val lName = lastName.value!!
        val mobNo = mobileNo.value!!
        insert(User(0, fName, lName, mobNo))


    }

    private fun insert(user: User) {
        viewModelScope.launch {
            userRepository.insert(user)
        }
    }


    val usersList = userRepository.users



}