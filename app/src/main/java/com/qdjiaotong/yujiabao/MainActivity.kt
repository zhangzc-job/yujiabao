package com.qdjiaotong.yujiabao

import android.os.Bundle
import com.qdjiaotong.yujiabao.databinding.ActivityMainBinding
import com.qdjiaotong.yujiabao.fragment.home.HomeFragment
import com.qdjiaotong.yujiabao.fragment.me.MeFragment
import com.qdjiaotong.yujiabao.fragment.message.MessageFragment
import com.qdjiaotong.yujiabao.fragment.Service.ServiceFragment

class MainActivity : BaseActivity() {

    lateinit var binding: ActivityMainBinding

    lateinit var homeFragment: HomeFragment
    lateinit var meFragment: MeFragment
    lateinit var messageFragment: MessageFragment
    lateinit var serviceFragment: ServiceFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        homeFragment = HomeFragment()
        meFragment = MeFragment()
        messageFragment =
            MessageFragment()
        serviceFragment =
            ServiceFragment()

        initBottomNavigation()

        supportFragmentManager.beginTransaction().replace(R.id.home_frame,homeFragment).commit()
    }

    private fun initBottomNavigation() {

        binding.bnvMenu.setOnNavigationItemSelectedListener() {
            when (it.itemId) {
                R.id.home_home -> {
                    supportFragmentManager.beginTransaction().replace(R.id.home_frame, homeFragment)
                        .commit()
//                R.id.home_center -> supportFragmentManager.beginTransaction().replace(R.id.home)
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.home_center -> {
                    supportFragmentManager.beginTransaction().replace(R.id.home_frame, meFragment)
                        .commit()
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.home_service -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.home_frame, serviceFragment).commit()
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.home_message -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.home_frame, messageFragment).commit()
                    return@setOnNavigationItemSelectedListener true
                }
            }
            false

        }


    }
}