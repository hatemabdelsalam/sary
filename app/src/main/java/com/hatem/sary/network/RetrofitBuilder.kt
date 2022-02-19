package com.hatem.sary.network


import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.SocketTimeoutException


object RetrofitBuilder {

    val instant: Apis by lazy {

        val retrofit = Retrofit.Builder().baseUrl(Urls.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(NetworkResponseAdapterFactory())
            .client(okHttpClient)
            .build()
        //create retrofit client
        return@lazy retrofit.create(Apis::class.java)
    }

    private val logging: HttpLoggingInterceptor =
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    private val okHttpClient =
        OkHttpClient.Builder().addInterceptor(logging).addInterceptor { chain ->

            try {
                val originalRequest = chain.request()
                val requestBuilder =
                    originalRequest.newBuilder()

                requestBuilder.addHeader("Authorization","token eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpZCI6ODg2NiwidXNlcl9waG9uZSI6Ijk2NjU2NDk4OTI1MCJ9.VYE28vtnMRLmwBISgvvnhOmPuGueW49ogOhXm5ZqsGU")
                requestBuilder.addHeader("Device-Type", "android")
                requestBuilder.addHeader("Device-Id", "e979a401955ab2a5")
                requestBuilder.addHeader("App-Version", "5.5.0.0.0")
                requestBuilder.addHeader("Platform", "FLAGSHIP")
                requestBuilder.addHeader("Accept-Language", "en")

                chain.proceed(requestBuilder.build())
            } catch (exception: SocketTimeoutException) {
                exception.printStackTrace()
                chain.proceed(chain.request())
            }


        }.build()
}