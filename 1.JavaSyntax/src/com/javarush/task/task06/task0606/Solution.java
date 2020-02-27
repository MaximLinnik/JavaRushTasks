package com.javarush.task.task06.task0606;

import java.io.*;

/* 
Чётные и нечётные циферки
*/

public class Solution {

    public static int even;
    public static int odd;

    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        Reader r = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(r);
        String n = reader.readLine();
        int num = Integer.parseInt(n);
        while(num%10!=0){
            if(num%2==0)
                even++;
            else
                odd++;
            num=num/10;
        }
        System.out.println("Even: "+even+" Odd: "+odd);

    }
}
