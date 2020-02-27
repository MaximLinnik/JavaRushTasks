package com.javarush.task.task07.task0706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Улицы и дома
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int even = 0, odd = 0;
        int []mas = new int[15];
        InputStreamReader r = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(r);
        for(int i = 0; i<15; i++) {
            mas[i] = Integer.parseInt(reader.readLine());
            if(i%2==0)
                even+=mas[i];
            else
                odd+=mas[i];
        }



        if (even>odd)
            System.out.println("В домах с четными номерами проживает больше жителей.");
        else
            System.out.println("В домах с нечетными номерами проживает больше жителей.");

    }
}
