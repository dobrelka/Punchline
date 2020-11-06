package com.raywenderlich.android.punchline

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.github.javafaker.Faker
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.test.KoinTest
import org.koin.test.inject
import org.koin.test.mock.declareMock

@RunWith(AndroidJUnit4::class)
class MainActivityTest: KoinTest {

  private val mockRepository: Repository by inject()
  private val faker = Faker()

  @Before
  fun setUp() {
    declareMock<Repository>()
  }

  @Test
  fun onLaunchButtonIsDisplayed() {
    whenever(mockRepository.getJoke())
        .thenReturn(Single.just(Joke(
            faker.idNumber().valid(),
            faker.lorem().sentence())))

  }
}