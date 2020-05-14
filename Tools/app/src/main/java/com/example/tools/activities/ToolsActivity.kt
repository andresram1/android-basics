package com.example.tools.activities;

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

import android.os.Bundle

import com.example.tools.R;
import com.example.tools.commons.MenuCommunication;
import com.example.tools.fragments.Lantern;
import com.example.tools.fragments.Level;
import com.example.tools.fragments.Menu;
import com.example.tools.fragments.Music;

class ToolsActivity : AppCompatActivity(),  MenuCommunication {

    private var myFragments = mutableListOf<Fragment>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_tools)

        myFragments.add(Lantern())
        myFragments.add(Music())
        myFragments.add(Level())

        val extras : Bundle? = intent.extras

        // The pressed button information is retrieved from a previous
        // event on this or any other activity which implements
        // MenuCommunication interface
        if (extras != null) {
            menuAction(extras.getInt("PRESSED_BUTTON"))
        }

    }

    override fun menuAction(currentButton : Int) {

        val fragmentManager : FragmentManager= getSupportFragmentManager()

        // Begin the transaction. Transactions are synchronous
        val fragmentTransaction : FragmentTransaction = fragmentManager.beginTransaction()

        // Create additional fragments, depending on which button was pressed
        val activeMenu : Fragment = Menu()
        val data : Bundle = Bundle()
        data.putInt("PRESSED_BUTTON", currentButton)
        activeMenu.arguments = data
        fragmentTransaction.replace(R.id.menu, activeMenu)

        // This portion replaces the lower component of the app (i.e. Lower fragment)
        fragmentTransaction.replace(R.id.tools, myFragments[currentButton])
        fragmentTransaction.commit()
    }
}
