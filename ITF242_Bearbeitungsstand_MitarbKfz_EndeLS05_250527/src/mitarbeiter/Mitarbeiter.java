package mitarbeiter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public abstract class Mitarbeiter implements Comparable<Mitarbeiter> {
    private int id;
    private String name;
    protected static List<Integer> idListe = new ArrayList<>();

    public Mitarbeiter(int id, String name){
        this.setId(id);
        this.setName(name);
    }

    // Abstrakte Methode – jede Unterklasse (z. B. Angestellter, Manager) muss diese definieren
    public abstract double einkommen();

    // Prüft ID-Bereich und stellt sicher, dass jede ID eindeutig ist
    protected void setId(int id, int min, int max){
        if(id < min || id > max){
            throw new IllegalArgumentException("Ungültige ID");
        }
        Integer newId = id;
        while(idListe.contains(newId)){
            newId++;
        }
        this.id = newId;
        idListe.add(newId);
    }

    protected void setId(int id){
        this.setId(id, 1000, 1999);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name.isBlank()){
            throw new IllegalArgumentException("Name darf nicht leer sein.");
        }
        this.name = name;
    }

    @Override
    public String toString(){
        return "ID: " + getId() + ", Name: " + getName() + ", Einkommen: " + einkommen() + " €";
    }

    //  Vergleich nach Name (natürliche Sortierung)
    @Override
    public int compareTo(Mitarbeiter anderer) {
        // alphabetische Sortierung nach Namen
        return this.name.compareToIgnoreCase(anderer.name);
    }

    //  Statische innere Klasse für Vergleich nach Einkommen
    //    (eine "Hilfsklasse" speziell für Mitarbeiter)
    public static class MitarbeiterComparator implements Comparator<Mitarbeiter> {

        @Override
        public int compare(Mitarbeiter m1, Mitarbeiter m2) {
            // Vergleich der Einkommen in aufsteigender Reihenfolge
            // (wer weniger verdient, steht zuerst)
            return Double.compare(m1.einkommen(), m2.einkommen());
        }
    }
}

