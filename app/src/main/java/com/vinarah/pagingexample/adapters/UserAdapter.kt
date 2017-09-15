package com.vinarah.pagingexample.adapters

import android.arch.paging.PagedListAdapter
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.vinarah.pagingexample.R
import com.vinarah.pagingexample.entities.User

/**
 * @author Vincent
 * @since 2017/09/15
 */
class UserAdapter: PagedListAdapter<User, UserAdapter.UserViewHolder>(User.DIFF_CALLBACK){

    override fun onBindViewHolder(holder: UserViewHolder?, position: Int) {
        holder?.bindTo(getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): UserViewHolder =
            UserViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.user_item,parent,
            false))


    class UserViewHolder(view: View): RecyclerView.ViewHolder(view){

        private val nameTextView = itemView.findViewById<TextView>(R.id.name)

        fun bindTo(user: User?){
            nameTextView.text = ("${user?.name} ${user?.surname}")
        }
    }

}