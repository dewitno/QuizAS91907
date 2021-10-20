/* Based on the ecs 100 template
 * Code for ??
 * Name:
 * Date:
 */


import ecs100.*;
import java.util.*;
import java.io.*;
import java.awt.Color;


/** <description of class QuizGUI>
 */
public class QuizGUI{
    // variables
    private QuizDriver quiz;
    private String question;
    private String ansBox1;
    private String ansBox2;
    private String ansBox3;
    private String ansBox4;
    private String userAns;
    private int score;
    private boolean check;
    
    // constant variables
    static final int MAXSCORE = 8;
    static final int WIDTH = 200;
    static final int HEIGHT = 100;
    static final double ILOCX = 100;
    static final double ILOCY = 100;
    static final double FLOCX = 300 + 50;
    static final double FLOCY = 200 + 50;
    static final double AILOCX = 125;
    static final double AFLOCX = 125;
    static final double AFLOCY = 125;
    /**
     * constructor of QuizGUI
     */
    public QuizGUI(){
        quiz = new QuizDriver();
        UI.initialise();
        UI.setMouseListener(this::doMouse);
        UI.addButton("Begin Quiz", this::beginQuiz);
        UI.addButton("Quit", UI::quit);
    }

    public static void main(String[] args){
        QuizGUI obj = new QuizGUI();
    }
    
    /**
     * begin quiz method
     */
    public void beginQuiz() {
        // clears graphics plain of previous card
        UI.clearGraphics();
        // draws question, answer boxes and possible answers
        UI.setLineWidth(2);
        drawBoxes();
    }
    
    /**
     * draw boxes
     */
    public void drawBoxes() {
        UI.drawRect(ILOCX, ILOCY, WIDTH, HEIGHT);
        UI.drawRect(FLOCX, ILOCY, WIDTH, HEIGHT);
        UI.drawRect(ILOCX, FLOCY, WIDTH, HEIGHT);
        UI.drawRect(FLOCX, FLOCY, WIDTH, HEIGHT);
    }
    
    /**
     * display question and possible answers in boxes
     */
    public void display() {
        UI.drawString(this.ansBox1, 1, 1);
        UI.drawString(this.ansBox2, 1, 1);
        UI.drawString(this.ansBox3, 1, 1);
        UI.drawString(this.ansBox4, 1, 1);
    }
    
    /**
     * mouse method
     */
    public void doMouse(String action, double x, double y) {
        if (action.equals("clicked")) {
            // if statements to check user answer
            if ((x >= this.ILOCX) && (x <= this.WIDTH + this.ILOCX) && (y >= this.ILOCY) && (y <= this.HEIGHT + this.ILOCY)) {
                userAns = ansBox1;
                quiz.checkAnswer(userAns);
            }
            else if ((x >= this.FLOCX) && (x <= this.WIDTH + this.FLOCX) && (y >= this.ILOCY) && (y <= this.HEIGHT + this.ILOCY)) {
                userAns = ansBox2;
                quiz.checkAnswer(userAns);
            }
            else if ((x >= this.ILOCX) && (x <= this.WIDTH + this.ILOCX) && (y >= this.FLOCY) && (y <= this.HEIGHT + this.FLOCY)) {
                userAns = ansBox3;
                quiz.checkAnswer(userAns);
            }
            else if ((x >= this.FLOCX) && (x <= this.WIDTH + this.FLOCX) && (y >= this.FLOCY) && (y <= this.HEIGHT + this.FLOCY)) {
                userAns = ansBox4;
                quiz.checkAnswer(userAns);
            }
        }
        check = quiz.getCheck();
        //erase();
    }
    
    /**
     * erase method
     */
    public void erase() {
        UI.sleep(500);
        UI.clearGraphics();
    }
    
    
}

