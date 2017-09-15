package com.vinarah.pagingexample

import java.util.concurrent.Executors

/**
 * @author Vincent
 * @since 2017/09/15
 */


private val IO_THREAD = Executors.newSingleThreadExecutor()

fun ioThread(func: () ->Unit){
    IO_THREAD.execute(func)
}