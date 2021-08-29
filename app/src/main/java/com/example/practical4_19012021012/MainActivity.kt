package com.example.practical4_19012021012

import android.content.Intent
import android.content.Intent.ACTION_DIAL
import android.net.Uri
import android.os.Bundle
import android.provider.ContactsContract
import android.provider.MediaStore
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val callingBtn = findViewById<Button>(R.id.btn_call)
        val viewPageBtn = findViewById<Button>(R.id.btn_url)
        val textMobileUrlInput = findViewById<TextInputEditText>(R.id.txtInput_mobile_url)
        val pickContactButton = findViewById<Button>(R.id.btn_pick_contact)
        val viewCallLogButton = findViewById<Button>(R.id.btn_view_call_log)
        val openGalleryButton = findViewById<Button>(R.id.btn_open_gallery)
        val openCameraButton = findViewById<Button>(R.id.btn_open_camera)


// Make a call to Mobile No. (typed in Textbox above the button) when user clicks "MAKE A CALL" BUTTON
        callingBtn.setOnClickListener {
            Intent(ACTION_DIAL, Uri.parse("tel:" + textMobileUrlInput.text)).apply {
                startActivity(this)
            }
        }


// Open a Website url(typed in Textbox above the button) into browser when user clicks "VIEW A WEBPAGE" BUTTON

        viewPageBtn.setOnClickListener {

//            val viewPageIntent = Intent(Intent.ACTION_VIEW)

//            viewPageIntent.setData(Uri.parse("https://" + textMobileUrlInput.text)).apply {
//                startActivity(this)
//            }

            Intent(Intent.ACTION_VIEW, Uri.parse("https://" + textMobileUrlInput.text)).apply {
                startActivity(this)
            }
        }


// Open Contacts Picker when user clicks "PICK A CONTACT" BUTTON

        pickContactButton.setOnClickListener {
            val pickContactIntent = Intent(Intent.ACTION_PICK)

            pickContactIntent.type = ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE
            startActivity(pickContactIntent)
        }


// Open a Call log when user clicks "VIEW CALL LOGS" BUTTON

        viewCallLogButton.setOnClickListener {
            Intent(Intent.ACTION_VIEW, Uri.parse("content://call_log/calls")).apply { startActivity(this) }

        }

// Open a Gallery when user clicks "OPEN GALLERY" BUTTON

        openGalleryButton.setOnClickListener {
            val intent = Intent()
            intent.action = Intent.ACTION_GET_CONTENT
            intent.type = "image/*"
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
        }

// Open a camera when user clicks "OPEN A CAMERA" BUTTON

        openCameraButton.setOnClickListener {
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

            startActivity(intent)
        }
    }


}