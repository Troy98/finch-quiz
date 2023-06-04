public class NormalePuntentelling implements PuntentellingStrategie{

    @Override
    public int berekenPunten(int aantalJuisteAntwoorden, long aantalSeconden) {
        int basisPuntenPerVraag = 10;
        int bonusPuntenPerSeconde = 1;
        int extraPuntenVoorAlleVragenGoed = 50;


        int totaalPunten = aantalJuisteAntwoorden * basisPuntenPerVraag;

        totaalPunten += (10 * 60 - aantalSeconden) * bonusPuntenPerSeconde;

        if (aantalJuisteAntwoorden == 10) {
            totaalPunten += extraPuntenVoorAlleVragenGoed;
        }

        return totaalPunten;
    }
}
