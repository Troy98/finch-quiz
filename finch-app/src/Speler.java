import java.util.ArrayList;

public class Speler {

    String gebruikersnaam;
    String wachtwoord;
    int saldo;
    final int startSaldo = 200;
    private Quiz huidigeQuiz;

    Taal taal;


    ArrayList<VragenlijstVanSpeler> vragenlijstenVanSpeler = new ArrayList<VragenlijstVanSpeler>();

    ArrayList<Quiz> gespeeldeQuizzen = new ArrayList<Quiz>();

    public Speler(String gebruikersnaam, String wachtwoord) {
        this.gebruikersnaam = gebruikersnaam;
        this.wachtwoord = wachtwoord;
        this.saldo = startSaldo;
        this.taal = new Taal("nl");
    }

    public void addSaldo(int saldo) {
        this.saldo += saldo;
    }

    public void removeSaldo(int saldo) {
        this.saldo -= saldo;
    }

    public void addVragenlijstVanSpeler(Vragenlijst vragenlijst) {
        VragenlijstVanSpeler vragenlijstVanSpeler = new VragenlijstVanSpeler(vragenlijst);
        vragenlijstenVanSpeler.add(vragenlijstVanSpeler);
    }


    public void toonVragenlijsten() {
        for (VragenlijstVanSpeler vragenlijstVanSpeler : vragenlijstenVanSpeler) {
            System.out.println(vragenlijstVanSpeler.getVragenlijstNaam());
        }
    }

    public void selecteerVragenlijst(String vragenlijstNaam) {
        VragenlijstVanSpeler vragenlijstVanSpeler = getVragenlijstVanSpeler(vragenlijstNaam);
        huidigeQuiz.setVragenlijst(vragenlijstVanSpeler);
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
        huidigeQuiz.beantwoordVraag(antwoord);
    }

    public void nieuweQuiz() {
        huidigeQuiz = new Quiz(this.taal);
    }

    public void verbeterScore() {
        gespeeldeQuizzen.add(huidigeQuiz);

        int extraSaldoBijAlleVragenGoed = 2;
        String gespeeldeVragenlijstNaam = huidigeQuiz.getGespeeldeVragenlijstNaam();

        int totaalBehaaldePunten = huidigeQuiz.getTotalePunten();
        boolean alleVragenGoedBeantwoord = huidigeQuiz.isAllesGoedBeantwoord();
        if (alleVragenGoedBeantwoord) {
            addSaldo(extraSaldoBijAlleVragenGoed);
        }

        VragenlijstVanSpeler vragenlijstVanSpeler = getVragenlijstVanSpeler(gespeeldeVragenlijstNaam);

        vragenlijstVanSpeler.updateLifetimeBestScore(totaalBehaaldePunten);
    }
}
