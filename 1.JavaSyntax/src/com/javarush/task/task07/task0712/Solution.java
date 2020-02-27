package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Reader r = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(r);
        ArrayList<String> list = new ArrayList<String>();
        for(int i = 0;i<10;i++){
            list.add(reader.readLine());
        }
        int lenMin = list.get(0).length(), lenMax = list.get(0).length(), numMin = 0, numMax = 0;
        for (int i = 0;i<list.size();i++){
            if (lenMin>list.get(i).length()) {
                numMin = i;
                lenMin = list.get(i).length();
            }
            if (lenMax<list.get(i).length())
            {
                numMax = i;
                lenMax = list.get(i).length();
            }
        }
        if(numMin<numMax) System.out.println(list.get(numMin));
        else System.out.println(list.get(numMax));
    }
}
