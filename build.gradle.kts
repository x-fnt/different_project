group = "x-fnt"
version = "1.0-SNAPSHOT"

plugins {
    // Плагин 'base' добавляет задачу 'clean' в корневой проект
    base
}

subprojects {
    apply(plugin = "java")

    dependencies {
    }

    tasks.withType<JavaCompile> {
        sourceCompatibility = "21"
        targetCompatibility = "21"
    }

    repositories {
        mavenCentral()
    }
}

// Конфигурация корневого проекта
allprojects {
    // Общие настройки для всех проектов, включая корневой
    // Можно оставить пустым, если нет общих настроек
}

// Удаляем директорию src в корневом проекте, если она создается
tasks.register("cleanRootSrcDir") {
    doLast {
        delete("src")
    }
}

// Добавляем зависимость задачи clean от cleanRootSrcDir
tasks.named("clean") {
    dependsOn("cleanRootSrcDir")
}