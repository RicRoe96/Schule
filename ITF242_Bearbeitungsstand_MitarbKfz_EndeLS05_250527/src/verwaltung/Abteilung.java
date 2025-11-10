package verwaltung;

import mitarbeiter.Manager;
import mitarbeiter.Mitarbeiter;
import mitarbeiter.Schichtarbeiter;

import java.util.ArrayList;
import java.util.List;

public class Abteilung {
    private String name;
    private List<Mitarbeiter> personal = new ArrayList<>();
    private Manager abteilungsleiter;

    public Abteilung (String name){
        this.setName(name);
    }
    public Abteilung (String name, Manager abteilungsleiter){
        this(name);
        this.setAbteilungsleiter(abteilungsleiter);
    }

    public void einstellen(Mitarbeiter mitarbeiter){
        if(this.personal.contains(mitarbeiter)){
            System.out.println(mitarbeiter.getName() + " ist arbeitet bereits in dieser Abteilung.");
        } else {
            this.personal.add(mitarbeiter);
        }
    }
    public void entlassen(Mitarbeiter mitarbeiter){
        if(!this.personal.contains(mitarbeiter)){
            System.out.println(mitarbeiter.getName() + " arbeitet nicht in dieser Abteilung.");
        } else {
            this.personal.remove(mitarbeiter);
        }
    }
    public Manager managerAustauschen(Manager manager){
        Manager alterManager = this.getAbteilungsleiter();
        this.setAbteilungsleiter(manager);
        return alterManager;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Mitarbeiter> getPersonal() {
        return personal;
    }

    public void setPersonal(List<Mitarbeiter> personal) {
        this.personal = personal;
    }

    public Manager getAbteilungsleiter() {
        return abteilungsleiter;
    }

    public void setAbteilungsleiter(Manager abteilungsleiter) {
        this.abteilungsleiter = abteilungsleiter;
    }

    public void abteilungsInfo(){
        double gesamtPersonalkosten = 0;
        System.out.println("Abteilungsinfo " +name+":");
        System.out.println("*************************");
        System.out.println("Abteilungsleiter_in: " +abteilungsleiter);
        System.out.println("Personal:");
        for(Mitarbeiter m : personal){
            System.out.println(m);
            gesamtPersonalkosten += m.einkommen();
        }
        System.out.println("Personalkosten insgesamt: " +gesamtPersonalkosten);
    }
}
