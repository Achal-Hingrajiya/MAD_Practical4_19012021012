package com.example.practical4_19012021012

import android.content.Intent
import android.content.Intent.ACTION_DIAL
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val callingBtn = findViewById<Button>(R.id.btn_call)
        val viewPageBtn = findViewById<Button>(R.id.btn_url)
        val textMobileUrlInput = findViewById<TextInputEditText>(R.id.txtInput_mobile_url)

        //com.google.android.material.textfield.TextInputLayout
        //com.google.android.material.textfield.TextInputEditText

        callingBtn.setOnClickListener(View.OnClickListener {
            val callIntent = Intent(Intent.ACTION_DIAL)
            callIntent.setData(Uri.parse("tel:" + textMobileUrlInput.text)).apply {
                startActivity(this)
            }
        })

        viewPageBtn.setOnClickListener(View.OnClickListener {
            val viewPageIntent = Intent(Intent.ACTION_VIEW)

            viewPageIntent.setData(Uri.parse("https://" + textMobileUrlInput.text)).apply {
                startActivity(this)
            }
        })


    }


}