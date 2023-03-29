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

    public void setLifetimeBestScore(int lifetimeBestScore) {
        this.lifetimeBestScore = lifetimeBestScore;
    }

    public Date getAankoopDatum() {
        return aankoopDatum;
    }

}
