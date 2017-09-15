package com.vinarah.pagingexample.dao

import android.arch.paging.LivePagedListProvider
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.vinarah.pagingexample.entities.User

/**
 * @author Vincent
 * @since 2017/09/15
 */
@Dao
interface UserDao {

    @Query("SELECT * FROM users ORDER BY name ASC")
    fun getUsers(): LivePagedListProvider<Int, User>

    @Insert
    fun insert(users: List<User>)

    @Insert
    fun insert(user: User)

}