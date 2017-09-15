package com.vinarah.pagingexample

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.Toast
import com.vinarah.pagingexample.adapters.UserAdapter
import com.vinarah.pagingexample.viewmodels.UserViewModel

/**
 * @author Vincent
 * @since 2017/09/15
 */
class MainActivity: AppCompatActivity() {

    private val viewModel  by lazy(LazyThreadSafetyMode.NONE) {
        ViewModelProviders.of(this).get(UserViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = UserAdapter()

        val userList = findViewById<RecyclerView>(R.id.userList)

        userList.adapter = adapter

        viewModel.allUsers.observe(this, Observer{list ->
            adapter.setList(list)
            list?.forEach{user-> Log.d("MainActivity", "User${user?.toString()}")}
        } )
    }
}