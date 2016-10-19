package ru.sbt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@AllowRemoteAccess
public class DbLessonDao implements LessonDao {
    private final String host;
    private final int port;
    private final int connectionPoolSize;
    private final String username;
    private final String password;

    @Autowired
    public DbLessonDao(@Value("${host}") String host,
                       @Value("${port}")int port,
                       @Value("${port}")int connectionPoolSize,
                       @Value("${host}")String username,
                       @Value("${host}")String password) {
        this.host = host;
        this.port = port;
        this.connectionPoolSize = connectionPoolSize;
        this.username = username;
        this.password = password;
    }

    @Override
    public void update(Object o) {

    }
}
