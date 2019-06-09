
public class Message 
{
	private User sender;
	private User receiver;
	private String message;

	public Message(User sender, User receiver, String message) 
	{
		this.sender = sender;
		this.receiver = receiver;
		this.message = message;
	}

	public User getSender() 
	{
		return sender;
	}

	public User getReceiver() 
	{
		return receiver;
	}

	public String getMessage() 
	{
		return message;
	}
	
	public boolean compareFollowedUsers(User user1, User user2) 
	{
		boolean flag = false;
		for (User u1 : user1.getFollowedUserList()) 
		{
			for (User u2 : user2.getFollowedUserList()) 
			{
				if(u1 == u2)
				{
					flag = true;
					System.out.println("You can send message.");
				}
				else
				{
					flag = false;
					System.out.println("You can not send message. You are not following each other.");
				}
			}
		}
		
		return flag;
	}
	
}
