package com.practice;

import com.sun.tools.jconsole.JConsoleContext;

import java.sql.SQLOutput;
import java.util.*;
//import java.util.List;

public class Main {

    public static void main(String[] args) {

/*        List<Integer> aL1 = new ArrayList<>(Arrays.asList(2, 4));
        List<Integer> aL2 = new ArrayList<>(3);
        aL2.addAll(Arrays.asList(16, 32, 96));
        System.out.println(getTotalX(aL1, aL2));*/

//        int[] bBall = {2,2,3,4,5,6,1};
//
//        System.out.println(Arrays.toString(breakingRecords(bBall)));
/*        List<Integer> aL1 = new ArrayList<>(Arrays.asList(1,2,1,3,2));
        System.out.println(birthday(aL1, 3, 2));*/
/*
        int[] nums = {1, 3, 2, 6, 1, 2,};
        System.out.println(divisibleSumPairs(6, 3, nums));*/
/*
        List<Integer> aL1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 4, 3, 2, 1, 3, 4));
        System.out.println(migratoryBirds(aL1));*/
//        System.out.println(dayOfProgrammer(1985));
/*        int[] inp = {10, 20, 20, 10, 10, 30, 50, 10, 20};
        System.out.println(sockMerchant(9, inp));*/
//        System.out.println(printerError("aaaxbbbbyyhwawiwjjjwwm"));
//        hashPractice("aaaxbbbbyyhwawiwjjjwwmmmqzacderfvbgtyhnmjuioiplmjkhiyughryftvbcvxcdfdreewdxcxczxasqwwretrutoypuypummmmm");
//        dynamicMultiArray();
//        int[] tbs = {1, 6, 2, 9, 5, 7, 3, 4, 8, 5, 9, 2, 1, 4, 7};
//        sortArray(tbs);
//        System.out.println(digital_root(991));

        System.out.println("Hello");
}

        public static int digital_root(int n) {
            int sum = 0;
            String[] result = String.valueOf(n).split("");
            if(result.length <= 1){
                return Integer.parseInt(result[0]);
            } else {
                for(int i = 0; i < result.length; i++){
                    sum += Integer.parseInt(result[i]);
                }
                return digital_root(sum);
            }
        }


    public static int[] sortArray(int[] array) {

        List<Integer> evenIndex = new LinkedList<Integer>();
        List<Integer> oddNumbers = new LinkedList<Integer>();
        int j = 0;

        for(int i = 0; i < array.length; i++){
            if(array[i] % 2 == 1) {
                oddNumbers.add(array[i]);
            } else {
                evenIndex.add(i);
            }
        }

        oddNumbers.sort(Integer::compareTo);

        for(int i = 0; i < array.length; i++) {
            if(!evenIndex.contains(i)){
                array[i] = oddNumbers.get(j);
                j++;
            }
        }

        return array;
    }

    public static void dynamicMultiArray(){
        ArrayList<ArrayList<Integer>> dyMuAr = new ArrayList<ArrayList<Integer>>();
        dyMuAr.add(new ArrayList<Integer>());
        System.out.println(dyMuAr);
        dyMuAr.get(0).add(0,34);
        System.out.println(dyMuAr);
        dyMuAr.get(0).add(1, 12);
        System.out.println(dyMuAr);
        dyMuAr.add(new ArrayList<Integer>(Arrays.asList(3, 4, 6)));
        System.out.println(dyMuAr);
        dyMuAr.get(0).add(dyMuAr.get(0).size(),38); //adds at end
        System.out.println(dyMuAr);
        dyMuAr.get(0).add(65); //easier way to add at end
        System.out.println(dyMuAr);
        dyMuAr.get(1).add(1, 78); //pops into index 1
        System.out.println(dyMuAr);
        dyMuAr.get(0).set(1, dyMuAr.get(0).get(1) +1 ); //increment dyMuAr[0][1]
        System.out.println(dyMuAr);
        dyMuAr.get(0).set(1, dyMuAr.get(0).get(1) *3 ); //multiplies it by three
        System.out.println(dyMuAr);
        dyMuAr.get(0).set(1, dyMuAr.get(1).get(1) * dyMuAr.get(0).get(1) ); //dyMuAr[0][1] = dyMuAr[1][1] * dyMuAr[0][1]
        System.out.println(dyMuAr);
        dyMuAr.get(1).remove(2); //removes dyMuAr[1][2]
        System.out.println(dyMuAr);
        int temp = dyMuAr.get(0).get(0); //swap dyMuAr[1][1] and dyMuAr[0][0]
        dyMuAr.get(0).set(0, dyMuAr.get(1).get(1));
        dyMuAr.get(1).set(1, temp);

        System.out.println(dyMuAr);
    }

