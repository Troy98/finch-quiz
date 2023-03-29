public class Vragenlijst {

    private String onderwerp;
    private Thema thema;
    private Vraag[] vragen;

    public Vragenlijst(String onderwerp, Thema thema, Vraag[] vragen) {
        this.onderwerp = onderwerp;
        this.thema = thema;
        this.vragen = vragen;
    }

    public String getOnderwerp() {
        return onderwerp;
    }

    public Thema getThema() {
        return thema;
    }

    public Vraag[] getVragen() {
        return vragen;
    }


}
