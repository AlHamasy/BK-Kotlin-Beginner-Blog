package id.asad.blogidn

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import id.asad.blogidn.api.ApiConfig
import id.asad.blogidn.databinding.ActivityMainBinding
import id.asad.blogidn.model.ResponseArtikel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ApiConfig.service().getAllArtikel().enqueue(object : Callback<ResponseArtikel> {
            override fun onFailure(call: Call<ResponseArtikel>, t: Throwable) {
                binding.tvError.visibility = View.VISIBLE
                binding.tvError.text = t.localizedMessage
            }
            override fun onResponse(call: Call<ResponseArtikel>, response: Response<ResponseArtikel>) {
                if (response.isSuccessful){

                    // all json
                    val responseArtikel = response.body()

                    // ambil data
                    val message = responseArtikel?.message
                    val dataArtikel = responseArtikel?.dataArtikel

                    // panggil adapter
                    val blogAdapter = BlogAdapter(dataArtikel)

                    // tampilkan recyclerview
                    binding.rvBlog.apply {
                        setHasFixedSize(true)
                        layoutManager = LinearLayoutManager(this@MainActivity)
                        blogAdapter.notifyDataSetChanged()
                        adapter = blogAdapter
                    }
                }
            }
        })
        
    }
}