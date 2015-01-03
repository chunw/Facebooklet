import student.web.SharedPersistentMap;
import student.*;
import java.util.*;

// -------------------------------------------------------------------------
/**
 *  Provides test cases for ProfileViewer.
 *  Test if ProfileViewer is able to display, create,
 *  save, and look up user profiles correctly. 
 * 
 *  @author  chun91 
 *  @version 2012.02.12
 */
public class ProfileViewerTest
    extends TestCase
{
    private ProfileViewer profileViewer1;
    private SharedPersistentMap < UserProfile > profileMap1;
    private UserProfile profile1;
    
    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new ProfileViewer test object.
     */
    public ProfileViewerTest()
    {
        profileMap1 = new SharedPersistentMap < UserProfile > 
        (UserProfile.class);
    }


    //~ Methods ...............................................................
    // ----------------------------------------------------------
    /**
     * Sets up the test fixture.
     * Called before every test case method.
     */
    public void setUp()
    {
        profileViewer1 = new ProfileViewer();
        profile1 = new UserProfile(); 
    }
    
    // ----------------------------------------------------------
    /**
     * Test the accessor for the user profile map.
     */
    public void testGetProfileMap()
    {
        assertEquals(2, profileViewer1.getProfileMap().size());
    }
    // ----------------------------------------------------------
    /**
     * Test the accessor and the mutator for current user profile.
     */
    public void testSetProfile()
    {  
        profile1.setPassword("5678");
        profileViewer1.setProfile(profile1);
        assertEquals("5678", profileViewer1.getProfile().getPassword());
    }
    // ----------------------------------------------------------
    /**
     * Test the createNewProfile method.See if a new profile is
     * created for a reasonable name and set the profile as 
     * current profile.
     */
    public void testCreateNewProfile()
    {  
        profileViewer1.createNewProfile("dummy");
        assertEquals("dummy", profileViewer1.getProfile().getName());
        profileViewer1.createNewProfile("");
        assertEquals(null, profileViewer1.getProfile());
        profileViewer1.removeProfile("dummy");
    }  
    // ----------------------------------------------------------
    /**
     * Test the saveProfile method.See if a newly created profile 
     * is properly stored to profileMap1.
     */
    public void testSaveProfile()
    {  
        profileViewer1.saveProfile();
        assertEquals(null, profileViewer1.getProfile().getName());
        profileViewer1.createNewProfile("dummy");
        profileViewer1.saveProfile();
        assertEquals("dummy", profileViewer1.getProfile().getName());
        profileMap1.remove("dummy");
        assertEquals(2,  profileViewer1.getSharedMapSize());
    }  
    // ----------------------------------------------------------
    /**
     * Test the loadProfile method.See the method can look up 
     * the user profile for the given user name in profileMap,
     * and properly store the profile as current user profile 
     * if the profile does exist.
     */
    public void testLoadProfile()
    {  
        profileViewer1.createNewProfile("dummy");
        profileViewer1.saveProfile();
        profileViewer1.loadProfile("");
        profileViewer1.loadProfile("dummy");
        assertEquals("dummy", profileViewer1.getProfile().getName());
        profileMap1.remove("dummy");
    }
   
}










