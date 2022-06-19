package com.ajay.roomdbinserapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ajay.roomdbinserapp.R
import com.ajay.roomdbinserapp.adapter.MyRecyclerViewAdapter
import com.ajay.roomdbinserapp.databinding.ActivityDisplayBinding
import com.ajay.roomdbinserapp.factory.UserViewModelFactory
import com.ajay.roomdbinserapp.repository.UserRepository
import com.ajay.roomdbinserapp.roomdatabase.UserDatabase
import com.ajay.roomdbinserapp.viewmodel.MyViewModel

class DisplayActivity : AppCompatActivity() {
    private lateinit var binding : ActivityDisplayBinding
    private lateinit var myViewModel: MyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_display)


        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        //TODO: Initializing all the MVVM concepts used here
        val dao = UserDatabase.getInstance(this).dao
        val userRepository = UserRepository(dao)
        val factory = UserViewModelFactory(userRepository)
        myViewModel = ViewModelProvider(this, factory)[MyViewModel::class.java]

        //TODO: Giving lifecycle owner to layout file
        binding.displayviewmodel = myViewModel

        //TODO: Giving lifecycle owner to layout file
        binding.lifecycleOwner = this

        userDisplayList()

    }

    private fun userDisplayList(){
        myViewModel.usersList.observe(this, Observer {
            binding.recyclerView.adapter = MyRecyclerViewAdapter(it)
        })

    }
}