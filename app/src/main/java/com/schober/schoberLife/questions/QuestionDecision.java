package com.schober.schoberLife.questions;

public class QuestionDecision {
    public final Decision[] decisionArray = new Decision[4];
    private boolean specialQuestion = false;

    QuestionDecision() {
        for (int i = 0; i < decisionArray.length; i++) {
            decisionArray[i] = new Decision();
        }
    }

    public boolean isSpecialQuestion() {
        return specialQuestion;
    }

    public void setSpecialQuestion(boolean specialQuestion) {
        this.specialQuestion = specialQuestion;
    }
}
