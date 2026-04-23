# CrossLanguage Gradle Project

A multi-language JVM project demonstrating Java, Kotlin, and Scala services built together with Gradle.

## Project Structure

```
CrossLanguage/
├── app/                    # Main application (depends on all services)
├── JavaService/           # Pure Java service module
├── KotlinService/         # Pure Kotlin service module
├── ScalaService/          # Pure Scala service module
├── build.gradle.kts       # Root build configuration
└── settings.gradle.kts    # Multi-project include configuration
```

## How It Works

### Multi-Module Setup

The root [settings.gradle.kts](settings.gradle.kts) includes three language-specific services:

```kotlin
include("JavaService", "KotlinService", "ScalaService")
```

Each service builds independently but can be combined into a single uber JAR.

### Uber JAR

The root [build.gradle.kts](build.gradle.kts) creates an `appJar` task that:
1. Bundles all service outputs (`JavaService`, `KotlinService`, `ScalaService`)
2. Includes all runtime dependencies
3. Sets `crosslanguage.App` as the main class

### Java Version

All modules target **Java 21**:
```kotlin
java {
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
}
```

### Kotlin classes

Because of the way kotlin compiles to JVM kotlin objects/methods need to be called through KtClass.INSTANCE.class/method!


---

## Build Commands

### Build All Modules

```bash
./gradlew build
```

**Note:** Tests run automatically before the build completes.

### Build Without Running Tests

```bash
./gradlew build -x test
```

### Clean Build

```bash
./gradlew clean build
```

### Build Specific Service

```bash
./gradlew :JavaService:build
./gradlew :KotlinService:build
./gradlew :ScalaService:build
```

### Create Uber JAR Only

```bash
./gradlew appJar
```

Output: `build/libs/CrossLanguageApp-all.jar`

---

## Test Commands

**Note:** Tests run automatically before `build` completes for all modules.

### Run All Tests

```bash
./gradlew test
```

### Run Tests for Specific Service

```bash
./gradlew :JavaService:test
./gradlew :KotlinService:test
./gradlew :ScalaService:test
```

### Test Report

Open `build/reports/tests/test/index.html` after running tests.

---

## Run Commands

### Run Uber JAR Directly

```bash
java -jar build/libs/CrossLanguageApp-all.jar
```

### Run Individual Service JARs

```bash
java -jar JavaService/build/libs/JavaService.jar
java -jar KotlinService/build/libs/KotlinService.jar
java -jar ScalaService/build/libs/ScalaService.jar
```

---

## Common Tasks

| Task | Command |
|------|---------|
| List all projects | `./gradlew projects` |
| Dependency tree | `./gradlew dependencies` |
| Check style | `./gradlew check` |
| Stop Gradle daemon | `./gradlew --stop` |

---

## Troubleshooting

### Java Version Mismatch

If you see version errors, specify the JDK explicitly:

```bash
./gradlew build -Dorg.gradle.java.home=$JAVA_HOME
```

### Configuration Cache Issues

Disable configuration cache if needed:

```bash
./gradlew build --no-configuration-cache
```