    public static void hashPractice(String s){
        HashMap<Character, Integer> myHash = new HashMap<>();
        char[] sArray = s.toCharArray();
        for(int i = 0; i < sArray.length; i++){
                myHash.put(sArray[i], myHash.getOrDefault(sArray[i], 0) + 1);
        }
        System.out.println(myHash);
    }

    static List<Integer> oddNumbers(int l, int r) {
        List<Integer> result = new LinkedList<>();
            for(int i = l; i <= r; i++){
                if(i % 2 == 1){
                    result.add(i);
                }
            }
        return result;
    }

        public static String printerError(String s) {
            int numerator = 0;
            char[] letters = s.toCharArray();

            for(int i = 0; i < letters.length; i++){
                if (letters[i] > 'm'){
                    numerator++;
                }
            }
//            System.out.println(numerator + "/" + letters.length);
        return (numerator + "/" + letters.length);
        }

    static int sockMerchant(int n, int[] ar) {

        int[][] sockPile = new int[100][2];
        int j;
        boolean newSock;
        int result = 0;

        sockPile[0][0] = ar[0];

        for(int i = 0; i < n; i++) {
            newSock = true;
            j = 0;
            while (sockPile[j][0] != 0) {
                if (ar[i] == sockPile[j][0]) {
                    sockPile[j][1]++;
                    newSock = false;
                }
                j++;
            }
            if(newSock){
                sockPile[j][0] = ar[i];
                sockPile[j][1] = 1;
            }
        }
        j = 0;
        while(sockPile[j][0] != 0){
            result += sockPile[j][1] / 2;
            j++;
        }

        return result;
    }

    static void bonAppetit(List<Integer> bill, int k, int b) {
        int sum = 0;
        int owed = 0;
        for(int i = 0; i < bill.size(); i++){
            sum += k == i ? 0 : bill.get(i);
        }
        owed = b - (sum/2);
        if(owed == 0){
            System.out.print("Bon Appetit");
        } else {
            System.out.print(owed);
        }

    }

    static String dayOfProgrammer(int year) {
        String progDay = "";

        if (year == 1918){
            progDay = "26.09.18";
        } else if (year > 1918) {
            if ( (year % 400 == 0) || ((year % 4 == 0 ) && (year % 100 != 0))){
                progDay = "12.9."+year;
            } else {
                progDay = "13.9."+year;
            }
        } else {
            if (year % 4 == 0){
                progDay = "12.9."+year;
            } else {
                progDay = "13.9."+year;
            }
        }
    return progDay.trim();
    }

    static int migratoryBirds(List<Integer> arr) {
        int[][] counter = {{1,0},{2,0},{3,0},{4,0},{5,0}};
        int winner = 1;
        int winAmt = 0;
        for(int i = 0; i < arr.size(); i++){
            counter[arr.get(i)-1][1]++;
        }

        for(int i = 0; i < counter.length; i++){
            if(counter[i][1] > winAmt){
                winAmt = counter[i][1];
                winner = counter[i][0];
            }
        }

        return winner;
    }

    static int divisibleSumPairs(int n, int k, int[] ar) {
        int count = 0;
        for(int i = 0; i < n-1; i++) {
            for(int j = i+1; j < n; j++){
                if((ar[i]+ar[j])%k == 0){
                    count++;
                }
            }
        }
        return count;
    }

/*    static int birthday(List<Integer> s, int d, int m) {
        int count = 0;
        int sum = 0;
        for(int i = 0; i <= (s.size()-m); i++ ){
            sum = 0;
            for(int j = i; j < i + m; j++){
                sum += s.get(j);
            }
            if(sum == d){
                count++;
            }
        }

        return count;
    }*/

    static int[] breakingRecords(int[] scores) {
        int lowest = scores[0];
        int highest = scores[0];
        int[] result = {0,0};
        for(int i = 1; i < scores.length; i++){
            if(scores[i] < lowest) {
                lowest = scores[i];
                result[1]++;
            }
            if(scores[i] > highest) {
                highest = scores[i];
                result[0]++;
            }
        }
        return result;
    }

    public static int getTotalX(List<Integer> a, List<Integer> b) {
        int count = 0;
        int inc = a.get(a.size()-1);
        boolean flag;
        for(int i = inc; i <= b.get(0); i += inc){
            flag = true;

            for(int j = 0; j < a.size(); j++){
                if(i % a.get(j) != 0) {
                    flag = false;
                    break;
                }
            }
            if(!flag){
                continue;
            }
            for(int j = 0; j < b.size(); j++){
                if(b.get(j) % i != 0) {
                    flag = false;
                    break;
                }
            }
            if(flag){
                count ++;
            }
        }
    return count;
    }
}
