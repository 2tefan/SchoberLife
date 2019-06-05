package at.schiebung.stefan.schoberLive.questions;

public class Decision
{
    public static final int     NO_NEXT_QUESTION = -1;
    //Beliebtheit - Note - Eltern - Geld
    private             int     reputation       = 0;
    private             int     grade            = 0;
    private             int     parents          = 0;
    private             int     money            = 0;
    private             boolean suicide          = false;
    private             int     nextQuestion     = NO_NEXT_QUESTION;


    public int getReputation()
    {
        return reputation;
    }
    public void setReputation(int reputation)
    {
        this.reputation = reputation;
    }
    public int getGrade()
    {
        return grade;
    }
    public void setGrade(int grade)
    {
        this.grade = grade;
    }
    public int getParents()
    {
        return parents;
    }
    public void setParents(int parents)
    {
        this.parents = parents;
    }
    public int getMoney()
    {
        return money;
    }
    public void setMoney(int money)
    {
        this.money = money;
    }
    public boolean isSuicide()
    {
        return suicide;
    }
    public void setSuicide(boolean suicide)
    {
        this.suicide = suicide;
    }
    public int getNextQuestion()
    {
        return nextQuestion;
    }
    public void setNextQuestion(int nextQuestion)
    {
        this.nextQuestion = nextQuestion;
    }
}
