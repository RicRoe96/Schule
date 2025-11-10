package verwaltung;

import kfz.GPSPosition;
import kfz.KFZ;
import mitarbeiter.Mitarbeiter;
import mitarbeiter.Schichtarbeiter;

import java.util.ArrayList;
import java.util.List;

public class Unternehmensverwaltung {
    private List<Abteilung> abteilungen = new ArrayList<>();
    private List<KFZ> fuhrpark = new ArrayList<>();

    public GPSPosition getFuhrparkposition() {
        return fuhrparkposition;
    }

    public void setFuhrparkposition(GPSPosition fuhrparkposition) {
        this.fuhrparkposition = fuhrparkposition;
    }

    private GPSPosition fuhrparkposition;

    public List<Mitarbeiter> personalListe(){
        List<Mitarbeiter> liste = new ArrayList<>();
        for(Abteilung a : abteilungen){
            liste.addAll(a.getPersonal());
        }
        return liste;
    }
    public List<Schichtarbeiter> schichtarbeiterListe(){
        List<Schichtarbeiter> liste = new ArrayList<>();
        for(Abteilung a : abteilungen){
            for(Mitarbeiter m : a.getPersonal()){
                if( m instanceof Schichtarbeiter ){
                    liste.add( (Schichtarbeiter) m );
                }
            }
        }
        return liste;
    }
    public void arbeitstag(){
        for(Schichtarbeiter s : schichtarbeiterListe()){
            s.arbeite(8);
        }
    }
    public void abteilungHinzufuegen(Abteilung abteilung){
        if(abteilungen.contains(abteilung)){
            System.out.println("Die Abteilung ist bereits enthalten.");
        } else {
            abteilungen.add(abteilung);
        }
    }
    public void abteilungenHinzufuegen(Abteilung... abteilungen){
        for(Abteilung a : abteilungen){
            abteilungHinzufuegen(a);
        }
    }
    public void abteilungEntfernen(Abteilung abteilung){
        if(!abteilungen.contains(abteilung)){
            System.out.println("Die Abteilung ist nicht enthalten.");
        } else {
            abteilungen.remove(abteilung);
        }
    }
    public void abteilungenEntfernen(Abteilung... abteilungen){
        for(Abteilung a : abteilungen){
            abteilungEntfernen(a);
        }
    }
    public void kfzHinzufuegen(KFZ kfz){
        if(fuhrpark.contains(kfz)){
            System.out.println("Das Fahrzeug ist bereits im Fuhrpark enthalten.");
        } else {
            if(kfz.getGpsPosition()==null){
                kfz.setGpsPosition(fuhrparkposition);
            }
            fuhrpark.add(kfz);
        }
    }
    public void kfzsHinzufuegen(KFZ... kfzListe){
        for(KFZ kfz : kfzListe){
            kfzHinzufuegen(kfz);
        }
    }
    public void kfzEntfernen(KFZ kfz){
        if(!fuhrpark.contains(kfz)){
            System.out.println("Fahrzeug nicht im Fuhrpark enthalten.");
        } else {
            fuhrpark.remove(kfz);
        }
    }
    public void kfzsEntfernen(KFZ... kfzListe){
        for(KFZ kfz : kfzListe){
            kfzEntfernen(kfz);
        }
    }
    public void unternehmensInfo(){
        System.out.println("Unternehmensinfo");
        System.out.println("****************");
        for(Abteilung a : abteilungen){
            a.abteilungsInfo();
            System.out.println();
        }
        System.out.println("Fahrzeuge befinden sich an folgenden Positionen:");
        for(KFZ kfz : fuhrpark){
            System.out.println(kfz.getGpsPosition());
        }
    }
}
