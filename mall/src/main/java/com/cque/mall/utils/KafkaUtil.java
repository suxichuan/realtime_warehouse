package com.cque.mall.utils;

import com.cque.mall.config.AppConfig;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

/**
 * @school:cque
 * @author:suxichuan
 * @create： 2022/11/15:14:42:56
 */
public class KafkaUtil {
    public static KafkaProducer<String, String> kafkaProducer = null;

    public static KafkaProducer<String, String> createKafkaProducer() {
        Properties properties = new Properties();
        properties.put("bootstrap.servers", AppConfig.kafka_server);
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        KafkaProducer<String, String> producer = null;
        try {
            producer = new KafkaProducer<String, String>(properties);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return producer;
    }

    public static void send(String topic, String msg) {
        if (kafkaProducer == null) {
            kafkaProducer = createKafkaProducer();
        }
        kafkaProducer.send(new ProducerRecord<String, String>(topic, msg));
    }
}
