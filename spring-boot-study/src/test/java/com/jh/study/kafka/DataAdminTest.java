package com.jh.study.kafka;

import java.util.concurrent.ExecutionException;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DataAdminTest {

    @Test
    public void testDeleteRecords() throws ExecutionException, InterruptedException {
        DataAdmin dataAdmin=new DataAdmin();
        dataAdmin.deleteRecords();
    }

}
