package com.ajay.roomdbinserapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ajay.roomdbinserapp.databinding.DisplayItemsBinding
import com.ajay.roomdbinserapp.roomdatabase.User

class MyRecyclerViewAdapter(private val userList: List<User>) : RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = DisplayItemsBinding.inflate(layoutInflater, parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(userList[position])
    }

    override fun getItemCount(): Int {
        return userList.size
    }


    inner class MyViewHolder(val binding: DisplayItemsBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(user: User) {
            binding.yourName.text = user.firstName+" "+user.lName
            binding.mobileNumber.text = user.mobileNo

        }
    }



}