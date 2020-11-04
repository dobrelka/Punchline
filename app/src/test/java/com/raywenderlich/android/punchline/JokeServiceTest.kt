package com.raywenderlich.android.punchline

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.mockwebserver.MockWebServer
import org.junit.Rule
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class JokeServiceTestUsingMockWebServer {

  @get:Rule
  val mockWebServer = MockWebServer()

  private val retrofit by lazy {
    Retrofit.Builder()
        .baseUrl(mockWebServer.url("/"))
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build()
  }

  private val jokeService by lazy {
    retrofit.create(JokeService::class.java)
  }

  @Test
  fun getRandomJokeEmitsJoke() {

  }

}