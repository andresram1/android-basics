package com.example.tools.fragments

import android.app.Activity
import android.os.Bundle

import androidx.fragment.app.Fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton

import com.example.tools.R
import com.example.tools.commons.MenuCommunication

/**
 * A simple {@link Fragment} subclass.
 */
class Menu : Fragment (){

    /**
     * Menu buttons are identified for later usage
     */
    val MENU_BUTTONS = arrayOf(R.id.lantern, R.id.music, R.id.level)

    /**
     * Array to identified pressed buttons
     */
    val MENU_PRESSED_BUTTONS = arrayOf(R.drawable.lantern_02, R.drawable.musica_02, R.drawable.level_02)

    /**
     * Identifies the pressed button
     */
    var mButton = -1

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        val view : View = inflater.inflate(R.layout.fragment_menu, container, false)

        mButton = arguments?.getInt("PRESSED_BUTTON") ?: -1


        var menuButton : ImageButton?

        for (i in MENU_BUTTONS.indices){

            val currentButton = i

            menuButton = view.findViewById(MENU_BUTTONS[i])

            // Replaces the image with the highlighted button
            if(mButton == currentButton) menuButton.setImageResource(MENU_PRESSED_BUTTONS[mButton])


            menuButton.setOnClickListener(View.OnClickListener {
                // Current activity is retrieved
                // Activity is implementing MenuCommunication interface
                val currentActivity : Activity? = activity
                if(currentActivity is MenuCommunication){
                    currentActivity.menuAction(currentButton)
                }
            })

        }

        return view
    }
}
