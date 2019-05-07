package at.schiebung.stefan.schober0021;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity
{
    at.schiebung.stefan.schober0021.Methoden methoden = new at.schiebung.stefan.schober0021.Methoden();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources res     = getResources();
        String[]  aufgabe = res.getStringArray(R.array.aufgabe);
        methoden.werte(aufgabe.length);

        frage();
    }

    public void choise1(View V)
    {
        auswerten(0);
    }

    public void choise2(View V)
    {
        auswerten(1);
    }

    public void choise3(View V)
    {
        auswerten(2);
    }

    public void choise4(View V)
    {
        auswerten(3);
    }

    public void btnAcknowledge(View V)
    {
        switchButtons();
        frage();
    }

    public void auswerten(int choise)
    {
        Vars.reputation += Vars.change[Vars.frage][choise][0];
        Vars.grade += Vars.change[Vars.frage][choise][1];
        Vars.parents += Vars.change[Vars.frage][choise][2];
        Vars.money += Vars.change[Vars.frage][choise][3];

        antwort(choise);
        stats();
    }

    public void stats()
    {
        money();
        grade();
        reputation();
        parents();
    }

    public void money()
    {
        ImageView imgMoney = findViewById(R.id.img_money);
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

    public void grade()
    {
        ImageView imgGrade = findViewById(R.id.img_grade);
        int       grade    = R.drawable.grade_5;

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

    public void reputation()
    {
        ImageView imgGrade   = findViewById(R.id.img_reputation);
        int       reputation = R.drawable.reputation_0;

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

    public void parents()
    {
        ImageView imgMoney = findViewById(R.id.img_parents);
        int       parents  = R.drawable.parents_0;


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

    public void frage()
    {
        Resources res = getResources();
        Random    rng = new Random();

        String[] aufgabe = res.getStringArray(R.array.aufgabe);
        int      frage;
        do
        {
            frage = rng.nextInt(aufgabe.length-1);
        } while (Vars.frage == frage);
        Vars.frage = frage;

        TextView txtAufgabe = findViewById(R.id.txtAufgabe);
        txtAufgabe.setText(aufgabe[Vars.frage]);

        String[] choise1    = res.getStringArray(R.array.choise1);
        TextView btnChoise1 = findViewById(R.id.btnChoise1);
        btnChoise1.setText(choise1[Vars.frage]);

        String[] choise2    = res.getStringArray(R.array.choise2);
        TextView btnChoise2 = findViewById(R.id.btnChoise2);
        btnChoise2.setText(choise2[Vars.frage]);

        String[] choise3    = res.getStringArray(R.array.choise3);
        TextView btnChoise3 = findViewById(R.id.btnChoise3);
        btnChoise3.setText(choise3[Vars.frage]);

        String[] choise4    = res.getStringArray(R.array.choise4);
        TextView btnChoise4 = findViewById(R.id.btnChoise4);
        btnChoise4.setText(choise4[Vars.frage]);
    }

    public void antwort(int choise)
    {
        TextView ausgabe = findViewById(R.id.txtAufgabe);

        String[] answer = {};
        switch (choise)
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
        String output;
        try
        {
            output = answer[Vars.frage];
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            Random   rng            = new Random();
            int      wert;
            String[] defaultAnswers = getResources().getStringArray(R.array.defaultAnswers);
            wert = rng.nextInt(defaultAnswers.length - 1);
            output = defaultAnswers[wert];
        }
        ausgabe.setText(output);

        switchButtons();
    }

    public void switchButtons()
    {
        TextView btnChoise1     = findViewById(R.id.btnChoise1);
        TextView btnChoise2     = findViewById(R.id.btnChoise2);
        TextView btnChoise3     = findViewById(R.id.btnChoise3);
        TextView btnChoise4     = findViewById(R.id.btnChoise4);
        TextView btnAcknowledge = findViewById(R.id.btnAcknowledge);

        if (btnAcknowledge.getVisibility() == View.VISIBLE)
        {
            btnChoise1.setVisibility(View.VISIBLE);
            btnChoise2.setVisibility(View.VISIBLE);
            btnChoise3.setVisibility(View.VISIBLE);
            btnChoise4.setVisibility(View.VISIBLE);
            btnAcknowledge.setVisibility(View.GONE);
        }
        else
        {
            btnChoise1.setVisibility(View.GONE);
            btnChoise2.setVisibility(View.GONE);
            btnChoise3.setVisibility(View.GONE);
            btnChoise4.setVisibility(View.GONE);
            btnAcknowledge.setVisibility(View.VISIBLE);
        }
    }
}
