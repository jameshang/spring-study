package com.jh.study;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FooTest {

    @Test
    public void testFoo() throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = sdf.parse("2019-04-13 17:09:47");
        log.info(date.getTime() + "");
    }

    @Test
    public void testUUID() {
        log.info(UUID.randomUUID().toString());
    }

    @Test
    public void testSymbol() throws Exception {
        String s = "abc,def";
        s = URLEncoder.encode(s, StandardCharsets.UTF_8.name());
        log.info(s);
        s = "ssk%2C1234";
        log.info(URLDecoder.decode(s, StandardCharsets.UTF_8.name()));
    }

}
