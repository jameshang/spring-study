package com.jh.study.kafka;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DataProducerTest {

    @Test
    public void testSendData() {
        DataProducer producer = new DataProducer("topic1", 5);
        producer.produce();
    }

}
