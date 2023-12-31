package application;

/**
 * This is the paid user account in which they wont have restrictions on skips and 
 * wont be subjugated to ads. Though they will have the option to cancel their subscription
 * Outside of that it will share things from the account abstract class and user
 * interface. Namely the variables name, subtype, playlist, and the function delete account
 * from account class and the add to playlist function from the interface
 */
public class PaidUser extends account implements user{
	//default constructor for paid users 
	public PaidUser() {
		super("", true);
	}
	//this method sets the username
	public void setName(String name) {
		this.name = name;
	}
	
	//this will turn your subscription into a freetype
	public static void cancelSub() {
		subType = false;
	}

}
