package com.company;

class ConstrainCheck {
    public static boolean CheckNumbersInRange(int firstDigit, int secondDigit) {
        return (firstDigit < 1 || firstDigit > 10) || (secondDigit < 1 || secondDigit > 10);
    }

    public static boolean CheckingTheNumberOfInputElements(String[] inputExpression) {
        return inputExpression.length != 3;
    }

    public static boolean inputElementsSameTypeCheck(String firstDigit, String seconfGigit) {
        return !(Character.isDigit(firstDigit.charAt(0)) && Character.isDigit(seconfGigit.charAt(0)) ||
                (!Character.isDigit(firstDigit.charAt(0)) && !Character.isDigit(seconfGigit.charAt(0))));
    }
}
