public class Fietser {

    private String naam;
    private int conditie;
    private double portemonnee;

    public Fietser(String naam, int conditie, double portemonnee) {
        this.naam = naam;
        this.conditie = conditie;
        this.portemonnee = portemonnee;
    }

    public double getPortemonnee() {
        return this.portemonnee;
    }

    public double getConditie(){
        return this.conditie;
    }

    void lekkerFietsen(int afstand) {
        if (conditie <= 0) {
            System.out.println("Je conditie is te laag om verder te fietsen, laten we naar huis gaan.");
            System.exit(0);
        } else {
            conditie = conditie - afstand;
            System.out.println("Je hebt " + afstand + " kilometer gefietst en hebt daarom nu nog een conditie van " + conditie + ".");
        }
    }

    void MarsEten() {
        if (conditie <= 80.0) {
            this.conditie = conditie + 20;
            this.portemonnee = portemonnee - 1.20;
            System.out.println("Je moest even een Mars a EUR 1,20 eten om wat conditie-punten (20) te krijgen. Je conditie is momenteel " + conditie + " en je portemonnee bevat momenteel " + portemonnee + " euro.");
        } else {
            System.out.println("Laat de Mars nog maar even liggen, je conditie is momenteel " + this.conditie + " en je conditie mag na het eten van een Mars niet hoger zijn dan 100.0. Een Mars levert 20 conditie-punten op.");
        }
    }

    void zelfRepareren(){
        this.conditie = conditie - 20;
        System.out.println("Het plakken van je band heeft je 20 conditie-punten gekost. Je conditie is nu " + getConditie());
        Fiets.setGeplakteBand();
    }

    void latenRepareren(){
        this.portemonnee = portemonnee - 10.0;
        System.out.println("Het laten plakken van je band kost EUR 10,-. Je hebt daarom nog " + this.portemonnee + " euro in je portemonnee.");
        Fiets.setGeplakteBand();
    }

    public String toString() {
        return "Je conditie is momenteel " + this.conditie + " en je portemonnee bevat " + this.portemonnee + " euro.";
    }
}