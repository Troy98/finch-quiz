import java.util.ArrayList;

public class Speler {

    String gebruikersnaam;
    String wachtwoord;
    int saldo;
    int startSaldo = 200;
    private Quiz quiz;

    ArrayList<VragenlijstVanSpeler> vragenlijstenVanSpeler = new ArrayList<VragenlijstVanSpeler>();

    public Speler(String gebruikersnaam, String wachtwoord) {
        this.gebruikersnaam = gebruikersnaam;
        this.wachtwoord = wachtwoord;
        this.saldo = startSaldo;
        quiz = new Quiz(new Taal("nl"));
    }

    public void addVragenlijstVanSpeler(Vragenlijst vragenlijst) {
        VragenlijstVanSpeler vragenlijstVanSpeler = new VragenlijstVanSpeler(vragenlijst);
        vragenlijstenVanSpeler.add(vragenlijstVanSpeler);
    }

    public void speelQuiz(String onderwerp) {
        for (VragenlijstVanSpeler vragenlijstVanSpeler : vragenlijstenVanSpeler) {
            if (vragenlijstVanSpeler.vragenlijst.getVragenlijstNaam().equals(onderwerp)) {
                quiz.speelQuiz(vragenlijstVanSpeler.vragenlijst);
            }
        }
    }

    public void toonVragenlijsten() {
        for (VragenlijstVanSpeler vragenlijstVanSpeler : vragenlijstenVanSpeler) {
            System.out.println(vragenlijstVanSpeler.getVragenlijstNaam());
        }
    }

    public void verbeterScore(String vragenlijstNaam) {
        for (VragenlijstVanSpeler vragenlijstVanSpeler : vragenlijstenVanSpeler) {
            if (vragenlijstVanSpeler.vragenlijst.getVragenlijstNaam().equals(vragenlijstNaam)) {
                if (vragenlijstVanSpeler.getLifetimeBestScore() < quiz.getTotalePunten()) {
                    vragenlijstVanSpeler.setLifetimeBestScore(quiz.getTotalePunten());
                }
            }
        }
    }

    public void selecteerVragenlijst(String onderwerp) {
        VragenlijstVanSpeler vragenlijstVanSpeler = getVragenlijstVanSpeler(onderwerp);
        quiz.setVragenlijst(vragenlijstVanSpeler);
    }

    private VragenlijstVanSpeler getVragenlijstVanSpeler(String vragenlijstnaam) {
        for (VragenlijstVanSpeler vragenlijstVanSpeler : vragenlijstenVanSpeler) {
            if (vragenlijstVanSpeler.getVragenlijstNaam().equals(vragenlijstnaam)) {
                return vragenlijstVanSpeler;
            }
        }
        return null;
    }

    public void beantwoordVraag(String antwoord) {
        quiz.beantwoordVraag(antwoord);
    }

    public void verbeterScore() {
        String gespeeldeVragenlijstNaam = quiz.getGespeeldeVragenlijstNaam();

        int totaalBehaaldePunten = quiz.getTotalePunten();

        VragenlijstVanSpeler vragenlijstVanSpeler = getVragenlijstVanSpeler(gespeeldeVragenlijstNaam);

        vragenlijstVanSpeler.setLifetimeBestScore(totaalBehaaldePunten);
    }
}
