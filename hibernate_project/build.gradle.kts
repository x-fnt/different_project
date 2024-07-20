dependencies {
    testImplementation("org.testng:testng:7.8.0")
    testImplementation("org.slf4j:slf4j-nop:2.0.12")
    testImplementation("org.postgresql:postgresql:42.7.3")
    testImplementation("org.hibernate:hibernate-core:6.5.2.Final")
    testImplementation("org.jboss.logging:jboss-logging:3.4.1.Final")
    testImplementation(project(":l4jqa"))
}

tasks.test {
    useTestNG()
}