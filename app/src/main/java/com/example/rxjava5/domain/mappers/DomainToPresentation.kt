/**
 *
 * Copyright 2020 David Odari
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *            http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 *
 **/
package com.example.rxjava5.domain.mappers

import com.example.rxjava5.data.ManagerEntity
import com.example.rxjava5.data.PersonEntity
import com.example.rxjava5.domain.Manager
import com.example.rxjava5.domain.Person
import com.example.rxjava5.presentation.ManagerItem
import com.example.rxjava5.presentation.PersonItem


internal fun Person.toPresentation(): PersonItem {
    return PersonItem(
            id = id,
            name = name
    )
}

internal fun Manager.toPresentation(): ManagerItem = ManagerItem(id, name)

