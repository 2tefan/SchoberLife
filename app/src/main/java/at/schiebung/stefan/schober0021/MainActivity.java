package at.schiebung.stefan.schober0021;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

import timber.log.Timber;

public class MainActivity extends AppCompatActivity
{
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

        questions.init(getResources().getStringArray(R.array.question).length);
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

    public void doNextStep()
    {
        refreshIcons();

        if (!gameOver())
        {
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
        Vars.reputation += questions.questionDecisionArray.questionDecision[Vars.lastQuestion].getDecisionArray()[choice].getReputation();
        Vars.grade += questions.questionDecisionArray.questionDecision[Vars.lastQuestion].getDecisionArray()[choice].getGrade();
        Vars.parents += questions.questionDecisionArray.questionDecision[Vars.lastQuestion].getDecisionArray()[choice].getParents();
        Vars.money += questions.questionDecisionArray.questionDecision[Vars.lastQuestion].getDecisionArray()[choice].getMoney();

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
        int       money    = R.drawable.fail;

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
        else if (Vars.money >= 200)
        {
            money = R.drawable.money_2;
        }
        else if (Vars.money >= 100)
        {
            money = R.drawable.money_1;
        }
        else if (Vars.money >= 0)
        {
            money = R.drawable.money_0;
        }

        imgMoney.setImageResource(money);
    }

    /**
     * Sets the icon of grade according to how much of that is left.
     */
    private void grade()
    {
        ImageView imgGrade = findViewById(R.id.imgGrade);
        int       grade    = R.drawable.fail;

        if (Vars.grade >= 800)
        {
            grade = R.drawable.grade_1;
        }
        else if (Vars.grade >= 600)
        {
            grade = R.drawable.grade_2;
        }
        else if (Vars.grade >= 400)
        {
            grade = R.drawable.grade_3;
        }
        else if (Vars.grade >= 200)
        {
            grade = R.drawable.grade_4;
        }
        else if (Vars.grade >= 0)
        {
            grade = R.drawable.grade_5;
        }

        imgGrade.setImageResource(grade);
    }

    /**
     * Sets the icon of reputation according to how much of that is left.
     */
    private void reputation()
    {
        ImageView imgGrade   = findViewById(R.id.imgReputation);
        int       reputation = R.drawable.fail;

        if (Vars.reputation >= 850)
        {
            reputation = R.drawable.reputation_6;
        }
        else if (Vars.reputation >= 700)
        {
            reputation = R.drawable.reputation_5;
        }
        else if (Vars.reputation >= 550)
        {
            reputation = R.drawable.reputation_4;
        }
        else if (Vars.reputation >= 400)
        {
            reputation = R.drawable.reputation_3;
        }
        else if (Vars.reputation >= 250)
        {
            reputation = R.drawable.reputation_2;
        }
        else if (Vars.reputation >= 100)
        {
            reputation = R.drawable.reputation_1;
        }
        else if (Vars.reputation >= 0)
        {
            reputation = R.drawable.reputation_0;
        }

        imgGrade.setImageResource(reputation);
    }

    /**
     * Sets the icon of parents according to how much of that is left.
     */
    private void parents()
    {
        ImageView imgMoney = findViewById(R.id.imgParents);
        int       parents  = R.drawable.fail;


        if (Vars.parents >= 750)
        {
            parents = R.drawable.parents_3;
        }
        else if (Vars.parents >= 500)
        {
            parents = R.drawable.parents_2;
        }
        else if (Vars.parents >= 250)
        {
            parents = R.drawable.parents_1;
        }
        else if (Vars.parents >= 0)
        {
            parents = R.drawable.parents_0;
        }

        imgMoney.setImageResource(parents);
    }

    /**
     * Displays a new Question and the choices correlating to it.
     */
    private void showNewQuestion()
    {
        Resources res = getResources();
        Random    rng = new Random();

        String[] question = res.getStringArray(R.array.question);
        int      pickedQuestion;
        do
        {
            pickedQuestion = rng.nextInt(question.length);
        } while (Vars.lastQuestion == pickedQuestion);

        Vars.lastQuestion = pickedQuestion;

        TextView txtQuestion = findViewById(R.id.txtQuestion);
        txtQuestion.setText(question[Vars.lastQuestion]);

        String[] choice1    = res.getStringArray(R.array.choice1);
        TextView btnChoice1 = findViewById(R.id.btnChoice1);
        btnChoice1.setText(choice1[Vars.lastQuestion]);

        String[] choice2    = res.getStringArray(R.array.choice2);
        TextView btnChoice2 = findViewById(R.id.btnChoice2);
        btnChoice2.setText(choice2[Vars.lastQuestion]);

        String[] choice3    = res.getStringArray(R.array.choice3);
        TextView btnChoice3 = findViewById(R.id.btnChoice3);
        btnChoice3.setText(choice3[Vars.lastQuestion]);

        String[] choice4    = res.getStringArray(R.array.choice4);
        TextView btnChoice4 = findViewById(R.id.btnChoice4);
        btnChoice4.setText(choice4[Vars.lastQuestion]);
    }

    /**
     * Returns if the game is over.
     *
     * @return If the game is over.
     */
    private boolean gameOver()
    {
        return Vars.reputation < 0 || Vars.grade < 0 || Vars.parents < 0 || Vars.money < 0;
    }

    /**
     * Shows the game over screen.
     */
    private void showGameOverScreen(boolean gom)
    {
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

        if (Vars.reputation < 0)
        {
            gameOverMessage = res.getStringArray(R.array.GOMReputation);
        }
        if (Vars.grade < 0)
        {
            gameOverMessage = res.getStringArray(R.array.GOMGrade);
        }
        if (Vars.parents < 0)
        {
            gameOverMessage = res.getStringArray(R.array.GOMParents);
        }
        if (Vars.money < 0)
        {
            gameOverMessage = res.getStringArray(R.array.GOMMoney);
        }

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
            if (answer[Vars.lastQuestion].equals(""))
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
            output = answer[Vars.lastQuestion];
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

        switchConstraintLayouts(welcomeMessage, clWelcome, clChoices);
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
