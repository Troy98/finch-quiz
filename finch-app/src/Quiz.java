import java.util.ArrayList;

public class Quiz {

    private int totalePunten;
    private int[] muntenKoopOpties;
    private Taal taal;

    private int aantalBeantwoordeVragen = 0;
    private int aantalGoedeAntwoorden = 0;
    private boolean allesGoedBeantwoord = false;
    private PuntentellingStrategie puntentellingStrategie = new NormalePuntentelling();
    private ArrayList<Vraag> vragenVoorQuiz = new ArrayList<Vraag>();
    public VragenlijstVanSpeler vragenlijstVanSpeler;
    public final int aantalVragenInQuiz = 10;

    long startTime = 0;

    public Quiz(Taal taal) {
        this.taal = taal;
        this.totalePunten = 0;
        this.muntenKoopOpties = new int[]{10, 20, 50, 100, 200, 500, 1000};
    }

    public void printQuizResultaat(int aantalGoedeAntwoorden, long tijd, int punten) {
        System.out.println("Je hebt " + aantalGoedeAntwoorden + " goed");
        System.out.println("Je hebt " + tijd + " seconden nodig gehad");
        System.out.println("Je hebt " + punten + " punten verdiend");
    }


    public int getTotalePunten() {
        return totalePunten;
    }

    public void setTotalePunten(int totalePunten) {
        this.totalePunten = totalePunten;
    }

    public void setVragenlijst(VragenlijstVanSpeler vragenlijstVanSpeler) {
        startTimer();

        setTeSpelenVragenlijstVanSpeler(vragenlijstVanSpeler);

        for (int i = 0; i < getAantalVragenInQuiz(); i++) {
            vragenVoorQuiz.add(vragenlijstVanSpeler.getRandomVraag());
        }

        printVolgendeVraag();
    }

    public int getAantalVragenInQuiz() {
        return aantalVragenInQuiz;
    }

    public void setTeSpelenVragenlijstVanSpeler(VragenlijstVanSpeler vragenlijstVanSpeler) {
        this.vragenlijstVanSpeler = vragenlijstVanSpeler;
    }

    private void startTimer() {
        startTime = System.currentTimeMillis();
    }

    private void printVolgendeVraag() {
        if (getAantalBeantwoordeVragen() < getAantalVragenInQuiz()) {
            System.out.println(vragenVoorQuiz.get(getAantalBeantwoordeVragen()).getVraagTekst());
        }
    }

    private int getAantalBeantwoordeVragen() {
        return aantalBeantwoordeVragen;
    }

    private void setAantalBeantwoordeVragen(int aantalBeantwoordeVragen) {
        this.aantalBeantwoordeVragen = aantalBeantwoordeVragen;
    }

    private void setAantalGoedeAntwoorden(int aantalGoedeAntwoorden) {
        this.aantalGoedeAntwoorden = aantalGoedeAntwoorden;
    }

    private void resetQuiz() {
        setAantalBeantwoordeVragen(0);
        setAantalGoedeAntwoorden(0);
        vragenVoorQuiz.clear();
    }

    public long getStartTime() {
        return startTime;
    }

    public void beantwoordVraag(String antwoord) {
        boolean isCorrect = vragenVoorQuiz.get(aantalBeantwoordeVragen).controleerAntwoord(antwoord);

        slaAntwoordOp(antwoord, isCorrect);

        verhoogAantalBeantwoordeVragen();

        if (isCorrect) {
            System.out.println("Goed");
            verhoogAantalVragenGoed();
        } else {
            System.out.println("Fout");
        }

        if (aantalBeantwoordeVragen == getAantalVragenInQuiz()) {
            long eind = System.currentTimeMillis();
            long tijdInSeconde = (eind - getStartTime()) / 1000;

            if (aantalGoedeAntwoorden == getAantalVragenInQuiz()) {
                allesGoedBeantwoord = true;
            }
            int behaaldePunten = puntentellingStrategie.berekenPunten(aantalGoedeAntwoorden, tijdInSeconde);
            setTotalePunten(behaaldePunten);
            printQuizResultaat(aantalGoedeAntwoorden, tijdInSeconde, totalePunten);
            resetQuiz();
        } else {
            printVolgendeVraag();
        }
    }

    private void verhoogAantalVragenGoed() {
        aantalGoedeAntwoorden++;
    }

    private void verhoogAantalBeantwoordeVragen() {
        aantalBeantwoordeVragen++;
    }

    public String getGespeeldeVragenlijstNaam() {
        return this.vragenlijstVanSpeler.getVragenlijstNaam();
    }

    public boolean isAllesGoedBeantwoord() {
        return allesGoedBeantwoord;
    }

    public void slaAntwoordOp(String antwoord, boolean isCorrect) {
        Vraag vraag = getHuidigeVraag();

        var vragenlijst = vragenlijstVanSpeler.getVragenlijst();
        vragenlijst.slaAntwoordOp(antwoord, isCorrect, vraag);
    }

    private Vraag getHuidigeVraag() {
        return vragenVoorQuiz.get(aantalBeantwoordeVragen);
    }
}
