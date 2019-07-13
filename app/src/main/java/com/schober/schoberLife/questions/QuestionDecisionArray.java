package com.schober.schoberLife.questions;

public class QuestionDecisionArray {
    public final QuestionDecision[] questionDecision;

    public QuestionDecisionArray(int countQuestions) {
        questionDecision = new QuestionDecision[countQuestions];
        for (int i = 0; i < questionDecision.length; i++) {
            questionDecision[i] = new QuestionDecision();
        }
    }
}
