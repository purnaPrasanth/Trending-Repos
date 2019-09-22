package com.purnaprasanth.githubrepos.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import com.purnaprasanth.githubrepos.R
import com.purnaprasanth.githubrepos.databinding.ViewErrorScreenBinding

/**
 * Created by Purna on 2019-09-22 as a part of GithubRepos
 **/
class ErrorView : ConstraintLayout {

    lateinit var binding: ViewErrorScreenBinding

    var retryListener: RetryListener? = null

    constructor(context: Context) : super(context) {
        initView()
    }

    constructor(context: Context, attributes: AttributeSet) : super(context, attributes) {
        initView()
    }

    constructor(context: Context, attributes: AttributeSet, defStyle: Int) : super(context, attributes, defStyle) {
        initView()
    }

    private fun initView() {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        binding = DataBindingUtil.inflate(inflater, R.layout.view_error_screen, this, true)
        binding.retryTv.setOnClickListener {
            retryListener?.onRetry()
        }
    }

    fun SetOnRetryListener(retryListener: RetryListener) {
        this.retryListener = retryListener
    }
}

interface RetryListener {
    fun onRetry()
}