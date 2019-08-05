package com.jh.study.kafka;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ExecutionException;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.DeleteRecordsOptions;
import org.apache.kafka.clients.admin.DeleteRecordsResult;
import org.apache.kafka.clients.admin.KafkaAdminClient;
import org.apache.kafka.clients.admin.RecordsToDelete;
import org.apache.kafka.common.TopicPartition;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DataAdmin {

    private final AdminClient admin;

    public DataAdmin() {
        Properties props = new Properties();
        props.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        admin = KafkaAdminClient.create(props);
    }

    public void deleteRecords() throws ExecutionException, InterruptedException {
        Map<TopicPartition, RecordsToDelete> recordsToDelete = new HashMap<>();
        DeleteRecordsOptions options = new DeleteRecordsOptions();
        recordsToDelete.put(new TopicPartition("topic1", 0), RecordsToDelete.beforeOffset(5));
        DeleteRecordsResult result = admin.deleteRecords(recordsToDelete, options);
        result.all().get();
    }

}
