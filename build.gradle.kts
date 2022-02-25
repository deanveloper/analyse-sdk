import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar;

plugins {
    java
    id("com.github.johnrengelman.shadow") version "7.1.0"
}

repositories {
    mavenLocal()
    maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
    maven("https://repo.maven.apache.org/maven2/")
    mavenCentral()
}

dependencies {
    testImplementation("junit:junit:4.13")

    implementation("com.squareup.okhttp3:okhttp:4.9.3")
    implementation("com.google.code.gson:gson:2.8.9")

    compileOnly("org.jetbrains:annotations:16.0.2")
}

group = "net.analyse"
version = "1.0.0"
description = "sdk"
java.sourceCompatibility = JavaVersion.VERSION_1_8

val shadowJar: ShadowJar by tasks

tasks.withType<JavaCompile>() {
    options.encoding = "UTF-8"
}