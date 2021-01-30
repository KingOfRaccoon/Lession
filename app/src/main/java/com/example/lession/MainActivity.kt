package com.example.lession

import android.content.Intent
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val prefBtn: Button = findViewById<View>(R.id.prefButton) as Button
        prefBtn.setOnClickListener {
            val settingsActivity = Intent(baseContext,
                    Preferences::class.java)
            startActivity(settingsActivity)
        }   
    }
    var CheckboxPreference = false
    var ListPreference: String? = null
    var editTextPreference: String? = null
    var ringtonePreference: String? = null
    var secondEditTextPreference: String? = null
    var customPref: String? = null

    private fun getPrefs() {
        // Get the xml/preferences.xml preferences
        val prefs = PreferenceManager
                .getDefaultSharedPreferences(baseContext)
        CheckboxPreference = prefs.getBoolean("checkboxPref", true)
        ListPreference = prefs.getString("listPref", "nr1")
        editTextPreference = prefs.getString("editTextPref",
                "Nothing has been entered")
        ringtonePreference = prefs.getString("ringtonePref",
                "DEFAULT_RINGTONE_URI")
        secondEditTextPreference = prefs.getString("SecondEditTextPref",
                "Nothing has been entered")
        // Get the custom preference
        val mySharedPreferences = getSharedPreferences(
                "myCustomSharedPrefs", MODE_PRIVATE)
        customPref = mySharedPreferences.getString("myCusomPref", "")
    }
}