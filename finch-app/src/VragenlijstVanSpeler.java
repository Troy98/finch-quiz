import java.util.Date;

public class VragenlijstVanSpeler {

   private int lifetimeBestScore;
   private Date aankoopDatum;

   Vragenlijst vragenlijst;

    public VragenlijstVanSpeler(Vragenlijst vragenlijst) {
         this.vragenlijst = vragenlijst;
         this.aankoopDatum = new Date();
    }

    public int getLifetimeBestScore() {
        return lifetimeBestScore;
    }

    public void updateLifetimeBestScore(int lifetimeBestScore) {
        int currentHighScore = getLifetimeBestScore();
        if (lifetimeBestScore > currentHighScore) {
            setLifetimeBestScore(lifetimeBestScore);
        }
    }

    public void setLifetimeBestScore(int lifetimeBestScore) {
        this.lifetimeBestScore = lifetimeBestScore;
        System.out.println("Nieuwe highscore: " + lifetimeBestScore);
    }

    public Vraag getRandomVraag() {
        return vragenlijst.getRandomVraag();
    }

    public String getVragenlijstNaam() {
        return vragenlijst.getVragenlijstNaam();
    }
}
