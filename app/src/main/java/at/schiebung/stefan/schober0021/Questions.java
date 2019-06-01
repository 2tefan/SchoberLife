package at.schiebung.stefan.schober0021;

import at.schiebung.stefan.schober0021.questions.Decision;
import at.schiebung.stefan.schober0021.questions.QuestionDecisionArray;

class Questions
{
    private final QuestionDecisionArray questionDecisionArray = new QuestionDecisionArray();
    //Beliebtheit - Note - Eltern - Geld
    //private final int[][] question   = {{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}};

    //    private final int[][] question1  = {{10, -50, -75, 0}, {-50, 50, 0, 0}, {-50, -100, 0, 0}, {25, -100, 0, 0}};
    //    private final int[][] question2  = {{150, 50, 0, 0}, {0, -50, 0, 0}, {-25, -50, 0, 0}, {0, -150, 0, 0}};
    //    private final int[][] question3  = {{-100, -20, 0, 0}, {10, -50, -50, 0}, {100, -50, -50, 0}, {-10000, -10000, -10000, -10000}};
    //    private final int[][] question4  = {{0, 20, 0, 0}, {0, -250, 0, 0}, {20, 100, 0, 0}, {0, -50, 0, 0}};
    //    private final int[][] question5  = {{-25, -25, 0, 0}, {300, 10, 20, 0}, {-50, -50, 0, 0}, {-50, 250, 0, 0}};
    //    private final int[][] question6  = {{-50, -10, 0, 0}, {300, 10, 0, 0}, {-250, -25, 0, 200}, {-50, 0, 0, 0}};
    //    private final int[][] question7  = {{-50, -10, 0, 0}, {100, -100, 0, 0}, {-200, 0, 0, 0}, {-300, 50, 0, 0}};
    //    private final int[][] question8  = {{-10, 20, 20, 0}, {-50, -100, -20, 0}, {0, 200, 0, -500}, {0, -120, 0, 0}};
    //    private final int[][] question9  = {{20, 100, 0, 0}, {0, -100, 0, 0}, {0, 250, 0, 0}, {0, -100, -50, 0}};
    //    private final int[][] question10 = {{0, 100, 0, 0}, {0, 120, 0, 0}, {0, -150, 0, 0}, {0, -100, 0, 0}};
    //    private final int[][] question11 = {{0, 0, 0, 100}, {0, 0, 0, 0}, {-500, 0, -500, 0}, {100, 0, 0, 0}};
    //    private final int[][] question12 = {{50, 0, -250, 250}, {0, 0, -250, 250}, {0, 0, -20, 0}, {250, -20, -20, 0}};
    //    private final int[][] question13 = {{0, -50, 0, 0}, {0, 50, 0, 0}, {-25, -50, 0, 0}, {0, -70, 0, 0}};
    //    private final int[][] question14 = {{250, -250, -50, -20}, {-250, 100, 20, 0}, {50, 50, 0, -10}, {-50, -200, -10, -20}};
    //    private final int[][] question15 = {{100, 0, 0, 0}, {-100, 0, 0, 0}, {-150, 0, 0, 0}, {0, 0, 0, 0}};
    //    private final int[][] question16 = {{-50, 0, 0, 0}, {-100, 0, 0, 0}, {-150, 0, 0, 0}, {-25, 0, 0, 0}};
    //
    //    final int[][][] questionDecisionArray.questionArrayMainValues = {question1, question2, question3, question4, question5, question6, question7, question8, question9, question10, question11, question12, question13,
    //            question14, question15, question16};
    int currentQuestion;
    int currentDecision;

    Decision getCurrentDecision()
    {
        return questionDecisionArray.questionDecision[currentQuestion].getDecisionArray()[currentDecision];
    }

