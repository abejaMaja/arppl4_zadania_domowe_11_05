package pl.sda.arp4.zad2;

public class Obywatel {
    private Plec plec;
    private String imie;
    private String nazwisko;
    private String pesel;

    public Obywatel(Plec plec, String imie, String nazwisko, String pesel) {
        this.plec = plec;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.pesel = pesel;
    }

    @Override
    public String toString() {
        return "Obywatel{" +
                "plec=" + plec +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", pesel='" + pesel + '\'' +
                '}';
    }

    public void przedstawSie(){
        System.out.println("Cześć, tu " + imie + " " + nazwisko);
    }














}
