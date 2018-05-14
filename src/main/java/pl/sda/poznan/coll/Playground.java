package pl.sda.poznan.coll;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Playground {

    public static void main(String[] args) {
        Person student = new Person("Jan", "Kowalski", 20);
        Person kierownik = new Person("Adam", "Nowak", 25);
        Person dyrektor = new Person("Alina", "Adamiak", 30);

        List<Person> people = Arrays.asList(student, kierownik, dyrektor);

        //sortowanie z uzyciem collections.sort
        Collections.sort(people);

    }
}
