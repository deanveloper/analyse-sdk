import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar;

plugins {
    java
    `maven-publish`
    id("com.github.johnrengelman.shadow") version "7.1.0"
}

repositories {
    mavenLocal()
    maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
    maven("https://repo.maven.apache.org/maven2/")
    mavenCentral()
}

dependencies {
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



publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            groupId = "net.analyse"
            artifactId = "sdk"
            version = "1.0.0"

            from(components["java"])

            pom {
                name.set("Analyse SDK")
                description.set("An official wrapper for Analyse.")
                url.set("https://analyse.net")

                licenses {
                    license {
                        name.set("The Apache License, Version 2.0")
                        url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                    }
                }
                developers {
                    developer {
                        id.set("heychazza")
                        name.set("Charlie Joseph")
                        email.set("ch@rli.es")
                    }
                }
                scm {
                    connection.set("scm:git:git://github.com/track/sdk.git")
                    developerConnection.set("scm:git:ssh://github.com/track/sdk.git")
                    url.set("https://github.com/track/sdk")
                }
            }
        }
    }
}