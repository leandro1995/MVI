package com.leandro1995.mvi

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.leandro1995.mvi.viewmodel.MainViewModel
import com.leandro1995.mvi.adapter.PostAdapter
import com.leandro1995.mvi.config.callback.MainCallBack
import com.leandro1995.mvi.databinding.ActivityMainBinding
import com.leandro1995.mvi.intent.config.MainIntentConfig
import com.leandro1995.mvi.model.Post
import kotlinx.coroutines.flow.collect

class MainActivity : AppCompatActivity(), MainCallBack {

    private lateinit var activityMainBinding: ActivityMainBinding

    private lateinit var mainViewModel: MainViewModel

    private lateinit var mainIntentConfig: MainIntentConfig

    private lateinit var postAdapter: PostAdapter

    private val postList = mutableListOf<Post>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        observer()

        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        activityMainBinding.mainViewModel = mainViewModel

        view()
    }

    private fun observer() {

        mainIntentConfig = MainIntentConfig.instance(mainCallBack = this)

        mainViewModel.apply {

            lifecycleScope.launchWhenCreated {

                mainIntentFlow.collect {

                    mainIntentConfig.mainCollect(mainIntent = it)
                }
            }
        }
    }

    private fun view() {

        postAdapter = PostAdapter(postList = postList)

        activityMainBinding.apply {

            postRecycler.apply {

                layoutManager = LinearLayoutManager(this@MainActivity).apply {

                    orientation = LinearLayoutManager.VERTICAL
                }

                adapter = postAdapter
            }
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun postList(postList: MutableList<Post>) {

        this.postList.clear()
        this.postList.addAll(postList)

        postAdapter.notifyDataSetChanged()
    }

    override fun progress() {

        activityMainBinding.progress.loading {

            mainViewModel.servicePostList()
        }
    }

    override fun messageError(code: Int, message: String) {

        activityMainBinding.progress.message(code = code, errorMessage = message)
    }
}