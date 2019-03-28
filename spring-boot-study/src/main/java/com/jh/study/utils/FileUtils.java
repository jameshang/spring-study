package com.jh.study.utils;

import java.io.File;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FileUtils {

    private static void removeSpacePriv(File file){
        if(file==null||!file.exists()||!file.isDirectory()){
            return;
        }
        File parent=file.getParentFile();
        String fileName=file.getName().replaceAll(" ", "-");
        File dest=new File(parent, fileName);
        file.renameTo(dest);
    }

    public static void removeSpace(File dir){
        if(dir==null||!dir.exists()||!dir.isDirectory()){
            return;
        }
        File[] files=dir.listFiles();
        for(File file:files){
            removeSpace(file);
            removeSpacePriv(file);
        }
    }

}
