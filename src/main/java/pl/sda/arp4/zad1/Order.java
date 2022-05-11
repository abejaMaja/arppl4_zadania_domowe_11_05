package pl.sda.arp4.zad1;

public class Order {
    private Bilet bilet;
    private double cena;

    public Order(Bilet bilet, double cena) {
        this.bilet = bilet;
        this.cena = cena;
    }

    public double sumuj(double cena, int ilosc){
        return cena * ilosc;
    }
}
