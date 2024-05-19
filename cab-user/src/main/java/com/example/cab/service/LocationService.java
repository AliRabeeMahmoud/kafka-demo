package com.example.cab.service;

import com.example.cab.model.Driver;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class LocationService {

    @KafkaListener(topics = "cab-location", groupId = "user-group")
    public void cabLocation(String location) {
        System.out.println(location);
    }

    @KafkaListener(topics = "cab-location", groupId = "user-group")
    public void getDriver(Driver driver) {
        System.out.println(driver.getName());

        System.out.println(driver.getAge());
    }
}


