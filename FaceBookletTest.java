import student.web.*;
import student.*;

// -------------------------------------------------------------------------
/**
 *  Test cases for Facebooklet class.
 * 
 *  @author  chun91
 *  @version 03.06.2012
 */
public class FaceBookletTest
    extends TestCase
{
    private FaceBooklet facebooklet1;
    
    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new FacebookletTest test object.
     */
    public FaceBookletTest()
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
        facebooklet1 = new FaceBooklet();
    }
    // ----------------------------------------------------------
   /**
    * Test initial values.
    */
    /*public void testInitials()
    { 
        /*
         * serBeingViewed = new ProfileViewer();
        sessionPersistentMap = new SessionPersistentMap 
        < UserProfile > (UserProfile.class);
        currentUser = sessionPersistentMap.get("user");
         
        */
        
    
    // ----------------------------------------------------------
    /**
     * Test the accessor for currentUser.
     */
    public void testGetCurrentUser()
    { 
        assertEquals(null,  facebooklet1.getCurrentUser());
    }
    
    // ----------------------------------------------------------
    /**
     * Test the createNewUser method.
     */
    public void testCreateNewUser()
    { 
        facebooklet1.createNewUser("chun91", "910505");
        assertEquals("chun91", facebooklet1.getProfileViewer()
            .getProfile().getName());
        assertEquals("910505", facebooklet1.getProfileViewer()
            .getProfile().getPassword());
        facebooklet1.createNewUser("", "910505");
        assertEquals(false, facebooklet1.createNewUser("chun91", "910605"));
        facebooklet1.getProfileViewer().removeProfile("chun91");
    }
    
    // ----------------------------------------------------------
    /**
     * Test the removeCurrentUser method.
     */
    public void testRemoveCurrentUser()
    { 
        facebooklet1.createNewUser("chun93", "910505");
        facebooklet1.removeCurrentUser();
        assertEquals(null, facebooklet1.getCurrentUser());
    }
    
    // ----------------------------------------------------------
    /**
     * Test the login method.
     */
    public void testLogin()
    {         
        facebooklet1.createNewUser("chun92", "910505");
        facebooklet1.login("chun92", "910505");
        assertEquals("chun92", facebooklet1.getProfileViewer()
            .getProfile().getName());
        assertEquals("910505", facebooklet1.getProfileViewer()
            .getProfile().getPassword());
        facebooklet1.login("chun92", "910504");
        facebooklet1.login("", "910505");
        facebooklet1.login("tao", "910505");
        //facebooklet1.getProfileViewer().removeProfile("chun92");
    }
    
    // ----------------------------------------------------------
    /**
     * Test the logout method.
     */
    public void testLogout()
    {         
        facebooklet1.createNewUser("chun", "910505");
        facebooklet1.login("chun", "910505");
        facebooklet1.logout();
        assertEquals(null,  facebooklet1.getCurrentUser());
        assertEquals(null,  facebooklet1.getProfileViewer().getProfile());   
        //facebooklet1.getProfileViewer().removeProfile("chun");
    }
 
}

