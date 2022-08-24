plugins {
    kotlin("jvm") version "1.7.10"
}

group = "net.sagberg"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

val arrowVersion = "1.1.2"
val ktorVersion = "2.1.0"
val kotestVersion = "5.4.2"

dependencies {
    testImplementation(kotlin("test"))
    testImplementation("io.kotest", "kotest-assertions-core-jvm", kotestVersion)
    testImplementation("io.kotest", "kotest-runner-junit5", kotestVersion)

//    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
    implementation("io.arrow-kt:arrow-core:$arrowVersion")
//    implementation("io.arrow-kt:arrow-fx-coroutines:$arrowVersion")
    implementation("io.ktor:ktor-client-core:$ktorVersion")
    implementation("io.ktor:ktor-client-cio:$ktorVersion")
    implementation("io.ktor:ktor-client-content-negotiation:$ktorVersion")
    implementation("io.ktor:ktor-serialization-gson:$ktorVersion")
    implementation("com.google.code.gson:gson:2.9.0")
    implementation("org.openjdk.jmh:jmh-core:1.35")

}

tasks.test {
    useJUnitPlatform()
}
