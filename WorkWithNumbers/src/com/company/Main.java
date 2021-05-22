package com.company;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;


public class Main {

    public static void main(String[] args) {

        List<Integer> intList = Arrays.asList(1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4);

        List<Integer> result = new ArrayList<>();

        for (int x = 0 ; x < intList.size(); x++){
            if (intList.get(x) > 0 && intList.get(x) % 2 == 0){
                result.add(intList.get(x));
            }
        }

        Collections.sort(result);
        System.out.println(result);
    }
}
