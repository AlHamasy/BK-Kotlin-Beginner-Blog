package id.asad.blogidn.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiConfig {

    const val BASE_URL = "http://192.168.8.101:8888/api_blog_idn/"

    fun config() : Retrofit{
        return Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
    }

    fun service() : ApiService {
        return config().create(ApiService::class.java)
    }
}