import kfz.*;
import mitarbeiter.Bueroarbeiter;
import mitarbeiter.Fahrer;
import mitarbeiter.Manager;
import verwaltung.Abteilung;
import verwaltung.Unternehmensverwaltung;

import static mitarbeiter.Fuehrerscheinklasse.C;
import static mitarbeiter.Fuehrerscheinklasse.D;

public class Main {
    public static void main(String[] args) {
        Fahrer anna = new Fahrer(3000, "Anna", C);
        Fahrer bernd = new Fahrer(3000, "Bernd", D);
        Bus bus1 = new Bus(200, 6);
        bus1.tanken(60);
        bus1.setFahrer(bernd);
        bus1.setIstMotorAn(true);
        LKW volvo = new LKW(200, 50);
        volvo.tanken(47);
        volvo.setFahrer(anna);
        volvo.setIstMotorAn(true);
        LKW man = new LKW(200, 50);
        Bueroarbeiter bueroarbeiter1 = new Bueroarbeiter(5000, "Charles", 26000);
        Bueroarbeiter bueroarbeiter2 = new Bueroarbeiter(5000, "Dirk", 26000);
        Bueroarbeiter bueroarbeiter3 = new Bueroarbeiter(5000, "Ernie", 26000);
        Bueroarbeiter bueroarbeiter4 = new Bueroarbeiter(5000, "Felix", 26000);
        Bueroarbeiter bueroarbeiter5 = new Bueroarbeiter(5000, "Gustav", 26000);
        Manager manager1 = new Manager(5000, "Heinrich", 48000, 21000);
        Manager manager2 = new Manager(5000, "Ingeborg", 48000, 21000);
        Abteilung abteilung1 = new Abteilung("Produktion", manager1);
        abteilung1.einstellen(bueroarbeiter1);
        abteilung1.einstellen(bueroarbeiter2);
        abteilung1.einstellen(bueroarbeiter3);
        abteilung1.einstellen(anna);
        Abteilung abteilung2 = new Abteilung("Vertrieb", manager2);
        abteilung2.einstellen(bueroarbeiter4);
        abteilung2.einstellen(bueroarbeiter5);
        abteilung2.einstellen(bernd);
        Unternehmensverwaltung hbmg_gmbh = new Unternehmensverwaltung();
//        Aachen befindet sich auf dem Breitengrad 50,7753 und dem Längengrad 6,0839
        hbmg_gmbh.setFuhrparkposition( new GPSPosition(6.0839, 50.7753) );
        hbmg_gmbh.abteilungenHinzufuegen(abteilung1, abteilung2);
        hbmg_gmbh.kfzsHinzufuegen(bus1, volvo, man);

        volvo.fahrenNachPosition(new GPSPosition(4.6, 64), 45);
        bus1.fahrenNachPosition(new GPSPosition(12, 46), 45);

        hbmg_gmbh.unternehmensInfo();
    }
}