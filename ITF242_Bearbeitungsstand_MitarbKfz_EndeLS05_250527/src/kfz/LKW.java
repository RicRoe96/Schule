package kfz;

import mitarbeiter.Fahrer;

import static mitarbeiter.Fuehrerscheinklasse.C;
import static mitarbeiter.Fuehrerscheinklasse.D;

public class LKW extends KFZ{
    private double ladeFlaeche;
    private double ladung;

    public LKW(double tankGroesse, double ladeFlaeche){
        super(tankGroesse);
        setLadeFlaeche( ladeFlaeche);
        setLadung(0);
    }
    public double getLadeFlaeche() {
        return this.ladeFlaeche;
    }

    public void setLadeFlaeche(double ladeFlaeche) {
        this.ladeFlaeche = ladeFlaeche;
    }

    public double getLadung() {
        return this.ladung;
    }

    public void setLadung(double ladung) {
        if(ladung  > this.ladeFlaeche){
            this.ladung = this.ladeFlaeche;
            System.out.println("Geht nicht. LadeFlaeche zu klein");
        }
        else
        if (ladung < 0){
            System.out.println("Geht nicht. Negative Beladung nicht m�glich.");
            this.ladung = 0;
        }
        else {
            this.ladung = ladung;
        }
    }

    public void beladen(double zuLadung){
        this.setLadung( this.ladung + zuLadung);
    }

    public void entladen(double entLadung){
        this.setLadung(this.ladung - entLadung);
    }

    public double auslastung(){
        return this.ladung / this.ladeFlaeche;
    }

    public void reiseBereitMachen(){
        super.reiseBereitMachen();
        if(this.ladung < 0.95*this.ladeFlaeche)
            this.ladung =0.95*this.ladeFlaeche;
    }
    @Override
    public void setFahrer(Fahrer fahrer){
        super.setFahrer(fahrer, C);
    }
    public double auslastung( int ladung ){
        return ladung/ladeFlaeche;
    }
}