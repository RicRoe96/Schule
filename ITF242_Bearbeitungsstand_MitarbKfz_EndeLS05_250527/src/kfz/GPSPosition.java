package kfz;

public class GPSPosition {
    public double laengengrad;
    public double breitengrad;


    public GPSPosition(double laengengrad, double breitengrad){
        setLaengengrad(laengengrad);
        setBreitengrad(breitengrad);
    }

    public void setLaengengrad(double laengengrad){
        this.laengengrad = laengengrad % 360;
    }
    public double getLaengengrad(){
        return laengengrad;
    }
    public void setBreitengrad(double breitengrad){
        if(breitengrad > 90 || breitengrad < -90){
            throw new IllegalArgumentException("Der Breitengrad muss zwischen -90° und 90° liegen.");
        }
        this.breitengrad=breitengrad;
    }
    public double getBreitengrad() {
        return breitengrad;
    }

    static double degreesToRadians(double degrees) {
        return degrees * Math.PI / 180;
    }

    static double distanzZwischenKoordinaten(GPSPosition pos1, GPSPosition pos2) {
        double earthRadiusKm = 6371;

        double dLat = degreesToRadians(pos2.getBreitengrad() - pos1.getBreitengrad());
        double dLon = degreesToRadians(pos2.getLaengengrad() - pos1.getLaengengrad());

        double lat1 = degreesToRadians(pos1.getBreitengrad());
        double lat2 = degreesToRadians(pos2.getBreitengrad());

        double a = Math.sin(dLat/2) * Math.sin(dLat/2) +
                Math.sin(dLon/2) * Math.sin(dLon/2) * Math.cos(lat1) * Math.cos(lat2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        return earthRadiusKm * c;
    }
    @Override
    public String toString(){
        return "Laengengrad: " +laengengrad+ "°, Breitengrad: " +breitengrad+ "°";
    }
}
