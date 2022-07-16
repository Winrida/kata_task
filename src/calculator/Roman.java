package calculator;

public enum Roman {
    I(1), II(2), III(3), IV(4), V(5), VI(6), VII(7), VIII(8), IX(9), X(10);

    private int num;

    Roman(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public static String toRoman(int input) {
        String number = "";
        if (input >= 100) {
            number += "C";
            input -= 100;
        }
        if (input >= 90) {
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
