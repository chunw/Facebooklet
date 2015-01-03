import student.*;

// -------------------------------------------------------------------------
/**
 *  Test cases for GameQuestion class.
 *  
 *  @author  chun91
 *  @version 2012.04.26
 */
public class GameQuestionTest
    extends TestCase
{
    private GameQuestion question1;
    private Game game1;
    
    //~ Constructor ...........................................................
    // ----------------------------------------------------------
    /**
     * Creates a new GameQuestionTest test object.
     */
    public GameQuestionTest()
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
        game1 = new Game();
        game1.setName("chun");
        question1 = new GameQuestion(game1);
        
    }
    // ----------------------------------------------------------
    /**
     * Test the initial values.
     */
    public void testSetUp()
    {
        assertEquals("chun", question1.getAnswerer());
        assertEquals("enter your answer here", question1.getAnswer());
        question1.setAnswer("yes"); 
        assertEquals("yes", question1.getAnswer());
    }

}
