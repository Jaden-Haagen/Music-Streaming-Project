package application;

/**
 * The class is used to cover the variables that each user
 * will share, as well as constructors to establish an account
 */
public abstract class account {
	//the user's name
	public String name;
	//a boolean containing whether the user is a paid or free user
	//if they are paid it will be true, otherwise it will be false
	protected static boolean subType;
	//a String array that acts a playlist
	public String[] playList;
	public static int numSkips = 4;
	
	//no arg constructor
	public account() {
		name = "Test User 1";
		subType = false;
	}
	
	//initialization constructor
	public account(String n, boolean s) {
		name = n;
		subType = s;
	}
	//a method that wipes all of the information within an account
	public void deleteAccount() {
		this.name = "";
		playList = new String[0];
		subType = false;
	}
	
	
}
