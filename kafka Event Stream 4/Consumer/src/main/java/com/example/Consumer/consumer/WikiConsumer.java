package com.example.Consumer.consumer;

import com.example.Consumer.model.WikiData;
import com.example.Consumer.repo.WikiRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class WikiConsumer {

    @Autowired
    private WikiRepo wikiRepo;
    @KafkaListener(topics = "wiki_topic", groupId = "wikiGroup")
    public  void consumeMessage(String message){

        System.out.println(message);


        WikiData wikiData = new WikiData();
        wikiData.setWikiMessage(message);

        wikiRepo.save(wikiData);


    }


}
