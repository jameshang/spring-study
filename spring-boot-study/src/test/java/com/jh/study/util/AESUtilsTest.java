package com.jh.study.util;

import org.junit.Assert;
import org.junit.Test;

import com.jh.study.utils.AESUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AESUtilsTest {

    private static final String KEY = "123456";

    @Test
    public void testAES() {
        try {
            String content = "{'repairPhone':'18547854787','customPhone':'12365478965','captchav':'58m7'}";
            System.out.println("加密前：" + content);
            System.out.println("加密密钥和解密密钥：" + KEY);
            String encrypt = AESUtils.encrypt(content, KEY);
            System.out.println("加密后：" + encrypt);
            String decrypt = AESUtils.decrypt(encrypt, KEY);
            System.out.println("解密后：" + decrypt);
            Assert.assertEquals(content, decrypt);
        } catch (Exception e) {
            log.error("", e);
        }
    }

}
