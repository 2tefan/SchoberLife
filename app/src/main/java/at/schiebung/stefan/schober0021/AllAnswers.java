package at.schiebung.stefan.schober0021;

class AllAnswers
{
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
    //    final int[][][] allQuestionArray.questionArrayMainValues = {question1, question2, question3, question4, question5, question6, question7, question8, question9, question10, question11, question12, question13,
    //            question14, question15, question16};

    AllQuestionArray allQuestionArray = new AllQuestionArray();

    public void init(int countQuestions)
    {
        allQuestionArray.init(countQuestions);
        allQuestionArray.questionArray[0].getDecision0().setReputation(10);
        allQuestionArray.questionArray[0].getDecision0().setGrade(-50);
        allQuestionArray.questionArray[0].getDecision0().setParents(-75);

        allQuestionArray.questionArray[0].getDecision1().setReputation(-50);
        allQuestionArray.questionArray[0].getDecision1().setGrade(50);

        allQuestionArray.questionArray[0].getDecision2().setReputation(-50);
        allQuestionArray.questionArray[0].getDecision2().setGrade(-100);

        allQuestionArray.questionArray[0].getDecision3().setReputation(-50);
        allQuestionArray.questionArray[0].getDecision3().setGrade(-100);

        //----------------------------------------------------------------------------

        allQuestionArray.questionArray[1].getDecision0().setReputation(150);
        allQuestionArray.questionArray[1].getDecision0().setGrade(50);

        allQuestionArray.questionArray[1].getDecision1().setGrade(-50);

        allQuestionArray.questionArray[1].getDecision2().setReputation(-25);
        allQuestionArray.questionArray[1].getDecision2().setGrade(-50);

        allQuestionArray.questionArray[1].getDecision3().setReputation(0);
        allQuestionArray.questionArray[1].getDecision3().setGrade(-150);

        //----------------------------------------------------------------------------

        allQuestionArray.questionArray[2].getDecision0().setReputation(-100);
        allQuestionArray.questionArray[2].getDecision0().setGrade(-20);

        allQuestionArray.questionArray[2].getDecision1().setReputation(10);
        allQuestionArray.questionArray[2].getDecision1().setGrade(-50);
        allQuestionArray.questionArray[2].getDecision1().setParents(-50);

        allQuestionArray.questionArray[2].getDecision2().setReputation(100);
        allQuestionArray.questionArray[2].getDecision2().setGrade(-50);
        allQuestionArray.questionArray[2].getDecision2().setParents(-50);

        allQuestionArray.questionArray[2].getDecision3().setReputation(-10000);
        allQuestionArray.questionArray[2].getDecision3().setGrade(-10000);
        allQuestionArray.questionArray[2].getDecision3().setParents(-10000);
        allQuestionArray.questionArray[2].getDecision3().setMoney(-10000);

        //----------------------------------------------------------------------------

        allQuestionArray.questionArray[3].getDecision0().setGrade(20);

        allQuestionArray.questionArray[3].getDecision1().setGrade(-250);

        allQuestionArray.questionArray[3].getDecision2().setReputation(20);
        allQuestionArray.questionArray[3].getDecision2().setGrade(100);

        allQuestionArray.questionArray[3].getDecision3().setGrade(-50);

        //----------------------------------------------------------------------------

        allQuestionArray.questionArray[4].getDecision0().setReputation(-25);
        allQuestionArray.questionArray[4].getDecision0().setGrade(-25);

        allQuestionArray.questionArray[4].getDecision1().setReputation(300);
        allQuestionArray.questionArray[4].getDecision1().setGrade(10);
        allQuestionArray.questionArray[4].getDecision1().setParents(20);

        allQuestionArray.questionArray[4].getDecision2().setReputation(-50);
        allQuestionArray.questionArray[4].getDecision2().setGrade(-50);

        allQuestionArray.questionArray[4].getDecision3().setReputation(-50);
        allQuestionArray.questionArray[4].getDecision3().setGrade(250);

        //----------------------------------------------------------------------------

        allQuestionArray.questionArray[5].getDecision0().setReputation(-50);
        allQuestionArray.questionArray[5].getDecision0().setGrade(-10);

        allQuestionArray.questionArray[5].getDecision1().setReputation(300);
        allQuestionArray.questionArray[5].getDecision1().setGrade(10);

        allQuestionArray.questionArray[5].getDecision2().setReputation(-250);
        allQuestionArray.questionArray[5].getDecision2().setGrade(-25);

        allQuestionArray.questionArray[5].getDecision3().setReputation(-50);

        //----------------------------------------------------------------------------

        allQuestionArray.questionArray[6].getDecision0().setReputation(-50);
        allQuestionArray.questionArray[6].getDecision0().setGrade(-10);

        allQuestionArray.questionArray[6].getDecision1().setReputation(100);
        allQuestionArray.questionArray[6].getDecision1().setGrade(-100);

        allQuestionArray.questionArray[6].getDecision2().setReputation(-200);

        allQuestionArray.questionArray[6].getDecision3().setReputation(-300);
        allQuestionArray.questionArray[6].getDecision3().setGrade(50);

        //----------------------------------------------------------------------------

        allQuestionArray.questionArray[7].getDecision0().setReputation(-10);
        allQuestionArray.questionArray[7].getDecision0().setGrade(20);
        allQuestionArray.questionArray[7].getDecision0().setParents(20);

        allQuestionArray.questionArray[7].getDecision1().setReputation(-50);
        allQuestionArray.questionArray[7].getDecision1().setGrade(-100);
        allQuestionArray.questionArray[7].getDecision1().setParents(-20);

        allQuestionArray.questionArray[7].getDecision2().setGrade(200);
        allQuestionArray.questionArray[7].getDecision2().setMoney(-500);

        allQuestionArray.questionArray[7].getDecision3().setGrade(-120);

        //----------------------------------------------------------------------------

        allQuestionArray.questionArray[8].getDecision0().setReputation(20);
        allQuestionArray.questionArray[8].getDecision0().setGrade(100);

        allQuestionArray.questionArray[8].getDecision1().setGrade(-100);

        allQuestionArray.questionArray[8].getDecision2().setGrade(250);

        allQuestionArray.questionArray[8].getDecision3().setGrade(-100);
        allQuestionArray.questionArray[8].getDecision3().setParents(-50);

        //----------------------------------------------------------------------------

        allQuestionArray.questionArray[9].getDecision0().setGrade(100);

        allQuestionArray.questionArray[9].getDecision1().setGrade(120);

        allQuestionArray.questionArray[9].getDecision2().setGrade(-150);

        allQuestionArray.questionArray[9].getDecision3().setGrade(-100);

        //----------------------------------------------------------------------------

        allQuestionArray.questionArray[10].getDecision0().setMoney(100);

        allQuestionArray.questionArray[10].getDecision2().setReputation(-500);
        allQuestionArray.questionArray[10].getDecision2().setParents(-500);

        allQuestionArray.questionArray[10].getDecision3().setReputation(100);

        //----------------------------------------------------------------------------

        allQuestionArray.questionArray[11].getDecision0().setReputation(50);
        allQuestionArray.questionArray[11].getDecision0().setParents(-250);
        allQuestionArray.questionArray[11].getDecision0().setMoney(250);

        allQuestionArray.questionArray[11].getDecision1().setParents(-250);
        allQuestionArray.questionArray[11].getDecision1().setMoney(250);

        allQuestionArray.questionArray[11].getDecision2().setParents(-20);

        allQuestionArray.questionArray[11].getDecision3().setReputation(250);
        allQuestionArray.questionArray[11].getDecision3().setGrade(-20);
        allQuestionArray.questionArray[11].getDecision3().setParents(-20);

        //----------------------------------------------------------------------------

        allQuestionArray.questionArray[12].getDecision0().setGrade(-50);

        allQuestionArray.questionArray[12].getDecision1().setGrade(50);

        allQuestionArray.questionArray[12].getDecision2().setReputation(-25);
        allQuestionArray.questionArray[12].getDecision2().setGrade(-50);

        allQuestionArray.questionArray[12].getDecision3().setGrade(-70);

        //----------------------------------------------------------------------------

        allQuestionArray.questionArray[13].getDecision0().setReputation(250);
        allQuestionArray.questionArray[13].getDecision0().setGrade(-250);
        allQuestionArray.questionArray[13].getDecision0().setParents(-50);
        allQuestionArray.questionArray[13].getDecision0().setMoney(-20);

        allQuestionArray.questionArray[13].getDecision1().setReputation(-250);
        allQuestionArray.questionArray[13].getDecision1().setGrade(100);
        allQuestionArray.questionArray[13].getDecision1().setParents(20);

        allQuestionArray.questionArray[13].getDecision2().setReputation(50);
        allQuestionArray.questionArray[13].getDecision2().setGrade(50);
        allQuestionArray.questionArray[13].getDecision2().setMoney(-10);

        allQuestionArray.questionArray[13].getDecision3().setReputation(-50);
        allQuestionArray.questionArray[13].getDecision3().setGrade(-200);
        allQuestionArray.questionArray[13].getDecision3().setParents(-10);
        allQuestionArray.questionArray[13].getDecision3().setMoney(-20);

        //----------------------------------------------------------------------------

        allQuestionArray.questionArray[14].getDecision0().setReputation(100);

        allQuestionArray.questionArray[14].getDecision1().setReputation(-100);

        allQuestionArray.questionArray[14].getDecision2().setReputation(-150);

        //----------------------------------------------------------------------------

        allQuestionArray.questionArray[15].getDecision0().setReputation(-50);

        allQuestionArray.questionArray[15].getDecision1().setReputation(-100);

        allQuestionArray.questionArray[15].getDecision2().setReputation(-150);

        allQuestionArray.questionArray[15].getDecision3().setReputation(-25);


    }
}
