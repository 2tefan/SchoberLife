package com.schober.schoberLife.questions;

public class QuestionDecisionArray
{
    public QuestionDecision[] questionDecision = new QuestionDecision[0];

    public void init(int countQuestions)
    {
        questionDecision = new QuestionDecision[countQuestions];
        for (int i = 0; i < questionDecision.length; i++)
        {
            questionDecision[i] = new QuestionDecision();
            questionDecision[i].init();
        }
    }
}
