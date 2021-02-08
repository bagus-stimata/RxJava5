package com.example.rxjava5

import androidx.lifecycle.*
import com.example.rxjava5.data.PersonEntity
import com.example.rxjava5.data.mappers.toDomain
import com.example.rxjava5.domain.Manager
import com.example.rxjava5.domain.Person
import com.example.rxjava5.presentation.PersonItem


class MainViewModel: ViewModel() {

    private val TAG = MainViewModel::class.java.simpleName
    init {
    }

    private val personEntity = MutableLiveData<PersonEntity>()
//    private val personDomain : LiveData<Person> = Transformations
//            .map<PersonEntity, Person>(personEntity,::conversionData)
//    private fun conversionData(personEntity: PersonEntity): Person =
//        if (personEntity.id == null) {
//            Person(0, "")
//        }else{
//            Person(personEntity.id, personEntity.name)
//        }
    fun getPersonDomain() : LiveData<Person> {
        return personDomain
    }
    private val personDomain : LiveData<Person> = Transformations
            .map<PersonEntity, Person>(personEntity, {
                val manager = getManager(it.id)
                it.toDomain(manager)

            })



    fun setPersonEntity(personEntity: PersonEntity) : MainViewModel =
        //This will be use for the back end like calling retrofit data or
        apply {
            this.personEntity.setValue(personEntity)
        }


    fun getPersonItem() : LiveData<PersonItem> {
        return personItem
    }

    private val personItem  = Transformations
            .switchMap<Person, PersonItem>(personDomain, {

                getPersonWithManager(it)
            })


    fun getPersonWithManager(person: Person) : LiveData<PersonItem> {
        val newPersonItemLive : MutableLiveData<PersonItem> = MutableLiveData()

//
//        if (varId ==1L){
//            newPersonItemLive.value = PersonItem(1, "Tukang Bos Manager")
//
//        }else {
//            newPersonItemLive.value = PersonItem(0, "Manajer Kelas Atas")
//        }


        return newPersonItemLive
    }
    fun getManager(varId: Long) : Manager {
//        val newManagerLive : MutableLiveData<Manager> = MutableLiveData()
        val newManagerLive : Manager

        if (varId ==1L){
            newManagerLive = Manager(1, "Tukang Bos Manager")

        }else {
            newManagerLive = Manager(0, "Manajer Kelas Atas")
        }


        return newManagerLive
    }


    private val person  = Transformations
            .switchMap<Person, PersonItem>(personDomain, {
//                it.toPresentation()
                getPersonWithManager(it.id)

            })

    protected fun onCreateXX() {
//        personDomain
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .flatMap(object : Function<Person?, Observable<User?>?>() {
//                    @Throws(Exception::class)
//                    fun apply(user: User?): Observable<User?>? {
//
//                        // getting each user address by making another network call
//                        return getAddressObservable(user)
//                    }
//                })
//                .subscribe(object : Observer<User?>() {
//                    fun onSubscribe(d: Disposable) {
//                        Log.e(TAG, "onSubscribe")
//                        disposable = d
//                    }
//
//                    fun onNext(user: User) {
//                        Log.e(TAG, "onNext: " + user.getName() + ", " + user.getGender() + ", " + user.getAddress().getAddress())
//                    }
//
//                    fun onError(e: Throwable?) {}
//                    fun onComplete() {
//                        Log.e(TAG, "All users emitted!")
//                    }
//                })
    }


    /**
     * Assume this as a network call
     * returns Users with address filed added
     */
//    private fun getAddressObservable(user: User): Observable<User?>? {
//        val addresses = arrayOf(
//                "1600 Amphitheatre Parkway, Mountain View, CA 94043",
//                "2300 Traverwood Dr. Ann Arbor, MI 48105",
//                "500 W 2nd St Suite 2900 Austin, TX 78701",
//                "355 Main Street Cambridge, MA 02142"
//        )
//        return Observable
//                .create(ObservableOnSubscribe<Any?> { emitter ->
//                    val address = Address()
//                    address.setAddress(addresses[Random().nextInt(2) + 0])
//                    if (!emitter.isDisposed) {
//                        user.setAddress(address)
//
//
//                        // Generate network latency of random duration
//                        val sleepTime: Int = Random().nextInt(1000) + 500
//                        Thread.sleep(sleepTime.toLong())
//                        emitter.onNext(user)
//                        emitter.onComplete()
//                    }
//                }).subscribeOn(Schedulers.io())
//    }

    /**
     * Assume this is a network call to fetch users
     * returns Users with name and gender but missing address
     */
//    private fun getUsersObservable(): Observable<User?>? {
//        val maleUsers = arrayOf("Mark", "John", "Trump", "Obama")
//        val users: MutableList<User> = ArrayList()
//        for (name in maleUsers) {
//            val user: User = User()
//            user.setName(name)
//            user.setGender("male")
//            users.add(user)
//        }
//        return Observable
//                .create(ObservableOnSubscribe<Any?> { emitter ->
//                    for (user in users) {
//                        if (!emitter.isDisposed) {
//                            emitter.onNext(user)
//                        }
//                    }
//                    if (!emitter.isDisposed) {
//                        emitter.onComplete()
//                    }
//                }).subscribeOn(Schedulers.io())
//    }


}

