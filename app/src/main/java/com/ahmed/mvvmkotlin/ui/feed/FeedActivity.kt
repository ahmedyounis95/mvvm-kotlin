package com.ahmed.mvvmkotlin.ui.feed

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.core.app.NavUtils
import androidx.core.app.TaskStackBuilder
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.ahmed.mvvmkotlin.BR
import com.ahmed.mvvmkotlin.R
import com.ahmed.mvvmkotlin.ViewModelProviderFactory
import com.ahmed.mvvmkotlin.databinding.ActivityFeedBinding
import com.ahmed.mvvmkotlin.ui.base.BaseActivity
import com.google.android.material.tabs.TabLayout
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

/**
 * Created by Ahmed Younis on 10/27/2019.
 */
class FeedActivity : BaseActivity<ActivityFeedBinding, FeedViewModel>(), HasSupportFragmentInjector {

    @Inject
    internal lateinit var fragmentDispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>
    @Inject
    internal lateinit var mPagerAdapter: FeedPagerAdapter
    @Inject
    internal lateinit var factory: ViewModelProviderFactory

    private var mActivityFeedBinding: ActivityFeedBinding? = null

    private var mFeedViewModel: FeedViewModel? = null


    override fun bindingVariable(): Int {
        return BR.viewModel
    }

    override fun layoutId(): Int {
        return R.layout.activity_feed
    }

    override fun viewModel(): FeedViewModel {
        mFeedViewModel = ViewModelProviders.of(this, factory).get(FeedViewModel::class.java)
        return mFeedViewModel as FeedViewModel
    }

    fun newIntent(context: Context): Intent {
        return Intent(context, FeedActivity::class.java)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            // Respond to the action bar's Up/Home button
            android.R.id.home -> {
                val upIntent = NavUtils.getParentActivityIntent(this)
                upIntent!!.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                if (NavUtils.shouldUpRecreateTask(this, upIntent)) {
                    // This activity is NOT part of this app's task, so create a new task
                    // when navigating up, with a synthesized back stack.
                    TaskStackBuilder.create(this)
                        // Add all of this activity's parents to the back stack
                        .addNextIntentWithParentStack(upIntent)
                        // Navigate up to the closest parent
                        .startActivities()
                } else {
                    // This activity is part of this app's task, so simply
                    // navigate up to the logical parent activity.
                    NavUtils.navigateUpTo(this, upIntent)
                }
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment>? {
        return fragmentDispatchingAndroidInjector
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mActivityFeedBinding = viewDataBinding
        setUp()
    }

    private fun setUp() {
        setSupportActionBar(mActivityFeedBinding?.toolbar)

        mPagerAdapter.count = 2

        mActivityFeedBinding?.feedViewPager?.adapter = mPagerAdapter

        mActivityFeedBinding?.tabLayout?.newTab()?.setText(getString(R.string.news))?.let {
            mActivityFeedBinding?.tabLayout?.addTab(
                it
            )
        }
        mActivityFeedBinding?.tabLayout?.newTab()?.setText(getString(R.string.favorites))?.let {
            mActivityFeedBinding?.tabLayout?.addTab(
                it
            )
        }

        mActivityFeedBinding?.feedViewPager?.offscreenPageLimit = mActivityFeedBinding!!.tabLayout.tabCount

        mActivityFeedBinding?.feedViewPager?.addOnPageChangeListener(
            TabLayout.TabLayoutOnPageChangeListener(
                mActivityFeedBinding?.tabLayout
            )
        )

        mActivityFeedBinding?.tabLayout?.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab) {

            }

            override fun onTabSelected(tab: TabLayout.Tab) {
                mActivityFeedBinding?.feedViewPager?.currentItem = tab.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}
        })
    }


}
