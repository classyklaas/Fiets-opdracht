public class Fiets {


    private String merkNaam;
    private String kleur;
    private String model;
    private static boolean platteBand;

    public Fiets (String merkNaam, String kleur, String model, boolean platteBand) {
        this.merkNaam = merkNaam;
        this.kleur = kleur;
        this.model = model;
        this.platteBand = platteBand;

    }
    public boolean setPlatteBand() {
        platteBand = true;
        return true;
    }
    public static boolean setGeplakteBand(){
        platteBand = false;
        return false;
    }

    public String toString(){
        return "Dus je hebt een " + this.model + " van het merk '" + this.merkNaam + "'. De kleur is " + this.kleur + ".";
    }
}