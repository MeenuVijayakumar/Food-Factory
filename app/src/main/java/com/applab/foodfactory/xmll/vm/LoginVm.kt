package com.applab.foodfactory.xmll.vm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginVm:ViewModel() {
    val loginResult  = MutableLiveData<String>()

    fun login(uName:String,password:String){
        loginResult.value = when{
            uName.isBlank()||password.isBlank()-> "Please enter uname and pswd"
            uName =="admin" && password =="1234"->"Login successful"
            else -> "Invalid credential"
        }
    }
}