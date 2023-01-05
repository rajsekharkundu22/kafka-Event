package com.example.Producer.controller;


import com.example.Producer.config.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class WikiController {

    @Autowired
    private KafkaProducer kafkaProducer;


    @GetMapping("/changes")
    public String getWikiChanges() throws InterruptedException {
        kafkaProducer.sendMessage();
        return "Start consume Wiki changes from Wiki endpoint";


    }
}
