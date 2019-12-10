package com.practice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
/*
//for abstract class Book and MyBook

        MyBook new_novel = new MyBook();
        new_novel.setTitle( "A Tail of Two Kitties");
        System.out.println("The title is: "+new_novel.getTitle());
 */
        String myString = "1123.345.5.66";
        System.out.println(myRegex(myString));
        for(int i = 1; i <= 35; i++){
            System.out.println("i: "+i);
            weirdo(i);
        }
    }

    static void weirdo(int n){
        if((n >= 6 && n <= 20) || (n % 2 == 1)){
            System.out.println("Weird");
        } else {
            System.out.println("Not Weird");
        }
    }

    static boolean myRegex(String toBeCompared){
        Pattern checkRegex = Pattern.compile("[0-9]{1,3}.[0-9]{1,3}.[0-9]{1,3}.[0-9]{1,3}");
        Matcher regMatcher = checkRegex.matcher(toBeCompared);
        return regMatcher.matches();
    }

    static abstract class Book{
        String title;
        abstract void setTitle(String s);
        String getTitle(){
            return title;
        }

    }

    static class MyBook extends Book{
        void setTitle(String s){
            this.title = s;
        }
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