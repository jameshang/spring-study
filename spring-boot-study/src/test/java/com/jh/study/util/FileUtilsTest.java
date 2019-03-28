package com.jh.study.util;

import java.io.File;

import org.junit.Test;

import com.jh.study.utils.FileUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FileUtilsTest {

    @Test
    public void testRemoveSpace() {
        try{
            File file=new File("/Users/jameshang/work/git/es101/betmatrix");
            FileUtils.removeSpace(file);
        }catch(Exception e){
            log.error("testRemoveSpace failed!", e);
        }
    }

}
