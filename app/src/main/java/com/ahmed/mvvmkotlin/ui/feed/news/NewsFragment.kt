package hcww.mvvm.ayounis.com.mvvmproject.ui.feed.news

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ahmed.mvvmkotlin.BR
import com.ahmed.mvvmkotlin.R
import com.ahmed.mvvmkotlin.ViewModelProviderFactory
import com.ahmed.mvvmkotlin.data.model.Articles
import com.ahmed.mvvmkotlin.databinding.FragmentNewsBinding
import com.ahmed.mvvmkotlin.ui.base.BaseFragment
import com.ahmed.mvvmkotlin.ui.feed.news.CheckboxOnItemSelectedListener
import com.ahmed.mvvmkotlin.ui.feed.news.NewsAdapter
import com.ahmed.mvvmkotlin.ui.feed.news.NewsNavigator
import com.ahmed.mvvmkotlin.ui.feed.news.NewsViewModel
import io.reactivex.processors.PublishProcessor
import javax.inject.Inject

/**
 * Created by Ahmed Younis on 3/28/2019.
 */
class NewsFragment : BaseFragment<FragmentNewsBinding, NewsViewModel>(), NewsNavigator,
    NewsAdapter.NewsAdapterListener {

    private var mFragmentNewsBinding: FragmentNewsBinding? = null
    @Inject
    internal lateinit var mLayoutManager: LinearLayoutManager
    @Inject
    internal lateinit var mNewsAdapter: NewsAdapter
    @Inject
    internal lateinit var factory: ViewModelProviderFactory

    private var mNewsViewModel: NewsViewModel? = null
    private var loading = false
    private val VISIBLE_THRESHOLD = 1
    private var lastVisibleItem: Int = 0
    private var totalItemCount: Int = 0
    private var checkboxOnItemSelectedListener: CheckboxOnItemSelectedListener? = null


    override val bindingVariable: Int
        get() = BR.viewModel

    override val layoutId: Int
        get() = R.layout.fragment_news

    override val viewModel: NewsViewModel
        get() {
            mNewsViewModel = ViewModelProviders.of(this, factory).get(NewsViewModel::class.java)
            return mNewsViewModel as NewsViewModel

        }

    override fun handleError(throwable: Throwable) {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mNewsViewModel?.navigator = this
        mNewsAdapter.setListener(this)
        checkboxOnItemSelectedListener?.let { mNewsAdapter.setCheckboxOnItemSelectedListener(it) }

    }

    override fun onRetryClick() {
        mNewsViewModel!!.fetchRepos()
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mFragmentNewsBinding = viewDataBinding
        setUp()
    }

    private fun setUp() {

        mLayoutManager.orientation = LinearLayoutManager.VERTICAL
        mFragmentNewsBinding?.newsRecyclerView?.layoutManager = mLayoutManager
        mFragmentNewsBinding?.newsRecyclerView?.itemAnimator = DefaultItemAnimator()
        mFragmentNewsBinding?.newsRecyclerView?.adapter = mNewsAdapter
        checkboxOnItemSelectedListener =
            CheckboxOnItemSelectedListener { articles, checked ->
                if (checked) {
                    mNewsViewModel?.dataManager?.updateFavorites(checked,articles.id)
                    Log.e("data inserted", "success")
                } else {

                    mNewsViewModel?.dataManager?.updateFavorites(checked,articles.id)
                    Log.e("data removed", "success")

                }
            }
        checkboxOnItemSelectedListener?.let { mNewsAdapter.setCheckboxOnItemSelectedListener(it) }

//        setUpLoadMoreListener()


    }

    private fun setUpLoadMoreListener() {
        mFragmentNewsBinding?.newsRecyclerView?.addOnScrollListener(object :
            RecyclerView.OnScrollListener() {
            override fun onScrolled(
                recyclerView: RecyclerView,
                dx: Int, dy: Int
            ) {
                super.onScrolled(recyclerView, dx, dy)

                totalItemCount = mLayoutManager.itemCount
                lastVisibleItem = mLayoutManager
                    .findLastVisibleItemPosition()

                if (!loading && totalItemCount <= lastVisibleItem + VISIBLE_THRESHOLD) {
                    //                    mNewsViewModel.setPageNumber();
                    loading = true
                    mNewsViewModel?.setIsLoading(loading)
                    mNewsViewModel?.fetchRepos()
                    mNewsAdapter.notifyDataSetChanged()
                }
            }
        })
    }

    companion object {

        fun newInstance(): NewsFragment {
            val args = Bundle()
            val fragment = NewsFragment()
            fragment.arguments = args
            return fragment
        }
    }

}
