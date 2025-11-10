package mitarbeiter;

public class Bueroarbeiter extends Mitarbeiter{
    private double festgehalt;

    public Bueroarbeiter(int id, String name, double festgehalt){
        super(id, name);
        this.setFestgehalt(festgehalt);
    }
    public void setFestgehalt(double festgehalt){
        if(festgehalt<0){
            throw new IllegalArgumentException("Das Gehalt darf nicht negativ sein.");
        }
        this.festgehalt=festgehalt;
    }
    public double getFestgehalt(){
        return this.festgehalt;
    }

    @Override
    public double einkommen(){
        return this.getFestgehalt();
    }
    @Override
    protected void setId(int id){
        super.setId(id, 5000, 5999);
    }
}
