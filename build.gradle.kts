val ktorVersion = "1.4.1"
val jupiterVersion = "5.4.1"
val kluentVersion = "1.61"

plugins {
    kotlin("jvm") version "1.4.10"
}


dependencies {
    api(kotlin("stdlib-jdk8"))
    implementation("io.ktor:ktor-server-netty:$ktorVersion")
    testImplementation(kotlin("test-junit5"))
    testImplementation("org.junit.jupiter:junit-jupiter-engine:$jupiterVersion")
    testImplementation("org.amshove.kluent:kluent:$kluentVersion")
    testImplementation("io.ktor:ktor-server-test-host:$ktorVersion")
}

repositories {
    jcenter()
    mavenCentral()
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }

    withType<Test> {
        useJUnitPlatform()
    }
}