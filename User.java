import java.util.ArrayList;

public class User 
{
	private String name;
	private String email;
	private String dateOfBirth;
	private String placeOfRecidence;
	
	public ArrayList<User> userList = new ArrayList<User>();;
	
	private ArrayList<String> notificationBox;
	private ArrayList<Post> postList;
	private ArrayList<Post> timeLine;
	private ArrayList<Post> favouritePostList;
	private ArrayList<User> followedUserList;
	private ArrayList<Message> incomingMessages;
	private ArrayList<Message> outGoingMessages;
	
	public User(String name, String email, String dateOfBirth, String placeOfRecidence) 
	{
		this.name = name;
		this.email = email;
		this.dateOfBirth = dateOfBirth;
		this.placeOfRecidence = placeOfRecidence;
		
		
		notificationBox = new ArrayList<String>();
		postList = new ArrayList<Post>();
		timeLine = new ArrayList<Post>();
		favouritePostList = new ArrayList<Post>();
		followedUserList = new ArrayList<User>();
		incomingMessages = new ArrayList<Message>();
		outGoingMessages = new ArrayList<Message>();	
		
	}
	
	public String getName() 
	{
		return name;
	}
	
	public String getDateOfBirth() 
	{
		return dateOfBirth;
	}	
	
	public ArrayList<User> getFollowedUserList() 
	{
		return followedUserList;
	}
	
    public void addDefaultUsers()
	{
    	User user1 = new User("Burak", "one@gmail.com", "01/01/1990", "Turkey"); // These are users of our social network application. They do not follow each other at the beginning.
		User user2 = new User("Emre", "two@gmail.com", "02/01/1990", "Turkey");
		User user3 = new User("Messi", "three@gmail.com", "03/01/1990", "Argentina");
		User user4 = new User("Ronaldo", "four@gmail.com", "04/01/1990", "Portugal");
		User user5 = new User("Salah", "five@gmail.com", "05/01/1990", "Egypt");
		User user6 = new User("Happy", "six@gmail.com", "06/01/1990", "Korea");
		User user7 = new User("Toby", "seven@gmail.com", "07/01/1990", "Canada");
		User user8 = new User("Slyvester", "eight@gmail.com", "08/01/1990", "Spain");
		User user9 = new User("Paige", "nine@gmail.com", "09/01/1990", "Ireland");
		
		userList.add(user1); // We hold these users on ArrayList of userList, but followers held on ArrayList of followedUserList.
		userList.add(user2);
		userList.add(user3);
		userList.add(user4);
		userList.add(user5);
		userList.add(user6);
		userList.add(user7);
		userList.add(user8);
		userList.add(user9);	
	}

	public void followUser(int index) 
	{
		if(index < 0 || index > userList.size())
		{
			System.out.println("Undefined user index. Please enter acceptable number.");
		}
		else
		{
			followedUserList.add(userList.get(index));			
		}
	}
	
	public void listUsers()
	{
		for (int i = 0; i < userList.size(); i++) 
		{
			System.out.println(i + ". " + userList.get(i).name);
		}
	}
	
	public void listFollowedUsers()
	{
		for (int i = 0; i < followedUserList.size(); i++) 
		{
			System.out.println(i + ". " + followedUserList.get(i).name);
		}
	}
	
	public void sendNotification(User user, int index)
	{
		userList.get(index).notificationBox.add(user.getName() + " follows you");
	}
	
	public void listNotifications()
	{
		for (int i = 0; i < notificationBox.size(); i++) 
		{
			System.out.println(i);			
		}
	}
	
	public void sendMessage(Message message)
	{
		message.getSender().outGoingMessages.add(message);
		
		message.getReceiver().incomingMessages.add(message);
	}
	

	public void listIncomingMessages()
	{
		for (int i = 0; i < incomingMessages.size(); i++) 
		{
			System.out.println(i);			
		}
	}
	
	public void listOutgoingMessages()
	{
		for (int i = 0; i < outGoingMessages.size(); i++) 
		{
			System.out.println(i);			
		}
	}
	
	public void sharePost(Post post)
	{
		postList.add(post);
	}
	
	public void showTimeLine()
	{
		for (Post post : timeLine) 
		{
			System.out.println("Shared by : " + post.getWhom() + "\n" +
								"Post : " + post.getPostText() + "\n" +
								"Likes : " + post.getLikes() + "\n" 
								);
			
		}
	}


}
