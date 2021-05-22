package com.company;

import javax.naming.LimitExceededException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10_000_000; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }
        // посчет количества людей возраста меньше 18 лет
        long count = persons.stream()
                .filter(value -> value.getAge() <18)
                .count();

        // список фамилий призывников от 18 до 27 годиков
        List<String> spisok = persons.stream()
                .filter(person -> person.getSex() == Sex.MAN)
                .filter(person -> person.getAge() >= 18)
                .filter(person -> person.getAge() < 27)
                .map(Person::getFamily)
                .collect(Collectors.toList());
        System.out.println(spisok);

        // потенциально работоспособное населения
        List<String> workable = persons.stream()
                .filter(person -> person.getEducation() == Education.HIGHER)
                .filter(person -> person.getAge() >= 18)
                .filter(person -> (person.getSex() == Sex.MAN ? (person.getAge() <= 65) : (person.getAge() <= 60)))
                .map(person -> person.getFamily())
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
        System.out.println(workable);
        System.out.println("⬆️ Сортированный список работоспособного населения ⬆️");
        System.out.println();
        System.out.println("Колличество несовершеннолетних - " + count);
    }
}
