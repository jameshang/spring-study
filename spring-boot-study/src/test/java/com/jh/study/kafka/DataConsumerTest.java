package com.jh.study.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DataConsumerTest {

    @Test
    public void testConsume() {
        DataConsumer consumer = new DataConsumer("topic1", "group3");
        ConsumerRecords<Integer, String> records = consumer.consume();
        log.info("==== Messages["+records.count()+"] ===");
        for (ConsumerRecord<Integer, String> record : records) {
            log.info("Received message: (" + record.key() + ", " + record.value() + ") at offset " + record.offset());
        }
    }

}
