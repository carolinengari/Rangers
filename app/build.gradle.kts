import org.jooq.meta.jaxb.ForcedType

/*
 * This file was generated by the Gradle "init" task.
 *
 * This generated file contains a sample Kotlin application project to get you started.
 * For more details on building Java & JVM projects, please refer to https://docs.gradle.org/8.3/userguide/building_java_projects.html in the Gradle documentation.
 */

plugins {
    // Apply the org.jetbrains.kotlin.jvm Plugin to add support for Kotlin.
    id("org.jetbrains.kotlin.jvm") version "1.9.10"
    id("org.flywaydb.flyway") version "9.22.0"
    id("nu.studer.jooq") version "8.2.1"
    application
}

repositories {
    // Use Maven Central for resolving dependencies.
    mavenCentral()
}



dependencies {

    // Spark 
    implementation ("com.sparkjava:spark-kotlin:1.0.0-alpha")
    implementation ("com.h2database:h2:2.2.220")
    implementation("com.sparkjava:spark-template-velocity:2.7.1")

    // Use the Kotlin JUnit 5 integration.
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")

    // Use the JUnit 5 integration.
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.9.3")

    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    // This dependency is used by the application.
    implementation("com.google.guava:guava:32.1.1-jre")

    implementation("org.xerial:sqlite-jdbc:3.43.0.0")
    jooqGenerator("org.xerial:sqlite-jdbc:3.43.0.0")

    testImplementation("com.h2database:h2:2.2.220")

}

// Apply a specific Java toolchain to ease working on different environments.
java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(18))
    }
}

application {
    // Define the main class for the application.
    mainClass.set("ngari.caroline.AppKt")
}

tasks.named<Test>("test") {
    // Use JUnit Platform for unit tests.
    useJUnitPlatform()
}


flyway {
    url = "jdbc:sqlite:file:app/db/wildlife.db"
    locations = arrayOf("filesystem:db/migration")
}

jooq {
    version.set("3.18.6")

    configurations {
        create("main") {
            jooqConfiguration.apply {
                logging = org.jooq.meta.jaxb.Logging.WARN
                jdbc.apply {
                    driver = "org.sqlite.JDBC"
                    url = "jdbc:sqlite:db/wildlife.db"
                }
                generator.apply {
                    name = "org.jooq.codegen.DefaultGenerator"
                    database.apply {
                        name = "org.jooq.meta.sqlite.SQLiteDatabase"
                        excludes = "flyway_schema_history"
                        forcedTypes.apply {
                            forcedTypes = listOf(ForcedType().apply {
                                name = "INTEGER"
                                includeExpression = ".*\\.id"
                            })
                        }

                        target.apply {
                            packageName = "ngari.caroline.jooq"
                            directory = "src/generated/jooq"
                        }
                    }


                }
            }
        }
    }
}