    void init(int countQuestions)
    {
        questionDecisionArray.init(countQuestions);
        questionDecisionArray.questionDecision[0].getDecision0().setReputation(10);
        questionDecisionArray.questionDecision[0].getDecision0().setGrade(-50);
        questionDecisionArray.questionDecision[0].getDecision0().setParents(-75);

        questionDecisionArray.questionDecision[0].getDecision1().setReputation(-50);
        questionDecisionArray.questionDecision[0].getDecision1().setGrade(50);

        questionDecisionArray.questionDecision[0].getDecision2().setReputation(-50);
        questionDecisionArray.questionDecision[0].getDecision2().setGrade(-100);

        questionDecisionArray.questionDecision[0].getDecision3().setReputation(-50);
        questionDecisionArray.questionDecision[0].getDecision3().setGrade(-100);

        //----------------------------------------------------------------------------

        questionDecisionArray.questionDecision[1].getDecision0().setReputation(150);
        questionDecisionArray.questionDecision[1].getDecision0().setGrade(50);

        questionDecisionArray.questionDecision[1].getDecision1().setGrade(-50);

        questionDecisionArray.questionDecision[1].getDecision2().setReputation(-25);
        questionDecisionArray.questionDecision[1].getDecision2().setGrade(-50);

        questionDecisionArray.questionDecision[1].getDecision3().setReputation(0);
        questionDecisionArray.questionDecision[1].getDecision3().setGrade(-150);

        //----------------------------------------------------------------------------

        questionDecisionArray.questionDecision[2].getDecision0().setReputation(-100);
        questionDecisionArray.questionDecision[2].getDecision0().setGrade(-20);

        questionDecisionArray.questionDecision[2].getDecision1().setReputation(10);
        questionDecisionArray.questionDecision[2].getDecision1().setGrade(-50);
        questionDecisionArray.questionDecision[2].getDecision1().setParents(-50);

        questionDecisionArray.questionDecision[2].getDecision2().setReputation(100);
        questionDecisionArray.questionDecision[2].getDecision2().setGrade(-50);
        questionDecisionArray.questionDecision[2].getDecision2().setParents(-50);

        questionDecisionArray.questionDecision[2].getDecision3().setReputation(-10000);
        questionDecisionArray.questionDecision[2].getDecision3().setGrade(-10000);
        questionDecisionArray.questionDecision[2].getDecision3().setParents(-10000);
        questionDecisionArray.questionDecision[2].getDecision3().setMoney(-10000);
        questionDecisionArray.questionDecision[2].getDecision3().setSuicide(true);

        //----------------------------------------------------------------------------

        questionDecisionArray.questionDecision[3].getDecision0().setGrade(20);

        questionDecisionArray.questionDecision[3].getDecision1().setGrade(-250);

        questionDecisionArray.questionDecision[3].getDecision2().setReputation(20);
        questionDecisionArray.questionDecision[3].getDecision2().setGrade(100);

        questionDecisionArray.questionDecision[3].getDecision3().setGrade(-50);

        //----------------------------------------------------------------------------

        questionDecisionArray.questionDecision[4].getDecision0().setReputation(-25);
        questionDecisionArray.questionDecision[4].getDecision0().setGrade(-25);

        questionDecisionArray.questionDecision[4].getDecision1().setReputation(300);
        questionDecisionArray.questionDecision[4].getDecision1().setGrade(10);
        questionDecisionArray.questionDecision[4].getDecision1().setParents(20);

        questionDecisionArray.questionDecision[4].getDecision2().setReputation(-50);
        questionDecisionArray.questionDecision[4].getDecision2().setGrade(-50);

        questionDecisionArray.questionDecision[4].getDecision3().setReputation(-50);
        questionDecisionArray.questionDecision[4].getDecision3().setGrade(250);

        //----------------------------------------------------------------------------

        questionDecisionArray.questionDecision[5].getDecision0().setReputation(-50);
        questionDecisionArray.questionDecision[5].getDecision0().setGrade(-10);

        questionDecisionArray.questionDecision[5].getDecision1().setReputation(300);
        questionDecisionArray.questionDecision[5].getDecision1().setGrade(10);

        questionDecisionArray.questionDecision[5].getDecision2().setReputation(-250);
        questionDecisionArray.questionDecision[5].getDecision2().setGrade(-25);

        questionDecisionArray.questionDecision[5].getDecision3().setReputation(-50);

        //----------------------------------------------------------------------------

        questionDecisionArray.questionDecision[6].getDecision0().setReputation(-50);
        questionDecisionArray.questionDecision[6].getDecision0().setGrade(-10);

        questionDecisionArray.questionDecision[6].getDecision1().setReputation(100);
        questionDecisionArray.questionDecision[6].getDecision1().setGrade(-100);

        questionDecisionArray.questionDecision[6].getDecision2().setReputation(-200);

        questionDecisionArray.questionDecision[6].getDecision3().setReputation(-300);
        questionDecisionArray.questionDecision[6].getDecision3().setGrade(50);

        //----------------------------------------------------------------------------

        questionDecisionArray.questionDecision[7].getDecision0().setReputation(-10);
        questionDecisionArray.questionDecision[7].getDecision0().setGrade(20);
        questionDecisionArray.questionDecision[7].getDecision0().setParents(20);

        questionDecisionArray.questionDecision[7].getDecision1().setReputation(-50);
        questionDecisionArray.questionDecision[7].getDecision1().setGrade(-100);
        questionDecisionArray.questionDecision[7].getDecision1().setParents(-20);

        questionDecisionArray.questionDecision[7].getDecision2().setGrade(200);
        questionDecisionArray.questionDecision[7].getDecision2().setMoney(-500);

        questionDecisionArray.questionDecision[7].getDecision3().setGrade(-120);

        //----------------------------------------------------------------------------

        questionDecisionArray.questionDecision[8].getDecision0().setReputation(20);
        questionDecisionArray.questionDecision[8].getDecision0().setGrade(100);

        questionDecisionArray.questionDecision[8].getDecision1().setGrade(-100);

        questionDecisionArray.questionDecision[8].getDecision2().setGrade(250);

        questionDecisionArray.questionDecision[8].getDecision3().setGrade(-100);
        questionDecisionArray.questionDecision[8].getDecision3().setParents(-50);

        //----------------------------------------------------------------------------

        questionDecisionArray.questionDecision[9].getDecision0().setGrade(100);

        questionDecisionArray.questionDecision[9].getDecision1().setGrade(120);

        questionDecisionArray.questionDecision[9].getDecision2().setGrade(-150);

        questionDecisionArray.questionDecision[9].getDecision3().setGrade(-100);

        //----------------------------------------------------------------------------

        questionDecisionArray.questionDecision[10].getDecision0().setMoney(100);

        questionDecisionArray.questionDecision[10].getDecision2().setReputation(-500);
        questionDecisionArray.questionDecision[10].getDecision2().setParents(-500);

        questionDecisionArray.questionDecision[10].getDecision3().setReputation(100);

        //----------------------------------------------------------------------------

        questionDecisionArray.questionDecision[11].getDecision0().setReputation(50);
        questionDecisionArray.questionDecision[11].getDecision0().setParents(-250);
        questionDecisionArray.questionDecision[11].getDecision0().setMoney(250);

        questionDecisionArray.questionDecision[11].getDecision1().setParents(-250);
        questionDecisionArray.questionDecision[11].getDecision1().setMoney(250);

        questionDecisionArray.questionDecision[11].getDecision2().setParents(-20);

        questionDecisionArray.questionDecision[11].getDecision3().setReputation(250);
        questionDecisionArray.questionDecision[11].getDecision3().setGrade(-20);
        questionDecisionArray.questionDecision[11].getDecision3().setParents(-20);

        //----------------------------------------------------------------------------

        questionDecisionArray.questionDecision[12].getDecision0().setGrade(-50);

        questionDecisionArray.questionDecision[12].getDecision1().setGrade(50);

        questionDecisionArray.questionDecision[12].getDecision2().setReputation(-25);
        questionDecisionArray.questionDecision[12].getDecision2().setGrade(-50);

        questionDecisionArray.questionDecision[12].getDecision3().setGrade(-70);

        //----------------------------------------------------------------------------

        questionDecisionArray.questionDecision[13].getDecision0().setReputation(250);
        questionDecisionArray.questionDecision[13].getDecision0().setGrade(-250);
        questionDecisionArray.questionDecision[13].getDecision0().setParents(-50);
        questionDecisionArray.questionDecision[13].getDecision0().setMoney(-20);

        questionDecisionArray.questionDecision[13].getDecision1().setReputation(-250);
        questionDecisionArray.questionDecision[13].getDecision1().setGrade(100);
        questionDecisionArray.questionDecision[13].getDecision1().setParents(20);

        questionDecisionArray.questionDecision[13].getDecision2().setReputation(50);
        questionDecisionArray.questionDecision[13].getDecision2().setGrade(50);
        questionDecisionArray.questionDecision[13].getDecision2().setMoney(-10);

        questionDecisionArray.questionDecision[13].getDecision3().setReputation(-50);
        questionDecisionArray.questionDecision[13].getDecision3().setGrade(-200);
        questionDecisionArray.questionDecision[13].getDecision3().setParents(-10);
        questionDecisionArray.questionDecision[13].getDecision3().setMoney(-20);

        //----------------------------------------------------------------------------

        questionDecisionArray.questionDecision[14].getDecision0().setReputation(100);

        questionDecisionArray.questionDecision[14].getDecision1().setReputation(-100);

        questionDecisionArray.questionDecision[14].getDecision2().setReputation(-150);

        //----------------------------------------------------------------------------

        questionDecisionArray.questionDecision[15].getDecision0().setReputation(-50);

        questionDecisionArray.questionDecision[15].getDecision1().setReputation(-100);

        questionDecisionArray.questionDecision[15].getDecision2().setReputation(-150);

        questionDecisionArray.questionDecision[15].getDecision3().setReputation(-25);


    }
}
