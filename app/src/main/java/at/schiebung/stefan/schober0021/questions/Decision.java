package at.schiebung.stefan.schober0021.questions;

public class Decision
{
    //Beliebtheit - Note - Eltern - Geld
    private int reputation = 0;
    private int grade      = 0;
    private int parents    = 0;
    private int money      = 0;

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
}
