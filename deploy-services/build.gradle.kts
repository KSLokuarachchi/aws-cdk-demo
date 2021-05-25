import com.moowork.gradle.node.NodeExtension
import com.moowork.gradle.node.npm.NpxTask

plugins {
    application
    id("com.github.node-gradle.node") version "2.2.2"
}

repositories {
    mavenCentral()
}

application {
    mainClass.set("com.example.demo.CdkDeployApp")
}

val env: String? by project

configure<NodeExtension> {
    version = "12.6.0"
    npmVersion = "6.4.1"
    download = true
}

task<NpxTask>("synth") {
    description = "Generate CDK artifacts"
    command = "cdk"
    args = listOf("synth", "-c", "env=$env")
}

task<NpxTask>("deploy") {
    description = "Deploy CDK components"
    command = "cdk"
    args = listOf("deploy", "*", "-c", "env=$env")
    doFirst {
        "Deploying env:$env"
    }
}

task<NpxTask>("destroy") {
    description = "Destroy CDK components"
    command = "cdk"
    args = listOf("destroy", "$env", "-c", "env=$env", "--force")
    doFirst {
        "Destroying platform for env:$env"
    }
}

dependencies {
    implementation("software.amazon.awscdk:core:1.83.0")
    implementation("software.amazon.awscdk:dynamodb:1.83.0")
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

