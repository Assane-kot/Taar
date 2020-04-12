package com.jambaar.taar.ui.activities

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.jambaar.taar.R
import com.jambaar.taar.ui.fragments.home.HomeFragment
import com.jambaar.taar.ui.fragments.login.LoginFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        if (savedInstanceState == null) {
            replaceFragment(HomeFragment(), "HomeFragment")
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu to use in the action bar
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_item, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.item_login -> {
                replaceFragment(LoginFragment(), "LoginFragment")
            }
        }
        return super.onOptionsItemSelected(item)
    }

    /**
     * Cette fonction remplace le fragment courant a celui selectionne par l'utilisateur
     * @param fragment
     * @param tag
     * @return Void
     */
    private fun replaceFragment(fragment: Fragment, tag: String) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, fragment, tag)
            .addToBackStack(null)
            .commit()
    }
}
