package com.schober.schoberLife.questions;

import java.util.ArrayList;

public class QuestionDecision {
    public final Decision[] decisionArray = new Decision[4];
    private boolean specialQuestion = false;

    QuestionDecision() {

        for (int i = 0; i < decisionArray.length; i++) {
            decisionArray[i] = new Decision();
        }
    }

    public Decision getDecision1() {
        return decisionArray[0];
    }

    public Decision getDecision2() {
        return decisionArray[1];
    }

    public Decision getDecision3() {
        return decisionArray[2];
    }

    public Decision getDecision4() {
        return decisionArray[3];
    }

    public Decision[] getDecisionArray() {
        return decisionArray;
    }

    public boolean isSpecialQuestion() {
        return specialQuestion;
    }

    public void setSpecialQuestion(boolean specialQuestion) {
        this.specialQuestion = specialQuestion;
    }
}
