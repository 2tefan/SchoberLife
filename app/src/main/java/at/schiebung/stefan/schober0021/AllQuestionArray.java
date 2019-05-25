package at.schiebung.stefan.schober0021;

public class AllQuestionArray
{
    QuestionArray[] questionArray = new QuestionArray[0];

    public void init(int countQuestions)
    {
        questionArray = new QuestionArray[countQuestions];
        for (int i = 0; i < questionArray.length; i++)
        {
            questionArray[i] = new QuestionArray();
            questionArray[i].init();
        }
    }
    public void addToQuestionArray(QuestionArray array)
    {
        QuestionArray[] temp = new QuestionArray[questionArray.length + 1];
        temp[temp.length - 1] = array;

        System.arraycopy(temp, 0, questionArray, 0, questionArray.length);
    }
}
