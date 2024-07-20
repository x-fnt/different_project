package com.example.repository;

import com.example.model.Client;
import org.hibernate.SessionFactory;

public class ClientRepository extends HibernateCrudRepository<Client, Long> {

    public ClientRepository(SessionFactory sessionFactory) {
        super(Client.class, sessionFactory);
    }
}
