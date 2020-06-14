import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Hoi! Klaar om vandaag te gaan fietsen? ja/nee");

        for (int index = 0; ; index++) {
            String antwoord = scanner.nextLine();
            if (antwoord.equals("ja") || antwoord.equals("JA") || antwoord.equals("Ja")) {
                System.out.println("Leuk! Laten we elkaar wat beter leren kennen. Ik heet Fietscomputer. Hoe heet jij?");
                break;
            } else if (antwoord.equals("nee") || antwoord.equals("NEE") || antwoord.equals("Nee")) {
                System.out.println("No worries, volgende keer beter :)");
                System.exit(1);
            } else {
                System.out.println("Ik heb helaas geen correcte invoer (ja of nee) van je ontvangen.");
            }
        }

        String naam = scanner.nextLine();
        System.out.println("Hoi, " + naam + "! Ik heb een aantal korte vragen voor je.");
        System.out.println("Van welk merk is je fiets?");
        String merkNaam = scanner.nextLine();
        System.out.println("Welke kleur heeft je fiets?");
        String kleur = scanner.nextLine();
        System.out.println("Wat voor soort fiets heb je? Een racefiets, bijvoorbeeld?");
        String model = scanner.nextLine();

        Fiets fiets = new Fiets(merkNaam, kleur, model, false);
        System.out.println(fiets);

        Fietser fietser = new Fietser(naam, 100, 25);
        System.out.println(fietser);

        while (true) {
            // eerst even kijken of we een lekke band hebben. Wil nog wel eens gebeuren na een winter niet fietsen

            Random dobbelsteen = new Random();
            int nummer = 1 + dobbelsteen.nextInt(6);

            if (nummer == 1) {
                fiets.setPlatteBand();
                System.out.println("Je hebt een lekke band. Zelf repareren of niet? ja/nee");
                String antwoord = scanner.nextLine();
                if (antwoord.equals("ja")) {
                    fietser.zelfRepareren();
                } else {
                    fietser.latenRepareren();
                }
            }
            // er moet een aantoonbare reden zijn om te stoppen met fietsen. Ik gebruik hiervoor geldgebrek en de conditie
            if (fietser.getConditie() <= 0) {
                System.out.println("Je conditie is momenteel te slecht om verder te fietsen. Maar niet getreurd: morgen weer een dag!");
                break;
            }
            if (fietser.getPortemonnee() <= 0) {
                System.out.println("Je hebt momenteel niet genoeg geld in je portemonnee om verder te fietsen. Maar niet getreurd: morgen weer een dag!");
                break;
            }
            // Indien de fietser een conditie van lager dan 40 heeft, kopen we een Mars.
            if (fietser.getConditie() < 40) {
                fietser.MarsEten();
                fietser.MarsEten();
            } else {
                System.out.println("Hoe lang wordt de komende route?");
                int afstand = Integer.valueOf(scanner.nextLine());
                fietser.lekkerFietsen(afstand);
            }
        }
    }
}
