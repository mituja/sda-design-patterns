package pl.sda.poznan.iterator;

import java.lang.Iterable;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class MyIterableCollection implements Iterable {

    private int inddex = 0;
    private String[] elements = new String[10];

    @Override
    public Iterator iterator() {
        return new Iterator() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public Object next() {
                return null;
            }
        };
    }
}
