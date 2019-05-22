rootProject.name = "fizzbuzz"

val knownPlugins = mapOf(
    "com.android.application" to "com.android.tools.build:gradle"
)

pluginManagement {
  repositories {
    gradlePluginPortal()
    google()
  }
  resolutionStrategy {
    eachPlugin {
      knownPlugins["${requested.id}"]?.let { module ->
        useModule("$module:${requested.version}")
      }
    }
  }
}
