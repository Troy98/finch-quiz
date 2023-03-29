import java.util.ArrayList;
import java.util.Collections;

public class VragenlijstSeedScript {

    public static Vragenlijst vragenlijst1;
    public static Vragenlijst vragenlijst2;
    public static Vragenlijst vragenlijst3;

    public static void generateVragenlijst() {
        Thema algemeneKennis = new Thema("Algemene kennis");
        Thema geschiedenis = new Thema("Geschiedenis");
        Thema wetenschap = new Thema("Wetenschap");

        vragenlijst1 = new Vragenlijst("Quiz 1", algemeneKennis, maakWillekeurigeVragen(10));
        vragenlijst2 = new Vragenlijst("Quiz 2", geschiedenis, maakWillekeurigeVragen(10));
        vragenlijst3 = new Vragenlijst("Quiz 3", wetenschap, maakWillekeurigeVragen(10));

    }

    public static Vraag[] maakWillekeurigeVragen(int aantalVragen) {
        ArrayList<Vraag> vragen = new ArrayList<>();

        // Maak een array van vragen
        vragen.add(new Meerkeuzevraag("Wat is de hoofdstad van Nederland?", new KeuzeOptie[]{
                new KeuzeOptie("Rotterdam", false),
                new KeuzeOptie("Den Haag", false),
                new KeuzeOptie("Amsterdam", true),
                new KeuzeOptie("Utrecht", false)
        }));
        vragen.add(new Meerkeuzevraag("Wie was de eerste mens op de maan?", new KeuzeOptie[]{
                new KeuzeOptie("Neil Armstrong", true),
                new KeuzeOptie("Buzz Aldrin", false),
                new KeuzeOptie("Yuri Gagarin", false),
                new KeuzeOptie("Alan Shepard", false)
        }));
        vragen.add(new Openvraag("Hoeveel vingers heeft een menselijke hand?", new CorrecteAntwoord[]{
                new CorrecteAntwoord("5"),
                new CorrecteAntwoord("vijf")
        }));
        vragen.add(new Openvraag("Wat is het op één na grootste continent ter wereld?", new CorrecteAntwoord[]{
                new CorrecteAntwoord("Europa"),
                new CorrecteAntwoord("europa")
        }));
        vragen.add(new Meerkeuzevraag("Wie was de uitvinder van de telefoon?", new KeuzeOptie[]{
                new KeuzeOptie("Thomas Edison", false),
                new KeuzeOptie("Alexander Graham Bell", true),
                new KeuzeOptie("Nikola Tesla", false),
                new KeuzeOptie("Samuel Morse", false)
        }));
        vragen.add(new Openvraag("Wat is de naam van het proces waarbij een rups in een vlinder verandert?", new CorrecteAntwoord[]{
                new CorrecteAntwoord("metamorfose"),
                new CorrecteAntwoord("verpopping")
        }));
        vragen.add(new Meerkeuzevraag("Welke kleur heeft het logo van Google?", new KeuzeOptie[]{
                new KeuzeOptie("blauw", false),
                new KeuzeOptie("rood", false),
                new KeuzeOptie("geel", true),
                new KeuzeOptie("groen", false)
        }));
        vragen.add(new Openvraag("Wat is de naam van de hoogste berg ter wereld?", new CorrecteAntwoord[]{
                new CorrecteAntwoord("Mount Everest"),
                new CorrecteAntwoord("Everest")
        }));

        vragen.add(new Openvraag("Wat is de hoofdstad van Frankrijk?", new CorrecteAntwoord[]{
                new CorrecteAntwoord("Parijs"),
                new CorrecteAntwoord("parijs")
        }));

        vragen.add(new Openvraag("Wat is de hoofdstad van België?", new CorrecteAntwoord[]{
                new CorrecteAntwoord("Brussel"),
                new CorrecteAntwoord("brussel")
        }));

        vragen.add(new Openvraag("Wat is de hoofdstad van Duitsland?", new CorrecteAntwoord[]{
                new CorrecteAntwoord("Berlijn"),
                new CorrecteAntwoord("berlijn")
        }));

        vragen.add(new Openvraag("Wat is de hoofdstad van Italië?", new CorrecteAntwoord[]{
                new CorrecteAntwoord("Rome"),
                new CorrecteAntwoord("rome")
        }));

        vragen.add(new Openvraag("Wat is de hoofdstad van Spanje?", new CorrecteAntwoord[]{
                new CorrecteAntwoord("Madrid"),
                new CorrecteAntwoord("madrid")
        }));

        vragen.add(new Openvraag("Wat is de hoofdstad van Engeland?", new CorrecteAntwoord[]{
                new CorrecteAntwoord("Londen"),
                new CorrecteAntwoord("londen")
        }));

        vragen.add(new Openvraag("Wat is de hoofdstad van Zweden?", new CorrecteAntwoord[]{
                new CorrecteAntwoord("Stockholm"),
                new CorrecteAntwoord("stockholm")
        }));

        vragen.add(new Openvraag("Wat is de hoofdstad van Zwitserland?", new CorrecteAntwoord[]{
                new CorrecteAntwoord("Bern"),
                new CorrecteAntwoord("bern")
        }));

        vragen.add(new Openvraag("Wat is de hoofdstad van Oostenrijk?", new CorrecteAntwoord[]{
                new CorrecteAntwoord("Wenen"),
                new CorrecteAntwoord("weenen")
        }));

        vragen.add(new Openvraag("Wat is de hoofdstad van Denemarken?", new CorrecteAntwoord[]{
                new CorrecteAntwoord("Kopenhagen"),
                new CorrecteAntwoord("kopenhagen")
        }));

        vragen.add(new Openvraag("Wat is de hoofdstad van Noorwegen?", new CorrecteAntwoord[]{
                new CorrecteAntwoord("Oslo"),
                new CorrecteAntwoord("oslo")
        }));

        vragen.add(new Openvraag("Wat is de hoofdstad van Finland?", new CorrecteAntwoord[]{
                new CorrecteAntwoord("Helsinki"),
                new CorrecteAntwoord("helsinki")
        }));

        vragen.add(new Openvraag("Wat is de hoofdstad van Rusland?", new CorrecteAntwoord[]{
                new CorrecteAntwoord("Moskou"),
                new CorrecteAntwoord("moskou")
        }));

        vragen.add(new Openvraag("Wat is de hoofdstad van Griekenland?", new CorrecteAntwoord[]{
                new CorrecteAntwoord("Athene"),
                new CorrecteAntwoord("athene")
        }));

        vragen.add(new Openvraag("Wat is de hoofdstad van Turkije?", new CorrecteAntwoord[]{
                new CorrecteAntwoord("Ankara"),
                new CorrecteAntwoord("ankara")
        }));

        //maak meerkeuze vragen

        vragen.add(new Meerkeuzevraag("Wat is de hoofdstad van Nederland?", new KeuzeOptie[]{
                new KeuzeOptie("Rotterdam", false),
                new KeuzeOptie("Den Haag", false),
                new KeuzeOptie("Amsterdam", true),
                new KeuzeOptie("Utrecht", false)
        }));

        vragen.add(new Meerkeuzevraag( "Wat is de hoofdstad van België?", new KeuzeOptie[]{
                new KeuzeOptie("Brussel", true),
                new KeuzeOptie("Antwerpen", false),
                new KeuzeOptie("Gent", false),
                new KeuzeOptie("Brugge", false)
        }));

        Collections.shuffle(vragen);
        Vraag[] willekeurigeVragen = new Vraag[aantalVragen];
        for (int i = 0; i < aantalVragen; i++) {
            willekeurigeVragen[i] = vragen.get(i);
        }

        return willekeurigeVragen;
    }
}