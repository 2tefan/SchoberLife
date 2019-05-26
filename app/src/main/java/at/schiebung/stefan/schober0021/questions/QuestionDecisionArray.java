package at.schiebung.stefan.schober0021.questions;

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
    public void addToQuestionArray(QuestionDecision array)
    {
        QuestionDecision[] temp = new QuestionDecision[questionDecision.length + 1];
        temp[temp.length - 1] = array;

        System.arraycopy(temp, 0, questionDecision, 0, questionDecision.length);
    }
}
