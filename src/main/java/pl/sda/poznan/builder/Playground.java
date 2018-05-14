package pl.sda.poznan.builder;

import java.time.LocalDate;

import pl.sda.poznan.builder.Reservation.ReservationBuilder;

public class Playground {

    public static void main(String[] args) {
        ReservationBuilder rb = Reservation.builder()
                .city("Poznań")
                .headcount(100)
                .price(99d);

        //odczyt z pliku
        rb.date(LocalDate.parse("2018-03-03"));
        //zakocz proces budowania - zwroc gotowy obiekt
        Reservation build = rb.build();
        System.out.println(build);

        //inny scenariusz - znane sa wszystkie wartosci od razu
        Reservation wroclaw = Reservation.builder()
                .date(LocalDate.parse("2018-03-03"))
                .headcount(200)
                .price(52)
                .city("Wroclaw")
                .build();
    }
}
