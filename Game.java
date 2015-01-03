import student.*;
import java.io.*;
import java.util.*;

// -------------------------------------------------------------------------
/**
 *  A Game class provides the current user an 
 *  access to the major services of the friendship credit game, 
 *  such as sending request for credits from one user to another, 
 *  and adding credits. By extending the Entity class, it will 
 *  has access to critical attributes for the game such as the 
 *  list of creditRequests and the creditReport that are defined 
 *  in Entity class.
 * 
 *  @author  chun91
 *  @version 2012.04.26
 */
public class Game extends Entity
{
    //~ Instance/static variables .............................................
    UserProfile player;
    String[][] questionPool;

    //~ Constructor ...........................................................
    // ----------------------------------------------------------
    /**
     * Creates a new Game object.
     * @param currentUser set current user as game player
     */
    public Game(UserProfile currentUser) 
    {
        player = currentUser;
        setName(player.getName());
        questionPool = new String[2][20]; 
        prepareQuestionPool();
    }
    // ----------------------------------------------------------
    /**
     * Creates a new Game object.
     */
    public Game() 
    {
        questionPool = new String[2][20]; 
        prepareQuestionPool();
    } 


    //~ Methods ...............................................................
    // ---------------------------------------------------------- 
    /**
     * An accessor for questionPool.
     * @return the questionPool array list. 
     */
    public String[][] getQuestionPool() 
    {
        return questionPool; 
    }
    // ---------------------------------------------------------- 
    /**
     * An accessor for the player's user profile.
     * @return the player's user profile.
     */
    public UserProfile getPlayer() 
    {
        return player; 
    }
    // ---------------------------------------------------------- 
    /**
     * Send a request for friendship credits to the user being viewed.
     * @param userBeingViewed the user being viewed.
     * @param question a question just answered, containing the 
     * question statement, answer, answerer's name and 
     * corresponding credit value.
     * to request.
     * @return whether the request for credit is sent successfully.
     */
    public boolean requestForCredit
    (UserProfile userBeingViewed, GameQuestion question) 
    {
        if (player.getFriends().contains(userBeingViewed.getName())) 
        //verify the userBeingViewed is a friend of current user
        {
            /*generate a string request that contains information of the
              question answered and add this string request to the friend's
              credit request list */
            String string = "*Your friend <em> " + question.getAnswerer() 
                + " </em> answered the question: <strong>"
                + question.getQuestion() + "</strong></br> "
                + "If the answer: <strong>" 
                + question.getAnswer() 
                + "</strong> is correct, " + " you guys will BOTH get " 
                + question.getCreditValue() 
                + " friendship credits.";
            userBeingViewed.getCreditRequests().add(string); 
            return true;
        }
        else
        {
            return false; 
        }
    }
    // ---------------------------------------------------------- 
    /**
     * Add credits to both of current user and the answerer.
     * @param answerer the answerer's user profile.
     * @param creditValue the numeber of credits to be added.
     * @return an indication that the method has been successfully executed.
     */
    public boolean addCredit(UserProfile answerer, String creditValue) 
    {
        /*Add a certain number of credits and the old number of 
         *credit stored in the user's friendship credit map.
         *First convert the strings into integers.
         */
        int k = Integer.parseInt(creditValue) 
            + Integer.parseInt(player.getCreditReport()
                .get(answerer.getName()));
        String newValue = "" + k;        
        
        //update the friendship credit report
        player.getCreditReport().put(answerer.getName(), newValue); 
        answerer.getCreditReport().put(player.getName(), newValue);
        
        return true;
    }
    // ---------------------------------------------------------- 
    /**
     * Read a string credit request and extract the name of answerer.
     * @param request the string credit request generated in requestForCredit.
     * @return the answerer of the question.
     */
    public String readAnswerer(String request)
    {  
        String answerer = "";
        //create a scanner to read in the string request
        Scanner scanner = new Scanner(request); 
        while (scanner.hasNext())  
        {
            String next = scanner.next();
            //take the third word after "*Your" in 
            //string request as answerer's name
            if (next.equals("*Your"))
            {
                answerer = scanner.next(); 
                answerer = scanner.next(); 
                answerer = scanner.next(); 
            }
        }
        return answerer;
    }
    // ---------------------------------------------------------- 
    /**
     * Read a string credit request and extract the number of credit.
     * @param request the string credit request generated in requestForCredit.
     * @return the number of credits corresponding to the question.
     */
    public String readCredit(String request)
    {
        String credit = "";
        Scanner scanner = new Scanner(request); 
        while (scanner.hasNext())  
        {
            String next = scanner.next();
            //take the second word after "BOTH" in
            //string request as the number of credits
            if (next.equals("BOTH"))
            {
                credit = scanner.next();
                credit = scanner.next();
            }
        }
        return credit;
    }
     // ---------------------------------------------------------- 
    /**
     * Fill in the questionPool array.
     */
    public void prepareQuestionPool() 
    {
        questionPool[0][0] = "What's his/her favorite drink?"; 
        questionPool[1][0] = "5" ; //this question is worth 5 credits

        questionPool[0][1] = "What's his/her favorite color? ";
        questionPool[1][1] = "5";

        questionPool[0][2] = "What are his/her personal aspirations?";
        questionPool[1][2] = "15";

        questionPool[0][3] = "Where did he/she grow up?";
        questionPool[1][3] = "5";

        questionPool[0][4] = "What sort of a life partner does he/she expect? ";
        questionPool[1][4] = "20";

        questionPool[0][5] = "Which is the place he/she visits most often? ";
        questionPool[1][5] = "10";

        questionPool[0][6] = "Does he/she have any pets? ";
        questionPool[1][6] = "5"; 

        questionPool[0][7] = "What¡¯s his/her favorite kind of music? ";
        questionPool[1][7] = "10"; 

        questionPool[0][8] = "What is the one thing that he/she is"
            + " most proud of?";
        questionPool[1][8] = "20"; 

        questionPool[0][9] = "Who is his/her hero? ";
        questionPool[1][9] = "15";

        questionPool[0][10] = "Who influences him/her the most now? ";
        questionPool[1][10] = "20";

        questionPool[0][11] = "Who is his/her hero?";
        questionPool[1][11] = "15";

        questionPool[0][12] = "What does he/she think is the" 
            + " sexiest part of you?";
        questionPool[1][12] = "10";

        questionPool[0][13] = "Has he/she ever been dumped?";
        questionPool[1][13] = "10";

        questionPool[0][14] = "What is his/her biggest regret?";
        questionPool[1][14] = "20";

        questionPool[0][15] = "What is the one thing that disgusts him/her?";
        questionPool[1][15] = "5";

        questionPool[0][16] = "What was his/her first impression about you?";
        questionPool[1][16] = "15";

        questionPool[0][17] = "How many people are there in his/her family?";
        questionPool[1][17] = "5";

        questionPool[0][18] = "Is his/her bed big or small?";
        questionPool[1][18] = "10";

        questionPool[0][19] = "What is the one thing that" 
            + " he/she cannot live without?";
        questionPool[1][19] = "10";
    }
}
