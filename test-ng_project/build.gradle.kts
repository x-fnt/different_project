dependencies {
    testImplementation("org.testng:testng:7.8.0")
    testImplementation("org.slf4j:slf4j-nop:2.0.12")
    implementation(project(":l4jqa"))
}

tasks.test {
    useTestNG()
}