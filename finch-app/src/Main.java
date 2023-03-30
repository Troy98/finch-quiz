import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Spel spel = new Spel();
        Speler speler = spel.maakSpelerAan("test", "test");

        System.out.println("Kies een vragenlijst om te spelen: ");
        spel.toonVragenlijstenVanSpeler("test");
        System.out.println("----");
        System.out.println("Typ het onderwerp van de vragenlijst: ");
        String vragenlijstNaam = scanner.nextLine();

        spel.selecteerVragenlijst(vragenlijstNaam, "test");
//        spel.speelQuiz(speler, onderwerp);

        for(int i = 0; i < 10; i++) {
//            spel.speelQuiz(speler, onderwerp);
//            speler.speelQuiz(onderwerp);
//
//            speler.speelQuiz(onderwerp);
            String antwoord = scanner.nextLine();
            speler.beantwoordVraag(antwoord);
        }

        spel.verbeterTopScore(vragenlijstNaam);
        spel.verbeterTopScore2("test");
    }
}
