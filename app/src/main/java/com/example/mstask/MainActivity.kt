package com.example.mstask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.mstask.fragments.Fragment1
import com.example.mstask.fragments.Fragment2
import com.example.mstask.fragments.Fragment3
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title=resources.getString(R.string.home)
        loadFragment(Fragment1())

        navigationView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.navigation_fav-> {
                    title=resources.getString(R.string.favorites)
                    loadFragment(Fragment2())
                    return@setOnNavigationItemSelectedListener true
                }

                R.id.navigation_home-> {
                    title=resources.getString(R.string.home)
                    loadFragment(Fragment1())
                    return@setOnNavigationItemSelectedListener true
                }

                R.id.navigation_settings-> {
                    title=resources.getString(R.string.settings)
                    loadFragment(Fragment3())
                    return@setOnNavigationItemSelectedListener true
                }

            }
            false

        }
    }

    private fun loadFragment(fragment: Fragment) {
        // load fragment
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}