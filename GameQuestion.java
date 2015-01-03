import student.*;
import java.util.Random;
 
// -------------------------------------------------------------------------
/**
 *  A GameQuestion class represents a friendship question that 
 *  is used to determine if a certain number of credits can 
 *  be awarded to a pair of friends.  Its main purpose is to
 *  store any inputs from the player that is related to a specific
 *  question for future review by another user.  A major component 
 *  of a GameQuestion is a statement of the question itself. Every
 *  time the player chooses to continue to answer a new question, 
 *  a question statement and its associated credit value will be 
 *  randomly generated from a pre-made 2D array called questionPool, 
 *  and displayed to screen so that player can read and answer. 
 * 
 *  @author  chun91
 *  @version 2012.04.26
 */

public class GameQuestion
{
    //~ Instance/static variables .............................................
    private String answerer;
    private String question; 
    private String answer;
    private String creditValue;

    //~ Constructor ...........................................................
    // ----------------------------------------------------------
    /**
     * Creates a new GameQuestion object.
     * @param gameBeingPlayed the game that is 
     * being played by current user.
     */
    public GameQuestion(Game gameBeingPlayed)
    {
        //set current user as answerer to the question
        //and initialize answer
        answerer = gameBeingPlayed.getName(); 
        answer = "enter your answer here";
        
        //randomly generate a question from questionPool
        //and get the corresponding credit value
        //first generate a random index r that 
        //should be in range 0..19
        Random generator = new Random();
        int r = generator.nextInt(20); 
        String[][] questionArray = gameBeingPlayed.getQuestionPool();
        question = questionArray[0][r]; 
        creditValue = questionArray[1][r]; 
    }
    

    //~ Methods ...............................................................
    /**
     * An accessor for the answerer's name.
     * @return the answerer's name.
     */
    public String getAnswerer() 
    {
        return answerer;
    }
    // ----------------------------------------------------------
    /**
     * An accessor for the question.
     * @return the question. 
     */
    public String getQuestion() 
    {
        return question; 
    }
    // ----------------------------------------------------------
    /**
     * An accessor for the answer.
     * @return the answer. 
     */
    public String getAnswer() 
    {
        return answer; 
    }
    // ----------------------------------------------------------
    /**
     * An mutator for the answer.
     * @param newAnswer a user input answer to the given question.
     */
    public void setAnswer(String newAnswer) 
    {
        answer = newAnswer;
    }
    // ----------------------------------------------------------
    /**
     * An accessor for creditValue.
     * @return the creditValue. 
     */
    public String getCreditValue() 
    {
        return creditValue; 
    }
}
