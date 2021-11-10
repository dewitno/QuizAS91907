import ecs100.*;
import java.util.*;
import java.io.*;
import java.awt.Color;
/**
 * QuizSupport class
 *
 * @author dewitno
 * @version V.5
 */
public class QuizSupport
{
    // instance variables
    private String question;
    private String corAns;
    private String incorAns1;
    private String incorAns2;
    private String incorAns3;

    /**
     * Constructor for objects of class QuizSupport
     * @param q from QuizDriver
     * @param cAns from QuizDriver
     * @param icAns1 from QuizDriver
     * @param icAns2 from QuizDriver
     * @param icAns3 from QuizDriver
     */
    public QuizSupport(String q, String cAns, String icAns1, 
        String icAns2, String icAns3)
    {
        // initialise instance variables
        this.question = q;
        this.corAns = cAns;
        this.incorAns1 = icAns1;
        this.incorAns2 = icAns2;
        this.incorAns3 = icAns3;
    }

    /**
     * getter method to get question
     * @return question
     */
    public String getQuest()
    {
        return this.question;
    }
    
    /**
     * getter method to get correct answer
     * @return corAns
     */
    public String getCorAns() {
        return this.corAns;
    }
    
    /**
     * getter method to get incorrect answer 1
     * @return incorAns1
     */
    public String getIncorAns1() {
        return this.incorAns1;
    }
    
    /**
     * getter method to get incorrect answer 2
     * @return incorAns2
     */
    public String getIncorAns2() {
        return this.incorAns2;
    }
    
    /**
     * getter method to get incorrect answer 3
     * @return incorAns3
     */
    public String getIncorAns3() {
        return this.incorAns3;
    }
}
