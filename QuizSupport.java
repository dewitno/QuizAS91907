import ecs100.*;
import java.util.*;
import java.io.*;
import java.awt.Color;
/**
 * Write a description of class QuizSupport here.
 *
 * @author (your name)
 * @version (a version number or a date)
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
     */
    public QuizSupport(String q, String cAns, String icAns1, String icAns2, String icAns3)
    {
        // initialise instance variables
        this.question = q;
        this.corAns = cAns;
        this.incorAns1 = icAns1;
        this.incorAns2 = icAns1;
        this.incorAns3 = icAns3;
    }

    /**
     * getter method to get question
     */
    public String getQuest()
    {
        return this.question;
    }
    
    /**
     * getter method to get correct answer
     */
    public String getCorAns() {
        return this.corAns;
    }
    
    /**
     * getter method to get incorrect answer 1
     */
    public String getIncorAns1() {
        return this.incorAns1;
    }
    
    /**
     * getter method to get incorrect answer 2
     */
    public String getIncorAns2() {
        return this.incorAns2;
    }
    
    /**
     * getter method to get incorrect answer 3
     */
    public String getIncorAns3() {
        return this.incorAns3;
    }
}
