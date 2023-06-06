import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Spel spel = new Spel();
        Speler speler = spel.registreer("test", "test");

        System.out.println("Kies een vragenlijst om te spelen:");
        spel.toonVragenlijstenVanSpeler("test");
        System.out.println("----");

        System.out.println("Typ het onderwerp van de vragenlijst: ");
        String vragenlijstNaam = scanner.nextLine();

        spel.startQuiz("test");
        spel.selecteerVragenlijst(vragenlijstNaam, "test");

        for (int i = 0; i < 10; i++) {
            String antwoord = scanner.nextLine();
            speler.beantwoordVraag(antwoord);
        }

        spel.verbeterTopScore("test");


        System.out.println("Kies een vragenlijst om te spelen:");
        spel.toonVragenlijstenVanSpeler("test");
        System.out.println("----");

        System.out.println("Typ het onderwerp van de vragenlijst: ");
        String vragenlijstNaam2 = scanner.nextLine();

        spel.selecteerVragenlijst(vragenlijstNaam2, "test");

        for (int i = 0; i < 10; i++) {
            String antwoord = scanner.nextLine();
            speler.beantwoordVraag(antwoord);
        }

        spel.verbeterTopScore("test");
    }
}
