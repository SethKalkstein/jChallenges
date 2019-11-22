package com.practice;


import java.util.Arrays;
import java.util.function.DoubleToIntFunction;

public class Main {
//    private static int[] practiceArray = new int[]{1,2,3, 3, 4, -5, 4, 4, 4, 4, 12, 0, 4, 5 ,4,3,2,20,3,4,5,6,50,-1};

    public static void main(String[] args) {
/*
        System.out.println(factorial(4));
        int[] arData = { 1, 2, 3, 4, 5 };
        int kiosks = 1;
        int[] arData = { 2, 2, 3, 3, 4, 4 };
        int kiosks = 3;
        System.out.println(solveSuperMarketQueue(arData, kiosks));
        Calc cal = new Calc();
        System.out.println(cal.div(21,5));
*/
//    frequencySort(new int[] {1,2,3, 3, 4, 4, 4, 4, 4, 12, 0, 4, 5 ,4,3,2,3,4,5,6});
//    freqSort2(new int[] {1,2,3, 3, 4, 4, 4, 4, 4, 12, 0, 4, 5 ,4,3,2,3,4,5,6});
//        int[] practiceArray;
//        practiceArray = new int[]{1,2,3, 3, 4, -5, 4, 4, 4, 4, 12, 0, 4, 5 ,4,3,2,20,3,4,5,6,50,-1};

        int[] practiceArray = new int[]{1,2,3, 3, 4, -5, 4, 4, 4, 4, 12, 0, 4, 5 ,4,3,2,20,3,4,5,6,50,-1};

        System.out.println(Arrays.toString(selectSort(practiceArray)));
        int[] nextArray = selectSort(practiceArray);
        int[] toFind = insertSort(nextArray);
        System.out.println(Arrays.toString(toFind));
        System.out.println(Arrays.toString(practiceArray));
        /* int searchResult = binSearch(toFind, 7); */
    }
/*    public static int[] qSort(int[] theArray){
        int inputLength = theArray.length;
        int[] result = new int[inputLength];
        if(theArray.length > 0){
            result[inputLength/2] =
        }
        return result;
    }*/

 /*   public static int binSearch(int[] theArray, int toBeFound){
        int indexOfItem = -1;
    }*/


    public static int[] insertSort(int[] theArray){
        int count = 0;
        int j;
        System.out.println(Arrays.toString(theArray));
        for(int i = 1; i < theArray.length; i++){

            int toBeMoved = theArray[i];

            for (j = i; j > 0 && theArray[j-1] > toBeMoved; j--){
                theArray[j] = theArray[j-1];
                count++;
            }

            theArray[j] = toBeMoved;
            count++;
        }
        System.out.println("iterations: "+count);

        return theArray;
    }

    public static int[] selectSort(int[] sortArray){
//        System.out.println("\n"+Arrays.toString(sortArray));
        int count = 0;
        for(int i = 0; i < sortArray.length; i++){
            System.out.println(Arrays.toString(sortArray));
            int minimum = i;
            for (int j = i +1; j < sortArray.length; j++ ){
                if(sortArray[minimum] > sortArray[j]){
                    minimum = j;
                }
                count ++;
            }
            int temp = sortArray[i];
            sortArray[i] = sortArray[minimum];
            sortArray[minimum] = temp;
        }
        System.out.println("interations: "+ count + " array length: "+sortArray.length);

        int[] returnArray = new int[sortArray.length];

        return returnArray;
//        return sortArray;
    }

