package com.example.londonsightseensapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.londonsightseensapp.App
import com.example.londonsightseensapp.R
import com.example.londonsightseensapp.databinding.ActivityMainBinding
import com.example.londonsightseensapp.presenter.MainPresenter
import com.example.londonsightseensapp.utils.BackButtonListener
import com.example.londonsightseensapp.view.IMainView
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.androidx.AppNavigator
import com.github.terrakok.cicerone.androidx.FragmentScreen
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter
import javax.inject.Inject

class MainActivity : MvpAppCompatActivity(), IMainView {

    @Inject
    lateinit var navigationHolder: NavigatorHolder
//    val navigator = AppNavigator(this, R.id.container)

    val navigator = object : AppNavigator(this, R.id.container) {
        override fun setupFragmentTransaction(
                screen: FragmentScreen,
                fragmentTransaction: FragmentTransaction,
                currentFragment: Fragment?,
                nextFragment: Fragment
        ) {
            fragmentTransaction.setCustomAnimations(
                    R.anim.slide_in,
                    R.anim.fade_out,
                    R.anim.fade_in,
                    R.anim.slide_out)
        }
    }

    private var binding: ActivityMainBinding? = null
    private val presenter by moxyPresenter {
        MainPresenter().apply {
            App.instance.appComponent.inject(
                this
            )
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_LondonSightseensApp)
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        App.instance.appComponent.inject(this)
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigationHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        navigationHolder.removeNavigator()
    }

    override fun onBackPressed() {
        supportFragmentManager.fragments.forEach {
            if (it is BackButtonListener && it.backPressed()) {
                return
            }
        }
        presenter.backClicked()
        super.onBackPressed()
    }
}