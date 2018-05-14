package pl.sda.poznan.iterator;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Playground {

    public static void main(String[] args) {

        List<String> names = Arrays.asList("Piotr", "Jan", "Ala");

        for (int i = 0; i < names.size(); i++) {
            String s = names.get(i);
            System.out.println(s);
        }

        System.out.println("Petla for each .....");
        for (String s : names) {
            System.out.println(s);
        }

        System.out.println("Z uzyciem iteratora .....");
        Iterator<String> iterator = names.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            System.out.println("Podana wartosc to: " + next);
        }

        System.out.println("z uzyciem wlasnego iteratora");
        MyCollection imiona = new MyCollection();
        imiona.addELement("Piotr");
        imiona.addELement("Pawel");
        imiona.addELement("Kuba");

        pl.sda.poznan.iterator.Iterator<String> iteratorImion = imiona.getIterator();
        while (iteratorImion.hasNextElement()) {
            String elem = iteratorImion.getNextElement();
            System.out.println(elem);
        }

    }
}
