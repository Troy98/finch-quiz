public class BeantwoordeVragen {

    private boolean isCorrect;
    private String antwoord;
    private Vraag vraag;

    public BeantwoordeVragen(Vraag vraag, String antwoord, boolean isCorrect) {
        this.vraag = vraag;
        this.antwoord = antwoord;
        this.isCorrect = isCorrect;
    }
}
