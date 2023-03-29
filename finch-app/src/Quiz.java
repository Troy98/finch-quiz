import java.util.Scanner;

public class Quiz {

    private int totalePunten;
    private int[] muntenKoopOpties;
    private Taal taal;
    public Quiz(Taal taal) {
        this.taal = taal;
        this.totalePunten = 0;
        this.muntenKoopOpties = new int[]{10, 20, 50, 100, 200, 500, 1000};
    }

    private PuntentellingStrategie puntentellingStrategie;

//    public VragenlijstVanSpeler kiesVragenLijst() {
//        VragenlijstVanSpeler spelerVragenlijst = speler.vragenlijstenVanSpeler.stream()
//                .filter(v -> v.vragenlijst == vragenlijst)
//                .findFirst().orElse(null);
//        return spelerVragenlijst;
//    }

    public void speelQuiz(Vragenlijst vragenlijst) {
        Scanner scanner = new Scanner(System.in);
        Vraag[] vragen = vragenlijst.getVragen();
        int aantalVragen = vragen.length;
        int aantalGoedeAntwoorden = 0;
        int aantalFouteAntwoorden = 0;
        long start = System.currentTimeMillis();

        for (int i = 0; i < aantalVragen; i++) {
            Vraag vraag = vragen[i];
            System.out.println(vraag.getVraagTekst());
            if(vraag instanceof Meerkeuzevraag){
                for (int j = 0; j < ((Meerkeuzevraag) vraag).getKeuzeOpties().length; j++) {
                    System.out.println(((Meerkeuzevraag) vraag).getKeuzeOpties()[j].getOptieTekst());
                }
            }
            String antwoord = scanner.nextLine();

            if (vraag.isCorrect(antwoord)) {
                System.out.println("Goed");
                aantalGoedeAntwoorden++;
            } else {
                System.out.println("Fout");
                aantalFouteAntwoorden++;
            }
        }

        long eind = System.currentTimeMillis();
        long tijd = (eind - start) / 1000;

        puntentellingStrategie =  new NormalePuntentelling();
        int punten = puntentellingStrategie.berekenPunten(aantalGoedeAntwoorden, aantalFouteAntwoorden, aantalVragen, tijd);


        System.out.println("Je hebt " + aantalGoedeAntwoorden + " van de " + aantalVragen + " goed");
        System.out.println("Je hebt " + aantalFouteAntwoorden + " van de " + aantalVragen + " fout");
        System.out.println("Je hebt " + tijd + " seconden nodig gehad");
    }

    public void speel(Speler speler) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welkom");
        System.out.println("Je hebt " + speler.saldo + " punten");
        System.out.println("Kies een vragenlijst om te spelen");

        for (int i = 0; i < speler.vragenlijstenVanSpeler.size(); i++) {
            VragenlijstVanSpeler vragenlijstVanSpeler = speler.vragenlijstenVanSpeler.get(i);
            System.out.println((i + 1) + ". " + vragenlijstVanSpeler.vragenlijst.getOnderwerp());
        }

        System.out.println("Kies een vragenlijst om te spelen");

        int keuze = scanner.nextInt();


        VragenlijstVanSpeler gekozenVragenlijst = speler.vragenlijstenVanSpeler.get(keuze - 1);

        speelQuiz(gekozenVragenlijst.vragenlijst);



    }
}
