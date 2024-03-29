/* Based on the ecs 100 template
 * Code for ??
 * Name:
 * Date:
 */


import ecs100.*;
import java.util.*;
import java.io.*;
import java.awt.Color;
import java.util.ArrayList;

/** 
 * QuizGUI class
 * 
 * @author dewitno
 * @version V.5
 */
public class QuizGUI {
    // variables
    private QuizDriver quiz;
    private String question;
    private String ansBox1;
    private String ansBox2;
    private String ansBox3;
    private String ansBox4;
    private String userAns;
    private int score;
    private int questID;
    private boolean check;
    private String clickLoc = "outside";
    ArrayList<String> failQuest = new ArrayList<String>();
    
    // constant variables
    static final int MAXSCORE = 8;
    static final int WIDTH = 200;
    static final int HEIGHT = 100;
    static final double ILOCX = 100;
    static final double ILOCY = 100;
    static final double FLOCX = 350;
    static final double FLOCY = 250;
    static final double AILOCX = 125;
    static final double AFLOCX = 125;
    static final double AFLOCY = 125;
    /**
     * constructor of QuizGUI
     */
    public QuizGUI() {
        quiz = new QuizDriver();
        UI.initialise();
        // displays translations for certain words
        UI.println("Elfstedentocht = Eleven Cities Tour");
        UI.println("Nieuwekerk aan den Ijssel = New Church on the IJssel (place in the Netherlands)");
        // intitialises buttons and mouse
        UI.setMouseListener(this::doMouse);
        UI.addButton("Begin Quiz", this::beginQuiz);
        UI.addButton("Quit", UI::quit);
    }
    
    /**
     * begin quiz method
     */
    public void beginQuiz() {
        // clears graphics plain of previous card
        UI.clearGraphics();
        // reset variables
        questID = 0; // questID 0 = question 1
        // draws question, answer boxes and possible answers
        UI.setLineWidth(2);
        display();
    }
    
    /**
     * displaies boxes, question and possible answers
     */
    public void display() {
        // checks if question ID is less than MAXSCORE
        // if questID is more or equal to MAXSCORE
        // quiz has finished and results get displayed
        if (this.questID < MAXSCORE) {
            // draws the current question
            UI.drawString(quiz.getQuest(questID), 1, 50);
            // calls method from quiz that scrambles 
            // location of the answers
            quiz.scrambleAns(questID);
            // draws the answer boxes
            UI.drawRect(ILOCX, ILOCY, WIDTH, HEIGHT);
            UI.drawRect(FLOCX, ILOCY, WIDTH, HEIGHT);
            UI.drawRect(ILOCX, FLOCY, WIDTH, HEIGHT);
            UI.drawRect(FLOCX, FLOCY, WIDTH, HEIGHT);
            // sets answers to their designated
            // answer boxes
            this.ansBox1 = quiz.getAns(0);
            this.ansBox2 = quiz.getAns(1);
            this.ansBox3 = quiz.getAns(2);
            this.ansBox4 = quiz.getAns(3);
            // draws answers into their answer boxes
            UI.drawString(this.ansBox1, 120, 120);
            UI.drawString(this.ansBox2, 370, 120);
            UI.drawString(this.ansBox3, 120, 270);
            UI.drawString(this.ansBox4, 370, 270);
        }
        else {
            // displays results
            UI.drawRect(150, 150, WIDTH, HEIGHT);
            UI.drawString("Results", 170, 170);
            UI.drawString(this.score + "/" + MAXSCORE, 170, 180);
        }
    }
    
    /**
     * mouse method
     * @param action from mouse click
     * @param x coord of mouse
     * @param y coord of mouse
     */
    public void doMouse(String action, double x, double y) {
        if (action.equals("clicked")) {
            // if statements to user mouse click
            // locations and sets userAnswer
            // to clicked box answer
            if (this.questID >= MAXSCORE) {
                clickLoc = "outside";
            }
            else if ((x >= this.ILOCX) && (x <= this.WIDTH + this.ILOCX) 
                && (y >= this.ILOCY) && (y <= this.HEIGHT + this.ILOCY)) {
                userAns = ansBox1;
                quiz.checkAnswer(userAns, questID);
                clickLoc = "inside";
            }
            else if ((x >= this.FLOCX) && (x <= this.WIDTH + this.FLOCX) 
                && (y >= this.ILOCY) && (y <= this.HEIGHT + this.ILOCY)) {
                userAns = ansBox2;
                quiz.checkAnswer(userAns, questID);
                clickLoc = "inside";
            }
            else if ((x >= this.ILOCX) && (x <= this.WIDTH + this.ILOCX) 
                && (y >= this.FLOCY) && (y <= this.HEIGHT + this.FLOCY)) {
                userAns = ansBox3;
                quiz.checkAnswer(userAns, questID);
                clickLoc = "inside";
            }
            else if ((x >= this.FLOCX) && (x <= this.WIDTH + this.FLOCX) 
                && (y >= this.FLOCY) && (y <= this.HEIGHT + this.FLOCY)) {
                userAns = ansBox4;
                quiz.checkAnswer(userAns, questID);
                clickLoc = "inside";
            }
            else {
                clickLoc = "outside";
            }
        }
        
        // if statement to check if
        // click location is inside
        // any of the answer boxes
        // if true, answer gets check, else nothing happens
        if (clickLoc.equals("inside")) {
            // checks to see if answer is correct
            check = quiz.getCheck();
            if (check == true) {
                this.score++;
            }
            else if (check == false) {
                failQuest.add(question);
            }
            // increase questID, reset variables and
            // clear current question and display next question
            this.questID++;
            check = false;
            clickLoc = "outside";
            erase();
            display();
        }
    }
    
    /**
     * erase method to clear current question
     */
    public void erase() {
        UI.sleep(500);
        UI.clearGraphics();
    }
}

