package com.raywenderlich.android.punchline

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.github.javafaker.Faker
import org.junit.Before
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
}