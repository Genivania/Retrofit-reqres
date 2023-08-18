package br.senai.sp.jandira.retrofit_reqres

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var apiService: ApiService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        apiService = RetrofitHelper.getInstance().create(ApiService::class.java)

        //AÇÃO DO BOTÃO GET:
        findViewById<Button>(R.id.btnGET).setOnClickListener{
            getUserById()
        }
    }

    private fun getUserById() {

        lifecycleScope.launch {
            //CHAMADA PARA ENDPOINT
            val result = apiService.getUserById("12")

            if (result.isSuccessful){

                Log.e("GETTING-DATA", "${result.body()?.data}")

            }else{

                Log.e("GETTING-DATA", "${result.message()}")

            }
        }

    }
}















