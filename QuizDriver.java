import ecs100.*;
import java.util.*;
import java.io.*;
import java.awt.Color;
import java.util.HashMap;
/**
 * Write a description of class QuizDriver here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class QuizDriver
{
    // instance variables 
    private HashMap<Integer, QuizSupport> quiz;
    private String question;
    private String corAns;
    private String[] questions;
    private String[] corAnswers;
    private String[] incorAnswers;
    private int[] qNumbers = {1, 2, 3, 4, 5, 6, 7, 8};
    private boolean correct;
    
    // constant variables
    private int INCARRAYMAX = 24;
    private int ARRAYMAX = 8;
    /**
     * Constructor for objects of class QuizDriver
     */
    public QuizDriver()
    {
        // initialise instance variables
        quiz = new HashMap<Integer, QuizSupport>();
        // questions and answers
        QuizSupport q1 = new QuizSupport("What worldwide used food became orange as a tribute to William of Orange, who led the struggle for Dutch independence?", 
        "Carrots", "Pumpkins", "Tangerines", "Capsicums");
        QuizSupport q2 = new QuizSupport("Belgium, Luxembourg and the Netherlands used to be part of the United Kingdom of the Netherlands before splitting off during the Belgium Revolution. When did that revolution happen?", 
        "1830-1839", "1800-1830", "1780-1650", "1600-2000");
        QuizSupport q3 = new QuizSupport("How much of the land in the Netherlands is below sea level?", "A third", "A half", "5/7ths", "All of it");
        QuizSupport q4 = new QuizSupport("What is the length of the Elfstedentocht?","135 miles","200 miles","10 miles","100 miles");
        QuizSupport q5 = new QuizSupport("What is the size of the Netherlands?","41,543 km²","50000km²","25000km²","1km");
        QuizSupport q6 = new QuizSupport("The lowest point in the Netherlands is located at Nieuwekerk aan den Ijssel. How many meters below sea level is it?",
        "6.76m","10.09m","3m","0.0001m");
        QuizSupport q7 = new QuizSupport("How long is the longest tunnel in the Netherlands?","6600m","3000m","10000m","5m");
        QuizSupport q8 = new QuizSupport("What are the known symbols of Dutchness?","","","","");
        
        this.question = "";
        
        quiz.put(1, q1);
        quiz.put(2, q2);
        quiz.put(3, q3);
        quiz.put(4, q4);
        quiz.put(5, q5);
        quiz.put(6, q6);
        quiz.put(7, q7);
        quiz.put(8, q8);
    }
    
    /**
     * method to setup quiz arrays
     */
    public void setArrays() {
        incorAnswers = new String[INCARRAYMAX];
        corAnswers = new String[ARRAYMAX];
        questions = new String[ARRAYMAX];
        
        for (int i : quiz.keySet()) {
            
        }
        
    }
    
    /**
     * method to send questions array to GUI
     */
    public String[] getQuestions() {
        return questions;
    }
    
    /**
     * method to send correct answers array to GUI
     */
    public String[] getCorAns() {
        return corAnswers;
    }
    
    /**
     * method to send incorrect answers array to GUI
     */
    public String[] getIncAns() {
        return incorAnswers;
    }
    
    /**
     * 
     */
    public void userAnswer(String answers) {
        
    }
    
    /**
     * method to check answer
     */
    public void checkAnswer(String answer) {
        if (answer == this.corAns) {
            this.correct = true;
        }
        else {
            this.correct = false;
        }
    }
    
    /**
     * return answer check
     */
    public boolean getCheck() {
        return correct;
    }
    
    
}
