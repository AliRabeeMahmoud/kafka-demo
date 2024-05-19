package com.example.cab.controller;

import com.example.cab.model.Driver;
import com.example.cab.service.CabLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/location")
public class CabLocationController {

    @Autowired
    private CabLocationService cabLocationService;

    //Business Logic



    @PutMapping
    public ResponseEntity updateLocation() throws InterruptedException {

        int range = 5;
        while (range > 0) {
            cabLocationService.updateLocation(Math.random() + " , " + Math.random());
            Thread.sleep(1000);
            range --;

        }

        return new ResponseEntity<>(Map.of("message", "Location Updated")
        , HttpStatus.OK);
    }

    @PostMapping("/driver")
    public ResponseEntity sendDriver(@RequestBody Driver driver){
        cabLocationService.sendDriver(driver);
        return new ResponseEntity<>(Map.of("message", "driver sent"), HttpStatus.OK);
    }
}
