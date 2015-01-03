import java.util.*;
import student.*;
import student.web.*;
import java.text.*;

// -------------------------------------------------------------------------
/**
* A WallPosting class represents a wall posting from an author, the
* current user, on a user's wall.
*
* @author  chun91
* @version 2012.04.04
*/
public class WallPosting 
{
    //~ Instance/static variables .............................................
    private String authorName; 
    private String message;
    private Date date;

    //~ Constructor ...........................................................
    // ----------------------------------------------------------
    /**
    * Creates a new WallPosting object.
    */
    public WallPosting()
    {   
      //do nothing
    }
    // ----------------------------------------------------------
    /**
    * Creates a new WallPosting object.
    * @param author the author of the post.
    * @param newMessage the message of the post.
    */
    public WallPosting(UserProfile author, String newMessage)
    {   
        authorName = author.getName();
        message = newMessage;  
        date = new Date(); 
    }

    //~ Methods ...............................................................
    // ----------------------------------------------------------
    /**
    * Get the author's message.
    * @return the author's message.
    */
    public String getMessage()
    {
        return message;
    }
    // ----------------------------------------------------------
    /**
    * Get the date.
    * @return the date.
    */
    public Date getDate()
    {
        return date;
    }
     // ----------------------------------------------------------
    /**
    * Get the author name.
    * @return the author name.
    */
    public String getAuthorName()
    {
        return authorName;
    }
    // ----------------------------------------------------------
    /**
    * Get the author's user profile.
    * @return the author's user profile.
    */
    public UserProfile getAuthor()
    {
        //UserProfile profile = new UserProfile();
        if (!(authorName == null) && !(authorName.equals("")))
        {
            SharedPersistentMap < UserProfile > profileMap = 
                new SharedPersistentMap < UserProfile > (UserProfile.class);
            return profileMap.get(authorName);
        }
        return null;
           /* if (!(profileMap.get(authorName) == null))
            {
                profile = profileMap.get(authorName);
            }
            else
            {
                profile = null;
            }
        }
        else
        {
            profile = null;
        }
        return profile;*/
    }
    // ----------------------------------------------------------
    /**
    * Generates a Html representation of post, which consists of
    * a thumbnail image of the author, author's name, message and
    * post date.
    * @return the string Html representation.
    */
    public String toString()
    {
        // format a date
        String output = "";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yy");
        String dateString = simpleDateFormat.format(date);   
        // return string html
        if ((getAuthor().getPictureThumbUrl() != null) 
            && !(getAuthor().getPictureThumbUrl().equals("")))
        {
            //String string = 
            output = "<p><img width=" + '"' + "80" + '"' + "height=" 
                + '"' + "80" + '"' + "src = " + '"' + 
                getAuthor().getPictureThumbUrl() 
                + '"' + "/></p>" + "<h4>" + getAuthor().getName() 
                + " says: </h4>" + "<p>" + getMessage() + "</p>" 
                + "<p>" + dateString + "</p>";
            return output;
        }
        else
        {
            return "Please upload a thumbnail image before posting.";
        }
    }
}
