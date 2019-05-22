import guru.drako.gradle.*

plugins {
  id("com.android.application") version "3.4.1"
  kotlin("android") version "1.3.31"
  kotlin("android.extensions") version "1.3.31"
  id("org.jetbrains.dokka-android")
}

group = "guru.drako.course.apps"
version = "1.0-SNAPSHOT"

repositories {
  mavenCentral()
  jcenter()
  google()
  kotlinx()
}

dependencies {
  implementation(kotlinArtifact("stdlib-jdk7"))
  implementation(kotlinArtifact("reflect"))
  testImplementation(kotlinArtifact("test-junit"))

  implementation(androidX(AndroidX.APPCOMPAT))
  implementation(androidX(AndroidX.CORE_KTX))
  implementation(androidX(AndroidX.RECYCLERVIEW))

  implementation(ktxCoroutines("core"))
  implementation(ktxCoroutines("android"))
}

android {
  compileSdkVersion(28)

  defaultConfig {
    minSdkVersion(17)
    targetSdkVersion(28)
    applicationId = "guru.drako.course.fizzbuzz"
    vectorDrawables.generatedDensities("hdpi", "xxhdpi")
  }

  sequenceOf("main", "test").forEach {
    sourceSets[it].java.srcDir("src/$it/kotlin")
  }

  buildTypes {
    getByName("debug") {
      isPseudoLocalesEnabled = true
    }
  }
}

androidExtensions {
  isExperimental = true
}

tasks {
  "wrapper"(Wrapper::class) {
    gradleVersion = "5.4.1"
  }

  "clean"(Delete::class) {
    setDelete(rootProject.buildDir)
  }

  dokka {
    outputFormat = "jekyll"
    outputDirectory = "$buildDir/../docs/"
    jdkVersion = 7
    linkMapping {
      dir = "src/main/kotlin"
      url = "https://github.com/Drako/fizzbuzz-app/blob/master/src/main/kotlin"
      suffix = "#L"
    }
  }
}
