package guru.drako.course.apps.fizzbuzz

object RomanNumerals {
  private val TRANSLATIONS = arrayOf(
    "M" to 1000,
    "CM" to 900,
    "D" to 500,
    "CD" to 400,
    "C" to 100,
    "XC" to 90,
    "L" to 50,
    "XL" to 40,
    "X" to 10,
    "IX" to 9,
    "V" to 5,
    "IV" to 4,
    "I" to 1
  )

  fun arabicToRoman(arabic: Int): String {
    var n = arabic
    var result = ""
    for ((r, a) in TRANSLATIONS) {
      val factor = n / a
      n %= a
      if (factor != 0) {
        result += r.repeat(factor)
      }
    }
    return result
  }

  fun romanToArabic(roman: String): Int {
    var result = 0
    var n = roman

    for ((r, a) in TRANSLATIONS) {
      while (n.isNotEmpty() && n.first() == r.first()) {
        // account for 2 character translations
        if (n.length > 1 && r.length == 2 && n[1] == r[1]) {
          result += a
          n = n.drop(2)
        } else if (r.length == 1) {
          result += a
          n = n.drop(1)
        } else {
          // two character translation but second character does not match
          break
        }
      }
    }
    return result
  }
}
