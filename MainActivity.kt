package com.example.colorcorrectiontile

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val padding = (24 * resources.displayMetrics.density).toInt()
        val layout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(padding, padding, padding, padding)
        }

        val title = TextView(this).apply {
            text = "Color Correction Quick Tile"
            textSize = 24f
        }
        val description = TextView(this).apply {
            text = "This prototype adds a Quick Settings shortcut that opens Android Accessibility settings. Android does not let an ordinary app switch system color correction directly without elevated permission."
            textSize = 16f
            setPadding(0, padding / 2, 0, padding)
        }
        val button = Button(this).apply {
            text = "Open Accessibility Settings"
            setOnClickListener {
                startActivity(Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS))
            }
        }
        val steps = TextView(this).apply {
            text = "\nAdd the tile:\n1. Swipe down twice from the top of the screen.\n2. Tap Edit (pencil or plus icon).\n3. Find “Color Settings” and drag it into your active tiles.\n4. Tap it whenever you want to open Accessibility settings."
            textSize = 16f
            setPadding(0, padding / 2, 0, 0)
        }

        layout.addView(title)
        layout.addView(description)
        layout.addView(button)
        layout.addView(steps)
        setContentView(layout)
    }
}
