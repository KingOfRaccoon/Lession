package com.example.lession

import android.os.Bundle
import android.preference.Preference
import android.preference.Preference.OnPreferenceClickListener
import android.preference.PreferenceActivity
import android.widget.Toast


class Preferences:PreferenceActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addPreferencesFromResource(R.xml.preferences)
        // Get the custom preference
        val customPref = findPreference("customPref") as Preference
        customPref.onPreferenceClickListener = OnPreferenceClickListener {
            Toast.makeText(
                baseContext,
                "The custom preference has been clicked",
                Toast.LENGTH_LONG
            ).show()
            val customSharedPreference = getSharedPreferences(
                "myCustomSharedPrefs", MODE_PRIVATE
            )
            val editor = customSharedPreference
                .edit()
            editor.putString(
                "myCustomPref",
                "The preference has been clicked"
            )
            editor.apply()
            true
        }
    }

}