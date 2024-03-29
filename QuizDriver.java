
import ecs100.*;
import java.util.*;
import java.io.*;
import java.awt.Color;
import java.util.HashMap;
import java.util.ArrayList;
/**
 * QuizDriver class
 *
 * @author dewitno
 * @version V.5
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
    private String[] currQuestAnswers;
    ArrayList<Integer> qNumbers = new ArrayList<Integer>();
    private boolean correct;
    private int num;
    private int currPost;
    
    // constant variables
    static final int INCARRAYMAX = 24;
    static final int ARRAYMAX = 8;
    static final int CURRQUESTANSMAX = 4;
    /**
     * Constructor for objects of class QuizDriver
     */
    public QuizDriver()
    {
        // initialise instance variables
        quiz = new HashMap<Integer, QuizSupport>();
        // questions and answers
        QuizSupport q1 = new QuizSupport("What worldwide used food became orange as a tribute to William of Orange, who led the struggle for Dutch independence?", 
            "Carrots", "Pumpkins", 
            "Tangerines", "Capsicums");
        QuizSupport q2 = new QuizSupport("Belgium, Luxembourg and the Netherlands used to be part of the United Kingdom of the Netherlands before splitting up during the Belgium Revolution. When did that revolution happen?", 
            "1830-1839", "1800-1830", 
            "1780-1650", "1600-2000");
        QuizSupport q3 = new QuizSupport("How much of the land in the Netherlands is below sea level?",
            "A third", "A half", 
            "5/7ths", "All of it");
        QuizSupport q4 = new QuizSupport("What is the length of the Elfstedentocht?",
            "200km", "321km", 
            "16km", "100km");
        QuizSupport q5 = new QuizSupport("What is the size of the Netherlands?",
            "41543km²", "50000km²", 
            "25938km²", "1km²");
        QuizSupport q6 = new QuizSupport("The lowest point in the Netherlands is located at Nieuwekerk aan den Ijssel. How many meters below sea level is it?",
            "6.76m", "10.09m", 
            "3m", "0.0001m");
        QuizSupport q7 = new QuizSupport("How long is the longest tunnel in the Netherlands?",
            "6600m", "3000m", 
            "10000m", "5m");
        QuizSupport q8 = new QuizSupport("What are the known symbols of Dutchness?",
            "wooden shoes, tulips, windmills", "lace caps, pyramids, wafels", 
            "tulips, stones, tundra", "dams, mountains, bikes");
        
        quiz.put(1, q1);
        quiz.put(2, q2);
        quiz.put(3, q3);
        quiz.put(4, q4);
        quiz.put(5, q5);
        quiz.put(6, q6);
        quiz.put(7, q7);
        quiz.put(8, q8);
        

        setArrays();
    }
    
    /**
     * method to setup quiz arrays
     */
    public void setArrays() {
        // set array lengths
        incorAnswers = new String[INCARRAYMAX];
        corAnswers = new String[ARRAYMAX];
        questions = new String[ARRAYMAX];
        currPost = 0;
        // do list that loops till qNumbers arraylist
        // size is equal to ARRAYMAX variable
        do {
            // gets a random number
            num = (int) (Math.random() * ARRAYMAX);
            // if statement to check whether arraylist is empty or not
            if (qNumbers.size() == 0) {
                qNumbers.add(num);
            } 
            else {
                // while loop that loops if number is already in arraylist
                while (qNumbers.contains(num) == true) {
                    num = (int) (Math.random() * ARRAYMAX);
                }
                qNumbers.add(num);
            }
        } while(qNumbers.size() != ARRAYMAX);
        // for loop that loops till all questions and answers
        // have been added to relevant arrays
        for (int post = 1; post <= qNumbers.size(); post++) {
            this.num = qNumbers.get(this.currPost) + 1;
            questions[this.currPost] = quiz.get(num).getQuest();
            corAnswers[this.currPost] = quiz.get(num).getCorAns();
            for (int i : quiz.keySet()) {
                incorAnswers[this.currPost * 3] = quiz.get(num).getIncorAns1();
                incorAnswers[this.currPost * 3 + 1] = quiz.get(num).getIncorAns2();
                incorAnswers[this.currPost * 3 + 2] = quiz.get(num).getIncorAns3();
            }
            this.currPost++;
        }
    }
    
    /**
     * method that scrambles current question's
     * answers locations
     * @param questID from GUI
     */
    public void scrambleAns(int questID) {
        // sets relavent variables and array sizes
        int id = 1;
        currQuestAnswers = new String[CURRQUESTANSMAX];
        num = (int) (Math.random() * CURRQUESTANSMAX);
        currQuestAnswers[num] = corAnswers[questID];
        // do statement that loops till id is equal or more than 4
        do {
            // gets random number
            num = (int) (Math.random() * CURRQUESTANSMAX);
            // if statement to add answers to array in random locations
            if (currQuestAnswers[num] != null) {
                num = (int) (Math.random() * CURRQUESTANSMAX);
            }
            else {
                if (id == 1) {
                    currQuestAnswers[num] = incorAnswers[questID * 3];
                    id++;
                }
                else if (id == 2) {
                    currQuestAnswers[num] = incorAnswers[questID * 3 + 1];
                    id++;
                }
                else if (id == 3) {
                    currQuestAnswers[num] = incorAnswers[questID * 3 + 2];
                    id++;
                }
            }
        } while(id < 4);
    }
    
    /**
     * method to send requried question to GUI
     * @return questions[id]
     * @param id from GUI
     */
    public String getQuest(int id) {
        return questions[id];
    }
    
    /**
     * method to send requried answers to GUI
     * @return ans
     * @param id from GUI
     */
    public String getAns(int id) {
        String ans = currQuestAnswers[id];
        return ans;
    }
    
    /**
     * method to check answer
     * @param answer from GUI
     * @param id from GUI
     */
    public void checkAnswer(String answer, int id) {
        if (answer == this.corAnswers[id]) {
            this.correct = true;
        }
        else {
            this.correct = false;
        }
    }
    
    /**
     * return answer check
     * @return correct
     */
    public boolean getCheck() {
        return correct;
    }
    
    
}
