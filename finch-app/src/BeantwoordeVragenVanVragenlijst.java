public class BeantwoordeVragenVanVragenlijst{

    private Vraag vraag;
    private boolean isCorrect;
    private String antwoord;

    public BeantwoordeVragenVanVragenlijst(String antwoord, boolean isCorrect, Vraag vraag){
        this.vraag = vraag;
        this.isCorrect = isCorrect;
        this.antwoord = antwoord;
    }
}