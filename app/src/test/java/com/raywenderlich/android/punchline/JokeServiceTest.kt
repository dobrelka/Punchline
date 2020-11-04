package com.raywenderlich.android.punchline

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.nhaarman.mockitokotlin2.mock
import junit.framework.Assert.assertEquals
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.Rule
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val id = "6"
private const val joke = "How does a train eat? It goes chew, chew"
private val testJson = """{ "id": $id, "joke": "$joke" }"""

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
    mockWebServer.enqueue(
        MockResponse()
            .setBody(testJson)
            .setResponseCode(200))

    val testObserver = jokeService.getRandomJoke().test()
    testObserver.assertValue(Joke(id, joke))

  }

  @Test
  fun getRandomJokeGetsRandomJokeJson() {
    mockWebServer.enqueue(
        MockResponse()
            .setBody(testJson)
            .setResponseCode(200))

    val testObserver = jokeService.getRandomJoke().test()
    testObserver.assertNoErrors()
    assertEquals("/random_joke.json",
        mockWebServer.takeRequest().path)
  }

  class JokeServiceTestMockingService() {

    private val jokeService: JokeService = mock()
    private val repository = RepositoryImpl(jokeService)

  }

}