package com.example.tools.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.tools.R;
import com.example.tools.commons.MenuCommunication;
import com.example.tools.fragments.Lantern;
import com.example.tools.fragments.Level;
import com.example.tools.fragments.Menu;
import com.example.tools.fragments.Music;

public class ToolsActivity extends AppCompatActivity implements MenuCommunication {

    Fragment[] myFragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tools);

        myFragments = new Fragment[3];
        myFragments[0] = new Lantern();
        myFragments[1] = new Music();
        myFragments[2] = new Level();

                Bundle extras = getIntent().getExtras();

        // The pressed button information is retrieved from a previous
        // event on this or any other activity which implements
        // MenuCommunication interface
        menuAction(extras.getInt("PRESSED_BUTTON"));

    }

    @Override
    public void menuAction(int currentButton) {

        FragmentManager fragmentManager = getSupportFragmentManager();
        // Begin the transaction. Transactions are synchronous
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        // Create additional fragments, depending on which button was pressed
        Fragment activeMenu = new Menu();
        Bundle data = new Bundle();
        data.putInt("PRESSED_BUTTON", currentButton);
        activeMenu.setArguments(data);
        fragmentTransaction.replace(R.id.menu, activeMenu);

        // This portion replaces the lower component of the app (i.e. Lower fragment)
        fragmentTransaction.replace(R.id.tools, myFragments[currentButton]);
        fragmentTransaction.commit();


    }
}
