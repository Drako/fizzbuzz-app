package guru.drako.course.apps.fizzbuzz

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel

/**
 * Activity shown when the app is launched.
 */
class MainActivity : AppCompatActivity(), CoroutineScope by MainScope() {

  private val fizzBuzzAdapter = FizzBuzzAdapter()

  /**
   * Use activity_main for layout.
   */
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    logDebug("content view created.")

    recycler.adapter = fizzBuzzAdapter
  }

  override fun onCreateOptionsMenu(menu: Menu): Boolean {
    super.onCreateOptionsMenu(menu)

    menuInflater.inflate(R.menu.filter_menu, menu)

    // example for dynamically created menu items
    /*
    for (n in (1..100)) {
      val item = menu.add("Nur $n")
      item.setOnMenuItemClickListener {
        fizzBuzzAdapter.filter = FizzBuzzAdapter.Filter { it == "$n" }
        true
      }
    }
    */

    return true
  }

  override fun onOptionsItemSelected(item: MenuItem): Boolean {
    when (item.itemId) {
      R.id.filter_all -> fizzBuzzAdapter.filter = FizzBuzzAdapter.Filter.All
      R.id.filter_numbers -> fizzBuzzAdapter.filter = FizzBuzzAdapter.Filter.OnlyNumbers
      R.id.filter_fizz -> fizzBuzzAdapter.filter = FizzBuzzAdapter.Filter.OnlyFizz
      R.id.filter_buzz -> fizzBuzzAdapter.filter = FizzBuzzAdapter.Filter.OnlyBuzz
      R.id.filter_fizzbuzz -> fizzBuzzAdapter.filter = FizzBuzzAdapter.Filter.OnlyFizzBuzz
    }
    return true
  }

  /**
   * Clean up still running coroutines.
   */
  override fun onDestroy() {
    super.onDestroy()
    cancel()
  }
}
