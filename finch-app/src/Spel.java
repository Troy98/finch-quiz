import java.util.ArrayList;

public class Spel {

    //start the quiz

    private ArrayList<Speler> spelers = new ArrayList<Speler>();

    public void maakSpelerAan(String gebruikersnaam, String wachtwoord) {
        Speler speler = new Speler(gebruikersnaam, wachtwoord);
        spelers.add(speler);
    }

    public void verwijderSpeler(Speler speler) {
        spelers.remove(speler);
    }

    public void voegVragenlijstToeAanSpeler(Speler speler, Vragenlijst vragenlijst) {
        speler.voegVragenlijstToe(vragenlijst);
    }


}