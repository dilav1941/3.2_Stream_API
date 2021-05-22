package com.company;


import java.util.function.*;

public class Calculator {

    protected static Supplier<Calculator> instance = Calculator::new;

    public Calculator() {

    }

    BinaryOperator<Integer> plus = (x, y) -> x + y;
    BinaryOperator<Integer> minus = (x, y) -> x - y;
    BinaryOperator<Integer> multiply = (x, y) -> x * y;
    BinaryOperator<Integer> devide = (x, y) -> {
        System.out.println("На ноль делить нельзя!");
        if (y != 0) return x / y;
        else return 0;
    };

    UnaryOperator<Integer> pow = x -> x * x;
    UnaryOperator<Integer> abs = x -> x > 0 ? x : x * -1;

    Predicate<Integer> isPositive = x -> x > 0;

    Consumer<Integer> println = System.out::println;

}

