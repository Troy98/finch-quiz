public class NormalePuntentelling implements PuntentellingStrategie{

    @Override
    public int berekenPunten(int aantalJuisteAntwoorden, int aantalOpenVragen, int aantalMeerkeuzeVragen, long aantalSeconden) {
        int basisPuntenPerVraag = 10; // Aantal punten per goed beantwoorde vraag
        int bonusPuntenPerSeconde = 1; // Bonuspunten per seconde
        int extraPunten = 50; // Extra punten voor alle vragen goed beantwoord
        //int munten = 0; // Aantal munten

        int totaalPunten = aantalJuisteAntwoorden * basisPuntenPerVraag;

        // Bonuspunten voor snelheid
        totaalPunten += (10 * 60 - aantalSeconden) * bonusPuntenPerSeconde;

//        // Extra punten en munten als alle vragen goed zijn beantwoord
//        if (aantalJuisteAntwoorden == (aantalOpenVragen + aantalMeerkeuzeVragen)) {
//            totaalPunten += extraPunten;
//            munten += 2;
//        }

        return totaalPunten;
    }
}
