package pl.sda.poznan.factory;

import pl.sda.poznan.factory.model.Company;
import pl.sda.poznan.factory.model.Employee;
import pl.sda.poznan.factory.writer.CompanyWriter;
import pl.sda.poznan.factory.writer.TxtCompanyWriter;
import pl.sda.poznan.factory.writer.XmlCompanyWriter;

import java.util.Scanner;

public class App {


    //utworzyc klase employee przechowujaca dane o pracownikach
    //imie, nazwisko, email, salary
    //utworzyc klase company
    //zaprezentowac fakt, ze firma ma pracownikow

    public static void main(String[] args) {
        Employee director = new Employee("Jan", "Nowak", "jan.nowak@gmail.com", 10000);
        Employee manager = new Employee("Jan", "Kowalski", "jan.nowak@gmail.com", 8000);

        Company company = new Company();
        company.addEmployee(director);
        company.addEmployee(manager);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj nazwę pliku wraz z rozszerzeniem: ");
        String fileName = scanner.next();
        CompanyWriterFactory companyWriterFactory = new CompanyWriterFactory();
        try {
            CompanyWriter writer = companyWriterFactory.create(fileName);
            writer.write(company);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
