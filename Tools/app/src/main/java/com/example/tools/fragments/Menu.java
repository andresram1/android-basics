package com.example.tools.fragments;

import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.tools.R;
import com.example.tools.commons.MenuCommunication;

/**
 * A simple {@link Fragment} subclass.
 */
public class Menu extends Fragment {

    /**
     * Menu buttons are identified for later usage
     */
    private final int[] MENU_BUTTONS = {R.id.lantern, R.id.music, R.id.level};

    /**
     * Array to identified pressed buttons
     */
    private final int[] MENU_PRESSED_BUTTONS = {R.drawable.lantern_02, R.drawable.musica_02, R.drawable.level_02};

    /**
     * Identifies the pressed button
     */
    private int mButton = -1;

    public Menu() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_menu, container, false);

        if(getArguments() != null) {
            mButton = getArguments().getInt("PRESSED_BUTTON");
        }

        ImageButton menuButton;

        for (int i=0; i< MENU_BUTTONS.length; i++){

            final int currentButton = i;
            menuButton = (ImageButton)view.findViewById(MENU_BUTTONS[i]);

            // Replaces the image with the highlighted button
            if(mButton == currentButton){
                menuButton.setImageResource(MENU_PRESSED_BUTTONS[mButton]);
            }

            menuButton.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {
                    // Current activity is retrieved
                    // Activity is implementing MenuCommunication interface
                    Activity activity = getActivity();
                    assert activity != null;
                    ((MenuCommunication)activity).menuAction(currentButton);
                }
            });
        }

        return view;
    }
}
