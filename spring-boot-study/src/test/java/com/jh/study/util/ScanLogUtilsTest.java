package com.jh.study.util;

import java.util.List;

import org.junit.Test;

import com.jh.study.utils.ScanLogUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ScanLogUtilsTest {

    private static final String logFile="temp/agent_access.log";
    private static final String filteredLogFile="temp/agent_access_filter001.log";
    private static int limit=-1;

    @Test
     public void testRead() throws Exception{
        List<String> list=ScanLogUtils.read(logFile, limit);
        for(String line:list){
            log.info(line);
        }
    }

    @Test
    public void testRead001() throws Exception{
        List<String> list=ScanLogUtils.read(filteredLogFile);
        for(String line:list){
            log.info(line);
        }
    }

}
