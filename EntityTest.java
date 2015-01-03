import student.*;

// -------------------------------------------------------------------------
/**
 *  Provides test cases for Entity.
 *  Test the accessors and mutators for the attributes 
 *  that class Entity includes.
 * 
 *  @author  chun91 
 *  @version 2012.01.31
 */
public class EntityTest
    extends TestCase
{
    private Entity entity1;
    private UserProfile user1;

    //~ Constructor ...........................................................
    
    // ----------------------------------------------------------
    /**
     * Creates a new EntityTest test object.
     */
    public EntityTest()
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
        entity1 = new Entity();
        entity1.setName("SomeUser");
        user1 = new UserProfile();
        user1.setName("chun");
    }


    // ----------------------------------------------------------
    /**
     * Tests the accessor for name.
     */
    public void testInitialName()
    {
        assertEquals("SomeUser", entity1.getName());
    }
    // ----------------------------------------------------------
    /**
     * Tests the accessor for pictureUrl.
     */
    public void testInitialPicUrl()
    {
        assertEquals("http://fms.mesa.k12.co.us/staff"
            + "/dturner/images/QuestionMark.gif"
            , entity1.getPictureUrl());
    }
    // ----------------------------------------------------------
    /**
     * Tests the mutator for pictureUrl.
     */
    public void testPicUrl()
    {
        entity1.setPictureUrl("http:www.go.com");
        assertEquals("http:www.go.com", entity1.getPictureUrl());
    }
    // ----------------------------------------------------------
    /**
     * Tests the addFriend method.
     */
    public void testAddFriend()  
    {
        entity1.addFriend(user1);
        assertTrue(entity1.getFriends().contains("chun"));
        assertTrue(user1.getFriends().contains("SomeUser"));
        entity1.addFriend(user1);
        entity1.removeFriend(user1);
    }
    
    // ----------------------------------------------------------
    /**
     * Tests the removeFriend method.
     */
    public void testRemoveFriend()   
    {
        entity1.addFriend(user1); 
        entity1.removeFriend(user1);
        assertFalse(entity1.getFriends().contains("chun"));
        assertFalse(user1.getFriends().contains("SomeUser"));
        UserProfile user2 = new UserProfile();
        user2.setName("chun2");
        entity1.removeFriend(user2);
    }
    
    // ----------------------------------------------------------
    /**
     * Tests the sendFriendRequest method.
     */
    public void testSendFriendRequest()
    {
        entity1.sendFriendRequest(user1);
        assertTrue(user1.getFriendsToConfirm().contains("SomeUser"));
        entity1.addFriend(user1);
        assertTrue(entity1.getFriends().contains("chun")); 
        assertTrue(user1.getFriends().contains("SomeUser")); 
        entity1.sendFriendRequest(user1);
    }
    
    // ----------------------------------------------------------
    /**
     * Tests the getCreditRequests method.
     */
    public void testGetCreditRequests() 
    {
        assertEquals(0, entity1.getCreditRequests().size()); 
    }
   
    // ----------------------------------------------------------
    /**
     * Tests the getCreditReport method.
     
    public void testGetCreditReport()
    {
        
        assertTrue(entity1.getCreditReport().isEmpty()); 
        //entity1.addFriend(user1);
        entity1.addFriend(user1);
        assertFalse(entity1.getCreditReport().isEmpty()); 
        entity1.removeFriend(user1);
        
        //assertTrue(entity1.getCreditReport().isEmpty());
    }*/
    
    

        
}


