public class Openvraag extends Vraag {
    private CorrecteAntwoord[] correcteAntwoorden;

    public Openvraag(String vraagTekst, CorrecteAntwoord[] correcteAntwoorden) {
        super(vraagTekst);
        this.correcteAntwoorden = correcteAntwoorden;
    }

    public CorrecteAntwoord[] getCorrecteAntwoorden() {
        return correcteAntwoorden;
    }

    @Override
    public boolean controleerAntwoord(String antwoord) {
        for (CorrecteAntwoord correctAntwoord : correcteAntwoorden) {
            if (antwoord.equalsIgnoreCase(correctAntwoord.getAntwoordTekst())) {
                return true;
            }
        }
        return false;
    }
}