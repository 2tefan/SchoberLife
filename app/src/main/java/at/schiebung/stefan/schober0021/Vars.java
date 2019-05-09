package at.schiebung.stefan.schober0021;

class Vars {
    static final String preferences_name = "Schober by Stefan";
    static final String preferences_key = "ThisIsVerySecureAndNoOneWillGuessThis";
    static int frage = 0;
    static int[] anweresed;

    static int reputation = 1000;
    static int grade = 1000;
    static int parents = 1000;
    static int money = 1000;

    //Beliebtheit - Note - Eltern - Geld

    static final int[][][] change =
            {{{10, -50, -75, 0}, {-50, 50, 0, 0}, {-50, -100, 0, 0}, {25, -100, 0, 0}},
                    {{150, 50, 0, 0}, {0, -50, 0, 0}, {-25, -50, 0, 0}, {0, -150, 0, 0}},
                    {{-100, -20, 0, 0}, {10, -50, -50, 0}, {100, -50, -50, 0}, {-10000, -10000, -10000, -10000}},
                    {{5, -10, 0, 0}, {50, 0, 0, 0}, {0, -5, 0, 0}, {-25, 0, 0, 0}},
                    {{0, -100, 0, 0}, {100, 0, 20, 0}, {-50, -50, 0, 0}, {-50, 250, 0, 0}},
                    {{-300, 0, 0, 0}, {300, 50, 0, 0}, {-100, 0, 0, 200}, {-50, 0, 0, 0}}};
}
