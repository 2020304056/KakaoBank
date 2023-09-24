package com.example.kakaobank

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kakaobank.MainViewPagerAdapter
import com.example.kakaobank.ImageDataModel
import com.example.kakaobank.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewPagerAdapter by lazy {
        MainViewPagerAdapter(this)
    }

    private val tabIcon = arrayListOf(
        R.drawable.home_size,
        R.drawable.lockers,
    )

    var likedItems: ArrayList<ImageDataModel> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()

    }

    private fun initView() = with(binding){
        viewpager.adapter = viewPagerAdapter

        TabLayoutMediator(tabLayout, viewpager) { tab, position ->
            tab.setText(viewPagerAdapter.getTitle(position))
            tab.setIcon(tabIcon[position])
        }.attach()
    }




}
