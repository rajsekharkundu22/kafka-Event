package com.example.Producer.config;

import com.example.Producer.handler.WikiEventHandler;
import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.EventSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.concurrent.TimeUnit;
import java.util.logging.Handler;

@Service
public class KafkaProducer {



    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;


    public void sendMessage() throws InterruptedException {
        String topic = "wiki_topic";


        EventHandler eventHandler = new WikiEventHandler(kafkaTemplate, topic);
        String url = "https://stream.wikimedia.org/v2/stream/recentchange";

        EventSource.Builder builder = new EventSource.Builder(eventHandler, URI.create(url));

        EventSource eventSource = builder.build();
        eventSource.start();

        TimeUnit.SECONDS.sleep(50);


    }

}
