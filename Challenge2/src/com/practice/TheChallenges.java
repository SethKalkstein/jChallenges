package com.practice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TheChallenges {
    public static void main(String[] args){

/*
//Arithmetic and Adder class

        Adder myAdd = new Adder();
        System.out.println(myAdd.add(69, 1));
*/

/*
// MyCalculator class and AdvancedArithmetic Interface

        MyCalculator cal = new MyCalculator();
        System.out.println( cal.divisor_sum(25) );
 */

/*
//populateList and myFunc methods

        ArrayList theList = new ArrayList();

        Iterator myIt = myFunc(populateList(theList));

        while(myIt.hasNext()){
            Object element = myIt.next();
            System.out.println(element);
        }
 */
    }
    static ArrayList populateList(ArrayList myList){
        myList.add(21);
        myList.add(65);
        myList.add("####");
        myList.add("Hello");
        myList.add("World");
        return myList;
    }
    static Iterator myFunc(ArrayList myList){
        Iterator it=myList.iterator();
/*        while(it.hasNext()){
            Object element = it.next();
            if(element instanceof Integer)
            {
                break;
            }
        }*/
        return it;

    }

}
interface AdvancedArithmetic{
    int divisor_sum(int n);
}

class MyCalculator implements AdvancedArithmetic{
    public int divisor_sum(int n){

        int sum = 0;
        int maxPossibleDivisor = (int) Math.sqrt(n);

        for(int i = 1; i <= maxPossibleDivisor; i++){
            if(n % i == 0){
                //add number once if it is a square root of n or both members of the divisor pair otherwise
                sum += (n / i == i ? i : i + (n/i));
            }
        }

        return sum;
    }
}
class Arithmetic{
    int add(int a, int b){
        return (a+b);
    }
}

class Adder extends Arithmetic{}