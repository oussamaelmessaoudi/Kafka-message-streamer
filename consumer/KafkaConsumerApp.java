package com.kme.kafkamessageecho.consumer;
import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.util.Collection;
import java.util.Collections;
import java.util.Properties;

public class KafkaConsumerApp {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.setProperty("bootstrap.servers", "localhost:9092");
        props.setProperty("group.id", "activity-consumer-group");
        props.setProperty("key.deserializer", StringDeserializer.class.getName());
        props.setProperty("value.deserializer", StringDeserializer.class.getName());
        props.setProperty("auto.offset.reset", "earliest");

        /*Here we create a consumer and give it the props defined above an then we make it subscribe to the user-activity topic*/
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);

        consumer.subscribe(Collections.singleton("user-activity"));

        /*Poll for messages*/
        while(true) {
            ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));
            for(ConsumerRecord<String,String> record : records){
                System.out.printf("Recieved record: key=%s, value=%s, partition=%d and offset=%d%n",
                        record.key(),record.value(),record.partition(),record.offset());
            }

        }
    }
}
