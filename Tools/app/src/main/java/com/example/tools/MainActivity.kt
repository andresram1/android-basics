package com.example.tools;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.tools.activities.ToolsActivity;
import com.example.tools.commons.MenuCommunication;

class MainActivity : AppCompatActivity(), MenuCommunication {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun menuAction(currentButton: Int) {
        val intent = Intent(this, ToolsActivity::class.java).apply {
            putExtra("PRESSED_BUTTON", currentButton)
        }
        startActivity(intent);
    }
}
