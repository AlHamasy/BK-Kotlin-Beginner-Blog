package id.asad.blogidn

import android.os.Bundle
import android.view.MenuItem
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import id.asad.blogidn.databinding.ActivityDetailBinding
import id.asad.blogidn.model.DataArtikelItem

class DetailActivity : AppCompatActivity() {

    lateinit var binding : ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        // icon back kiri atas
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        // terima data dari BlogAdapter
        val dataArtikelItem = intent.getParcelableExtra<DataArtikelItem>("DETAIL")

        // cek
        if(dataArtikelItem != null){

            Glide.with(this)
                .load(dataArtikelItem.gambar)
                .error(R.drawable.ic_launcher_foreground)
                .into(binding.imgDetail)

            binding.toolbarLayout.title = dataArtikelItem.judul
            binding.contentScrolling.tvIsiDetail.text = dataArtikelItem.isi
        }
    }

    // action icon back kiri atas
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

}