package com.schober.schoberLife;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.schober.schoberLife.questions.Decision;

import java.util.Random;

import timber.log.Timber;

public class MainActivity extends AppCompatActivity
{
    private       boolean   gameOver  = false;
    private final Questions questions = new Questions();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (BuildConfig.DEBUG)
        {
            Timber.plant(new Timber.DebugTree());
        }

        questions.importQuestionsFromCSV(this);

        Saves.loadSaves(this);

        showGameOverScreen(false);
        welcomeMessage(!Vars.loadedSave);
        doNextStep();
    }

    @Override
    public void onPause()
    {
        super.onPause();
    }

    public void choice1(View V)
    {
        evaluate(0);
    }

    public void choice2(View V)
    {
        evaluate(1);
    }

    public void choice3(View V)
    {
        evaluate(2);
    }

    public void choice4(View V)
    {
        evaluate(3);
    }

    /**
     * fab = floating Action Button
     * To Make the welcome screen disappear and the choice screen appear.
     *
     * @param V For android:click
     */
    public void closeWelcomeScreen(View V)
    {
        welcomeMessage(false);
    }

    public void resetGame(View V)
    {
        Vars.resetToDefaults();
        showGameOverScreen(false);
        doNextStep();
    }

    /**
     * Shows the acknowledge view.
     *
     * @param V For android:click
     */
    public void btnAcknowledge(View V)
    {
        switchButtons();
        doNextStep();
    }
    /**
     * Decides if the game show go on, or if a game over screen should be shown.
     */
    private void doNextStep()
    {
        refreshIcons();

        if (!gameOver())
        {
            gameOver = false;
            showNewQuestion();
        }
        else
        {
            showGameOverScreen(true);
        }
    }

    /**
     * Calculates all values.
     *
     * @param choice The choice the player took.
     */
    private void evaluate(int choice)
    {
        questions.currentDecision = choice;

        Vars.reputation += questions.getCurrentDecision().getReputation();
        Vars.grade += questions.getCurrentDecision().getGrade();
        Vars.parents += questions.getCurrentDecision().getParents();
        Vars.money += questions.getCurrentDecision().getMoney();

        showAnswer(choice);
        refreshIcons();
    }

    /**
     * Sets all icons.
     */
    private void refreshIcons()
    {
        money();
        grade();
        reputation();
        parents();
        Saves.saveSaves(this);
    }

    /**
     * Sets the icon of money according to how much of that is left.
     */
    private void money()
    {
        ImageView imgMoney = findViewById(R.id.imgMoney);
        int       money    = R.drawable.money_0;

        if (Vars.money >= 900)
        {
            money = R.drawable.money_9;
        }
        else if (Vars.money >= 800)
        {
            money = R.drawable.money_8;
        }
        else if (Vars.money >= 700)
        {
            money = R.drawable.money_7;
        }
        else if (Vars.money >= 600)
        {
            money = R.drawable.money_6;
        }
        else if (Vars.money >= 500)
        {
            money = R.drawable.money_5;
        }
        else if (Vars.money >= 400)
        {
            money = R.drawable.money_4;
        }
        else if (Vars.money >= 300)
        {
            money = R.drawable.money_3;
        }
        else if (Vars.money >= 150)
        {
            money = R.drawable.money_2;
        }
        else if (Vars.money >= 0)
        {
            money = R.drawable.money_1;
        }

        imgMoney.setImageResource(money);
    }

    /**
     * Sets the icon of grade according to how much of that is left.
     */
    private void grade()
    {
        ImageView imgGrade = findViewById(R.id.imgGrade);
        int       grade    = R.drawable.grade_0;

        if (Vars.grade >= 800)
        {
            grade = R.drawable.grade_5;
        }
        else if (Vars.grade >= 600)
        {
            grade = R.drawable.grade_4;
        }
        else if (Vars.grade >= 400)
        {
            grade = R.drawable.grade_3;
        }
        else if (Vars.grade >= 200)
        {
            grade = R.drawable.grade_2;
        }
        else if (Vars.grade >= 0)
        {
            grade = R.drawable.grade_1;
        }

        imgGrade.setImageResource(grade);
    }

    /**
     * Sets the icon of reputation according to how much of that is left.
     */
    private void reputation()
    {
        ImageView imgGrade   = findViewById(R.id.imgReputation);
        int       reputation = R.drawable.reputation_0;

        if (Vars.reputation >= 800)
        {
            reputation = R.drawable.reputation_6;
        }
        else if (Vars.reputation >= 600)
        {
            reputation = R.drawable.reputation_5;
        }
        else if (Vars.reputation >= 450)
        {
            reputation = R.drawable.reputation_4;
        }
        else if (Vars.reputation >= 300)
        {
            reputation = R.drawable.reputation_3;
        }
        else if (Vars.reputation >= 150)
        {
            reputation = R.drawable.reputation_2;
        }
        else if (Vars.reputation >= 0)
        {
            reputation = R.drawable.reputation_1;
        }

        imgGrade.setImageResource(reputation);
    }

    /**
     * Sets the icon of parents according to how much of that is left.
     */
    private void parents()
    {
        ImageView imgMoney = findViewById(R.id.imgParents);
        int       parents  = R.drawable.parents_0;


        if (Vars.parents >= 700)
        {
            parents = R.drawable.parents_3;
        }
        else if (Vars.parents >= 350)
        {
            parents = R.drawable.parents_2;
        }
        else if (Vars.parents >= 0)
        {
            parents = R.drawable.parents_1;
        }

        imgMoney.setImageResource(parents);
    }

    /**
     * Displays a new Question and the choices correlating to it.
     */
    private void showNewQuestion()
    {
        Resources res = getResources();

        if (questions.getCurrentDecision().getNextQuestion() == Decision.NO_NEXT_QUESTION)
        {
            getNewQuestion();
        }
        else
        {
            questions.currentQuestion = questions.getCurrentDecision().getNextQuestion();
        }

        TextView txtQuestion = findViewById(R.id.txtQuestion);
        txtQuestion.setText(getResources().getStringArray(R.array.question)[questions.currentQuestion]);

        String[] choice1    = res.getStringArray(R.array.choice1);
        TextView btnChoice1 = findViewById(R.id.btnChoice1);
        btnChoice1.setText(choice1[questions.currentQuestion]);

        String[] choice2    = res.getStringArray(R.array.choice2);
        TextView btnChoice2 = findViewById(R.id.btnChoice2);
        btnChoice2.setText(choice2[questions.currentQuestion]);

        String[] choice3    = res.getStringArray(R.array.choice3);
        TextView btnChoice3 = findViewById(R.id.btnChoice3);
        btnChoice3.setText(choice3[questions.currentQuestion]);

        String[] choice4    = res.getStringArray(R.array.choice4);
        TextView btnChoice4 = findViewById(R.id.btnChoice4);
        btnChoice4.setText(choice4[questions.currentQuestion]);
    }

    private void getNewQuestion()
    {
        String[] question = getResources().getStringArray(R.array.question);
        Random   rng      = new Random();

        int pickedQuestion;
        do
        {
            pickedQuestion = rng.nextInt(question.length);
        } while (questions.currentQuestion == pickedQuestion || questions.getQuestion(pickedQuestion).isSpecialQuestion());

        questions.currentQuestion = pickedQuestion;
    }

    /**
     * Returns if the game is over.
     *
     * @return If the game is over.
     */
    private boolean gameOver()
    {
        return !gameOver && (Vars.reputation < 0 || Vars.grade < 0 || Vars.parents < 0 || Vars.money < 0 || questions.getCurrentDecision().isSuicide());
    }

    /**
     * Shows the game over screen.
     */
    private void showGameOverScreen(boolean gom)
    {
        gameOver = true;
        ConstraintLayout clGOM     = findViewById(R.id.includeGameOverScreen);
        ConstraintLayout clChoices = findViewById(R.id.includeChoices);
        switchConstraintLayouts(gom, clGOM, clChoices);
        generateGameOverMessage();
    }

    /**
     * Picks a game over message depending on how you lost the game.
     */
    private void generateGameOverMessage()
    {
        Resources res             = getResources();
        Random    rng             = new Random();
        String[]  gameOverMessage = res.getStringArray(R.array.standardGOM);
        ImageView gop             = findViewById(R.id.imgGOP);
        int       picture         = R.drawable.gop_grade;

        if (Vars.reputation < 0)
        {
            gameOverMessage = res.getStringArray(R.array.GOMReputation);
            picture = R.drawable.gop_suicide;
        }
        if (Vars.grade < 0)
        {
            gameOverMessage = res.getStringArray(R.array.GOMGrade);
            picture = R.drawable.gop_grade;
        }
        if (Vars.parents < 0)
        {
            gameOverMessage = res.getStringArray(R.array.GOMParents);
            picture = R.drawable.gop_parents;
        }
        if (Vars.money < 0)
        {
            gameOverMessage = res.getStringArray(R.array.GOMMoney);
            picture = R.drawable.gop_money;
        }
        if (Vars.reputation < 0 && Vars.grade < 0)
        {
            gameOverMessage = res.getStringArray(R.array.GOMReputationAndGrade);
            picture = R.drawable.gop_grade;
        }
        if (Vars.reputation < 0 && Vars.parents < 0)
        {
            gameOverMessage = res.getStringArray(R.array.GOMReputationAndParents);
            picture = R.drawable.gop_grade;
        }
        if (Vars.reputation < 0 && Vars.money < 0)
        {
            gameOverMessage = res.getStringArray(R.array.GOMReputationAndMoney);
            picture = R.drawable.gop_money;
        }
        if (Vars.grade < 0 && Vars.parents < 0)
        {
            gameOverMessage = res.getStringArray(R.array.GOMGradeAndParents);
            picture = R.drawable.gop_grade;
        }
        if (Vars.grade < 0 && Vars.money < 0)
        {
            gameOverMessage = res.getStringArray(R.array.GOMGradeAndMoney);
            picture = R.drawable.gop_grade;
        }
        if (Vars.parents < 0 && Vars.money < 0)
        {
            gameOverMessage = res.getStringArray(R.array.GOMParentsAndMoney);
            picture = R.drawable.gop_parents;
        }
        if (Vars.reputation < 0 && Vars.grade < 0 && Vars.parents < 0)
        {
            gameOverMessage = res.getStringArray(R.array.GOMReputationAndGradeAndParents);
            picture = R.drawable.gop_grade;
        }
        if (Vars.reputation < 0 && Vars.grade < 0 && Vars.money < 0)
        {
            gameOverMessage = res.getStringArray(R.array.GOMReputationAndGradeAndMoney);
            picture = R.drawable.gop_grade;
        }
        if (Vars.reputation < 0 && Vars.parents < 0 && Vars.money < 0)
        {
            gameOverMessage = res.getStringArray(R.array.GOMReputationAndParentsAndMoney);
            picture = R.drawable.gop_parents;
        }
        if (Vars.grade < 0 && Vars.parents < 0 && Vars.money < 0)
        {
            gameOverMessage = res.getStringArray(R.array.GOMGradeAndParentsAndMoney);
            picture = R.drawable.gop_parents;
        }
        if (Vars.reputation < 0 && Vars.grade < 0 && Vars.parents < 0 && Vars.money < 0)
        {
            gameOverMessage = res.getStringArray(R.array.GOMReputationAndGradeAndParentsAndMoney);
            picture = R.drawable.gop_suicide;
        }
        if (questions.getCurrentDecision().isSuicide())
        {
            gameOverMessage = res.getStringArray(R.array.GOMsuiced);
            picture = R.drawable.gop_suicide;
        }

        gop.setImageResource(picture);

        int pickedGOM = rng.nextInt(gameOverMessage.length);

        TextView txtGOM = findViewById(R.id.txtGameOverMessage);
        txtGOM.setText(gameOverMessage[pickedGOM]);
    }

    /**
     * Gives a respond to the choice the user made.
     *
     * @param choice The choice, that was chosen by the user.
     */
    private void showAnswer(int choice)
    {
        TextView answers = findViewById(R.id.txtQuestion);

        String[] answer = {};
        switch (choice)
        {
            case 0:
                answer = getResources().getStringArray(R.array.answer1);
                break;
            case 1:
                answer = getResources().getStringArray(R.array.answer2);
                break;
            case 2:
                answer = getResources().getStringArray(R.array.answer3);
                break;
            case 3:
                answer = getResources().getStringArray(R.array.answer4);
                break;
        }
        String  output;
        boolean defaultAnswer = false;


        try
        {
            if (answer[questions.currentQuestion].equals(""))
            {
                defaultAnswer = true;
            }
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            defaultAnswer = true;
        }

        if (defaultAnswer)
        {
            Random   rng            = new Random();
            int      answerIndex;
            String[] defaultAnswers = getResources().getStringArray(R.array.defaultAnswers);
            answerIndex = rng.nextInt(defaultAnswers.length);
            output = defaultAnswers[answerIndex];
        }
        else
        {
            output = answer[questions.currentQuestion];
        }


        answers.setText(output);

        switchButtons();
    }

    /**
     * Makes the choice-buttons invisible/visible and the ack-button visible/invisible.
     */
    private void switchButtons()
    {
        TextView btnChoice1     = findViewById(R.id.btnChoice1);
        TextView btnChoice2     = findViewById(R.id.btnChoice2);
        TextView btnChoice3     = findViewById(R.id.btnChoice3);
        TextView btnChoice4     = findViewById(R.id.btnChoice4);
        TextView btnAcknowledge = findViewById(R.id.btnAcknowledge);

        if (btnAcknowledge.getVisibility() == View.VISIBLE)
        {
            btnChoice1.setVisibility(View.VISIBLE);
            btnChoice2.setVisibility(View.VISIBLE);
            btnChoice3.setVisibility(View.VISIBLE);
            btnChoice4.setVisibility(View.VISIBLE);
            btnAcknowledge.setVisibility(View.GONE);
        }
        else
        {
            btnChoice1.setVisibility(View.GONE);
            btnChoice2.setVisibility(View.GONE);
            btnChoice3.setVisibility(View.GONE);
            btnChoice4.setVisibility(View.GONE);
            btnAcknowledge.setVisibility(View.VISIBLE);
        }
    }

    /**
     * Makes the welcome message visible and gone, depending on the boolean.
     *
     * @param welcomeMessage true = message will show.
     */
    private void welcomeMessage(boolean welcomeMessage)
    {
        ConstraintLayout clWelcome = findViewById(R.id.includeWelcomeLayout);
        ConstraintLayout clChoices = findViewById(R.id.includeChoices);
        ConstraintLayout mainCL    = findViewById(R.id.mainCL);

        switchConstraintLayouts(welcomeMessage, clWelcome, clChoices);

        if (welcomeMessage)
        {
            mainCL.setBackground(getResources().getDrawable(R.drawable.welcome_screen_bg));
        }
        else
        {
            mainCL.setBackground(getResources().getDrawable(R.drawable.background));
        }
    }

    /**
     * Makes a ConstraintLayout visible/gone.
     *
     * @param showFirst Decides if the first ConstraintLayout will be shown or the second ConstraintLayout.
     * @param firstCL   The first ConstraintLayout.
     * @param secondCL  The second ConstraintLayout.
     */
    private void switchConstraintLayouts(boolean showFirst, ConstraintLayout firstCL, ConstraintLayout secondCL)
    {
        if (showFirst)
        {
            firstCL.setVisibility(View.VISIBLE);
            secondCL.setVisibility(View.GONE);
        }
        else
        {
            firstCL.setVisibility(View.GONE);
            secondCL.setVisibility(View.VISIBLE);
        }
    }
}
