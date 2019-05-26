package at.schiebung.stefan.schober0021.questions;

public class QuestionDecision
{
    private Decision[] decisionArray = new Decision[4];

    void init()
    {
        for (int i = 0; i < decisionArray.length; i++)
        {
            decisionArray[i] = new Decision();
        }
    }

    public Decision getDecision0()
    {
        return decisionArray[0];
    }
    public Decision getDecision1()
    {
        return decisionArray[1];
    }
    public Decision getDecision2()
    {
        return decisionArray[2];
    }
    public Decision getDecision3()
    {
        return decisionArray[3];
    }
    public Decision[] getDecisionArray()
    {
        return decisionArray;
    }
    public void setDecisionArray(Decision[] decisionArray)
    {
        this.decisionArray = decisionArray;
    }
}
