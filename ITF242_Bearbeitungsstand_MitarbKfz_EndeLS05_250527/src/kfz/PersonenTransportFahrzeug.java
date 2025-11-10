package kfz;

import mitarbeiter.Mitarbeiter;

import java.util.ArrayList;
import java.util.List;

public class PersonenTransportFahrzeug extends KFZ {

    private List<Mitarbeiter> passagiere = new ArrayList<>();
    private int sitze;

    public PersonenTransportFahrzeug(double tankGroesse, int sitze) {
        super(tankGroesse);	//am Anfang leer
        setSitze(sitze);
    }

    public void passagiereEinsteigen(Mitarbeiter... mitarbeiter){
        for(Mitarbeiter m : mitarbeiter){
            if(passagiere.contains(m)){
                System.out.println("Der Passagier ist bereits zugestiegen");
            } else if (passagiere.size() == sitze){
                System.out.println("Das Fahrzeug ist voll.");
                return;
            } else {
                passagiere.add(m);
            }
        }
    }
    public void passagiereAussteigen(Mitarbeiter... mitarbeiter) {
        for(Mitarbeiter m : mitarbeiter){
            if(!passagiere.contains(m)){
                System.out.println("Der Passagier befindet sich nicht im Fahrzeug");
            } else {
                passagiere.remove(m);
            }
        }
    }

    @Override
    public double auslastung(){
        return (double)passagiere.size()/sitze;
    }

    public List<Mitarbeiter> getPassagiere() {
        return passagiere;
    }

    public void setPassagiere(List<Mitarbeiter> passagiere) {
        this.passagiere = passagiere.subList(0, sitze-1);
    }

    public int getSitze() {
        return sitze;
    }

    public void setSitze(int sitze) {
        if(sitze > 0)
            this.sitze = sitze;
        else
            this.sitze=4; //default
    }
}
