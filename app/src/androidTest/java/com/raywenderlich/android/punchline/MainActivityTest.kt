package com.raywenderlich.android.punchline

import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Before
import org.junit.runner.RunWith
import org.koin.test.KoinTest
import org.koin.test.mock.declareMock

@RunWith(AndroidJUnit4::class)
class MainActivityTest: KoinTest {

  @Before
  fun setUp() {
    declareMock<Repository>()
  }
}