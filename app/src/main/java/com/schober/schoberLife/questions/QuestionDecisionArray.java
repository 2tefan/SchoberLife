package com.schober.schoberLife.questions;

public class QuestionDecisionArray {
    public QuestionDecision[] questionDecision = new QuestionDecision[0];

    public QuestionDecisionArray(int countQuestions) {
        questionDecision = new QuestionDecision[countQuestions];
        for (int i = 0; i < questionDecision.length; i++) {
            questionDecision[i] = new QuestionDecision();
        }
    }
}
