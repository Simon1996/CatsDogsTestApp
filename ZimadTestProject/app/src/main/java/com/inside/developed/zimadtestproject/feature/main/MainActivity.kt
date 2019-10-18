package com.inside.developed.zimadtestproject.feature.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayout
import com.inside.developed.zimadtestproject.R
import com.inside.developed.zimadtestproject.core.base.BaseActivity
import com.inside.developed.zimadtestproject.feature.main.fragment.CatsFragment
import com.inside.developed.zimadtestproject.feature.main.fragment.DogsFragment
import kotlinx.android.synthetic.main.activity_main.*

const val POSITION_ITEM = "item"
class MainActivity : BaseActivity() {

    override fun obtainLayoutResId(): Int = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        tabLayout.addTab(tabLayout.newTab().setText("Cats"))
        tabLayout.addTab(tabLayout.newTab().setText("Dogs"))

        tabLayout.tabGravity = TabLayout.GRAVITY_FILL

        if (savedInstanceState == null) {
            setFragment(CatsFragment())
        }
        tabLayout.getTabAt(savedInstanceState?.getInt(POSITION_ITEM) ?: 0)!!.select()

        tabLayout.addOnTabSelectedListener(object :
            TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                when (tab.position) {
                    0 -> setFragment(CatsFragment())
                    1 -> setFragment(DogsFragment())
                    else -> setFragment(CatsFragment())
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {
            }

            override fun onTabReselected(tab: TabLayout.Tab) {
            }
        })

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(POSITION_ITEM, tabLayout.selectedTabPosition)
    }

    private fun setFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(
            R.id.fragment_container,
            fragment
        ).commit()
    }
}