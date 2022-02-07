val ktorVersion = "1.6.7"
val jupiterVersion = "5.4.1"
val kluentVersion = "1.68"

plugins {
    `maven-publish`

    kotlin("jvm") version "1.6.10"
}


dependencies {
    implementation("io.ktor:ktor-server-netty:$ktorVersion")
    testImplementation(kotlin("test-junit5"))
    testImplementation("org.junit.jupiter:junit-jupiter-engine:$jupiterVersion")
    testImplementation("org.amshove.kluent:kluent:$kluentVersion")
    testImplementation("io.ktor:ktor-server-test-host:$ktorVersion")
}

repositories {
    mavenCentral()
}

publishing {
    repositories{
        mavenLocal()
    }

    publications {
        create<MavenPublication>("local") {
            from(components["java"])
        }
    }
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "13"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "13"
    }

    withType<Test> {
        useJUnitPlatform()
    }
}
