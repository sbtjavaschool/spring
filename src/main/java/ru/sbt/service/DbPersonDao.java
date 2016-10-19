package ru.sbt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class DbPersonDao implements PersonDao {
    private final String host;
    private final int port;
    private final int connectionPoolSize;
    private final String username;
    private final String password;

    @Autowired
    public DbPersonDao(@Value("${host}") String host,
                       @Value("${port}") int port,
                       @Value("${port}") int connectionPoolSize,
                       @Value("${db.username}") String username,
                       @Value("${db.password}") String password) {
        this.host = host;
        this.port = port;
        this.connectionPoolSize = connectionPoolSize;
        this.username = username;
        this.password = password;
    }
}
