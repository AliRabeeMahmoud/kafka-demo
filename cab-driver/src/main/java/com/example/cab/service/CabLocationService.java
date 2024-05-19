package com.example.cab.service;

import com.example.cab.constant.AppConstant;
import com.example.cab.model.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class CabLocationService {

    @Autowired
    private KafkaTemplate<String,Object> kafkaTemplate;

    public boolean updateLocation(String location) {
        kafkaTemplate.send(AppConstant.CAB_LOCATION, location);
        return true;
    }

    public boolean sendDriver(Driver driver){

        kafkaTemplate.send(AppConstant.CAB_LOCATION, driver);

        return true;
    }
}
