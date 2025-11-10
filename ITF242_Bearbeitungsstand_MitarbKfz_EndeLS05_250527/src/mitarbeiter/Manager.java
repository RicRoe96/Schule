package mitarbeiter;

public class Manager extends Bueroarbeiter{
    private double bonus;

    public Manager(int id, String name, double festgehalt, double bonus){
        super(id,name,festgehalt);
        this.setBonus(bonus);
    }
    public void setBonus(double bonus){
        if(bonus<0){
            throw new IllegalArgumentException("Der Bonus darf (leider) nicht negativ sein.");
        }
        this.bonus=bonus;
    }
    public double getBonus(){
        return this.bonus;
    }
    @Override
    public double einkommen(){
        return super.einkommen() + getBonus();
    }
    @Override
    public String toString(){
        return super.toString() + " (Festgehalt: "+getFestgehalt()+"€, Bonus: "+getBonus()+" €)";
    }
}
