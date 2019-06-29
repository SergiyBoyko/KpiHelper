package ua.devserhii.kpihelper.persistance.api

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit

class ServiceGenerator {

    private val httpClient = OkHttpClient.Builder()

    private val builder = Retrofit.Builder()
        .baseUrl(BASE_API_URL)
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .addConverterFactory(ScalarsConverterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())

    fun <T> createService(serviceClass: Class<T>): T {
        val guidInterceptor = Interceptor {
            val request = it.request().newBuilder()
                .build()

            it.proceed(request)
        }

        Interceptor { chain ->
            val request = chain.request()
            val stringurl = request.url().toString()
                .replace("%3A", ":")
                .replace("%2F", "/")
                .replace("%3F", "?")
                .replace("%3D", "=")

            val newRequest = Request.Builder()
                .url(stringurl)
                .build()

            chain.proceed(newRequest)
        }

        httpClient.addInterceptor(guidInterceptor)
        httpClient.connectTimeout(5, TimeUnit.MINUTES)
            .writeTimeout(5, TimeUnit.MINUTES)
            .readTimeout(5, TimeUnit.MINUTES)
        builder.client(httpClient.build())

        return builder.build().create(serviceClass)
    }
}