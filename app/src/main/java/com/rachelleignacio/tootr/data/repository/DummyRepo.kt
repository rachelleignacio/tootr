package com.rachelleignacio.tootr.data.repository

import com.rachelleignacio.tootr.data.models.Client
import io.reactivex.Single

object DummyRepo {

    val dummyClientList = Single.just(setOf(Client("Rachelle", 1), Client("Ruby")))
}