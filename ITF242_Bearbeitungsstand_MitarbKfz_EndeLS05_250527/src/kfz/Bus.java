package kfz;

import mitarbeiter.Fahrer;

import static mitarbeiter.Fuehrerscheinklasse.D;

public class Bus extends PersonenTransportFahrzeug{

    public Bus(double tankGroesse, int sitze){
        super(tankGroesse, sitze);
    }

    @Override
    public void setFahrer(Fahrer fahrer){
        super.setFahrer(fahrer, D);
    }
}
