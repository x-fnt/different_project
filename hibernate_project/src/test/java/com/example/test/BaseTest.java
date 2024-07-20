package com.example.test;

import com.example.model.Client;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import xfnt.LoggerFactory;
import xfnt.LoggerLevel;

import java.util.Properties;

import static java.lang.String.format;
import static xfnt.LoggerFactory.*;

public class BaseTest {
    protected SessionFactory sessionFactory;

    @BeforeSuite
    public void beforeSuit() {
        @SuppressWarnings("unused")
        org.jboss.logging.Logger logger = org.jboss.logging.Logger.getLogger("org.hibernate");
        java.util.logging.Logger.getLogger("org.hibernate").setLevel(java.util.logging.Level.OFF);
    }

    @BeforeClass
    public void setUp() {
        LoggerFactory.createLogger();
        String loggerEnv = System.getenv("logger.level");
        step(format("Уровень логирования - %s", loggerEnv));
        LoggerFactory.changeLoggerLevel(LoggerLevel.fromName(loggerEnv));

        step("Вычитываем переменные окружения");
        String pgUrl = System.getenv("postgres.url");
        String pgUser = System.getenv("postgres.user");
        String pgPassword = System.getenv("postgres.password");
        info(format("URL для соединения с БД postgres - %s", pgUrl));
        info(format("Имя пользователя БД postgres - %s", pgUser));
        info(format("Пароль пользователя БД postgres - %s", pgPassword));

        step("Конфигурируем hibernate");
        try {
            debug("Создаем конфигурацию Hibernate");
            Configuration configuration = new Configuration();
            debug("Настраиваем свойства Hibernate");
            Properties settings = new Properties();
            settings.put("hibernate.connection.driver_class", "org.postgresql.Driver");
            settings.put("hibernate.connection.url", pgUrl);
            settings.put("hibernate.connection.username", pgUser);
            settings.put("hibernate.connection.password", pgPassword);
            settings.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
            settings.put("hibernate.hbm2ddl.auto", "update");
            debug("Применяем настройки к конфигурации");
            configuration.setProperties(settings);
            debug("Регистрируем классы сущностей");
            configuration.addAnnotatedClass(Client.class);
            debug("Создаем SessionFactory");
            sessionFactory = configuration.buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Проблема с созданием SessionFactory", e);
        }
    }

    @AfterClass
    public void tearDown() {
        sessionFactory.close();
    }
}
