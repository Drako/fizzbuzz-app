package guru.drako.course.apps.fizzbuzz

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel

/**
 * Activity shown when the app is launched.
 */
class MainActivity : AppCompatActivity(), CoroutineScope by MainScope() {
  /**
   * Use activity_main for layout.
   */
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
  }

  /**
   * Clean up still running coroutines.
   */
  override fun onDestroy() {
    super.onDestroy()
    cancel()
  }
}
