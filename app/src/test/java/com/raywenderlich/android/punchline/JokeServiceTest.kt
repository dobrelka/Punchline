package com.raywenderlich.android.punchline

import okhttp3.mockwebserver.MockWebServer
import org.junit.Rule

class JokeServiceTestUsingMockWebServer {

  @get:Rule
  val mockWebServer = MockWebServer()

}