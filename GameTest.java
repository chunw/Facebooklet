import student.*;

// -------------------------------------------------------------------------
/**
 *  Test cases for the Game class.
 *  
 *  @author chun91
 *  @version 2012.04.19
 */
public class GameTest
    extends TestCase
{
    private Game game1; 
    private UserProfile user1;
    private GameQuestion question1;
    
    //~ Constructor ...........................................................
    // ----------------------------------------------------------
    /**
     * Creates a new GameTest test object.
     */
    public GameTest()
    {
        // The constructor is usually empty in unit tests, since it runs
        // once for the whole class, not once for each test method.
        // Per-test initialization should be placed in setUp() instead.
    }


    //~ Methods ...............................................................
    // ----------------------------------------------------------
    /**
     * Sets up the test fixture.
     * Called before every test case method.
     */
    public void setUp()
    {
        user1 = new UserProfile("jenny"); 
        //jenny should be chun's friend to play this game
        game1 = new Game();
        game1 = new Game(new UserProfile("chun")); 
        //current user is chun, game player is chun
        question1 = new GameQuestion(game1); 
        //chun is the question1's answerer 
    }
    // ----------------------------------------------------------
    /**
     * Tests the initial condition of the game.
     */
    public void testSetUp()
    {
        assertEquals("jenny", user1.getName());
        assertEquals("chun", game1.getName());
        assertEquals("chun", question1.getAnswerer());
        assertEquals("chun", game1.getPlayer().getName());
    }
    // ----------------------------------------------------------
    /**
     * Tests the questionPool.
     */
    public void testQuestionPool()
    {
        String[][] copyQuestionPool = game1.getQuestionPool();
        copyQuestionPool[0][0] = "test";
        assertEquals("test", copyQuestionPool[0][0]);
    }
    // ----------------------------------------------------------
    /**
     * Tests the requestForCredit method.
     */
    public void testRequestForCredit()
    {
        assertFalse(game1.requestForCredit(user1, question1));
        game1.getPlayer().addFriend(user1); //add jenny as chun's friend
        assertTrue(game1.requestForCredit(user1, question1));
    }
    // ----------------------------------------------------------
    /**
     * Tests the addCredit method.
     */
    public void testAddCredit()
    {   
        //add jenny as chun's friend
        game1.getPlayer().addFriend(user1); 
        //in chun's report, jenny should get "0" credit
        assertEquals("0", game1.getPlayer().getCreditReport()
            .get(user1.getName())); 
        //in jenny's report, chun should get "0" credit
        assertEquals("0", user1.getCreditReport().get(game1.getName())); 
        game1.addCredit(user1, "5"); 
        assertEquals("5", game1.getPlayer().getCreditReport()
            .get(user1.getName())); 
        assertEquals("5", user1.getCreditReport().get(game1.getName())); 
        game1.addCredit(user1, "10"); 
        assertEquals("15", game1.getPlayer().getCreditReport()
            .get(user1.getName())); 
        assertEquals("15", user1.getCreditReport().get(game1.getName())); 
    }
    // ----------------------------------------------------------
    /**
     * Tests the readAnswerer method.
     */
    public void testReadAnswerer()
    {
        String request = "*Your friend <em> chun " 
                + "</em> answered the question: <strong> "
                + "What's his/her favorite drink? </strong></br> "
                + "If the answer: <strong> " 
                + "Mocha. "
                + "</strong> is correct, " + " you guys will BOTH get " 
                + "5" 
                + " friendship credits.";
        assertEquals("chun", game1.readAnswerer(request));
    }
    // ----------------------------------------------------------
    /**
     * Tests the readCredit method.
     */
    public void testReadCredit()
    {
        String request = "*Your friend <em> chun " 
                + "</em> answered the question: <strong> "
                + "What's his/her favorite drink? </strong></br> "
                + "If the answer: <strong> " 
                + "Mocha. "
                + "</strong> is correct, " + " you guys will BOTH get " 
                + "5" 
                + " friendship credits.";
        assertEquals("5", game1.readCredit(request));
    }
}


