package com.rachelleignacio.tootr.mvi

import com.rachelleignacio.tootr.data.models.Client
import com.rachelleignacio.tootr.data.repository.DummyRepo
import io.reactivex.Single

sealed class Action {

    fun toResult(repo: DummyRepo): Single<Result> =
        when (this) {
            is GetClientList -> getList(repo)
            is GetClient -> Single.just(Result.ClientDetail(client))
        }

    class GetClientList : Action() {
        fun getList(repo: DummyRepo): Single<Result> = repo.dummyClientList.map { Result.ClientList(it) }
    }

    data class GetClient(val currentViewState: ViewState.Main, val client: Client) : Action()
}

