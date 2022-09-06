package com.company;

class Operation {
    public static int calculate(int firstDigit, String operator, int secondDigit) {

        if(ConstrainCheck.CheckNumbersInRange(firstDigit, secondDigit)){
            throw new RuntimeException("Ошибка: Введены числа больше требуемого диапазона");
        }
        int result;

        if (operator.equals("+")) {
            result = firstDigit + secondDigit;
        } else if (operator.equals("-")) {
            result = firstDigit - secondDigit;
        } else if (operator.equals("*")) {
            result = firstDigit * secondDigit;
        } else if (operator.equals("/")) {
            result = firstDigit / secondDigit;
        } else {
            throw new RuntimeException("Ошибка : Оператор не корректен, должен быть: + - * /");
        }
        return result;
    }
}
