package com.company;

import java.io.*;
import java.util.TreeMap;

public class Solution {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));

        TreeMap<Integer, Integer> Data = new TreeMap<>();
        Integer ItemCnt = 0;

        Integer IterNum = Integer.parseInt(reader.readLine());

        if(IterNum <= 10e+6) {

            while ((IterNum--) != 0) {


                String NewLine = reader.readLine();

                String[] NewAction = NewLine.split(" ");

                if (Integer.parseInt(NewAction[0]) == 1) {
                    //добавляем значение в структуру
                    Integer Key = Integer.parseInt(NewAction[1]);
                    if (Key <= 10e+9) {
                        if (Data.containsKey(Key)) {
                            Integer Val = Data.get(Key);
                            Data.put(Key, Val + 1);
                        } else {
                            Data.put(Key, 1);
                        }
                    }
                }

                if (Integer.parseInt(NewAction[0]) == 2) {
                    //извлекаем минимальный элемент
                    Integer Key = Data.firstKey();
                    writer.write(Key + "\n");
                    if (Data.get(Key) > 1) {
                        Integer Val = Data.get(Key);
                        Data.put(Key, Val - 1);
                    } else {
                        Data.remove(Key);
                    }
                }
            }
            writer.close();
        }
    }
}
