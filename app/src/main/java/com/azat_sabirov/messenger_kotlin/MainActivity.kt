package com.azat_sabirov.messenger_kotlin

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.azat_sabirov.messenger_kotlin.databinding.ActivityMainBinding
import com.azat_sabirov.messenger_kotlin.fragments.ChatsFragment
import com.azat_sabirov.messenger_kotlin.fragments.SearchFragment
import com.azat_sabirov.messenger_kotlin.fragments.SettingsFragment
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        initViews()
    }

    private fun initViews() {
        binding.apply {
            val toolbar: Toolbar = toolbar
            setSupportActionBar(toolbar)
            supportActionBar!!.title = ""

            val tabLayout: TabLayout = tabLayout
            val viewPager: ViewPager = viewPager
            val viewPagerAdapter = ViewPagerAdapter(supportFragmentManager)

            viewPagerAdapter.addFragment(ChatsFragment(), "Чаты")
            viewPagerAdapter.addFragment(SearchFragment(), "Поиск")
            viewPagerAdapter.addFragment(SettingsFragment(), "Настройки")

            viewPager.adapter = viewPagerAdapter

            tabLayout.setupWithViewPager(viewPager)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    internal class ViewPagerAdapter(fragmentManager: FragmentManager) :
        FragmentPagerAdapter(fragmentManager) {
        private val fragments: ArrayList<Fragment> = ArrayList()
        private val titles: ArrayList<String> = ArrayList()

        override fun getCount(): Int {
            return fragments.size
        }

        override fun getItem(position: Int): Fragment {
            return fragments[position]
        }

        fun addFragment(fragment: Fragment, title: String) {
            fragments.add(fragment)
            titles.add(title)
        }

        override fun getPageTitle(position: Int): CharSequence {
            return titles[position]
        }

    }
}