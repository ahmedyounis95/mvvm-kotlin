package com.ahmed.mvvmkotlin.ui.splash

import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.ahmed.mvvmkotlin.BR
import com.ahmed.mvvmkotlin.R
import com.ahmed.mvvmkotlin.ViewModelProviderFactory
import com.ahmed.mvvmkotlin.databinding.ActivitySplashBinding
import com.ahmed.mvvmkotlin.ui.base.BaseActivity
import javax.inject.Inject

/**
 * Created by Ahmed Younis on 7/31/2019.
 */

class SplashActivity : BaseActivity<ActivitySplashBinding, SplashViewModel>(), SplashNavigator {

    //To change initializer of created properties use File | Settings | File Templates.

    @set:Inject
    internal var factory: ViewModelProviderFactory? = null
    private var mSplashViewModel: SplashViewModel? = null

    override fun bindingVariable(): Int {
        return BR.viewModel
    }

    override fun layoutId(): Int {
        return R.layout.activity_splash
    }

    override fun viewModel(): SplashViewModel {
        mSplashViewModel = ViewModelProviders.of(this, factory).get(SplashViewModel::class.java!!)
        return mSplashViewModel as SplashViewModel

    }

    override fun openMainActivity() {
//        val intent = MainActivity.newIntent(this@SplashActivity)
//
//        startActivity(intent)
//        finish()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mSplashViewModel!!.navigator = this
        performDependencyInjection()
//        mSplashViewModel!!.startSeeding()
    }
}
