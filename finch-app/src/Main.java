public class Main {
    public static void main(String[] args) {
        VragenlijstSeedScript.generateVragenlijst();

        Speler speler = new Speler("test", "test");

        speler.voegVragenlijstToe(VragenlijstSeedScript.vragenlijst1);
        speler.voegVragenlijstToe(VragenlijstSeedScript.vragenlijst2);

        speler.speelQuiz(VragenlijstSeedScript.vragenlijst1);
    }
}
