package calculator;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(calc(scanner.nextLine()));
        scanner.close();
    }

    public static String calc(String input) {
        String[] parts = input.split(" ");

        if(parts.length != 3) {
            try {
                throw new Exception();
            } catch (Exception e) {
                System.out.println("throws Exception");
                System.exit(0);
            }
        }
        return calculate(parts);
    }

    public static String calculate(String[] expression) {
        boolean isRoman1 = false;
        boolean isRoman2 = false;
        boolean areRoman = false;
        int result;
        try{
            if (Integer.parseInt(expression[0]) <= 0 || Integer.parseInt(expression[0]) > 10 ||
                    Integer.parseInt(expression[2]) <= 0 || Integer.parseInt(expression[2]) > 10){
                throw new Exception();
            }
        }
        catch (Exception e){
            try{
                for (Roman roman : Roman.values()){
                    if (!isRoman1 && roman.toString().equals(expression[0])){
                        isRoman1 = true;
                        expression[0] = Integer.toString(roman.getNum());
                    }
                    if (!isRoman2 && roman.toString().equals(expression[2])){
                        isRoman2 = true;
                        expression[2] = Integer.toString(roman.getNum());
                    }
                    if (isRoman1 && isRoman2){
                        break;
                    }
                }
                if (isRoman1 != isRoman2) {
                    throw new Exception();
                } else if (isRoman1 && isRoman2) {
                    areRoman = true;
                } else {
                    throw new Exception();
                }
            }
            catch (Exception exp){
                System.out.println("throws Exception");
                System.exit(0);
            }

        }

        switch (expression[1]) {
            case ("+"):
                result = Integer.parseInt(expression[0]) + Integer.parseInt(expression[2]);
                break;
            case ("-"):
                result = Integer.parseInt(expression[0]) - Integer.parseInt(expression[2]);
                break;
            case ("*"):
                result = Integer.parseInt(expression[0]) * Integer.parseInt(expression[2]);
                break;
            case ("/"):
                result = Integer.parseInt(expression[0]) / Integer.parseInt(expression[2]);
                break;
            default:
                try {
                    throw new Exception();
                } catch (Exception e) {
                    System.out.println("throws Exception");
                    System.exit(0);
                    return "";
                }
        }
        if (!areRoman) {
            return Integer.toString(result);
        } else {
            try {
                if (result > 0) {
                    return toRoman(result);
                } else {
                    throw new Exception();
                }
            }
            catch (Exception e){
                System.out.println("throws Exception");
                System.exit(0);
            }
        }
        return null;
    }

    public static String toRoman(int input) {
        String number = "";
        while (input >= 100) {
            number += "C";
            input -= 100;
        }
        while (input >= 90) {
            number += "XC";
            input -= 90;
        }
        while (input >= 50) {
            number += "L";
            input -= 50;
        }
        while (input >= 40) {
            number += "XL";
            input -= 40;
        }
        while (input >= 10) {
            number += "X";
            input -= 10;
        }
        while (input >= 9) {
            number += "IX";
            input -= 9;
        }
        while (input >= 5) {
            number += "V";
            input -= 5;
        }
        while (input >= 4) {
            number += "IV";
            input -= 4;
        }
        while (input >= 1) {
            number += "I";
            input -= 1;
        }
        return number;
    }
}