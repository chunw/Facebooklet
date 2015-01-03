
import student.*;
import java.util.*;

// -------------------------------------------------------------------------
/**
* UserProfile defines the individual, extra features provided
* by entity of user-profile type.
*
* A user profile is used to manage information
* for individual users.
* The corresponding user's password, e-mail address,
* the URL for his "thumbnail" image, user's biography
* and the description for people user's interested in
* are not specified via the constructor.
*
* @author chun91
* @version 2012.01.31
*/
public class UserProfile extends Entity
{
    //~ Instance/static variables .............................................
    private String password;
    private String email;
    private String pictureThumbUrl;
    private String bio;
    private String peopleInterested;
    private String status;
    private ArrayList < WallPosting > wall;
    
    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
    * Creates a new UserProfile object.
    */
    public UserProfile()
    {
        password = null;
        email = null;
        pictureThumbUrl = 
            "http://fms.mesa.k12.co.us/staff/dturner" +
            "/images/QuestionMark.gif";
        bio = null;
        peopleInterested = null;
        status = null;
        wall = new ArrayList < WallPosting > ();
    }
    /**
    * Creates a new UserProfile object.
    * @param name the user's name.
    */
    public UserProfile(String name)
    {
        this.setName(name);
        password = null;
        email = null;
        pictureThumbUrl = 
            "http://fms.mesa.k12.co.us/staff/dturner" +
            "/images/QuestionMark.gif";
        bio = null;
        peopleInterested = null;
        status = null;
        wall = new ArrayList < WallPosting > ();
    }
    
    //~ Methods ...............................................................
    /**
    * An accessor for this user-profile's password.
    * @return the password associated with this user-profile.
    */
    public String getPassword()
    {
        return password;
    }
    // ----------------------------------------------------------
    /**
    * Change this user-profile's password.
    * @param newPassword The new password
    * associated with this user-profile
    */
    public void setPassword(String newPassword)
    {
        password = newPassword;
    }
    // ----------------------------------------------------------
    /**
    * An accessor for this user's  optional e-mail address.
    * @return the email address of this user.
    */
    public String getEmail()
    {
        return email;
    }
    // ----------------------------------------------------------
    /**
    * Change this user's email.
    * @param newEmail The user's new email
    */
    public void setEmail(String newEmail)
    {
        email = newEmail;
    }
    // ----------------------------------------------------------
    /**
    * An accessor for the URL of this user's "thumbnail" image.
    * A "thumbnail" image is a much smaller version of
    * the user's picture that might be used alongside
    * postings or in friends lists.
    * @return the URL of this user's "thumbnail" image
    */
    public String getPictureThumbUrl()
    {
        return pictureThumbUrl;
    }
    // ----------------------------------------------------------
    /**
    * Change the URL of this user's "thumbnail" image.
    * @param newPictureThumbUrl The new the URL of
    * this user's "thumbnail" image
    */
    public void setPictureThumbUrl(String newPictureThumbUrl)
    {
        pictureThumbUrl = newPictureThumbUrl;
    }
    // ----------------------------------------------------------
    /**
    * An accessor for this user's biography.
    * @return the user's biography
    */
    public String getBio()
    {
        return bio;
    }
    // ----------------------------------------------------------
    /**
    * Change this user's biography.
    * @param newBio The new biography
    */
    public void setBio(String newBio)
    {
        bio = newBio;
    }
    /**
     * An accessor for the description this user
     * given about the people they are interested in
     * having network with.
     * @return the description about
     * people the user has interest in
     */
    public String getPeopleInterested()
    {
        return peopleInterested;
    }
    // ----------------------------------------------------------
    /**
    * Change the description about people the user has interest in.
    * @param newPeopleInterested The user's new description
    * about people the user has interest in.
    */
    public void setPeopleInterested(String newPeopleInterested)
    {
        peopleInterested = newPeopleInterested;
    }
    // ----------------------------------------------------------
    /**
    * An accessor for this user's  current status.
    * @return the status of this user.
    */
    public String getStatus()
    {
        return status;
    }
    // -----------------------------------------------------------
    /**
    * Change this user's current status.
    * @param newStatus The user's new status
    */
    public void setStatus(String newStatus)
    {
        status = newStatus;
    }
    // -----------------------------------------------------------
    /**
    * Accessor to the user's wall postings.
    * @return the user's wall postings.
    */
    public ArrayList < WallPosting > getWall() 
    {
        return wall;
    }
    // -----------------------------------------------------------
    /**
    * Post the user's message to the wall.
    * @param author the posting author's profile.
    * @param message the message to be posted.
    */
    public void postToWall(UserProfile author, String message)
    {
        WallPosting thisPost = new WallPosting(author, message);
        //WallPosting thisPost = new WallPosting();
        //thisPost.getAuthorName() = author.getName();
        //thisPost.getMessage() = message;  
        //thisPost.getDate() = new Date(); 
        if (wall.size() >= 20)
        {
            wall.remove(19);
        }
        wall.add(0 , thisPost);
    }
}
