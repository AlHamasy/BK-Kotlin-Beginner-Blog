package id.asad.blogidn

import android.content.Intent
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import id.asad.blogidn.model.DataArtikelItem

class BlogAdapter(val dataArtikel : List<DataArtikelItem?>?) : RecyclerView.Adapter<BlogAdapter.MyViewHolder>() {

    // 2
    class MyViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        val imageBlog = view.findViewById<ImageView>(R.id.item_image)
        val judulBlog = view.findViewById<TextView>(R.id.item_tv_judul)
        val penulisBlog = view.findViewById<TextView>(R.id.item_tv_penulis)
        val tanggalTerbit = view.findViewById<TextView>(R.id.item_tv_tgl_terbit)
    }

    // 1
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BlogAdapter.MyViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.item_row_blog, parent, false)
        return MyViewHolder(layout)
    }

    // 3
    override fun getItemCount(): Int {
        if (dataArtikel != null){
            return dataArtikel.size
        }
        return 0
    }

    // 4
    override fun onBindViewHolder(holder: BlogAdapter.MyViewHolder, position: Int) {
        holder.judulBlog.text = dataArtikel?.get(position)?.judul
        holder.penulisBlog.text = dataArtikel?.get(position)?.author
        holder.tanggalTerbit.text = dataArtikel?.get(position)?.tglPosting

        Glide.with(holder.itemView)
                .load(dataArtikel?.get(position)?.gambar)
                .error(R.drawable.ic_launcher_background)
                .into(holder.imageBlog)

        val context = holder.itemView.context

        // klik ke DetailActivity
        holder.itemView.setOnClickListener {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra("DETAIL", dataArtikel?.get(position))
            context.startActivity(intent)
        }
    }

}