package com.javarush.task.task31.task3101;

import java.io.File;

/*
Проход по дереву файлов
*/
public class Solution {
    public static void main(String[] args) {
        File path = new File(args[0]);
        File resultFileAbsolutePath = new File(args[1]);
        if(FileUtils.isExist(resultFileAbsolutePath)){
            FileUtils.renameFile(resultFileAbsolutePath, new File(resultFileAbsolutePath.getParent()+"allFilesContent.txt"));
        }

        for (File file : path.listFiles()){
            if(file.length()>50){

            }
        }
    }
}
