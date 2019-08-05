package com.jh.study.kafka;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.IntegerSerializer;
import org.apache.kafka.common.serialization.StringSerializer;

public class DataProducer {

    private final KafkaProducer<Integer, String> producer;
    private final String                         topic;
    private final Boolean                        isAsync;
    private final SimpleDateFormat               sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SZ");
    private final int                            total;

    public DataProducer(String topic, int total, Boolean isAsync) {
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        props.put(ProducerConfig.CLIENT_ID_CONFIG, "DemoProducer");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, IntegerSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        producer = new KafkaProducer<>(props);
        this.topic = topic;
        this.isAsync = isAsync;
        this.total = total;
    }

    public DataProducer(String topic, int total) {
        this(topic, total, false);
    }

    public void produce() {
        for (int i = 1; i <= total; i++) {
            Date date = new Date();
            String msg = sdf.format(date) + " - " + UUID.randomUUID().toString();
            if (isAsync) { // Send asynchronously
                producer.send(new ProducerRecord<>(topic, i,
                        msg), new DemoCallBack(date.getTime(), i, msg));
            } else { // Send synchronously
                try {
                    producer.send(new ProducerRecord<>(topic, i,
                            msg)).get();
                    System.out.println("Sent message: (" + i + ", " + msg + ")");
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            }
        }
        producer.close();
    }
}

class DemoCallBack implements Callback {

    private final long   startTime;
    private final int    key;
    private final String message;

    public DemoCallBack(long startTime, int key, String message) {
        this.startTime = startTime;
        this.key = key;
        this.message = message;
    }

    /**
     * A callback method the user can implement to provide asynchronous handling of request completion. This method will
     * be called when the record sent to the server has been acknowledged. When exception is not null in the callback,
     * metadata will contain the special -1 value for all fields except for topicPartition, which will be valid.
     *
     * @param metadata  The metadata for the record that was sent (i.e. the partition and offset). Null if an error
     *                  occurred.
     * @param exception The exception thrown during processing of this record. Null if no error occurred.
     */
    public void onCompletion(RecordMetadata metadata, Exception exception) {
        long elapsedTime = System.currentTimeMillis() - startTime;
        if (metadata != null) {
            System.out.println(
                    "message(" + key + ", " + message + ") sent to partition(" + metadata.partition() +
                            "), " +
                            "offset(" + metadata.offset() + ") in " + elapsedTime + " ms");
        } else {
            exception.printStackTrace();
        }
    }


}
