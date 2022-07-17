package com.nytimes.ui.main

import android.os.Bundle
import androidx.core.view.WindowCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.nytimes.R
import com.nytimes.core.base.BaseActivity
import com.nytimes.databinding.ActivityMainBinding
import javax.inject.Inject


/**
 * @author: MOHAMMAD MISBAH
 * @since: 16-Jul-2022
 * @sample: Technology Assessment for Android Role
 * @desc MainActivity of the sample project
 * Email Id: mohammadmisbahazmi@gmail.com
 * GitHub: https://github.com/misbahazmi
 * Expertise: Android||Java||Flutter
 */
class MainActivity : BaseActivity<MainViewModel>() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    @Inject internal lateinit var viewModel: MainViewModel
    override fun getViewModel(): MainViewModel {
        return viewModel
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)
    }


    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}