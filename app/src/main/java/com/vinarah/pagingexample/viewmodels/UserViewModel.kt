package com.vinarah.pagingexample.viewmodels

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.paging.PagedList
import com.vinarah.pagingexample.db.UsersDb

/**
 * @author Vincent
 * @since 2017/09/15
 */
class UserViewModel(app: Application): AndroidViewModel(app) {

    val userDao = UsersDb.get(app).userDao()
    val allUsers = userDao.getUsers()
            .create(0,PagedList.Config.Builder()
                    .setPageSize(PAGE_SIZE)
                    .setPrefetchDistance(PREFETCH_DISTANCE)
                    .setEnablePlaceholders(ENABLE_PLACEHOLDERS).build())

    companion object {
        private const val PAGE_SIZE = 15
        private const val PREFETCH_DISTANCE = 5
        private const val ENABLE_PLACEHOLDERS = true
    }
}