package com.nytimes.ui.articles

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.nytimes.core.base.BaseFragment
import com.nytimes.core.data.remote.APIResult
import com.nytimes.utils.gone
import com.nytimes.utils.visible
import com.google.android.material.snackbar.Snackbar
import com.nytimes.core.data.model.ResultsItem
import com.nytimes.databinding.FragmentArticlesBinding
import com.nytimes.interfaces.OnArticleClickListener
import javax.inject.Inject

/**
 * @author: MOHAMMAD MISBAH
 * @since: 16-Jul-2022
 * @sample: Technology Assessment for Android Role
 * @desc ArticlesFragment is main listing of the articles
 * Email Id: mohammadmisbahazmi@gmail.com
 * GitHub: https://github.com/misbahazmi
 * Expertise: Android||Java||Flutter
 * A simple [Fragment] subclass as the default destination in the navigation.
 */

class ArticlesFragment : BaseFragment<ArticlesViewModel>(), OnArticleClickListener {

    private var _binding: FragmentArticlesBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    @Inject lateinit var factory: ViewModelProvider.Factory
    internal lateinit var viewModel: ArticlesViewModel

    override fun getViewModel(): ArticlesViewModel {
        viewModel = ViewModelProvider(viewModelStore, factory)[ArticlesViewModel::class.java]
        return viewModel
    }

    lateinit var adapter: ArticlesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter = ArticlesAdapter()
        adapter.setArticleClickListener(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentArticlesBinding.inflate(inflater, container, false)
        binding.viewModel= viewModel
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        binding.recyclerArticles.layoutManager =
            LinearLayoutManager(
                requireContext(), LinearLayoutManager.VERTICAL,
                false
            )

        binding.recyclerArticles.adapter = adapter
        observerArticlesObservable()
        //viewModel.getArticles(BuildConfig.Section, BuildConfig.Period)
    }

    private fun observerArticlesObservable(){
        viewModel.articlesObservable.observe(viewLifecycleOwner){ result->
            when(result?.status){
                APIResult.Status.LOADING->{
                    binding.progressbar.visible()
                }
                APIResult.Status.SUCCESS->{
                    if (result.data != null) {
                        adapter.refreshList(result.data.results)
                    }
                    binding.recyclerArticles.visible()
                    binding.progressbar.gone()
                }
                APIResult.Status.ERROR->{
                    result.message?.let {
                        Snackbar.make(
                            binding.recyclerArticles,
                            it,
                            Snackbar.LENGTH_LONG
                        ).show()
                    }
                    binding.recyclerArticles.visible()
                    binding.progressbar.gone()
                }
                else->{
                    result.message?.let {
                        Snackbar.make(
                            binding.recyclerArticles,
                            it,
                            Snackbar.LENGTH_LONG
                        ).show()
                    }
                    binding.recyclerArticles.visible()
                    binding.progressbar.gone()
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onArticleClick(article: ResultsItem) {
        findNavController().navigate(ArticlesFragmentDirections.actionArticlesFragmentToArticleDetailFragment(article,  article.title!!))
    }
}