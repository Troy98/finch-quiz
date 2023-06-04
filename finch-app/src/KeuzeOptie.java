public class KeuzeOptie {
    private String optieTekst;
    private boolean isJuist;

    public KeuzeOptie(String optieTekst, boolean isJuist) {
        this.optieTekst = optieTekst;
        this.isJuist = isJuist;
    }

    public String getOptieTekst() {
        return optieTekst;
    }

    public boolean isJuist() {
        return isJuist;
    }
}