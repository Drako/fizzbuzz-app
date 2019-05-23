package guru.drako.course.apps.fizzbuzz

import android.util.Log

inline fun <reified T> T.logDebug(message: String) {
  Log.d(T::class.java.simpleName, message)
}

inline fun <reified T> T.logWarn(message: String) {
  Log.w(T::class.java.simpleName, message)
}

inline fun <reified T> T.logInfo(message: String) {
  Log.i(T::class.java.simpleName, message)
}

inline fun <reified T> T.logError(message: String) {
  Log.e(T::class.java.simpleName, message)
}
