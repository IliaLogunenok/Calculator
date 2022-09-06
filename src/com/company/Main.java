package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Калькулятор для выражений через пробел. Допускаются числа от 1 до 10 или от I до X включительно. Операции: + - * /");
        System.out.print("Введите выражение: ");

        Main.calc(null);
    }

    public static String calc(String input) {
        try {
            Scanner scanner = new Scanner(System.in);
            input = scanner.nextLine();
            String[] expression = input.split(" ");

            if (ConstrainCheck.CheckingTheNumberOfInputElements(expression)) {
                throw new RuntimeException("Ошибка: Неверное количество элементов ввода");
            }

            if (ConstrainCheck.inputElementsSameTypeCheck(expression[0], expression[2])) {
                throw new RuntimeException("Ошибка: используются одновременно разные системы счисления");
            }

            boolean inputIsRoman = !Character.isDigit(expression[0].charAt(0));

            int firstDigit = Converter.romanToArabic(expression[0]);
            int secondDigit = Converter.romanToArabic(expression[2]);
            String operator = expression[1];

            Integer calculationResult = Operation.calculate(firstDigit, operator, secondDigit);
            String outputResult;

            if (inputIsRoman) {
                outputResult = Converter.arabicToRoman(calculationResult);
            } else {
                outputResult = calculationResult.toString();
            }
            System.out.println("Ответ = " + outputResult);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return input;
    }
}
