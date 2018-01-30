package in.nitjsr.ojass.Modals;

/**
 * Created by Aditya on 08-02-2017.
 */

public class FaqModel {

    String question,ans;


    public FaqModel(String question, String ans) {

        this.question=question;
        this.ans=ans;


    }
    public FaqModel()
    {

    }

    public String getAns() {
        return ans;
    }

    public String getQuestion() {
        return question;
    }
}
