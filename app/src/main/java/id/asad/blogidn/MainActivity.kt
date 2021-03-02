package id.asad.blogidn

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import id.asad.blogidn.api.ApiConfig
import id.asad.blogidn.model.ResponseArtikel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ApiConfig.service().getAllArtikel().enqueue(object : Callback<ResponseArtikel> {
            override fun onFailure(call: Call<ResponseArtikel>, t: Throwable) {
                Log.d("getDataArtikel", t.localizedMessage)
            }
            override fun onResponse(call: Call<ResponseArtikel>, response: Response<ResponseArtikel>) {
                if (response.isSuccessful){

                    // all json
                    val responseArtikel = response.body()

                    // ambil data yg key "message"
                    val message = responseArtikel?.message
                    Log.d("getDataArtikel", message ?: "")
                }
            }
        })
    }


}