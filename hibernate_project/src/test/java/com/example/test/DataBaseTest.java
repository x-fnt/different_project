package com.example.test;

import com.example.model.Client;
import com.example.repository.ClientRepository;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static xfnt.LoggerFactory.info;
import static xfnt.LoggerFactory.step;

public class DataBaseTest extends BaseTest {
    private ClientRepository clientRepository;
    private Client client;

    @BeforeClass
    public void beforeClass() {
        setUp();
        clientRepository = new ClientRepository(sessionFactory);
    }

    @BeforeMethod
    public void beforeMethod() {
        info("Подготавливаем тестовую сущность");
        client = new Client("Nicolay", "+0 (000) 000-0000");
        info(client.toString());
        info("Сохраняем клиента в БД");
        clientRepository.save(client);
    }

    @Test
    public void myFirstTest() {
        step("Вычитываем сущность из БД");
        List<Client> result = clientRepository.findAll();
        assertEquals(result.size(), 1);
        assertEquals(result.getFirst(), client);

        step("Выполняем различные шаги по тесту");
    }

    @Test
    public void throwExceptionTest() {
        throw  new RuntimeException("EXCEPTION");
    }
}
