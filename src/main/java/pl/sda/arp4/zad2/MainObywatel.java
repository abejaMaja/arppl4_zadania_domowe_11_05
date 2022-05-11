package pl.sda.arp4.zad2;

import java.util.Scanner;

public class MainObywatel {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

// zapytanie o płeć, opcje z enuma
        Plec plec = null;

        while (plec == null) {
            System.out.println("Podaj rodzaj płci: ");

            for (Plec rodzaj : Plec.values()) {
                System.out.printf(" *%s* ", rodzaj );
            }
            String rodzajPlec = sc.next();


            try {
                plec = Plec.valueOf(rodzajPlec.toUpperCase());


            } catch (IllegalArgumentException iae) {
                System.out.println("Wybrana płeć nie istnieje");
            }

        }

// zapytnie o imie
        System.out.println("Podaj swoje imie");
        String imie = sc.next();

// zapytanie o nazwisko
        System.out.println("Podaj swoje nazwisko");
        String nazwisko = sc.next();

// zapytanie o pesel
        String pesel = null;
        boolean flaga = false;

        while (!flaga) {
            System.out.println("Podaj swoj pesel");
            pesel = sc.next();
// walidacja peselu

            boolean a = isPeselValid(pesel);
            if (a) {
                flaga = true;
            }
        }

// stworzenie obiektu Obywatel
        Obywatel obywatel = new Obywatel(plec, imie, nazwisko ,pesel);

// wypisanie pól/cech obywatela
        System.out.println(obywatel);

// przywitanie się obywatela
        obywatel.przedstawSie();

    }

    public static int[] sumaKontrolnaPesel(String[] tablica){
// funkcja tworząca sumę kontrolą na potrzeby walidacji peselu

        int[] peselTab = new int [tablica.length];
        int[] kontrol = new int []{1, 3, 7, 9, 1, 3, 7, 9, 1, 3};
        int suma = 0;
        int[] result = new int[2];
// zamieniam tablice stringow na inty
        for(int i = 0; i< tablica.length; i++){
            peselTab[i] = Integer.valueOf(tablica[i]);
        }
// tworze sume kontrolna
        for(int i =0; i<kontrol.length; i++){
            suma += peselTab[i] * kontrol[i];
        }
        result[0] = 10 - suma%10;
        result[1] = peselTab[peselTab.length-1];
        return result;
    }

    public static boolean isPeselValid(String pesel) {
// funkcja sprawdzająca poprawność peselu
// nie uwzględniono poprawnosci ze wzgledu na rodzaj płci

// tworze tablice ze znakow stringa
        String[] tablica = pesel.split("");
        if (tablica.length != 11) {
            System.out.println("Pesel niepoprawny");
            return false;
        } else {
            int[] sumaKontrolna = sumaKontrolnaPesel(tablica);

            int lastK = sumaKontrolna[0];
            int lastP = sumaKontrolna[1];

            if (lastK != lastP) {
                return false;
            } else {
                System.out.println("Pesel poprawny");
                return true;
            }

        }
    }


}
