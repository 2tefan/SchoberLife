package at.schiebung.stefan.schober0021;

public class Vars
{
	static String preferences_name = "Schober by Stefan";
	static String preferences_key = "ThisIsVerySecureAndNoOneWillGuessThis";
	static int frage = 0;
	static int[] anweresed;

	static int reputation = 1000;
	static int grade = 1000;
	static int parents = 1000;
	static int money = 1000;

	//Beliebtheit - Note - Eltern - Geld

	static int[][][] change = {{{0, -50, -75, 0}, {-50, 50, 0, 0}, {-150, 100, 0, 0}, {25, -100, 0, 0}},
			{{150, 0, 0, 0}, {0, -10, 0, 0}, {-25, 0, 0, 0}, {0, -150, 0, 0}},
			{{-100, 0, 0, 0}, {10, 0, -50, 0}, {100, -50, -50, 0}, {-10000, -10000, -10000, -10000}},
			{{5, -10, 0, 0}, {50, 0, 0, 0}, {0, -5, 0, 0}, {-25, 0, 0, 0}}};
}
