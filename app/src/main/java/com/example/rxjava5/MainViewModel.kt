package com.example.rxjava5

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.rxjava5.data.ManagerEntity
import com.example.rxjava5.domain.Manager


class MainViewModel: ViewModel() {

    var managerEntityLiveData = MutableLiveData<ManagerEntity>().apply {
        postValue(ManagerEntity(1, "Top Manager"))
    }
    lateinit var managerDomainLiveData : MutableLiveData<Manager>

    var managerDomainLiveData = MutableLiveData<Manager>()Transformations.map(managerEntityLiveData, {
    })

}