    public static int[] freqSort2(int[] inp){
        System.out.println(Arrays.toString(inp));
        //keeps track of position for result
        int resultPos = 0;
        //will hold arrays for bubble sort
        int[] temp = new int[2];
        //sort input array
        Arrays.sort(inp);
        //initialize counter for length of multidimentional array
        int tupleLength = 1;
        //initialize variable to keep track of its position
        int tuplePos = 0;
        //count how many unique values the input array has
        for(int i = 1; i < inp.length; i++){
            if(inp[i] != inp[i-1]){
                tupleLength++;
            }
        }
        //initialize multi array of length equal to unique values in initial array
        int[][] tuple = new int[tupleLength][2];
        //set the first value
        tuple[tuplePos][0] = inp[0];
        tuple[tuplePos][1] = 1;
        //count occurrences of each member of input array and store in multi array
        for(int i = 1; i < inp.length; i++){
            if(inp[i] != tuple[tuplePos][0]){
                tuplePos ++;
                tuple[tuplePos][0] = inp[i];
            }
            tuple[tuplePos][1]++;
        }
        //bubble sort multiArray
        for(int i = tupleLength - 1; i > 0; i--){
            for (int k = 0; k < i; k++) {
                if (tuple[k][1] < tuple[k + 1][1]) {
                    temp = tuple[k];
                    tuple[k] = tuple[k + 1];
                    tuple[k + 1] = temp;
                }
            }
        }
        //reassign the input in the desired order
        for (int i = 0; i < tupleLength; i++){
            for(int j = 0; j < tuple[i][1]; j++){
                inp[resultPos] = tuple[i][0];
                resultPos++;
            }
        }
        return inp;
    }



    public static int[] frequencySort(int[] inp){

        int[][] tuple = new int[inp.length][2];
        boolean exists;
        int j = 0;
        int[] result = new int[inp.length];

        Arrays.sort(inp);


        for(int i = 0; i < inp.length; i++){
            exists = false;
            j = 0;
            while(tuple[j][1] != 0 && j < tuple.length){
                if(inp[i] == tuple[j][0]) {
                    tuple[j][1]++;
                    exists = true;
                    break;
                }
                j++;
            }
            if(!exists){
                tuple[j][0] = inp[i];
                tuple[j][1]++;
            }
        }
        for(int i = 0; i < j; i++){
            for(int k = 0; k < j; k++){
                if(tuple[k+1][1]>tuple[k][1]){
                    int[] temp = tuple[k+1];
                    tuple[k+1] = tuple[k];
                    tuple[k] = temp;
                }
            }
        }

        j = 0;
        int count = 0;

        while (tuple[j][1] != 0){
            for(int i = 0; i < tuple[j][1]; i++){
                result[count] = tuple[j][0];
                count++;
            }
            j++;
        }
        System.out.println(Arrays.toString(inp));
        System.out.println(Arrays.deepToString(tuple));
        System.out.println(Arrays.toString(result));
        System.out.println(j);
        return inp;
    }

        public static int solveSuperMarketQueue(int[] customers, int n) {
            int counter = 0;
            int nextPlaceInQ = 0;
            int[][] kioskHolder = new int[n][2];
            int emptyCount = 0;
            //are there 0 or 1 customers in line?
            if(customers.length == 0){
                return 0;
            } else if (customers.length == 1 ){
                return customers[0];
            }
            //are there more registers than customers?
            if(customers.length <= n){
                n = customers.length;
            }
            //initialize the first set of customers at the kiosks
            for(int i = 0; i < n; i++){
                kioskHolder[i][0] = customers[i];
                kioskHolder[i][1] = 0;
                nextPlaceInQ ++;
            }
            //cycle through the people in line until all kiosks are empty and count how many cycles total have elapsed
            while (emptyCount < n) {
                emptyCount = 0;

                for (int i = 0; i < n; i++) {

                    if (kioskHolder[i][0] == kioskHolder[i][1]) {
                        if(nextPlaceInQ > customers.length -1){
                            kioskHolder[i][0] = -1;
                            emptyCount++;
                        } else {
                            kioskHolder[i][0] = customers[nextPlaceInQ];
                            kioskHolder[i][1] = 1;
                            nextPlaceInQ++;
                        }
                    } else if (kioskHolder[i][0] == -1) {
                        emptyCount++;
                    } else {
                        kioskHolder[i][1]++;
                    }
                }
                if (emptyCount != n) {
                    counter++;
                }
            }

            return counter;
        }

    public static int factorial(int n) {
        int fact = 1;
        if(n < 0 || n > 12){
            throw new ArithmeticException();
        } else{
            while(n>0) {
                fact *= n;
                n--;
            }
        }
        return fact;
    }

}
