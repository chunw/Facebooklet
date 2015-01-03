
import student.*;
import student.web.*;

// -------------------------------------------------------------------------
/**
 *  The FaceBooklet class incorperates basic functionalities of
 *  the Facebooklet application such as login, logout, and creating 
 *  new user account.
 *  
 *  @author  chun91
 *  @version 03.05.2012
 */
public class FaceBooklet
{
    //~ Instance/static variables .............................................
    
    private UserProfile currentUser; 
    private ProfileViewer userBeingViewed;
    private SessionPersistentMap < UserProfile > sessionPersistentMap;
    
    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new Facebooklet object.
     */
    
    public FaceBooklet()
    {
        userBeingViewed = new ProfileViewer();
        sessionPersistentMap = new SessionPersistentMap 
        < UserProfile > (UserProfile.class);
        currentUser = sessionPersistentMap.get("user");
    }

    //~ Methods ...............................................................
    // ---------------------------------------------------------- 
    /**
     * Get the profile of current user.
     * @return the profile of current user.
     */
    public UserProfile getCurrentUser() 
    {
        return currentUser;
    }
    
    // ---------------------------------------------------------- 
    /**
     * View a user profile.
     * @return the profile of user being viewed 
     */
    public ProfileViewer getProfileViewer() 
    {
        return userBeingViewed;
    }
    
    // ---------------------------------------------------------- 
    /**
     * Create a new profile for user given username and password.
     * @param username inputed user name 
     * @param password the corresponding password
     * @return whether or not a new profile is successfully created
     */
    public boolean createNewUser(String username, String password) 
    {
        if ((username == null) || (password == null) || 
            (username.equals("")) || (password.equals(""))) 
        {
            return false;
        }
        else
        {
            userBeingViewed.loadProfile(username);
            if (!(userBeingViewed.getProfile() == null))
            {
                return false;
            }
            else
            {
                UserProfile userProfile = new UserProfile();
                userProfile.setName(username);
                userProfile.setPassword(password);
                userBeingViewed.setProfile(userProfile);
                userBeingViewed.saveProfile();
                login(username, password);
                return true;
            }
        }
    }
    
    // ---------------------------------------------------------- 
    /**
     * Remove current user profile.
     * @return whether or not the current user's profile 
     * is successfully removed.
     */
    public boolean removeCurrentUser() 
    {
        userBeingViewed.removeProfile(getCurrentUser().getName());
        logout();
        return true;
    }
    
    // ---------------------------------------------------------- 
    /**
     * Log in to the Facebooklet i.e. set current user to the
     * user indicated profile.
     * @param username user name the user wants to log in with
     * @param password the corresponding password
     * @return whether or not the login is successful
     */
    public boolean login(String username, String password) 
    {
        if ((username == null) || (password == null) || 
            (username.equals("")) || (password.equals(""))) 
        {
            return false;
        }
        else
        {
            userBeingViewed.loadProfile(username);
            if (userBeingViewed.getProfile() == null)
            {
                return false;
            }
            else 
            {
                if (!(userBeingViewed.getProfile().getPassword()
                    .equals(password)))
                {
                    return false;
                }
                else
                {
                    currentUser = userBeingViewed.getProfile();
                    sessionPersistentMap.put("user", currentUser);
                    return true;
                }
            }
        }
    }
    
    // ---------------------------------------------------------- 
    /**
     * Log out of Facebooklet i.e. clear all information for this
     * user in Facebooklet.
     */
    public void logout() 
    {    
        currentUser = null; 
        userBeingViewed.setProfile(null);
        sessionPersistentMap.remove("user");
    }
}
