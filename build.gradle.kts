plugins {//导入包
    val kotlinVersion = "1.3.72"
    val sprintBootVersion = "2.3.1.RELEASE"

    kotlin("jvm").version(kotlinVersion)
    kotlin("plugin.spring").version(kotlinVersion)
    kotlin("plugin.jpa").version(kotlinVersion)

    id("org.springframework.boot") version sprintBootVersion
    id("io.spring.dependency-management") version "1.0.9.RELEASE"





}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {//配置 maven下载地址
    maven("https://maven.aliyun.com/nexus/content/groups/public/")
    maven("https://repo.spring.io/libs-release")
    mavenCentral()
}


//依赖包
dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation(kotlin("reflect"))
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    runtimeOnly("mysql:mysql-connector-java")
    compile("org.springframework.boot:spring-boot-devtools")
    implementation("org.springframework.boot:spring-boot-starter-test")
    implementation("com.alibaba:fastjson:1.2.70")
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
}