package com.example.tools;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.tools.activities.ToolsActivity;
import com.example.tools.commons.MenuCommunication;

public class MainActivity extends AppCompatActivity implements MenuCommunication {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void menuAction(int currentButton) {
        Intent intent = new Intent(this, ToolsActivity.class);
        intent.putExtra("PRESSED_BUTTON", currentButton);
        startActivity(intent);
    }
}
