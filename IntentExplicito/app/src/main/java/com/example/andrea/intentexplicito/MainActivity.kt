package com.example.andrea.intentexplicito

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.MediaController
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import android.R.attr.data
import android.graphics.Bitmap
import android.provider.MediaStore
import android.R.attr.data
import android.support.v4.app.NotificationCompat.getExtras


class MainActivity : AppCompatActivity() {
    companion object {
        private val IMAGE_CODE=123
        private val PHOTO_CODE=1
        private val VIDEO_CODE=456
        private val AUDIO_CODE=789
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        imagenB.setOnClickListener{
            elegirImagen()
        }
        foto.setOnClickListener(){
            tomarFoto()
        }
        llamada.setOnClickListener(){
            realizarLlamada()
        }
        audioButton.setOnClickListener(){
            elegirAudio()
        }
        videoButton.setOnClickListener(){
            elegirVideo()
        }

    }
    fun elegirAudio(){
        val intent= Intent()
        intent.type= "audio/*"
        intent.action= Intent.ACTION_GET_CONTENT
        startActivityForResult(Intent.createChooser(intent,"Elige una canción"),AUDIO_CODE)
    }
    fun elegirVideo(){
        val intent= Intent()
        intent.type= "video/*"
        intent.action= Intent.ACTION_GET_CONTENT
        startActivityForResult(Intent.createChooser(intent,"Elige un video"), VIDEO_CODE)
    }
    fun realizarLlamada(){
        val phone= "5560806952"
        val intent= Intent()
        intent.action= Intent.ACTION_CALL
        intent.data= (Uri.parse("tel:" + phone))
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    fun elegirImagen(){
        val intent= Intent()
        intent.type= "image/*"
        intent.action= Intent.ACTION_GET_CONTENT
        startActivityForResult(Intent.createChooser(intent,"Elige una imagen"), IMAGE_CODE)
    }

    fun tomarFoto(){
        val intent= Intent()
        intent.action= MediaStore.ACTION_IMAGE_CAPTURE
        startActivityForResult(intent, PHOTO_CODE)
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(Activity.RESULT_OK == resultCode){
            if(IMAGE_CODE == requestCode){
                val imagenUri= data?.data
                //id del xml
                imagen.setImageURI(imagenUri)
                imagen.visibility= View.VISIBLE
            }
            else if(requestCode == PHOTO_CODE){
                val photo= data?.data
                //id del xml
                val extras = data?.getExtras()
                val imageBitmap = extras?.get("data") as Bitmap
                imagen.setImageBitmap(imageBitmap)
                imagen.visibility= View.VISIBLE

            }else  if(AUDIO_CODE == requestCode){
                val audioUri= data?.data
                //id del xml
                val audioController= MediaController(this)
                audioController.setAnchorView(video)
                video.visibility=  View.VISIBLE
                imagen.visibility= View.GONE
                video.setMediaController(audioController)
                try {
                    video.setVideoURI(audioUri)
                }catch (e: Exception){
                    e.printStackTrace();
                }
                video.start()
                Toast.makeText(this,"Inicia el audio", Toast.LENGTH_LONG).show()
            }else if(VIDEO_CODE == requestCode){
                val videoUri= data?.data
                //id del xml
                video.setVideoURI(videoUri)
                val videoController= MediaController(this)
                videoController.setAnchorView(video)
                video.visibility= View.VISIBLE
                imagen.visibility=View.GONE
                video.setMediaController(videoController)
                video.start()
                Toast.makeText(this,"Inicia el video", Toast.LENGTH_LONG).show()
            }
        }
    }


}




