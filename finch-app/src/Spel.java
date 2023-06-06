import java.util.ArrayList;

public class Spel {
    private ArrayList<Speler> spelers = new ArrayList<Speler>();
    private ArrayList<Vragenlijst> vragenlijsten = new ArrayList<Vragenlijst>();
    public Spel() {
        Thema algemeneKennis = new Thema("Algemene kennis");
        Thema geschiedenis = new Thema("Geschiedenis");
        Thema wetenschap = new Thema("Wetenschap");

        vragenlijsten.add(new Vragenlijst("De Brein Kraker", algemeneKennis, VragenlijstSeedScript.maakWillekeurigeVragen(10)));
        vragenlijsten.add(new Vragenlijst("Hersenspoeler", geschiedenis, VragenlijstSeedScript.maakWillekeurigeVragen(10)));
        vragenlijsten.add(new Vragenlijst("Anti Jelmer Wetenschap", wetenschap, VragenlijstSeedScript.maakWillekeurigeVragen(10)));
    }

    public Speler registreer(String gebruikersnaam, String wachtwoord) {
        Speler speler = new Speler(gebruikersnaam, wachtwoord);
        spelers.add(speler);

        for (int i = 0; i < 2; i++) {
            speler.addVragenlijstVanSpeler(getRandomVragenlijst());
        }

        return speler;
    }

    public void startQuiz(String gebruikersnaam) {
        Speler speler = getSpeler(gebruikersnaam);
        speler.nieuweQuiz();
    }

    public Vragenlijst getRandomVragenlijst() {
        int randomIndex = (int) (Math.random() * vragenlijsten.size());
        return vragenlijsten.get(randomIndex);
    }


    public Speler getSpeler(String gebruikersnaam) {
        for (Speler speler : spelers) {
            if (speler.gebruikersnaam.equals(gebruikersnaam)) {
                return speler;
            }
        }
        return null;
    }

    public void voegVragenlijstToeAanSpeler(String naamSpeler, Vragenlijst vragenlijst) {
        Speler gevondenSpeler = getSpeler(naamSpeler);
        gevondenSpeler.addVragenlijstVanSpeler(vragenlijst);
    }

    public void toonVragenlijstenVanSpeler(String spelerNaam) {
        Speler speler = getSpeler(spelerNaam);
        speler.toonVragenlijsten();
    }

    public void selecteerVragenlijst(String vragenlijstNaam, String spelerNaam) {
        Speler speler = getSpeler(spelerNaam);
        speler.selecteerVragenlijst(vragenlijstNaam);
    }

    public void verbeterTopScore(String test) {
        Speler speler = getSpeler(test);
        speler.verbeterScore();
    }
}