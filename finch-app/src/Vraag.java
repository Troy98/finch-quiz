public abstract class Vraag {
    private String vraagTekst;

    public Vraag(String vraagTekst) {
        this.vraagTekst = vraagTekst;
    }
    public String getVraagTekst() {
        return vraagTekst;
    }
    public abstract boolean controleerAntwoord(String antwoord);

    public void printVraag() {
        System.out.println(getVraagTekst());
    }
}