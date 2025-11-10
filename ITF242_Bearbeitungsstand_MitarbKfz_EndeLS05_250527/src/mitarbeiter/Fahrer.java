package mitarbeiter;

public class Fahrer extends Schichtarbeiter{
    private Fuehrerscheinklasse fuehrerscheinklasse;
    public Fahrer(int id, String name, Fuehrerscheinklasse fuehrerscheinklasse){
        super(id, name);
        this.setFuehrerscheinklasse(fuehrerscheinklasse);
    }
    public void setFuehrerscheinklasse(Fuehrerscheinklasse fuehrerscheinklasse){
        this.fuehrerscheinklasse = fuehrerscheinklasse;
    }
    public Fuehrerscheinklasse getFuehrerscheinklasse(){
        return fuehrerscheinklasse;
    }
    @Override
    public String toString(){
        return super.toString() + ", Führerscheinklasse: " +getFuehrerscheinklasse();
    }
}
