import java.util.ArrayList;

public class Spel {
    private ArrayList<Speler> spelers = new ArrayList<Speler>();
    private ArrayList<Vragenlijst> vragenlijsten = new ArrayList<Vragenlijst>();
    private Quiz quiz = new Quiz(new Taal("Nederlands"));


    public Spel() {
        Thema algemeneKennis = new Thema("Algemene kennis");
        Thema geschiedenis = new Thema("Geschiedenis");
        Thema wetenschap = new Thema("Wetenschap");

        vragenlijsten.add(new Vragenlijst("De Brein Kraker", algemeneKennis, VragenlijstSeedScript.maakWillekeurigeVragen(10)));
        vragenlijsten.add(new Vragenlijst("Hersenspoeler", geschiedenis, VragenlijstSeedScript.maakWillekeurigeVragen(10)));
        vragenlijsten.add(new Vragenlijst("Anti Jelmer Wetenschap", wetenschap, VragenlijstSeedScript.maakWillekeurigeVragen(10)));
    }

    public Speler maakSpelerAan(String gebruikersnaam, String wachtwoord) {
        Speler speler = new Speler(gebruikersnaam, wachtwoord);
        spelers.add(speler);

        speler.voegVragenlijstToe(getRandomVragenlijst());
        speler.voegVragenlijstToe(getRandomVragenlijst());

        return speler;
    }

    public Vragenlijst getRandomVragenlijst() {
        int randomIndex = (int) (Math.random() * vragenlijsten.size());
        return vragenlijsten.get(randomIndex);
    }

    public void verwijderSpeler(Speler speler) {
        spelers.remove(speler);
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
        gevondenSpeler.voegVragenlijstToe(vragenlijst);
    }

    public void toonVragenlijstenVanSpeler(String spelerNaam) {
        Speler gevondenSpeler = getSpeler(spelerNaam);
        gevondenSpeler.toonVragenlijsten();
    }

    public void verbeterTopScore(String onderwerp) {
        for (Speler speler : spelers) {
            speler.verbeterScore(onderwerp);
        }
    }

    public void speelQuiz(Speler speler, String onderwerp) {
        speler.speelQuiz(onderwerp);
    }

    public void selecteerVragenlijst(String vragenlijstNaam, String spelerNaam) {
        Speler gevondenSpeler = getSpeler(spelerNaam);
        gevondenSpeler.selecteerVragenlijst(vragenlijstNaam);
    }

    public void verbeterTopScore2(String test) {
        Speler gevondenSpeler = getSpeler(test);
        gevondenSpeler.verbeterScore2();
    }
}