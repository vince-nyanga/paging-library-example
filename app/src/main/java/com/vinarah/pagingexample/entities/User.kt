package com.vinarah.pagingexample.entities

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.support.v7.recyclerview.extensions.DiffCallback

/**
 * @author Vincent
 * @since 2017/09/15
 */
@Entity(tableName = "users")
data class User(@PrimaryKey(autoGenerate = true)val id: Int, val name: String, val surname:
String="Nyanga"){
    companion object {
        val DIFF_CALLBACK = object: DiffCallback<User>(){
            override fun areContentsTheSame(oldItem: User, newItem: User): Boolean = oldItem == newItem

            override fun areItemsTheSame(oldItem: User, newItem: User): Boolean =  oldItem == newItem

        }
    }
}