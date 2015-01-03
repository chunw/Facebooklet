import student.*;
import java.util.*;


// -------------------------------------------------------------------------
/**
 *  The Entity class represents the common features that 
 *  all of the entities in FaceBooklet have in common. 
 *  The entity's name and its picture URL are not 
 *  specified via the constructor. After modified, it
 *  provides bi-directional adding and removing friends 
 *  services, as well as access to critical attributes 
 *  for the friendship credit game such as the list of 
 *  creditRequests and the creditReport.
 *  
 *  @author chun91
 *  @version 2012.04.26
 */
public class Entity
{
    //~ Instance/static variables .............................................
    private String name;
    private String pictureUrl;
    private ArrayList < String > friends;
    private ArrayList < String > friendsToConfirm;
    
    //------Newly added fields : --------------------------------
    private ArrayList < String > creditRequests; 
    /*CreditRequests holds strings that contain
     * information about GameQuestion objects */
    private Map < String, String > creditReport; 
    /*CreditReport uses the user's friends' names 
     *as keys, and uses the total number of 
     *credits shared by user and his friends as values */
    
    //~ Constructor ...........................................................
    // ----------------------------------------------------------
    /**
     * Creates a new Entity object.
     */
    public Entity()
    {
        name = null;
        pictureUrl = "http://fms.mesa.k12.co.us/staff/dturner" 
            + "/images/QuestionMark.gif";
        friends = new ArrayList < String > ();
        friendsToConfirm = new ArrayList < String > ();
        
        //----Newly added instantiations : -----------------------
        creditRequests = new ArrayList < String > ();
        creditReport =  new HashMap < String, String > ();
    }

    //~ Methods ...............................................................
    /**
     * An accessor for this entity's name.
     * @return the name for this entity. The name is the unique identifier 
     * for this entity, just like a "user name" or a "profile name"
     */
    public String getName() 
    {
        return name; 
    }
    // ---------------------------------------------------------- 
    /**
     * Change this entity's name.
     * @param newName The new name for this entity
     */
    public void setName(String newName) 
    {
        name = newName; 
    }
    // ---------------------------------------------------------- 
    /**
     * An accessor for this entity's picture URL.
     * @return this entity's picture URL.A picture URL is an 
     * optional picture associated with the entity that can be 
     * displayed on the corresponding home page
     */
    public String getPictureUrl() 
    {
        return pictureUrl; 
    }
    // ---------------------------------------------------------- 
    /**
     * Change this entity's picture URL.
     * @param newPictureUrl  The new picture URL for this entity. 
     */
    public void setPictureUrl(String newPictureUrl) 
    {
        pictureUrl = newPictureUrl; 
    }
    // ---------------------------------------------------------- 
    /**
     * Retrieve a list of user names of the current user's friends.
     * @return friendList  A list of friends for current user. 
     */
    public ArrayList < String > getFriends() 
    {
        return  friends;
    }
    // ---------------------------------------------------------- 
    /**
     * Retrieve a list of user names of users who have sent friend 
     * request to the current user.
     * @return  A list of users who have sent friend 
     * request to the current user.
     */
    public ArrayList < String > getFriendsToConfirm() 
    {
        return  friendsToConfirm;
    }
    // ---------------------------------------------------------- 
    /**
     * Send a friend request to the user being viewed.
     * @param userBeingViewed the user being viewed.
     */
    public void sendFriendRequest(UserProfile userBeingViewed) 
    {
        if (!(userBeingViewed.getFriends().contains(this.name))) 
        {
            userBeingViewed.getFriendsToConfirm().add(this.name);
        }
        else
        {
            return;
        }
    }
    
    // -----------Newly modified methods : ----------------------
    // ---------------------------------------------------------- 
    /**
     * Add the user being viewed to current user's profile.
     * @param newFriend the new friend's user profile.
     */
    public void addFriend(UserProfile newFriend) 
    {
        if (friends.contains(newFriend.getName()))
        {
            return;
        }
        else
        {
            //add friends bi-directionally
            friends.add(newFriend.getName());
            newFriend.getFriends().add(this.getName()); 
            //remove the friend request from friend request list
            friendsToConfirm.remove(newFriend.getName()); 
            //update frienship credit report
            creditReport.put(newFriend.getName(), "0");
            newFriend.getCreditReport().put(this.getName(), "0");
        }
        
    }
    // ---------------------------------------------------------- 
    /**
     * Remove the user being viewed from current user's friend list.
     * @param friendToRemove user profile of the friend to be removed.
     */
    public void removeFriend(UserProfile friendToRemove) 
    {
        if (friends.contains(friendToRemove.getName()))
        {
            //remove friends bi-directionally
            friends.remove(friendToRemove.getName());
            friendToRemove.getFriends().remove(this.getName());
            //update frienship credit report
            creditReport.remove(friendToRemove.getName());
            friendToRemove.getCreditReport().remove(this.getName());
        }
        else
        {
            return;
        }
    }
    
    // -----------Newly added methods : -------------------------
    // ---------------------------------------------------------- 
    /**
     * Retrieve a list of credit requests, each containing
     * the answerer's name, the question, the answer, and 
     * the credit value.
     * @return  A list of credit requests to the current user.
     */
    public ArrayList < String > getCreditRequests() 
    {
        return creditRequests;
    }
    // ---------------------------------------------------------- 
    /**
     * Accessor for the creditReport.
     * @return creditReport.
     */
    public Map < String, String > getCreditReport() 
    {
        return creditReport;
    }
}
