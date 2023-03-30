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

    public void voegVragenlijstToe(Vragenlijst vragenlijst) {
        VragenlijstVanSpeler vragenlijstVanSpeler = new VragenlijstVanSpeler(vragenlijst);
        vragenlijstenVanSpeler.add(vragenlijstVanSpeler);
    }

    public void speelQuiz(String onderwerp) {
        for (VragenlijstVanSpeler vragenlijstVanSpeler : vragenlijstenVanSpeler) {
            if (vragenlijstVanSpeler.vragenlijst.getOnderwerp().equals(onderwerp)) {
                quiz.speelQuiz(vragenlijstVanSpeler.vragenlijst);
            }
        }
    }

    public void toonVragenlijsten() {
        for (VragenlijstVanSpeler vragenlijstVanSpeler : vragenlijstenVanSpeler) {
            System.out.println(vragenlijstVanSpeler.vragenlijst.getOnderwerp());
        }
    }

    public void verbeterScore(String vragenlijstNaam) {
        for (VragenlijstVanSpeler vragenlijstVanSpeler : vragenlijstenVanSpeler) {
            if (vragenlijstVanSpeler.vragenlijst.getOnderwerp().equals(vragenlijstNaam)) {
                if (vragenlijstVanSpeler.getLifetimeBestScore() < quiz.getTotalePunten()) {
                    vragenlijstVanSpeler.setLifetimeBestScore(quiz.getTotalePunten());
                }
            }
        }
    }
}
