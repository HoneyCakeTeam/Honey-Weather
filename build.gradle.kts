import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose") version "1.4.1"
    kotlin("plugin.serialization") version "1.5.10"
}

group = "com.example"
version = "1.0-SNAPSHOT"

repositories {
    google()
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    maven {
        url = uri("https://maven.pkg.jetbrains.space/public/p/ktor/eap")
    }
}

kotlin {
    jvm {
        jvmToolchain(11)
        withJava()
    }
    sourceSets {
        val jvmMain by getting {
            dependencies {
                implementation(compose.desktop.currentOs)

                // Integration with Ktor
                implementation("io.ktor:ktor-server-core:2.3.2")
                implementation("io.ktor:ktor-server-netty:2.3.2")
                implementation("io.ktor:ktor-client-core:1.6.4")
                implementation("io.ktor:ktor-client-cio:1.6.4")
                implementation("io.ktor:ktor-client-serialization:1.6.4")
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.0")

                //Integration with Coroutines
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.4.2")

                //Integration with Koin for Ktor
                val koinKtor = "3.4.1"
                implementation("io.insert-koin:koin-ktor:$koinKtor")
                implementation("io.insert-koin:koin-logger-slf4j:$koinKtor")

                //Integration with Compose icons
                implementation("org.jetbrains.compose.material:material-icons-extended-desktop:1.4.1")
            }
        }
        val jvmTest by getting
    }
}

compose.desktop {
    application {
        mainClass = "MainKt"
        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "Honey-Weather"
            packageVersion = "1.0.0"
        }
    }
}
