import java.util.ArrayList;
import java.util.Random;

public class Vragenlijst {

    private String vragenlijstNaam;
    private Thema thema;
    private Vraag[] vragen;
    private int prijsInMunten;
    private ArrayList<BeantwoordeVragenVanVragenlijst> beantwoordeVragenVanVragenlijst;

    public Vragenlijst(String vragenlijstNaam, Thema thema, Vraag[] vragen) {
        this.vragenlijstNaam = vragenlijstNaam;
        this.thema = thema;
        this.vragen = vragen;
        this.beantwoordeVragenVanVragenlijst = new ArrayList<BeantwoordeVragenVanVragenlijst>();
    }

    public String getVragenlijstNaam() {
        return vragenlijstNaam;
    }

    public Thema getThema() {
        return thema;
    }

    public Vraag[] getVragen() {
        return vragen;
    }

    public Vraag getRandomVraag() {
        Random random = new Random();
        int randomIndex = random.nextInt(vragen.length);
        return vragen[randomIndex];
    }

    public int getPrijsInMunten() {
        return prijsInMunten;
    }

    public void slaVraagOp(String antwoord, boolean isCorrect, Vraag vraag) {
        beantwoordeVragenVanVragenlijst.add(new BeantwoordeVragenVanVragenlijst(antwoord, isCorrect, vraag));
    }
}
