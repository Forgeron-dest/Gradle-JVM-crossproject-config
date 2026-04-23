plugins {
    scala
}

group = "com.jvmskeleton"

dependencies {
    implementation("org.scala-lang:scala3-library_3:3.4.2")
    testImplementation(libs.junit.jupiter)
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

java {
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
}

tasks.withType<ScalaCompile> {
    scalaCompileOptions.apply {
        additionalParameters = listOf("-deprecation", "-feature", "-unchecked")
    }
}

tasks.jar {
    archiveFileName.set("ScalaService.jar")
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}

tasks.named("build") {
    dependsOn("test")
}