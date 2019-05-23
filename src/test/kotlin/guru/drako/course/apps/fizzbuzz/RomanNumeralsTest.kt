package guru.drako.course.apps.fizzbuzz

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import kotlin.test.assertEquals

@RunWith(Parameterized::class)
class RomanNumeralsTest(
  private val arabic: Int,
  private val roman: String
) {
  companion object {
    @get:[JvmStatic Parameterized.Parameters(name = "{index}: line {0} should yield {1}")]
    val data: Collection<Array<Any>> = listOf(
      arrayOf(1, "I"),
      arrayOf(2, "II"),
      arrayOf(5, "V"),
      arrayOf(6, "VI"),
      arrayOf(4, "IV"),
      arrayOf(10, "X"),
      arrayOf(9, "IX"),
      arrayOf(11, "XI"),
      arrayOf(12, "XII"),
      arrayOf(14, "XIV"),
      arrayOf(15, "XV"),
      arrayOf(16, "XVI"),
      arrayOf(23, "XXIII"),
      arrayOf(49, "XLIX"),
      arrayOf(50, "L"),
      arrayOf(51, "LI"),
      arrayOf(99, "XCIX"),
      arrayOf(100, "C"),
      arrayOf(101, "CI"),
      arrayOf(149, "CXLIX"),
      arrayOf(500, "D"),
      arrayOf(999, "CMXCIX"),
      arrayOf(1000, "M"),
      arrayOf(1001, "MI"),
      arrayOf(1500, "MD"),
      arrayOf(1400, "MCD"),
      arrayOf(1990, "MCMXC"),
      arrayOf(3999, "MMMCMXCIX")
    )
  }

  @Test
  fun `conversion arabic to roman`() {
    assertEquals(
      expected = roman,
      actual = RomanNumerals.arabicToRoman(arabic)
    )
  }

  @Test
  fun `conversion roman to arabic`() {
    assertEquals(
      expected = arabic,
      actual = RomanNumerals.romanToArabic(roman)
    )
  }
}
