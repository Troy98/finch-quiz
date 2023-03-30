import java.util.Random;

public class Vragenlijst {

    private String vragenlijstNaam;
    private Thema thema;
    private Vraag[] vragen;

    public Vragenlijst(String vragenlijstNaam, Thema thema, Vraag[] vragen) {
        this.vragenlijstNaam = vragenlijstNaam;
        this.thema = thema;
        this.vragen = vragen;
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
}
