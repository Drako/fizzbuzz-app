package guru.drako.course.apps.fizzbuzz

import org.junit.Test
import org.junit.experimental.runners.Enclosed
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import kotlin.test.assertEquals

@RunWith(Enclosed::class)
class FizzBuzzProviderTest {
  class Values {
    @Test
    fun `fizzbuzz should return numbers from 1 to 100 as string with correct replacements`() {
      val expected = (1..100).map(FizzBuzzProvider::fizzbuzz)
      assertEquals(expected = expected, actual = FizzBuzzProvider.values)
    }
  }

  @RunWith(Parameterized::class)
  class FizzBuzz(
    private val lineNumber: Int,
    private val expected: String
  ) {
    companion object {
      @get:[JvmStatic Parameterized.Parameters(name = "{index}: line {0} should yield {1}")]
      val data: Collection<Array<Any>> = listOf(
        arrayOf(1, "1"),
        arrayOf(2, "2"),
        arrayOf(3, "Fizz"),
        arrayOf(4, "4"),
        arrayOf(5, "Buzz"),
        arrayOf(6, "Fizz"),
        arrayOf(10, "Buzz"),
        arrayOf(12, "Fizz"),
        arrayOf(15, "FizzBuzz"),
        arrayOf(30, "FizzBuzz"),
        arrayOf(100, "Buzz")
      )
    }

    @Test
    fun `fizzbuzz should have correct result`() {
      assertEquals(
        expected = expected,
        actual = FizzBuzzProvider.fizzbuzz(lineNumber)
      )
    }
  }
}
