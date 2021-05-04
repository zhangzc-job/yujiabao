package com.qdjiaotong.yujiabao

import android.os.Bundle
import android.view.View
import com.qdjiaotong.yujiabao.databinding.ActivityMainBinding
import com.qdjiaotong.yujiabao.fragment.home.HomeFragment
import com.qdjiaotong.yujiabao.fragment.me.MeFragment
import com.qdjiaotong.yujiabao.fragment.message.MessageFragment
import com.qdjiaotong.yujiabao.fragment.Service.ServiceFragment
import com.zzc.chaobaselibrary.base.ZBaseActivity

class MainActivity : ZBaseActivity() {

    lateinit var mBinding: ActivityMainBinding

    lateinit var homeFragment: HomeFragment
    lateinit var meFragment: MeFragment
    lateinit var messageFragment: MessageFragment
    lateinit var serviceFragment: ServiceFragment

    override fun initView() {
        mBinding = ActivityMainBinding.inflate(layoutInflater)

        homeFragment = HomeFragment()
        meFragment = MeFragment()
        messageFragment =
            MessageFragment()
        serviceFragment =
            ServiceFragment()


        supportFragmentManager.beginTransaction().replace(R.id.home_frame,homeFragment).commit()


    }

    override fun getLayoutView(): View {
        return mBinding.root
    }

    override fun initListener() {
        mBinding.bnvMenu.setOnNavigationItemSelectedListener() {
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