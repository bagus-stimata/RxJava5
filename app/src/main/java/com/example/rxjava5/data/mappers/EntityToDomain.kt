package com.example.rxjava5.data.mappers

import com.example.rxjava5.data.ManagerEntity
import com.example.rxjava5.data.PersonEntity
import com.example.rxjava5.domain.Manager
import com.example.rxjava5.domain.Person


internal fun PersonEntity.toDomain(manager: Manager): Person = Person(id, name, manager)

internal fun ManagerEntity.toDomain(): Manager = Manager(id, name)
