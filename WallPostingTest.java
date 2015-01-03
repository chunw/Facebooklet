import java.util.*;
import student.*;
import student.web.*;
import java.text.*;


// -------------------------------------------------------------------------
/**
 *  Test cases for WallPosting.
 * 
 *  @author  chun91
 *  @version 2012.03.31
 */
public class WallPostingTest
    extends TestCase
{
    private WallPosting post1;
    private ProfileViewer pView;
    private UserProfile user;
    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new WallPostingTest test object.
     */
    public WallPostingTest()
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
        //facebooklet1 = new FaceBooklet();
        //facebooklet1.createNewUser("chunwang06", "password");
        user = new UserProfile();
        pView = new ProfileViewer();
        user.setName("chun");
        pView.setProfile(user);
        pView.saveProfile();
        post1 = new WallPosting();
        post1 = new WallPosting(user, 
            "Hello everyone!");
    }
    // ----------------------------------------------------------
    /**
     * Test the accessor for message.
     */
    public void testGetMessage()
    { 
        assertEquals("Hello everyone!",  post1.getMessage());
    }
    // ----------------------------------------------------------
    /**
     * Test the getAuthor method.
     */
    public void testGetAuthor()
    {
        assertEquals("chun",  post1.getAuthor().getName());
        /*user.setName("");
        pView.setProfile(user);
        pView.saveProfile();*/
        UserProfile testUser = new UserProfile();
        WallPosting wallPost1 = new WallPosting(testUser, "test");
        assertNull(wallPost1.getAuthor());
        testUser.setName("");
        WallPosting wallPost2 = new WallPosting(testUser, "test");
        assertNull(wallPost2.getAuthor());
       /* facebooklet1.createNewUser("chunwang09", "password");
        assertEquals(null,  post1.getAuthor());*/
    }
    // ----------------------------------------------------------
    /**
     * Test the toString method.
     */
    public void testToString()
    {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yy");
        String dateString = simpleDateFormat.format(post1.getDate());   
        assertEquals("<p><img width=" + '"' + "80" + '"' + "height=" 
            + '"' + "80" + '"' + "src = " + '"' 
            + post1.getAuthor().getPictureThumbUrl() 
            + '"' + "/></p>" + "<h4>" + post1.getAuthor().getName() 
            + " says: </h4>" + "<p>" + post1.getMessage() + "</p>" 
            + "<p>" + dateString + "</p>", post1.toString());
            
        post1.getAuthor().setPictureThumbUrl("");
        assertEquals("Please upload a thumbnail image before posting.",
            post1.toString());
    }
}
