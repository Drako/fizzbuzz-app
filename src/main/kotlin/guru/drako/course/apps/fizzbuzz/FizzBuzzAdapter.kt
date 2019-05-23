package guru.drako.course.apps.fizzbuzz

import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.TextView
import androidx.core.text.isDigitsOnly
import androidx.recyclerview.widget.RecyclerView
import kotlin.properties.Delegates

class FizzBuzzAdapter : RecyclerView.Adapter<FizzBuzzAdapter.ViewHolder>() {

  class Filter(val predicate: (String) -> Boolean) {
    companion object {
      val All = Filter { true }
      val OnlyNumbers = Filter { it.isDigitsOnly() }
      val OnlyFizz = Filter { it == "Fizz" }
      val OnlyBuzz = Filter { it == "Buzz" }
      val OnlyFizzBuzz = Filter { it == "FizzBuzz" }
    }
  }

  private var cachedValues = FizzBuzzProvider.values

  var filter: Filter by Delegates.observable(Filter.All) { _, _, new ->
    cachedValues = FizzBuzzProvider.values
      .filter(new.predicate)
    notifyDataSetChanged()
  }

  class ViewHolder(private val textView: TextView) : RecyclerView.ViewHolder(textView) {
    fun bind(text: String) {
      textView.text = text
    }
  }

  override fun getItemCount(): Int {
    return cachedValues.size
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    return ViewHolder(TextView(parent.context).apply {
      layoutParams = ViewGroup.LayoutParams(MATCH_PARENT, WRAP_CONTENT)
    })
  }

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    holder.bind(cachedValues[position])
  }

}
