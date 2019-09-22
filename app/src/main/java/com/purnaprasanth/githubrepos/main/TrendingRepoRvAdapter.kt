package com.purnaprasanth.githubrepos.main

import android.content.Context
import androidx.recyclerview.widget.DiffUtil
import coil.ImageLoader
import coil.api.load
import coil.transform.CircleCropTransformation
import com.purnaprasanth.githubrepos.R
import com.purnaprasanth.githubrepos.annotations.GitHub
import com.purnaprasanth.githubrepos.baseandroid.SingleTypeBaseRvAdapter
import com.purnaprasanth.githubrepos.data.model.TrendingRepo
import com.purnaprasanth.githubrepos.databinding.RepoItemBinding
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Purna on 2019-09-21 as a part of GithubRepos
 **/
class TrendingRepoRvAdapter @Inject constructor(
    context: Context,
    trendingRepoListItemDiffCallback: TrendingRepoListItemDiffCallback,
    @GitHub val githubImageLoader: ImageLoader
) : SingleTypeBaseRvAdapter<RepoItemBinding, TrendingRepo>(
    context,
    R.layout.repo_item,
    trendingRepoListItemDiffCallback
) {

    override fun onBindViewHolder(binding: RepoItemBinding, position: Int) {
        val trendingRepo = getItem(position)
        binding.repoName.text = trendingRepo.name
        binding.repoAuthor.text = trendingRepo.author
        binding.repoAvatar.load(trendingRepo.avatar, githubImageLoader) {
            transformations(CircleCropTransformation())
        }
    }

}

@Singleton
class TrendingRepoListItemDiffCallback @Inject constructor() : DiffUtil.ItemCallback<TrendingRepo>() {
    override fun areItemsTheSame(oldItem: TrendingRepo, newItem: TrendingRepo) = oldItem.url == newItem.url

    override fun areContentsTheSame(oldItem: TrendingRepo, newItem: TrendingRepo) = oldItem == newItem

}