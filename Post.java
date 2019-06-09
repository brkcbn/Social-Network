import java.util.ArrayList;
import java.util.Date;

public class Post
{
	private User whom;
	private String postText;
	private Date date;
	
	private ArrayList<User> likes;
	
	Administrator admin = new Administrator();

	public Post(User whom, String postText) 
	{
		this.whom = whom;
		this.postText = postText;
		date = admin.takeCurrentTime();
		
		likes = new ArrayList<User>();
	}

	public User getWhom() 
	{
		return whom;
	}

	public String getPostText() 
	{
		return postText;
	}

	public ArrayList<User> getLikes() 
	{
		return likes;
	}
	
	
	
	
}
