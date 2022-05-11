package pl.sda.arp4.zad1;

import java.util.Scanner;

public class MainOrder {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

// wczytywanie opcji z enum, rodzaj biletu
        Bilet b = null;
        boolean flaga = false;

        while (!flaga) {
            System.out.println("Podaj rodzaj biletu");
            for (Bilet rodzaj : Bilet.values()) {
                System.out.printf(" *%s* \n", rodzaj );
            }
            String rodzajBilet = sc.next();

            try {
                b = Bilet.valueOf(rodzajBilet.toUpperCase());
                flaga = true;

            } catch (IllegalArgumentException iae) {
                System.out.println("Wybrana opcja biletów nie istnieje");
            }

        }

// przypisanie wybranego biletu jako typ String
        String wybranyBilet = b.toString();
        Double cena = null;

// przypisanie ceny w zalezność od wyboru biletu
        switch (wybranyBilet) {
            case "NORMALNY":
                cena = 1.70;
                break;
            case "STUDENCKI":
                cena = 0.90;
                break;
            case "DOBOWY":
                cena = 5.30;
                break;
            case "EMERYT":
                cena = 0.30;
        }

// podsumowanie zamówienia
        System.out.println("Wybrałeś bilet " + wybranyBilet + " w cenie "  + cena);
        Order zamowienie = new Order(b, cena);
        System.out.println("Ile zamawiasz biletów? ");
        int n = sc.nextInt();
        double cenaOstateczna = zamowienie.sumuj(cena, n);
        System.out.print("Ostateczna kwota do zapłaty ");
        System.out.print( String.format("%.2f", cenaOstateczna) );


















    }
}
