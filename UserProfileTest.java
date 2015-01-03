import student.*;

// -------------------------------------------------------------------------
/**
 *  Provides test cases for UserProfile.
 *  Test the accessors and mutators for the attributes 
 *  that class UserProfile includes.
 * 
 *  @author  chun91 
 *  @version 2012.01.31
 */
public class UserProfileTest
    extends TestCase
{
    private UserProfile userProf1;

    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new UserProfileTest test object.
     */
    public UserProfileTest()
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
        userProf1 = new UserProfile("chun");
        userProf1 = new UserProfile();
    }


    // ----------------------------------------------------------
    /**
     * Tests the accessor for password.
     */
    public void testInitialPassword()
    {
        assertEquals(null, userProf1.getPassword());
    }
    // ----------------------------------------------------------
    /**
     * Tests the mutator for password.
     */
    public void testPassword()
    {
        userProf1.setPassword("57699");
        assertEquals("57699", userProf1.getPassword());
    }
    // ----------------------------------------------------------
    /**
     * Tests the accessor for email.
     */
    public void testInitialEmail()
    {
        assertEquals(null, userProf1.getEmail());
    } 
    // ----------------------------------------------------------
    /**
     * Tests the mutator for email.
     */
    public void testEmail()
    {
        userProf1.setEmail("cw@vt.edu");
        assertEquals("cw@vt.edu", userProf1.getEmail());
    }
    // ----------------------------------------------------------
    /**
     * Tests the accessor for pictureThumbUrl.
     */
    public void testInitialPicThumbUrl()
    {
        assertEquals("http://fms.mesa.k12.co.us/staff/dturner" +
            "/images/QuestionMark.gif",
            userProf1.getPictureThumbUrl());
    }
    // ----------------------------------------------------------
    /**
     * Tests the mutator for pictureThumbUrl.
     */
    public void testPicThumbUrl()
    {
        userProf1.setPictureThumbUrl("http://www.image.com");
        assertEquals("http://www.image.com", userProf1.getPictureThumbUrl());
    }
    // ----------------------------------------------------------
    /**
     * Tests the accessor for bio.
     */
    public void testInitialBio()
    {
        assertEquals(null, userProf1.getBio());
    }
    // ----------------------------------------------------------
    /**
     * Tests the mutator for bio.
     */
    public void testBio()
    {
        userProf1.setBio("I am a sophomore majoring in CS.");
        assertEquals("I am a sophomore majoring in CS.", userProf1.getBio());
    }
    // ----------------------------------------------------------
    /**
     * Tests the accessor for peopleInterested.
     */
    public void testInitialDescription()
    {
        assertEquals(null, userProf1.getPeopleInterested());
    }
    // ----------------------------------------------------------
    /**
     * Tests the mutator for peopleInterested.
     */
    public void testDescription()
    {
        userProf1.setPeopleInterested ("I want to form a study group " + 
                                       " for CS1114."); 
        assertEquals("I want to form a study group " +
                     " for CS1114.", userProf1.getPeopleInterested()); 
    }
    // ----------------------------------------------------------
    /**
     * Tests the accessor for status.
     */
    public void testInitialStatus()
    {
        assertEquals(null, userProf1.getStatus());
    }
    // ----------------------------------------------------------
    /**
     * Tests the mutator for status.
     */
    public void testStatus()
    {
        userProf1.setStatus("new status");
        assertEquals("new status", userProf1.getStatus());
    }
    // ----------------------------------------------------------
    /**
     * Tests the postToWall method.
     */
    public void testPostToWall()
    {
        UserProfile userProf2 = new UserProfile();
        userProf2.setName("anon");
        userProf1.postToWall(userProf2, "I'll be right back guys!");
        assertEquals(1, userProf1.getWall().size());
        userProf1.postToWall(userProf2, "I'll be right back guys!");
        userProf1.postToWall(userProf2, "I'll be right back guys!");
        userProf1.postToWall(userProf2, "I'll be right back guys!");
        userProf1.postToWall(userProf2, "I'll be right back guys!");
        userProf1.postToWall(userProf2, "I'll be right back guys!");
        userProf1.postToWall(userProf2, "I'll be right back guys!");
        userProf1.postToWall(userProf2, "I'll be right back guys!");
        userProf1.postToWall(userProf2, "I'll be right back guys!");
        userProf1.postToWall(userProf2, "I'll be right back guys!");
        userProf1.postToWall(userProf2, "I'll be right back guys!");
        userProf1.postToWall(userProf2, "I'll be right back guys!");
        userProf1.postToWall(userProf2, "I'll be right back guys!");
        userProf1.postToWall(userProf2, "I'll be right back guys!");
        userProf1.postToWall(userProf2, "I'll be right back guys!");
        userProf1.postToWall(userProf2, "I'll be right back guys!");
        userProf1.postToWall(userProf2, "I'll be right back guys!");
        userProf1.postToWall(userProf2, "I'll be right back guys!");
        userProf1.postToWall(userProf2, "I'll be right back guys!");
        userProf1.postToWall(userProf2, "I'll be right back guys!");
        assertEquals(20, userProf1.getWall().size());
        userProf1.postToWall(userProf2, "I'll be right back guys!");
        assertEquals(20, userProf1.getWall().size());
    }
}









