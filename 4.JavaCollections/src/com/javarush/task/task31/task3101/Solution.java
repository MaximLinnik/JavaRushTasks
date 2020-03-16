package com.javarush.task.task31.task3101;

import java.io.*;
import java.util.*;

/*
Проход по дереву файлов
*/
public class Solution {


    public static void main(String[] args) throws IOException {
        String path = args[0];
        File folder = new File(path);

        File resultFileAbsolutePath = new File(args[1]);

        File destination = new File(resultFileAbsolutePath.getParent() + "/allFilesContent.txt");

        FileUtils.renameFile(resultFileAbsolutePath, destination);
        OutputStream out = new FileOutputStream(destination);

        TreeMap<String, File> files = new TreeMap<>();
        files = collectFiles(files, folder);

        for (Map.Entry<String, File> entry : files.entrySet()) {
            FileInputStream fis = new FileInputStream(entry.getValue());
            while (fis.available() > 0) {
                out.write(fis.read());
            }
            out.write(10);
            fis.close();
        }

        out.close();

    }

    private static TreeMap<String, File> collectFiles(TreeMap<String, File> map, File folder) {
        for (File file : Objects.requireNonNull(folder.listFiles())) {
            if (file.isDirectory()) {
                map.putAll(collectFiles(map, file));
            } else {
                if (file.length() <= 50)
                    map.put(file.getName(), file);
                else
                    FileUtils.deleteFile(file);
            }
        }

        return map;
    }
}

