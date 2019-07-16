package com.schober.schoberLife.questions;

public class QuestionDecisionArray {
    public QuestionDecision[] questionDecision;

    public QuestionDecisionArray() {
        this.questionDecision = new QuestionDecision[0];
    }

    public void addQuestionDecision() {
        QuestionDecision[] temp = new QuestionDecision[this.questionDecision.length + 1];

        System.arraycopy(questionDecision, 0, temp, 0, questionDecision.length);

        temp[temp.length - 1] = new QuestionDecision();

        questionDecision = temp;
    }
}
