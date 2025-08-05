package com.kme.kafkamessageecho.producer;

import org.apache.kafka.clients.producer.*;

import java.util.Properties;

public class KafkaProducerApp {
    public static void main(String[] args) {
        /*Creating properties*/
        Properties props = new Properties();

        /*Configuring the producer*/
        props.put("bootstrap.servers","localhost:9092");
        props.put("value.serializer","org.apache.kafka.common.serialization.StringSerializer");
        props.put("key.serializer","org.apache.kafka.common.serialization.StringSerializer");

        /*Creating a producer*/
        KafkaProducer<String , String> producer = new KafkaProducer<>(props);

        /*Creating a record or a message*/
        String topic = "user-activity";
        String key = "testUser";
        String value = "Hello World";

        ProducerRecord<String , String> record = new ProducerRecord<>(topic , key , value);

        /*We send the message to the broker*/
        producer.send(record, (metadata, exception) ->{
           if(exception == null){
               System.out.printf("Successfully sent to topic %s, partition %d and offset %d%n",metadata.topic(),metadata.partition(),metadata.offset());
           }else{
               exception.printStackTrace();
           }
        });

        producer.close();
    }
}
