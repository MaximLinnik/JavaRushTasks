package com.javarush.task.task08.task0818;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Только для богачей
*/

public class Solution {
    public static HashMap<String, Integer> createMap() {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("1", 5000);
        map.put("2",1000);
        map.put("3",200);
        map.put("4",100);
        map.put("5",254);
        map.put("6",500);
        map.put("7",600);
        map.put("8",700);
        map.put("9",900);
        map.put("10",125);
        return map;

    }

    public static void removeItemFromMap(HashMap<String, Integer> map) {
        Iterator iterator = map.entrySet().iterator();

        while (iterator.hasNext())
        {
            Map.Entry<String,Integer> entry = (Map.Entry<String, Integer>) iterator.next();

            if(entry.getValue()<500)

            iterator.remove();

        }

    }

    public static void main(String[] args) {

    }
}