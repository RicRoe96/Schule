package mitarbeiter;

import java.util.ArrayList;
import java.util.List;

public abstract class Mitarbeiter{
    private int id;
    private String name;
    protected static List<Integer> idListe = new ArrayList<>();

    public Mitarbeiter(int id, String name){
        this.setId(id);
        this.setName(name);
    }
    public abstract double einkommen();
    protected void setId(int id, int min, int max){
        if(id<min || id>max){
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
        return "ID: " +getId()+ ", Name: " +getName()+ ", Einkommen: " +einkommen()+ " €";
    }
}
