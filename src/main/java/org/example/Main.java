package org.example;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.time.temporal.ChronoUnit;

public class Main {
    public static void main(String[] args) {
        //Завдання 1:
        //Створіть і викличте наступні лямбда-вирази:
        // Перевірку чи є рік високосним
        // Підрахунок кількості днів між двома датами
        // Підрахунок кількості повних неділь між двома датами
        // Підрахунок дня тижня по отриманій даті. Наприклад, 20 липня 1969 рік - неділя
        CheckLeapYear checkLeapYear = year -> (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
        boolean checkYear = checkLeapYear.check(2014);
        String answerYear = checkYear ? "2014 is leap year." : "2014 is not leap year.";
        System.out.println(answerYear);

        LocalDate startDate = LocalDate.of(2022, 1, 1);
        LocalDate endDate = LocalDate.of(2022, 12, 31);
        GetDifferencesOfDates differencesOfDates = ((startDate1, endDate1) -> ChronoUnit.DAYS.between(startDate1, endDate1));
        long differences = differencesOfDates.count(startDate, endDate);
        System.out.println("Differences between dates: " + differences);

        GetDifferencesOfDates differencesOfDatesWeek = (startDate2, endDate2)->{
            long sundays = 0;
            LocalDate current = startDate2;
            while(!current.isAfter(endDate)){
                if(current.getDayOfWeek() == DayOfWeek.SUNDAY){
                    sundays++;
                }
                current = current.plusDays(1);
            }
            return sundays;
        };
        long fullSundaysBetween = differencesOfDatesWeek.count(startDate, endDate);
        System.out.println("Full Sundays between: " + fullSundaysBetween);

        CalculateDayOfWeek calculateDayOfWeek = LocalDate::getDayOfWeek;
        LocalDate date = LocalDate.of(2007, 11, 5);
        DayOfWeek dayOfWeek = calculateDayOfWeek.calculate(date);
        System.out.println(date + " is a " + dayOfWeek);

        //Завдання 2:
        //Створіть і викличте наступні лямбда-вирази:
        // Сума двох дробів
        // Різниця двох дробів
        // Множення двох дробів
        // Ділення двох дробів
        Fraction fraction1 = new Fraction(1, 2);
        Fraction fraction2 = new Fraction(1, 3);
        ArithmeticOperation addFractions = (frac1, frac2)->{
            int commonDenominator = frac1.getDenominator() * frac2.getDenominator();
            int newNumerator = frac1.getNumerator()*frac2.getDenominator() + frac2.getNumerator() * frac1.getDenominator();
            return new Fraction(newNumerator, commonDenominator);
        };
        var sum = addFractions.perform(fraction1, fraction2);
        System.out.println(fraction1 + " + " + fraction2 + " = " + sum);

        ArithmeticOperation subtractFractions = (frac1, frac2)->{
            int commonDenominator = frac1.getDenominator() * frac2.getDenominator();
            int newNumerator = frac1.getNumerator()*frac2.getDenominator() - frac2.getNumerator() * frac1.getDenominator();
            return new Fraction(newNumerator, commonDenominator);
        };

        var difference = subtractFractions.perform(fraction1, fraction2);
        System.out.println(fraction1 + " - " + fraction2 + " = " + difference);

        ArithmeticOperation multiplyFractions = (frac1, frac2)->{
            int commonDenominator = frac1.getDenominator() * frac2.getDenominator();
            int newNumerator = frac1.getNumerator() * frac2.getNumerator();
            return new Fraction(newNumerator, commonDenominator);
        };

        var multiply = multiplyFractions.perform(fraction1, fraction2);
        System.out.println(fraction1 + " * " + fraction2 + " = " + multiply);

        ArithmeticOperation divideFractions = (frac1, frac2)->{
            int commonDenominator = frac1.getDenominator() * frac2.getNumerator();
            int newNumerator = frac1.getNumerator() * frac2.getDenominator();
            return new Fraction(newNumerator, commonDenominator);
        };

        var divide = divideFractions.perform(fraction1, fraction2);
        System.out.println(fraction1 + " / " + fraction2 + " = " + divide);

        //Завдання 3:
        //Створіть і викличте наступні лямбда-вирази. Обов’язково використайте шаблони:
        // Максимум із чотирьох
        // Мінімум із чотирьох
        FindMaximumMinimumOfFour findMaximumOfFour = (a,b,c,d)->{
            Float max = (Float) a;
            if(b.compareTo(max) > 0){
                max = (Float) b;
            }

            if(c.compareTo(max) > 0){
                max = (Float) c;
            }

            if(d.compareTo(max) > 0){
                max = (Float) d;
            }
            return max;
        };
        var max = (Float) findMaximumOfFour.find(1.5F, 2.9F, -1.0F, 1.2F);
        System.out.println("Max of four: " + max);

        FindMaximumMinimumOfFour findMinimumOfFour = (a,b,c,d)->{
            Float min = (Float) a;
            if(b.compareTo(min) < 0){
                min = (Float) b;
            }

            if(c.compareTo(min) < 0){
                min = (Float) c;
            }

            if(d.compareTo(min) < 0){
                min = (Float) d;
            }
            return min;
        };
        var min = (Float) findMinimumOfFour.find(1.5F, 2.9F, -1.0F, 1.2F);
        System.out.println("Min of four: " + min);

        //Завдання 4:
        //Створіть і викличте наступні лямбда-вирази. Обов’язково використайте лямбду, як параметр методу.
        //Метод знаходить суму елементів масиву, що відповідає умові лямбда-виразу. Варіанти лямбда-виразів:
        // Перевірка на рівність конкретному числу
        // Число не знаходиться в діапазоні від A до В
        // Перевірка на додатне число
        // Перевірка на від’ємне числo
        int[] numbers = {1, -2, 3, -4, 5, 6, 7, -8, 9, -10};
        int val = 5;
        Condition isEqualTo = (number, value) -> number == value;
        int sumArr = sumMatchingCondition(numbers, val, isEqualTo);
        System.out.println("Sum array with check by val " + val + " : " + sumArr);

        ConditionLetter conditionLetter = (number, a, b) -> number < a || number > b;
        int sumArrLetter = sumMatchingConditionLetters(numbers, conditionLetter);
        System.out.println("Sum array is not between 'A' and 'B' : " + sumArrLetter);

        ConditionNum conditionNumPos = number -> number > 0;
        int sumPositiveNumPos = sumMatchingConditionNum(numbers, conditionNumPos);
        System.out.println("Sum array of positive numbers : " + sumPositiveNumPos);

        ConditionNum conditionNumNeg = number -> number < 0;
        int sumPositiveNumNeg = sumMatchingConditionNum(numbers, conditionNumNeg);
        System.out.println("Sum array of negative numbers : " + sumPositiveNumNeg);
    }

    @FunctionalInterface
    interface CheckLeapYear{
        boolean check(int year);
    }

    @FunctionalInterface
    interface GetDifferencesOfDates{
        long count(LocalDate startDate, LocalDate endDate);
    }

    @FunctionalInterface
    interface CalculateDayOfWeek{
        DayOfWeek calculate(LocalDate date);
    }

    @FunctionalInterface
    interface ArithmeticOperation{
        Fraction perform(Fraction fraction1, Fraction fraction2);
    }

    @FunctionalInterface
    interface FindMaximumMinimumOfFour<T extends Comparable<T>>{
        T find(T a, T b, T c, T d);
    }

    private static int sumMatchingCondition(int[] arr, int value, Condition condition){
        int sum = 0;
        for (var num : arr) {
            if(condition.test(num, value)){
                sum += num;
            }
        }
        return sum;
    }

    private static int sumMatchingConditionLetters(int[] arr, ConditionLetter conditionLetter){
        int sum = 0;
        for (var num : arr) {
            if(conditionLetter.test(num, 'A', 'B')){
                sum += num;
            }
        }
        return sum;
    }

    private static int sumMatchingConditionNum(int[] arr, ConditionNum conditionNum){
        int sum = 0;
        for (var num : arr) {
            if(conditionNum.test(num)){
                sum += num;
            }
        }
        return sum;
    }

    @FunctionalInterface
    interface Condition{
        boolean test(int a, int b);

    }

    @FunctionalInterface
    interface ConditionLetter{
        boolean test(int number, char A, char B);
    }

    @FunctionalInterface
    interface ConditionNum{
        boolean test(int number);
    }
}