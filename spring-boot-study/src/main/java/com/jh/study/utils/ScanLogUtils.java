package com.jh.study.utils;

import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ScanLogUtils {

    public static List<String> read(String file, int limit) {
        List<String> list = new ArrayList<>();
        int count = 0;
        try (RandomAccessFile raf = new RandomAccessFile(file, "r")) {
            for (String line = raf.readLine(); line != null; line = raf.readLine()) {
                if (limit > 0) {
                    if (count > limit) {
                        break;
                    }
                    count++;
                }
                String[] ss = line.split(" ", 6);
                if (ss.length < 6) {
                    continue;
                }
                String s = ss[5].replaceFirst("\"", "");
                ss = s.split("\"", 2);
                if (ss.length < 2) {
                    continue;
                }
                s = ss[0];
                ss = s.split(" ", 3);
                if (ss.length < 3) {
                    continue;
                }
                s = ss[0] + " " + ss[1];
                if (!"POST".equalsIgnoreCase(ss[0])) {
                    continue;
                }
                if (list.contains(s)) {
                    continue;
                }
                list.add(s);
            }
        } catch (Exception e) {
            log.error("Read log file failed!", e);
        }
        return list;
    }

    public static List<String> read(String file) {
        List<String> list = new ArrayList<>();
        try (RandomAccessFile raf = new RandomAccessFile(file, "r")) {
            for (String line = raf.readLine(); line != null; line = raf.readLine()) {
                String[] ss = line.split(" ", 2);
                if (ss.length < 2) {
                    continue;
                }
                String s = ss[1];
                if(!s.startsWith("/api")){
                    continue;
                }
                if (list.contains(s)) {
                    continue;
                }
                list.add(s);
            }
        } catch (Exception e) {
            log.error("Read log file failed!", e);
        }
        return list;
    }

}
