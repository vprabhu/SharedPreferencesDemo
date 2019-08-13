package com.vpdevs.sharedpreferencesdemo

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val SHARED_PREFERNCES_NAME = "com.vpdevs.sharedpreferencesdemo.demo"
    private val SHARED_PREFERNCES_KEY = "SampleKey"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView_saved_value.text = getSharedPreferencesKey().toString()

        button_save_value.setOnClickListener {
            setSharedPreferencesKey()
            textView_saved_value.text = resources.getString(R.string.sp_default_value)
        }

        button_get_value.setOnClickListener {
            textView_saved_value.text = getSharedPreferencesKey().toString()
        }
    }

    private fun setSharedPreferencesKey() {
        val sharedPreferences = getSharedPreferences(SHARED_PREFERNCES_NAME, Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putLong(SHARED_PREFERNCES_KEY, System.currentTimeMillis())
        editor.apply()
    }

    private fun getSharedPreferencesKey(): Long {
        val sharedPreferences = getSharedPreferences(SHARED_PREFERNCES_NAME, Context.MODE_PRIVATE)
        return sharedPreferences.getLong(SHARED_PREFERNCES_KEY, 0)
    }
}
