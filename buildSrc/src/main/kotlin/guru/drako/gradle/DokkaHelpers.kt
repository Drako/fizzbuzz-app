package guru.drako.gradle

import org.gradle.kotlin.dsl.delegateClosureOf
import org.jetbrains.dokka.gradle.DokkaAndroidTask
import org.jetbrains.dokka.gradle.LinkMapping

fun DokkaAndroidTask.linkMapping(configure: LinkMapping.() -> Unit) {
  linkMapping(delegateClosureOf(configure))
}
