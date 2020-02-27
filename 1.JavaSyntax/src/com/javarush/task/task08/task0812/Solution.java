package com.javarush.task.task08.task0812;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Cамая длинная последовательность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        Reader reader = new InputStreamReader(System.in);
        BufferedReader r = new BufferedReader(reader);
        ArrayList<Integer> list = new ArrayList<Integer>();
        int num = 1, res = 1;
        for(int i=0;i<10;i++)
            list.add(Integer.parseInt(r.readLine()));
        for(int i = 1;i<list.size();i++){
            if(list.get(i-1).equals(list.get(i))){
                num++;
                if(res<num)
                    res = num;
            }
            else num = 1;
        }
        System.out.println(res);
    }
}