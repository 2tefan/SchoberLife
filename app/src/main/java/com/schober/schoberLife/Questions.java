package com.schober.schoberLife;

import android.content.Context;

import com.schober.schoberLife.questions.Decision;
import com.schober.schoberLife.questions.QuestionDecision;
import com.schober.schoberLife.questions.QuestionDecisionArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import timber.log.Timber;

class Questions {

    private QuestionDecisionArray questionDecisionArray;
    //Beliebtheit - Note - Eltern - Geld

    int currentQuestion;
    int currentDecision;

    Decision getCurrentDecision() {
        return questionDecisionArray.questionDecision[currentQuestion].getDecisionArray()[currentDecision];
    }

    QuestionDecision getQuestion(int questionID) {
        return questionDecisionArray.questionDecision[questionID];
    }


    void importQuestionsFromCSV(Context context) {
        questionDecisionArray = new QuestionDecisionArray(context.getResources().getStringArray(R.array.question).length);

        InputStream inputStream = context.getResources().openRawResource(R.raw.questions_values);

        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        try {
            @SuppressWarnings("UnusedAssignment") String csvLine = reader.readLine(); // Skip first Line

            while ((csvLine = reader.readLine()) != null) {
                String[] row = csvLine.split(",");

                try {
                    questionDecisionArray.questionDecision[Integer.parseInt(row[0])].decisionArray[Integer.parseInt(row[1])].setReputation(Integer.parseInt(row[3]));
                } catch (Exception e) {
                    Timber.i("Using default Value for Q:" + row[0] + " D:" + row[1] + " Reputation");
                }
                try {
                    questionDecisionArray.questionDecision[Integer.parseInt(row[0])].decisionArray[Integer.parseInt(row[1])].setGrade(Integer.parseInt(row[4]));
                } catch (Exception e) {
                    Timber.i("Using default Value for Q:" + row[0] + " D:" + row[1] + " Grade");
                }
                try {
                    questionDecisionArray.questionDecision[Integer.parseInt(row[0])].decisionArray[Integer.parseInt(row[1])].setParents(Integer.parseInt(row[5]));
                } catch (Exception e) {
                    Timber.i("Using default Value for Q:" + row[0] + " D:" + row[1] + " Parents");
                }
                try {
                    questionDecisionArray.questionDecision[Integer.parseInt(row[0])].decisionArray[Integer.parseInt(row[1])].setMoney(Integer.parseInt(row[6]));
                } catch (Exception e) {
                    Timber.i("Using default Value for Q:" + row[0] + " D:" + row[1] + " Money");
                }
                try {
                    if (row[7] != null) {
                        questionDecisionArray.questionDecision[Integer.parseInt(row[0])].setSpecialQuestion(true);
                    }
                } catch (Exception e) {
                    Timber.i("Using default Value for Q:" + row[0] + " D:" + row[1] + " SpecialQuestion");
                }
                try {
                    questionDecisionArray.questionDecision[Integer.parseInt(row[0])].decisionArray[Integer.parseInt(row[1])].setNextQuestion(Integer.parseInt(row[8]));
                } catch (Exception e) {
                    Timber.i("Using default Value for Q:" + row[0] + " D:" + row[1] + " NextQuestion");
                }
                try {
                    if (row[9] != null) {
                        questionDecisionArray.questionDecision[Integer.parseInt(row[0])].decisionArray[Integer.parseInt(row[1])].setSuicide(true);
                    }
                } catch (Exception e) {
                    Timber.i("Using default Value for Q:" + row[0] + " D:" + row[1] + " Suicide");
                }
            }
        } catch (IOException ex) {
            throw new RuntimeException("Error in reading CSV file: " + ex);
        }
        try {
            inputStream.close();
        } catch (IOException e) {
            throw new RuntimeException("Error while closing input stream: " + e);
        }
    }
}
