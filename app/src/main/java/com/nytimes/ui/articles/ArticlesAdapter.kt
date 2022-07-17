package com.nytimes.ui.articles

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.library.baseAdapters.BR
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.nytimes.R
import com.nytimes.core.data.model.ResultsItem
import com.nytimes.databinding.ItemArticlesBinding
import com.nytimes.interfaces.OnArticleClickListener

/**
 * @author: MOHAMMAD MISBAH
 * @since: 16-Jul-2022
 * @sample: Technology Assessment for Android Role
 * @desc ArticlesFragment listing by this adapter
 * Email Id: mohammadmisbahazmi@gmail.com
 * GitHub: https://github.com/misbahazmi
 * Expertise: Android||Java||Flutter
 */
class ArticlesAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var articleList: List<ResultsItem?>? = emptyList()
    private var onArticleClickListener: OnArticleClickListener? = null

    fun setArticleClickListener(listener : OnArticleClickListener){
        this.onArticleClickListener = listener
    }

    inner class ItemViewHolder(var binding: ItemArticlesBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindData(pos: Int) {
            val data = articleList!![pos]
            binding.apply {
                setVariable(BR.data, data)
                setVariable(BR.itemClickListener, onArticleClickListener)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ItemArticlesBinding>(inflater, R.layout.item_articles, parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            (holder as ItemViewHolder).bindData(position)
    }

    override fun getItemCount(): Int {
        return articleList!!.size
    }


    fun refreshList(articles: List<ResultsItem?>?) {
        this.articleList = articles
        notifyDataSetChanged()
    }
}