package com.practice;

public class TheChallenges {
    public static void main(String[] args){
        Adder myAdd = new Adder();

        System.out.println(myAdd.add(69, 1));
    }

}

class Arithmetic{
    int add(int a, int b){
        return (a+b);
    }
}

class Adder extends Arithmetic{}