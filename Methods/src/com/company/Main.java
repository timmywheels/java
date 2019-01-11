package com.company;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class Main {

    public static void main(String[] args) {

//        calculateScore(true, 1000, 5, 100);
//        calculateScore(true, 10000, 8, 250);
//        printMegaBytesAndKiloBytes(1024);
        areEqualByThreeDecimalPlaces(-3.1756, -3.175);
    }

//    public static int calculateScore(boolean gameOver, int score, int levelCompleted, int bonus){
//
//        if (gameOver) {
//            int finalScore = score + (levelCompleted + bonus);
//            finalScore += 1000;
//            System.out.println("Final Score: " + finalScore);
//            return finalScore;
//        }
//
//        return -1;
//
//    }


    public static void printMegaBytesAndKiloBytes(int kiloBytes){

        if ((int)kiloBytes < 0) {
            System.out.println("Invalid Value");
        } else {

            int megaBytes = kiloBytes / 1024;
            int kiloBytesRemaining = kiloBytes % 1024;

            System.out.println(kiloBytes + " KB = " + megaBytes + " MB and " + kiloBytesRemaining + " KB");
        }
    }

    public static boolean bark(boolean barking, int hourOfDay){

        if (hourOfDay < 0 || hourOfDay > 23){
            return false;
        }

        if (barking && (hourOfDay < 8 || hourOfDay > 22 )) {
            return true;
        }

        return false;
    }


    public static boolean isLeapYear(int year){
        if (year < 1 || year < 10000){
            return false;
        }

        if (year % 4 == 0 && year % 100 != 0){
            return true;
        }
        return false;
    }


    public static boolean areEqualByThreeDecimalPlaces (double one, double two){
//        System.out.println("one: " + one);
//        System.out.println("two: " + two);

        DecimalFormat df = new DecimalFormat("###.###");

        var _one = df.format(one);
        var _two = df.format(two);

//        double oneRounded = (Math.floor(one * 1000)) / 1000;
//        double twoRounded = (Math.floor(two * 1000)) / 1000;

        System.out.println("one: " + _one);
        System.out.println("two: " + _two);
        if (_one == _two){
            return true;
        }
        System.out.println("false");
        return false;
    }


}
