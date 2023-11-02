package com.example.sendmoney.newRegistration

import android.app.Activity
import android.app.Dialog
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.view.Window
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.sendmoney.R
import com.example.sendmoney.databinding.ActivityBusinessInformationBinding
import com.google.android.material.radiobutton.MaterialRadioButton
import java.io.File
import java.util.jar.Manifest

class BusinessInformationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBusinessInformationBinding
    val REQUEST_CODE = 200
    val PICK_VIDEO_REQUEST = 220

    lateinit var dokanerImage: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBusinessInformationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setToolBar()
        initForRadio()
        onClickListener()

        checkCameraPermisson()


    }

    override fun onRequestPermissionsResult(
        requestCode: Int, permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            1 -> {
                if (grantResults.isNotEmpty() && grantResults[0] ==
                    PackageManager.PERMISSION_GRANTED
                ) {
                    if ((ContextCompat.checkSelfPermission(
                            this,
                            android.Manifest.permission.CAMERA
                        ) ===
                                PackageManager.PERMISSION_GRANTED)
                    ) {
                        Toast.makeText(this, "Permission Granted", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT).show()
                }
                return
            }
        }
    }

    val galleryLauncher = registerForActivityResult(ActivityResultContracts.GetContent()) {
        val galleryUri = it
        try{
            binding.forUploadedImage.visibility = View.VISIBLE
            binding.dokaneChobiUpload.visibility = View.GONE
            binding.dokaneChobiLayout.visibility = View.VISIBLE
            binding.dokaneChobiPlacement.setImageURI(galleryUri)
        }catch(e:Exception){
            e.printStackTrace()
        }

    }

    fun capturePhoto() {
        val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(cameraIntent, REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == REQUEST_CODE && data != null) {
            binding.forUploadedImage.visibility = View.VISIBLE
            binding.dokaneChobiUpload.visibility = View.GONE
            binding.dokaneChobiLayout.visibility = View.VISIBLE
            binding.dokaneChobiPlacement.setImageBitmap(data.extras?.get("data") as Bitmap)
        }
        else if (requestCode == PICK_VIDEO_REQUEST && resultCode == RESULT_OK) {
            var selectedVideoUri = data?.data
            val videoFile = selectedVideoUri?.path?.let { File(it) } // Convert the URI to a File
            val fileName = System.currentTimeMillis().toString()

        }
    }


    private fun checkCameraPermisson() {
        if (ContextCompat.checkSelfPermission(
                this,
                android.Manifest.permission.ACCESS_FINE_LOCATION
            ) !==
            PackageManager.PERMISSION_GRANTED
        ) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(
                    this,
                    android.Manifest.permission.CAMERA
                )
            ) {
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(android.Manifest.permission.CAMERA), 1
                )
            } else {
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(android.Manifest.permission.CAMERA), 1
                )
            }
        }
    }

    private fun onClickListener() {
        binding.dokaneChobiUpload.setOnClickListener {
            showDialog()
        }

        binding.dokaneVideoUpload.setOnClickListener {
            val intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.type = "video/*"
            startActivityForResult(intent, PICK_VIDEO_REQUEST)
        }

        binding.retakePhoto.setOnClickListener {
            binding.forUploadedImage.visibility = View.GONE
            binding.dokaneChobiUpload.visibility = View.VISIBLE
            binding.dokaneChobiLayout.visibility = View.GONE
            binding.dokaneChobiPlacement.setImageURI(null)
        }
    }

    private fun showDialog() {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.getWindow()?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT));
        dialog.setContentView(R.layout.camera_galary_popup)


        val cameraBTN = dialog.findViewById(R.id.fromCamera) as ImageView
        cameraBTN.setOnClickListener {
            dialog.dismiss()
            capturePhoto()
        }

        val galaryBTN = dialog.findViewById(R.id.fromGalary) as ImageView
        galaryBTN.setOnClickListener {
            dialog.dismiss()
            galleryLauncher.launch("image/*")
        }


        dialog.show()
    }

    private fun initForRadio() {
        binding.radioOffline.setOnClickListener {
            binding.radioOnline.isChecked = false
            binding.radioOvoyo.isChecked = false
            binding.forOffline.visibility = View.VISIBLE
            binding.forOnline.visibility = View.GONE
        }


        binding.radioOnline.setOnClickListener {
            binding.radioOffline.isChecked = false
            binding.radioOvoyo.isChecked = false
            binding.forOffline.visibility = View.GONE
            binding.forOnline.visibility = View.VISIBLE
        }

        binding.radioOvoyo.setOnClickListener {
            binding.radioOffline.isChecked = false
            binding.radioOnline.isChecked = false
            binding.forOffline.visibility = View.VISIBLE
            binding.forOnline.visibility = View.VISIBLE
        }

        binding.radioAche.setOnClickListener {
            binding.dbidLayout.visibility = View.VISIBLE
            binding.radioNai.isChecked = false
        }
        binding.radioNai.setOnClickListener {
            binding.dbidLayout.visibility = View.GONE
            binding.radioAche.isChecked = false
        }

    }

    private fun setToolBar() {
        try {
            setSupportActionBar(binding.toolbar)
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            supportActionBar?.setDisplayShowHomeEnabled(true)
            supportActionBar?.title = "ব্যবসার তথ্য"
            binding.toolbar.setNavigationOnClickListener {
                onBackPressed();
            }

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}