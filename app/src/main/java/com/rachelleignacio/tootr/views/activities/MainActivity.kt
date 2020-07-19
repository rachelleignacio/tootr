package com.rachelleignacio.tootr.views.activities

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.rachelleignacio.tootr.R
import com.rachelleignacio.tootr.mvi.Intent
import com.rachelleignacio.tootr.mvi.ViewState
import com.rachelleignacio.tootr.mvi.viewmodels.MainViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.subjects.PublishSubject

import kotlinx.android.synthetic.main.activity_main.*
import java.lang.IllegalArgumentException

class MainActivity : AppCompatActivity() {

    private val mainViewModel: MainViewModel by viewModels()
    private val intents = PublishSubject.create<Intent>()
    private val disposables = CompositeDisposable()

    private val navigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            return@OnNavigationItemSelectedListener when (item.itemId) {
                R.id.navigation_clients -> showFragment()
                R.id.navigation_packages -> showFragment()
                else -> false
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        main_navigation.init()
        initViewModelCycle()
    }

    private fun BottomNavigationView.init() {
        setOnNavigationItemSelectedListener(navigationItemSelectedListener)
        selectedItemId = R.id.navigation_clients
    }

    private fun initViewModelCycle() {
        Log.d("RIStuff", "MainActivity subscribeToViewModel()")
        mainViewModel
            .viewStates()
            .distinctUntilChanged()
            .subscribe { newViewState -> render(newViewState) }
            .addTo(disposables)

        intents
            .startWith(Intent.ViewClientList())
            .subscribe { mainViewModel.processIntent(it) }
            .addTo(disposables)
    }

    private fun render(incomingViewState: ViewState) {
        Log.d("RIStuff", "MainActivity render()")
        when (incomingViewState) {
            is ViewState.Main -> Log.d("MainActivity.render()", "ViewState.Main")
            else -> throw IllegalArgumentException("MainActivity.processViewState() not yet implemented")
        }
    }

    private fun showFragment(): Boolean {
        //TODO
        return true
    }

    public override fun onDestroy() {
        super.onDestroy()
        disposables.clear()
    }

//    override fun onCreateOptionsMenu(menu: Menu): Boolean {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        menuInflater.inflate(R.menu.navigation, menu)
//        return true
//    }

//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        return when (item.itemId) {
//            R.id.action_settings -> true
//            else -> super.onOptionsItemSelected(item)
//        }
//    }
}
