package com.jh.study;

import java.security.MessageDigest;
import java.util.Base64;

import org.junit.Assert;
import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AppTest {

    @Test
    public void testPing(){
        App app=new App();
        Assert.assertTrue(app.ping());
    }

    @Test
    public void testMD5(){
        try{
            MessageDigest md=MessageDigest.getInstance("MD5");

            for(int i=0;i<20;i++){
                String s="abc"+i;
                md.update(s.getBytes("UTF-8"));
                byte[] bs=md.digest();
                log.info(Base64.getEncoder().encodeToString(bs));
            }

        }catch(Exception e){
            log.error("testMD5 failed!", e);
        }
    }

}
