import java.util.ArrayList;

public class Spel {

    //start the quiz

    private ArrayList<Speler> spelers = new ArrayList<Speler>();


    public Speler maakSpelerAan(String gebruikersnaam, String wachtwoord) {
        Speler speler = new Speler(gebruikersnaam, wachtwoord);
        spelers.add(speler);

        speler.voegVragenlijstToe(VragenlijstSeedScript.vragenlijst1);
        speler.voegVragenlijstToe(VragenlijstSeedScript.vragenlijst2);

        return speler;
    }

    public void verwijderSpeler(Speler speler) {
        spelers.remove(speler);
    }

    public void voegVragenlijstToeAanSpeler(Speler speler, Vragenlijst vragenlijst) {
        speler.voegVragenlijstToe(vragenlijst);
    }

    public void toonVragenlijstenVanSpeler(String spelerNaam) {
        for (Speler speler : spelers) {
            if (speler.gebruikersnaam.equals(spelerNaam)) {
                speler.toonVragenlijsten();
            }
        }
    }

    public void verbeterTopScore(String onderwerp) {
        for (Speler speler : spelers) {
            speler.verbeterScore(onderwerp);
        }
    }

    public void speelQuiz(Speler speler, String onderwerp) {
        speler.speelQuiz(onderwerp);
    }

}