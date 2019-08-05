package com.jh.study;

import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.junit.Assert;
import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AppTest {

    @Test
    public void testPing() {
        App app = new App();
        Assert.assertTrue(app.ping());
    }

    @Test
    public void testMD5() {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");

            for (int i = 0; i < 20; i++) {
                String s = "abc" + i;
                md.update(s.getBytes("UTF-8"));
                byte[] bs = md.digest();
                log.info(Base64.getEncoder().encodeToString(bs));
            }
        } catch (Exception e) {
            log.error("testMD5 failed!", e);
        }
    }

    @Test
    public void testTimestamp() {
        try {
            Date date = new Date(1553779800000l);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
            log.info(sdf.format(date));
        } catch (Exception e) {
            log.error("testTimestamp failed!", e);
        }
    }

    @Test
    public void testJson(){
        try {
            Random r=new Random();
            ObjectMapper mapper=new ObjectMapper();
            Map<String, Object> map=new HashMap<>();
            map.put("name", "tester");
            map.put("date", new Date());
            map.put("doubleValue", r.nextDouble());
            map.put("longValue", r.nextLong());
            String json=mapper.writeValueAsString(map);
            log.info(json);
        } catch (Exception e) {
            log.error("testJson failed!", e);
        }
    }

}
