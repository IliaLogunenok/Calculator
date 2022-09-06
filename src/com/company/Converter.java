package com.company;

import java.util.HashMap;
import java.util.Map;

class Converter {

    public static int romanToArabic(String expression) {
        if (Character.isDigit(expression.charAt(0))) {
            return Integer.parseInt(expression);
        }

        if (expression.charAt(0) == '-') {
            throw new RuntimeException("Ошибка: в римской системе нет отрицательных чисел");
        }

        Map<Character, Integer> numRome = new HashMap<>() {
        };
        numRome.put('I', 1);
        numRome.put('V', 5);
        numRome.put('X', 10);

        int result = 0;

        for (int i = 0; i < expression.length(); i++) {
            Character ch = expression.charAt(i);
            if (!numRome.containsKey(ch)) {
                throw new RuntimeException("Ошибка: используются одновременно разные системы счисления");
            }
            result += numRome.get(expression.charAt(i));
        }

        for (int i = 0; i < expression.length() - 1; i++) {
            Character ch = expression.charAt(i);
            Character nextCh = expression.charAt(i + 1);
            if (numRome.get(ch) < numRome.get(nextCh)) {
                result -= 2;
            }
        }

        if (result > 10) {
            throw new RuntimeException("Ошибка: Введены римские числа превышающие 10");
        }

        if (result <= 0) {
            throw new RuntimeException("Ошибка: в римской системе нет отрицательных чисел");
        }

        return result;
    }

    public static String arabicToRoman(Integer digit) {
        Map<Integer, String> numRome = new HashMap<>() {
        };
        numRome.put(1, "I");
        numRome.put(4, "IV");
        numRome.put(5, "V");
        numRome.put(9, "IX");
        numRome.put(10, "X");
        numRome.put(50, "L");
        numRome.put(100, "C");

        if (digit <= 0) {
            throw new RuntimeException("Ошибка: в римской системе нет отрицательных чисел");
        }

        int number = digit;
        StringBuilder result = new StringBuilder();

        while (number != 0) {
            if (number >= 100) {
                result.append(numRome.get(100));
                number -= 100;
            } else if (number >= 40) {
                result.append(numRome.get(40));
                number -= 40;
            } else if (number >= 10) {
                result.append(numRome.get(10));
                number -= 10;
            } else if (number >= 9) {
                result.append(numRome.get(9));
                number -= 9;
            } else if (number >= 5) {
                result.append(numRome.get(5));
                number -= 5;
            } else if (number >= 4) {
                result.append(numRome.get(4));
                number -= 4;
            } else {
                result.append(numRome.get(1));
                number -= 1;
            }
        }

        return result.toString();
    }
}
