package com.example.rxjava5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.rxjava5.data.PersonEntity
import com.example.rxjava5.databinding.MainBinder
import com.example.rxjava5.domain.Person

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainViewModel
    lateinit var binding: MainBinder

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

//        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding = MainBinder.inflate(layoutInflater)
        setContentView(binding.root)

        binding.viewModel = viewModel
        //binding.setLifecycleOwner()

        setLiveDataObservers()
        setEventListeners()

    }

    private fun setLiveDataObservers() {
        //viewModel.getData().observe(this, Observer { string -> binding.textResult.text = string })
//        viewModel.getData().observe(this, object : Observer<String> {
//            override fun onChanged(string: String) {
//                binding.textResult.text = string
//            }
//        })

        viewModel.getPersonDomain().observe(this, object : Observer<Person> {
            override fun onChanged(person: Person) {
                binding.textResult.text = person.name
            }
        })
    }


    private fun setEventListeners() {
        /*binding.buttonSendData.setOnClickListener {
            binding.viewModel!!.setData(
                    CustomModel(
                            binding.editTextFirstName.text.toString(),
                            binding.editTextLastName.text.toString()
                    )
            )
        }*/
        binding.buttonSendData.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View) {
                //This was for the sample for the transformations map
                //This call is intended to use in the back end calling
                binding.viewModel!!.setPersonEntity(
                    PersonEntity(
                        binding.editTextId.text.toString().toLong(),
//                        12,
                        binding.editTextName.text.toString()
                    )
                )
            }

        })
    }

}