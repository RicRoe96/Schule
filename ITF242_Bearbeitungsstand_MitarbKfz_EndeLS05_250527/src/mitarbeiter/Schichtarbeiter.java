package mitarbeiter;

public class Schichtarbeiter extends Mitarbeiter{
    private double stundenSatz;
    private int anzahlStunden;
    public Schichtarbeiter(int id, String name){
        super(id, name);
        this.setStundenSatz(17.5);
    }

    public Schichtarbeiter(int id, String name, double stundenSatz, int anzahlStunden){
        super(id, name);
        this.setStundenSatz(stundenSatz);
        this.setAnzahlStunden(anzahlStunden);
    }

    public void arbeite(int anzahlStunden){
        if(stundenSatz<0){
            throw new IllegalArgumentException("Der Stundensatz darf nicht negativ sein.");
        }
        this.setAnzahlStunden( this.getAnzahlStunden() + anzahlStunden );
    }
    public void arbeite(){
        this.arbeite(8);
    }

    public void setStundenSatz(double stundenSatz){
        if(stundenSatz<0){
            throw new IllegalArgumentException("Der Stundensatz darf nicht negativ sein.");
        }
        this.stundenSatz = stundenSatz;
    }
    public double getStundenSatz(){
        return stundenSatz;
    }
    public void setAnzahlStunden(int anzahlStunden){
        if(anzahlStunden<0){
            throw new IllegalArgumentException("Die Anzahl Stunden darf nicht negativ sein.");
        }
        this.anzahlStunden = anzahlStunden;
    }
    public int getAnzahlStunden(){
        return anzahlStunden;
    }
    @Override
    public void setId(int id){
        super.setId(id, 3000, 3999);
    }
    @Override
    public double einkommen(){
        return this.anzahlStunden * this.stundenSatz;
    }
    @Override
    public String toString(){
        return super.toString() + ", Stundensatz: "+getStundenSatz()+" €, Anzahl Stunden: " +getAnzahlStunden();
    }
}
