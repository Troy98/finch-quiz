public class Meerkeuzevraag extends Vraag {
    private KeuzeOptie[] keuzeOpties;

    public Meerkeuzevraag(String vraagTekst, KeuzeOptie[] keuzeOpties) {
        super(vraagTekst);
        this.keuzeOpties = keuzeOpties;
    }

    public KeuzeOptie[] getKeuzeOpties() {
        return keuzeOpties;
    }
    //make a getOptions

    public KeuzeOptie[] getOpties() {
        return keuzeOpties;
    }

    @Override
    public boolean controleerAntwoord(String antwoord) {
        for (KeuzeOptie keuzeOptie : keuzeOpties) {
            if (antwoord.equalsIgnoreCase(keuzeOptie.getOptieTekst()) && keuzeOptie.isJuist()) {
                return true;
            }
        }
        return false;
    }
}