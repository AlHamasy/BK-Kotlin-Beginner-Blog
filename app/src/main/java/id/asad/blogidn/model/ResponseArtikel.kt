package id.asad.blogidn.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

data class ResponseArtikel(

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("data_artikel")
	val dataArtikel: List<DataArtikelItem?>? = null,

	@field:SerializedName("status")
	val status: Boolean? = null
)

@Parcelize
data class DataArtikelItem(

	@field:SerializedName("tgl_posting")
	val tglPosting: String? = null,

	@field:SerializedName("author")
	val author: String? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("judul")
	val judul: String? = null,

	@field:SerializedName("gambar")
	val gambar: String? = null,

	@field:SerializedName("isi")
	val isi: String? = null

):Parcelable