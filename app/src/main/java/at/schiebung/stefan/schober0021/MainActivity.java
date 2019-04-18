package at.schiebung.stefan.schober0021;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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

	public void auswerten(int choise)
	{
		Vars.reputation += Vars.change[Vars.frage][choise][0];
		Vars.grade += Vars.change[Vars.frage][choise][1];
		Vars.parents += Vars.change[Vars.frage][choise][2];
		Vars.money += Vars.change[Vars.frage][choise][3];

		bilder();
	}

	public void bilder()
	{
		money();
		grade();

		frage();
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

	public void frage()
	{
		Resources res = getResources();
		Random    rng = new Random();

		String[] aufgabe = res.getStringArray(R.array.aufgabe);
		int      frage;
		do
		{
			frage = rng.nextInt(aufgabe.length);
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
}
