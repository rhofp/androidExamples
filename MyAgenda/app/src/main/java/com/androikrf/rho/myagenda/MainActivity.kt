package com.androikrf.rho.myagenda

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONArray
import java.io.BufferedReader
import java.io.DataOutputStream
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.lang.Exception
import java.net.HttpURLConnection
import java.net.URL
import java.nio.charset.StandardCharsets
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ingresar.setOnClickListener {
            val tr = Thread()

            tr.run {

                val res = enviarPost(et_correo.text.toString(), et_pass.text.toString())
                runOnUiThread {
                    val r = objJSON(res)

                    if (r>0){
                        startActivity(Intent(applicationContext,Principal::class.java))
                    }else{
                        Toast.makeText(applicationContext,"Credenciales incorrectas",Toast.LENGTH_SHORT).show()
                    }
                }
            }

            tr.start()
        }
    }

    fun enviarPost(correo: String, pass: String): String {

        val params = "correo=$correo&pass=$pass"

        return pushToChat(params)

    }

    fun objJSON(resp: String): Int{
        var res = 0
        try {
            val json = JSONArray(resp)
            if (json.length()>0){
                res = 1
            }
        }catch (e:Exception){}

        return res
    }

    fun pushToChat(message: String): String {

        var output=""

        val url = URL("http://192.168.1.69:9010/controladores/validar.php")
        val connection = url.openConnection() as HttpURLConnection
        connection.requestMethod = "POST"
        connection.connectTimeout = 300000
        connection.connectTimeout = 300000
        connection.doOutput = true

        val postData: ByteArray = message.toByteArray()

        connection.setRequestProperty("charset", "utf-8")
        connection.setRequestProperty("Content-length", postData.size.toString())
        connection.setRequestProperty("Content-Type", "application/json")

        try {
            val outputStream: DataOutputStream = DataOutputStream(connection.outputStream)
            Log.e("Output",connection.outputStream.toString())
            outputStream.write(postData)
            outputStream.flush()



            val reader = BufferedReader(InputStreamReader(connection.inputStream))
            Log.e("Input",connection.inputStream.toString())
            output= reader.readLine()
        } catch (exception: Exception) {

        }

        return output

    }
}
