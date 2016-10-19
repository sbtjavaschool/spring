package ru.sbt.service;

import org.springframework.stereotype.Service;
import ru.sbt.run.RunAsync;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Service
public class Cache {
    private ConcurrentMap<String, String> map = new ConcurrentHashMap<>();

    @RunAsync
    public void populate() throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            System.out.println(i);
            Thread.sleep(1_000);
            map.putIfAbsent("fsd", "Fsdf");
        }
    }
}
