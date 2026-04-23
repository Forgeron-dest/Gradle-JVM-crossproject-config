plugins{
    java
    kotlin("jvm") version "1.9.24" apply false
}

group = "com.jvmskeleton"

repositories {
    mavenCentral()
}

sourceSets {
    main {
        java.srcDir("src/main/java")
    }
    test {
        java.srcDir("src/test/java")
    }
}

dependencies {
    testImplementation(libs.junit.jupiter)
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    implementation(project(":JavaService"))
    implementation(project(":KotlinService"))
    implementation(project(":ScalaService"))
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}
tasks.compileJava {
    dependsOn(
        project(":JavaService").tasks.named("build"),
        project(":KotlinService").tasks.named("build"),
        project(":ScalaService").tasks.named("build")
    )
}

java{
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
}

tasks.register<Jar>("appJar") {
    archiveFileName.set("JVMSkeleton-all.jar")
    manifest {
        attributes("Main-Class" to "com.jvmskeleton.App")
    }
    // Include root project output
    from(sourceSets.main.get().output)
    // Include all subproject outputs
    from(project(":JavaService").sourceSets.main.get().output)
    from(project(":KotlinService").sourceSets.main.get().output)
    from(project(":ScalaService").sourceSets.main.get().output)
    // Include dependencies
    dependsOn(configurations.runtimeClasspath)
    from({
        configurations.runtimeClasspath.get().filter { it.name.endsWith("jar") }.map { zipTree(it) }
    }){
        exclude("META-INF/*.SF", "META-INF/*.DSA", "META-INF/*.RSA")
    }

    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
}

tasks.named("build") {
    dependsOn("test")
    dependsOn("appJar")
}