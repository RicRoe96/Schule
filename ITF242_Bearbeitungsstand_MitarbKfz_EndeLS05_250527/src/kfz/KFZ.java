package kfz;

import mitarbeiter.Fahrer;
import mitarbeiter.Fuehrerscheinklasse;

public abstract class KFZ {
    private double tankGroesse;
    private double tankInhalt;
    private double speed;
    private Fahrer fahrer;
    private GPSPosition gpsPosition;

    public abstract double auslastung();

    public GPSPosition getGpsPosition() {
        return this.gpsPosition;
    }

    public void setGpsPosition(GPSPosition gpsPosition) {
        this.gpsPosition = gpsPosition;
    }

    public void setGpsPosition(double laengengrad, double breitengrad) {
        this.setGpsPosition(new GPSPosition(laengengrad, breitengrad));
    }

    public Fahrer getFahrer() {
        return fahrer;
    }

    public void setFahrer(Fahrer fahrer) {
        this.fahrer = fahrer;
    }

    public void setFahrer(Fahrer fahrer, Fuehrerscheinklasse fuehrerscheinklasse) {
        if (fahrer.getFuehrerscheinklasse() != fuehrerscheinklasse) {
            throw new IllegalArgumentException("Dieses Fahrzeug dard nur von Fahrern mit Führerscheinklasse " + fuehrerscheinklasse + " gefahren werden.");
        }
        this.fahrer = fahrer;
    }

    public boolean isIstMotorAn() {
        return istMotorAn;
    }

    public void setIstMotorAn(boolean istMotorAn) {
        if (fahrer != null) {
            this.istMotorAn = istMotorAn;
        }
    }

    private boolean istMotorAn;
    //In der Musterl�sung wird nur die Tankgr�sse gesetzt, andere Gr��en sind 0
    //Einen Default-Konstruktor soll es nicht geben

    public KFZ(double tankGroesse) {
        setTankGroesse(tankGroesse);
        setTankInhalt(0);
        setSpeed(0);
    }

    public double getTankGroesse() {
        return tankGroesse;
    }

    public void setTankGroesse(double tankGroesse) {
        this.tankGroesse = tankGroesse;
    }

    public double getTankInhalt() {
        return tankInhalt;
    }

    public void setTankInhalt(double tankInhalt) {
        if (tankInhalt < 0) {
            throw new IllegalArgumentException("Der Tankinhalt darf nicht negativ sein.");
        }
        this.tankInhalt = Math.min(tankInhalt, tankGroesse);
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        if (speed >= 0)
            this.speed = speed;
    }

    public void bremsen(double kmh) {
        if (kmh < 0) {
            throw new IllegalArgumentException("Bremsung darf nicht negativ sein.");
        }
        if (speed - kmh > 0)
            speed -= kmh;
        else
            speed = 0;
    }

    public void beschleunigen(double kmh) {
        if (kmh < 0) {
            throw new IllegalArgumentException("Beschleunigung darf nicht negativ sein.");
        }
        speed += kmh;
    }

    public void tanken(double liter) {
        this.setTankInhalt(this.getTankInhalt() + liter);
    }

    public void reiseBereitMachen() {
        tankInhalt = tankGroesse;
    }

    public void fahrenNachPosition(GPSPosition gpsPosition, double speed) {
        double km = GPSPosition.distanzZwischenKoordinaten(this.gpsPosition, gpsPosition);
        if (this.fahren(speed, km)) {
            this.setGpsPosition(gpsPosition);
            System.out.println("Das Fahrzeug befindet sich jetzt an der Position: " + gpsPosition);
            this.setSpeed(0);
        }
    }

    public boolean fahren(double speed, double km) {
        if (this.fahren(speed)) {
            System.out.println("Das Fahrzeug fährt " + km + " km.");
            this.fahrer.arbeite((int) ((km / speed) + 0.5));
            return true;
        }
        return false;
    }

    public boolean fahren(double speed) {
        if (!istMotorAn) {
            System.out.println("Fahrzeug kann nicht fahren: Der Motor ist nicht an.");
            return false;
        } else if (tankInhalt == 0) {
            System.out.println("Fahrzeug kann nicht fahren: Der Tank ist leer.");
            return false;
        } else if (fahrer == null) {
            System.out.println("Fahrzeug kann nicht fahren: Es gibt keinen Fahrer.");
            return false;
        } else {
            setSpeed(speed);
            System.out.println("Das Fahrzeug fährt mit " + speed + "km/h.");
            this.getFahrer().arbeite();
            return true;
        }
    }
}

