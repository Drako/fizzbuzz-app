package guru.drako.course.apps.fizzbuzz

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/**
 * Activity shown when the app is launched.
 */
class MainActivity : AppCompatActivity() {
  /**
   * Use activity_main for layout.
   */
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
  }
}
