package com.company;

public class Main {
    public static void main(String[] args) {
        //try { - ловим ошибку
        Calculator calc = Calculator.instance.get();

        int a = calc.plus.apply(1, 2);
        int b = calc.minus.apply(1, 1);
        int c = calc.devide.apply(a, b);
        int e = calc.multiply.apply(2, 3);

        calc.println.accept(c);

        // } catch (ArithmeticException ae) {
        //    System.out.println("На ноль делить нельзя!");
        // } - ловим ошибку

        // double d = calc.devideDouble.apply(a, b); - изменяем тип переменной с integer на double
        // calc.printlnDouble.accept(d);
    }
}

// Приведенный в задании код отработает с ошибкой - ArithmeticException,
// так как деление целого числа (int) на 0(int) - запрещено. BinaryOperator<Integer> devide = (x, y) ->  x / y;
// Способы решения проблемы:
// 1) поймать ошибку и выдать исключение через try catch
// 2) изменить тип переменных с Integer на Double
// 3) использовать блочное лямбда-выражение, внутри которого оператор if (см. описание класса Calculator)
// 4) можно изменить одно из значений - calc.minus.apply(1, 1); , чтобы избежать появления нуля ))

