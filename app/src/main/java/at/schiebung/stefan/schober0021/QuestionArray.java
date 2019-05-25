package at.schiebung.stefan.schober0021;

public class QuestionArray
{
    private Question[] questionArray = new Question[4];

    public void init()
    {
        for (int i = 0; i < questionArray.length; i++)
        {
            questionArray[i] = new Question();
        }
    }

    public Question getDecision0()
    {
        return questionArray[0];
    }
    public Question getDecision1()
    {
        return questionArray[1];
    }
    public Question getDecision2()
    {
        return questionArray[2];
    }
    public Question getDecision3()
    {
        return questionArray[3];
    }
    public Question[] getQuestionArray()
    {
        return questionArray;
    }
    public void setQuestionArray(Question[] questionArray)
    {
        this.questionArray = questionArray;
    }
}
