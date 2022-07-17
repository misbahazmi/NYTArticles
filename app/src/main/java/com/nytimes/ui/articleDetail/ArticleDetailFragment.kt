package com.nytimes.ui.articleDetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.nytimes.core.base.BaseFragment
import com.nytimes.databinding.FragmentArticleDetailBinding
import javax.inject.Inject

/**
 * @author: MOHAMMAD MISBAH
 * @since: 16-Jul-2022
 * @sample: Technology Assessment for Android Role
 * @desc ArticleDetailFragment for details display of the article
 * Email Id: mohammadmisbahazmi@gmail.com
 * GitHub: https://github.com/misbahazmi
 * Expertise: Android||Java||Flutter
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class ArticleDetailFragment : BaseFragment<ArticleDetailViewModel>() {

    private val articleModelArgs: ArticleDetailFragmentArgs by navArgs()
    private var _binding: FragmentArticleDetailBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    @Inject
    lateinit var factory: ViewModelProvider.Factory
    internal lateinit var viewModel: ArticleDetailViewModel

    override fun getViewModel(): ArticleDetailViewModel {
        viewModel = ViewModelProvider(viewModelStore, factory)[ArticleDetailViewModel::class.java]
        return viewModel
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentArticleDetailBinding.inflate(inflater, container, false)
        viewModel.articleData.value= articleModelArgs.articleModel
        binding.viewModel= viewModel
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}