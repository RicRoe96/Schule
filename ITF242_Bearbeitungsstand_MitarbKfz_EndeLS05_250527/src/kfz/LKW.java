package kfz;

import mitarbeiter.Fahrer;

import static mitarbeiter.Fuehrerscheinklasse.C;
import static mitarbeiter.Fuehrerscheinklasse.D;

import java.util.*;

//  Wir implementieren Comparable, um LKWs nach Auslastung vergleichen zu können
public class LKW extends KFZ implements Comparable<LKW> {
    private double ladeFlaeche;
    private double ladung;

    public LKW(double tankGroesse, double ladeFlaeche){
        super(tankGroesse);
        setLadeFlaeche(ladeFlaeche);
        setLadung(0);
    }

    public double getLadeFlaeche() {
        return this.ladeFlaeche;
    }

    public void setLadeFlaeche(double ladeFlaeche) {
        this.ladeFlaeche = ladeFlaeche;
    }

    public double getLadung() {
        return this.ladung;
    }

    public void setLadung(double ladung) {
        if(ladung > this.ladeFlaeche){
            this.ladung = this.ladeFlaeche;
            System.out.println("Geht nicht. LadeFlaeche zu klein");
        } else if (ladung < 0){
            System.out.println("Geht nicht. Negative Beladung nicht möglich.");
            this.ladung = 0;
        } else {
            this.ladung = ladung;
        }
    }

    public void beladen(double zuLadung){
        this.setLadung(this.ladung + zuLadung);
    }

    public void entladen(double entLadung){
        this.setLadung(this.ladung - entLadung);
    }

    // Berechnet die prozentuale Auslastung (0.0 - 1.0)
    public double auslastung(){
        return this.ladung / this.ladeFlaeche;
    }

    public void reiseBereitMachen(){
        super.reiseBereitMachen();
        if(this.ladung < 0.95 * this.ladeFlaeche)
            this.ladung = 0.95 * this.ladeFlaeche;
    }

    @Override
    public void setFahrer(Fahrer fahrer){
        super.setFahrer(fahrer, C);
    }

    public double auslastung(int ladung){
        return ladung / ladeFlaeche;
    }

    //  WICHTIG: Vergleich nach Auslastung implementieren
    @Override
    public int compareTo(LKW anderer) {
        // Double.compare() liefert:
        //  <0 wenn this kleiner ist, 0 wenn gleich, >0 wenn this größer ist
        return Double.compare(this.auslastung(), anderer.auslastung());
    }

    @Override
    public String toString() {
        return String.format("LKW [Ladefläche: %.1f m², Ladung: %.1f m², Auslastung: %.2f%%]",
                ladeFlaeche, ladung, auslastung() * 100);
    }

    // 🔽 Testmethode direkt in der Klasse (alternativ in Main)
    public static void main(String[] args) {
        Random rand = new Random();

        List<LKW> flotte = new ArrayList<>();
        flotte.add(new LKW(200, 50));
        flotte.add(new LKW(180, 60));
        flotte.add(new LKW(220, 40));
        flotte.add(new LKW(250, 80));

        // Zufällige Beladung und Entladung mehrmals durchführen
        for (int i = 0; i < 10; i++) {
            for (LKW lkw : flotte) {
                // Zufällige Beladung oder Entladung simulieren
                double menge = rand.nextDouble() * 20 - 10; // -10 bis +10
                if (menge > 0) lkw.beladen(menge);
                else lkw.entladen(-menge);
            }
        }

        System.out.println("Vor dem Sortieren (nach Auslastung):");
        for (LKW l : flotte) {
            System.out.println(l);
        }

        //  Hier sortieren wir die Liste nach Auslastung aufsteigend
        Collections.sort(flotte);

        System.out.println("\nNach dem Sortieren (schlecht ausgelastete zuerst):");
        for (LKW l : flotte) {
            System.out.println(l);
        }
    }
}
