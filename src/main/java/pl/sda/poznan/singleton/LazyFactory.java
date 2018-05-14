package pl.sda.poznan.singleton;

import pl.sda.poznan.factory.Factory;
import pl.sda.poznan.factory.writer.CompanyWriter;

public class LazyFactory implements Factory<String, CompanyWriter> {

    private static LazyFactory instance = null;

    public static LazyFactory getInstance() {
        if (instance == null) {
            instance = new LazyFactory();
        }
        return instance;
    }

    @Override
    public CompanyWriter create(String key) {
        return null;
    }
}
