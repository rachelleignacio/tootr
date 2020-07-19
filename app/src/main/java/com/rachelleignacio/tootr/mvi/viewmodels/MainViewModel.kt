package com.rachelleignacio.tootr.mvi.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import com.rachelleignacio.tootr.data.repository.DummyRepo
import com.rachelleignacio.tootr.mvi.Intent
import com.rachelleignacio.tootr.mvi.ViewState
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject

class MainViewModel : ViewModel() {

    private val viewIntents = PublishSubject.create<Intent>()
    private val currentViewState = PublishSubject.create<ViewState.Main>()

    init {
        Log.d("RIStuff", "MainViewModel init")
        viewIntents
            .doOnNext { Log.d("RIStuff", "MainViewModel viewIntents.doOnNext{} $it") }
            .map { intent -> intent.toAction() }
            .doOnNext { Log.d("RIStuff", "MainViewModel zipWith.doOnNext{}") }
            .flatMap { it.toResult(DummyRepo).toObservable() }
            .doOnNext { Log.d("RIStuff", "MainViewModel flatMap.doOnNext{}") }
            .map { result -> result.toViewState() }
            .doOnNext { Log.d("RIStuff", "MainViewModel map.doOnNext{}") }
            .subscribe(currentViewState)
    }


    fun processIntent(newIntent: Intent) {
        Log.d("RIStuff", "MainViewModel processIntent()")
        viewIntents.onNext(newIntent)
    }

    fun viewStates(): Observable<ViewState.Main> {
        Log.d("RIStuff", "MainViewModel viewState()")
        return currentViewState
    }
}