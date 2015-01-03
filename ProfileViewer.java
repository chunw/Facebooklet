import student.web.SharedPersistentMap;
import student.*;
import java.util.*;

// -------------------------------------------------------------------------
/**
 *  A ProfileViewer class represents an interface between users of
 *  Facebooklet and the application in the way that it takes in a 
 *  user name and then either create for this name a profile to be
 *  saved in a shared user profile map, or load an existed profile 
 *  from the map for this given user name.A ProfileViewer also has 
 *  a UserProfile attribute that serves as a temporary storage of 
 *  the input and output user profile to and from the map.
 * 
 *  @author  chun91
 *  @version 2012.02.11
 */
public class ProfileViewer 
{
    //~ Instance/static variables .............................................
    private SharedPersistentMap < UserProfile > profileMap;
    private UserProfile profile;

    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new ProfileViewer object.
     */
    public ProfileViewer()
    {
        profileMap = new SharedPersistentMap < UserProfile > 
        (UserProfile.class);
        profile = new UserProfile();
    }
    


    //~ Methods ...............................................................
    
    // ---------------------------------------------------------- 
     /**
     * An accessor for current user profile.
     * @return the current user profile. 
     */
    public UserProfile getProfile() 
    {
        return profile; 
    }
    // ---------------------------------------------------------- 
     /**
     * An accessor for user profile map.
     * @return the user profile map. 
     */
    public SharedPersistentMap < UserProfile >  getProfileMap() 
    {
        return profileMap; 
    }
    // ---------------------------------------------------------- 
    /**
     * Change current user profile.
     * @param newProfile The new current user profile 
     */
    
    public void setProfile(UserProfile newProfile) 
    { 
        profile = newProfile; 
    }
    // ---------------------------------------------------------- 
    /**
     * Create a new user profile for the given user name,
     * if the given name is not null and if it is not empty.
     * Store the new user profile as current user profile.
     * @param userName a given user name
     */
    public void createNewProfile(String userName) 
    {
        if (!(userName == null) && !(userName.equals("")))
        {
            UserProfile newProfile = new UserProfile();
            newProfile.setName(userName);
            profile = newProfile; 
        }
        else
        {
            profile = null;
        }
    }
    
    // ---------------------------------------------------------- 
    /**
     * Store the current user profile to profileMap,
     * if it is not null, and if it refers to 
     * a profile that does have a user name.
     */
    public void saveProfile()
    {
        if ((!(profile == null)) && (!(profile.getName() == null))
            && !(profile.getName().equals("")) )
        {
            profileMap.put(profile.getName(), profile);
        }
    }
    
    // ---------------------------------------------------------- 
    /**
     * Look up the user profile for the given user name in profileMap,
     * if the user name is not null, and if it is not empty.
     * If a user profile for the given user name does exist,
     * store the profile as current user profile.
     * @param userName the user name for the profile needed to load.
     */
    public void loadProfile(String userName)
    {
        if (!(userName == null) && !(userName.equals("")))
        {
            if (!(profileMap.get(userName) == null))
            {
                profile = profileMap.get(userName); 
            }
            else 
            {
                profile = null;
            }
        }
    }
   // ---------------------------------------------------------- 
    /**
     * Remove an existed user profile for the given user name.
     * @param userName a given user name
     */
    public void removeProfile(String userName)
    {
        if (!(userName == null) && !(userName.equals(""))
            && !(profileMap.get(userName) == null))
        {
            profileMap.remove(userName);
            /*if (userName.equals(getProfile().getName()))
            {
                profile = null;
            }  */
        }
    }
    // ---------------------------------------------------------- 
    /**
     * Accessor for share map's size.
     * @return share map's size.
     */
    public int getSharedMapSize()
    {
        return profileMap.size();
    }
    
}