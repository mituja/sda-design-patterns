package pl.sda.poznan.iterator;

public class MyCollection implements Iterable<String> {

    int index = 0;
    private String[] elements = new String[10];

    public void addELement(String e) {
        if (index < elements.length) {
            elements[index++] = e;
        }
    }

    @Override
    public Iterator<String> getIterator() {
        return new MyCollectionIterator();
    }

    private class MyCollectionIterator implements Iterator<String> {
        private int iteratorIndex = 0;

        @Override
        public String getNextElement() {
            if (!hasNextElement()) {
                throw new ArrayIndexOutOfBoundsException();
            }

            return elements[iteratorIndex++];
        }

        @Override
        public boolean hasNextElement() {
            //jezeli doszlismy do konca tablicy, to nie ma kolejnego elementu
            if (iteratorIndex >= elements.length) {
                return false;
            }
            //jezeli sa elementy w kolekcji to pobieramy element
            String elem = elements[iteratorIndex];
            //zwracamy wynik operacji czy element jest rozny od nulla
            //jezeli element jest rozny, to mamy kolejny element
            return elem != null;
        }
    }
}
