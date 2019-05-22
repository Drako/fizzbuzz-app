package guru.drako.course.apps.fizzbuzz

/**
 * Provider for fizzbuzz values.
 */
object FizzBuzzProvider {
  /**
   * A replacement rule. If [predicate] is true, the [replacement] shall be used.
   *
   * @property replacement The replacement to be used, when the [predicate] returns true.
   * @property predicate A function checking, whether the [replacement] should be used.
   */
  private data class Rule(
    val replacement: String,
    val predicate: (number: Int) -> Boolean
  )

  /**
   * Check, whether [divident] is divisable by [divisor].
   *
   * @receiver The divident.
   * @param other The divisor.
   * @return Whether the [divident] is divisable by the [divisor] or not.
   */
  private infix fun Int.isDivisableBy(other: Int) = this % other == 0

  /**
   * The default fizzbuzz rules.
   */
  private val RULES = sequenceOf(
    Rule(replacement = "Fizz") { it isDivisableBy 3 },
    Rule(replacement = "Buzz") { it isDivisableBy 5 }
  )

  /**
   * Apply the default fizzbuzz rules to number.
   *
   * @param number The number to be processed.
   * @return
   *  Fizz, when the [number] is divisable by 3.
   *  Buzz, when the [number] is divisable by 5.
   *  FizzBuzz, when the [number] is divisable by both.
   *  The [number] as a String otherwise.
   */
  fun fizzbuzz(number: Int): String {
    return RULES
      .filter { (_, predicate) -> predicate(number) }
      .joinToString(separator = "") { (replacement) -> replacement }
      .ifEmpty(number::toString)
  }

  /**
   * The 100 fizzbuzz values as a List of Strings.
   */
  val values: List<String> = (1..100).map(this::fizzbuzz)
}
