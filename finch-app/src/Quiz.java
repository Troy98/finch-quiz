import java.util.*;

public class Quiz {

    private int totalePunten;
    private int[] muntenKoopOpties;
    private Taal taal;

    private int aantalBeantwoordeVragen = 0;
    private int aantalGoedeAntwoorden = 0;
    private int aantalFouteAntwoorden = 0;
    long startTime = 0;

    public Quiz(Taal taal) {
        this.taal = taal;
        this.totalePunten = 0;
        this.muntenKoopOpties = new int[]{10, 20, 50, 100, 200, 500, 1000};
    }

    private PuntentellingStrategie puntentellingStrategie = new NormalePuntentelling();
    ;
    private ArrayList<Vraag> vragenlijstvoorQuiz = new ArrayList<Vraag>();

//    public VragenlijstVanSpeler kiesVragenLijst() {
//        VragenlijstVanSpeler spelerVragenlijst = speler.vragenlijstenVanSpeler.stream()
//                .filter(v -> v.vragenlijst == vragenlijst)
//                .findFirst().orElse(null);
//        return spelerVragenlijst;
//    }

    public Vraag[] kiesTienRandomVragen(Vragenlijst vragenlijst) {
        Vraag[] vragen = vragenlijst.getVragen();
        Vraag[] tienRandomVragen = new Vraag[10];

        List<Vraag> vragenList = new ArrayList<>(Arrays.asList(vragen));
        Collections.shuffle(vragenList);

        for (int i = 0; i < 10; i++) {
            tienRandomVragen[i] = vragenList.get(i);
        }

        return tienRandomVragen;
    }

    public void speelQuiz(Vragenlijst vragenlijst) {
        Scanner scanner = new Scanner(System.in);
        Vraag[] vragen = vragenlijst.getVragen();
        int aantalVragen = vragen.length;
        int aantalGoedeAntwoorden = 0;
        int aantalFouteAntwoorden = 0;
        long start = System.currentTimeMillis();

        Vraag[] tienRandomVragen = kiesTienRandomVragen(vragenlijst);

        for (int i = 0; i < aantalVragen; i++) {
            Vraag vraag = tienRandomVragen[i];
            System.out.println(vraag.getVraagTekst());

            if (vraag instanceof Meerkeuzevraag) {
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

        if (aantalGoedeAntwoorden == 10) {

        }


        long eind = System.currentTimeMillis();
        long tijd = (eind - start) / 1000;

        puntentellingStrategie = new NormalePuntentelling();

        int punten = puntentellingStrategie.berekenPunten(aantalGoedeAntwoorden, aantalFouteAntwoorden, aantalVragen, tijd);

        totalePunten = punten;

        printQuizResultaat(aantalGoedeAntwoorden, aantalVragen, aantalFouteAntwoorden, tijd, punten);
    }

    public void printQuizResultaat(int aantalGoedeAntwoorden, int aantalVragen, int aantalFouteAntwoorden, long tijd, int punten) {
        System.out.println("Je hebt " + aantalGoedeAntwoorden + " van de " + aantalVragen + " goed");
        System.out.println("Je hebt " + aantalFouteAntwoorden + " van de " + aantalVragen + " fout");
        System.out.println("Je hebt " + tijd + " seconden nodig gehad");
        System.out.println("Je hebt " + punten + " punten verdiend");
    }

    public void verbeterTopScore(VragenlijstVanSpeler vragenlijstVanSpeler) {
        if (vragenlijstVanSpeler.getLifetimeBestScore() < totalePunten) {
            vragenlijstVanSpeler.setLifetimeBestScore(totalePunten);
        }
    }

    public int getTotalePunten() {
        return totalePunten;
    }

    public void setTotalePunten(int totalePunten) {
        this.totalePunten = totalePunten;
    }

    public void setVragenlijst(Vragenlijst vragenlijstVanSpeler) {
        for (int i = 0; i < 10; i++) {
            vragenlijstvoorQuiz.add(vragenlijstVanSpeler.getRandomVraag());
        }
        printVolgendeVraag();
        startTimer();
    }

    private void startTimer() {
        startTime = System.currentTimeMillis();
    }

    private void printVolgendeVraag() {
        if (getAantalBeantwoordeVragen() < 10) {
            System.out.println(vragenlijstvoorQuiz.get(getAantalBeantwoordeVragen()).getVraagTekst());
        }
    }

    private int getAantalBeantwoordeVragen() {
        return aantalBeantwoordeVragen;
    }

    public long getStartTime() {
        return startTime;
    }
    public void beantwoordVraag(String antwoord) {

        if (vragenlijstvoorQuiz.get(aantalBeantwoordeVragen).isCorrect(antwoord)) {
            System.out.println("Goed");
            aantalGoedeAntwoorden++;
        } else {
            System.out.println("Fout");
            aantalFouteAntwoorden++;
        }

        verhoogAantalBeantwoordeVragen();

        if (aantalBeantwoordeVragen == 10) {
            long eind = System.currentTimeMillis();
            long tijd = (eind - getStartTime()) / 1000;

            setTotalePunten(puntentellingStrategie.berekenPunten(aantalGoedeAntwoorden, aantalFouteAntwoorden, aantalBeantwoordeVragen, tijd));
            printQuizResultaat(aantalGoedeAntwoorden, 10, aantalFouteAntwoorden, 0, totalePunten);
        } else {
            printVolgendeVraag();
        }
    }

    private void verhoogAantalBeantwoordeVragen() {
        aantalBeantwoordeVragen++;
    }
}
