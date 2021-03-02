package id.asad.blogidn.api

import id.asad.blogidn.model.ResponseArtikel
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("list_artikel.php")
    fun getAllArtikel() : Call<ResponseArtikel>

}