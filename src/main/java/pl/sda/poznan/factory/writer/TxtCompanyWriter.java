package pl.sda.poznan.factory.writer;

import pl.sda.poznan.factory.model.Company;
import pl.sda.poznan.factory.model.Employee;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TxtCompanyWriter implements CompanyWriter {

    private final String path;

    public TxtCompanyWriter(String path) {
        this.path = path;
    }

    @Override
    public void write(Company company) {

        //podejscie imperatywne
        List<String> strings = new ArrayList<>();
        for (Employee employee : company.getEmployees()) {
            strings.add(employee.toString());
        }

        //podejscie deklaratywne/funkcyjne - od javy 8
        List<String> collect = company.getEmployees()
                .stream()
                .map(Employee::toString)
                .collect(Collectors.toList());

        try {
            //metoda przyjmuje sciezke to pliku i Iterrable<? extends Charsequence>
            //drugi zapis oznacza ze mozemy podac tutaj liste ale tylko taka ktora
            //przechowuje typ dziedziczacy po CharSequence (np String)
            Files.write(Paths.get(path), strings);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
