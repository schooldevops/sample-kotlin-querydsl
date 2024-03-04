import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
//	id("org.springframework.boot") version "3.2.3"
	id("org.springframework.boot") version "2.7.18"
	id("io.spring.dependency-management") version "1.1.4"
	kotlin("jvm") version "1.9.22"
	kotlin("plugin.spring") version "1.9.22"
	kotlin("plugin.jpa") version "1.9.22"
	kotlin("kapt") version "1.9.10"
	idea
}

group = "com.schooldevops"
version = "0.0.1-SNAPSHOT"

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

java {
//	sourceCompatibility = JavaVersion.VERSION_17
	sourceCompatibility = JavaVersion.VERSION_11
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

	runtimeOnly ("com.mysql:mysql-connector-j")

//	implementation("com.querydsl:querydsl-jpa:5.0.0:jakarta")
//	implementation("com.querydsl:querydsl-jpa:5.0.0:jpa")
////	kapt("com.querydsl:querydsl-apt:5.0.0:jakarta")
//	kapt("com.querydsl:querydsl-apt:5.0.0:jpa")
//	kapt("jakarta.annotation:jakarta.annotation-api")
//	kapt("jakarta.persistence:jakarta.persistence-api")

	implementation("com.querydsl:querydsl-jpa:5.0.0")
	annotationProcessor("jakarta.annotation:jakarta.annotation-api")
	annotationProcessor("jakarta.persistence:jakarta.persistence-api")
	annotationProcessor(group = "com.querydsl", name = "querydsl-apt", classifier = "jpa")
	kapt("com.querydsl:querydsl-apt:5.0.0:jpa")
	kapt("org.springframework.boot:spring-boot-configuration-processor")


	annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	runtimeOnly("com.h2database:h2")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
}

// Querydsl 설정부 추가 - start
val generated = file("src/main/generated")

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs += "-Xjsr305=strict"
		jvmTarget = "11"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.getByName<Jar>("jar") {
	enabled = false
}


idea {
	module {
		val kaptMain = file("build/generated/source/kapt/main")
//		val kaptMain = file("src/main/generated/source/kapt/main")
		sourceDirs.add(kaptMain)
		generatedSourceDirs.add(kaptMain)
	}
}