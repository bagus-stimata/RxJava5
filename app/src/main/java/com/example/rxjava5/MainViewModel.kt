package com.example.rxjava5

import androidx.lifecycle.*
import com.example.rxjava5.data.PersonEntity
import com.example.rxjava5.domain.Person

class MainViewModel: ViewModel() {


    private val personEntity = MutableLiveData<PersonEntity>()
    private val personDomain : LiveData<Person> = Transformations.map<PersonEntity, Person>(personEntity,::conversionData)

    private fun conversionData(personEntity: PersonEntity): Person =
        if (personEntity.id == null) {
            Person(0, "")
        }else{
            Person(personEntity.id, personEntity.name)
        }

    fun getPersonDomain() : LiveData<Person> {
        return personDomain
    }

    fun setPersonEntity(personEntity: PersonEntity) : MainViewModel =
        //This will be use for the back end like calling retrofit data or
        apply {
            this.personEntity.setValue(personEntity)
        }

}


class PersonEntityMapper(){

}

