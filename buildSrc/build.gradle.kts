import org.gradle.kotlin.dsl.`kotlin-dsl`

repositories {
    mavenCentral()
    maven("https://jitpack.io")
}

plugins {
    `kotlin-dsl`
}

dependencies{
    implementation("com.github.frogobox:open-build-src:1.0.6")
    implementation("com.github.frogobox:frogo-build-src:1.1.3")
}