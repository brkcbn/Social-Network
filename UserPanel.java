import java.util.Scanner;

import org.omg.CosNaming.IstringHelper;

public class UserPanel {

	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		
		int option = 0;
		
		User user0 = new User("Walter",	"zero@gmail.com","01/01/1990","USA"); // Our main user. We will do all operations on him.
		
		user0.userList.add(user0);
		
		user0.addDefaultUsers(); // These are users of our social network application. They do not follow each other at the beginning.
		
		System.out.print("Welcome " + user0.getName() + ". ");
		do 
		{	
			System.out.println("Please choose a operation which you want; \n");
			System.out.println("[1] Show Inbox");
			System.out.println("[2] Show Outbox");
			System.out.println("[3] Send Message");
			System.out.println("[4] Share Post");
			System.out.println("[5] Show Timeline");
			System.out.println("[6] Show Contact List");
			System.out.println("[7] Show Notifications");
			System.out.println("[8] Follow People");
			System.out.println("[0] Quit");
			
			System.out.println("Your Choise : ");
							
			option = scan.nextInt();
				
			if(option < 0 || option > 8 ) // String girildiði zaman hata ver !!!!!
			{
				System.out.println("Error !");
			}
			else
			{				
				if(option == 1)
				{
					user0.listIncomingMessages();
				}
				
				else if(option == 2)
				{
					user0.listOutgoingMessages();
				}
				
				else if(option == 3)
				{
					System.out.println("Choose the person whom you want to send message: ");
					user0.listUsers();
					
					System.out.println("Your Choise: ");
					option = scan.nextInt();
										
					
					System.out.println("Enter the message you want to send: ");
					String text = scan.next();
					
					Message m = new Message(user0, user0.userList.get(option), text);
					
					if(m.compareFollowedUsers(user0, user0.userList.get(option)))
					{
						user0.sendMessage(m);
					
						System.out.println("Message sent");
					}
					
					else 
					{
						System.out.println("Message not sent. You are not following each other.");
					}					
					
				}
				
				else if(option == 4)
				{
					System.out.println("Please enter a post: ");
					String text = scan.next();
					
					Post post = new Post(user0, text);
					
					user0.sharePost(post);
				}
				
				else if(option == 5)
				{
					user0.showTimeLine();
				}
				
				else if(option == 6)
				{
					 user0.listFollowedUsers();
				}
				
				else if(option == 7)
				{
					user0.listNotifications();				
				}
				
				else if(option == 8)
				{
					System.out.println("Choose and enter id number of user's which you want to follow.");
					user0.listUsers();

					System.out.println("Your Choise: ");
					option = scan.nextInt();
					
					user0.followUser(option);
					
					System.out.println("You follow " + user0.userList.get(option).getName());
					
					user0.sendNotification(user0, option);
				}
			}			
		} while (option != 0);
		
		System.out.println("Program is finished.");
	}
}
