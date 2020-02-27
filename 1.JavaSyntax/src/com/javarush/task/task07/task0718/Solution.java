package com.javarush.task.task07.task0718;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;

/* 
Проверка на упорядоченность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        Reader reader = new InputStreamReader(System.in);
        BufferedReader r = new BufferedReader(reader);
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i<10; i++){
            list.add(r.readLine());
        }
        int sizeEl = list.get(0).length(), ex = 0, check = 0;

        for (int i = 1; i<list.size();i++){
            sizeEl = list.get(i).length();
            if(sizeEl<list.get(i-1).length()) {
                ex = i;
                //sizeEl = list.get(i).length();
                System.out.println(ex);
                break;
            }

        }
    }
}

