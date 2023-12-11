package application;

/**
 * the free user is a person that isnt paying a subscription fee and thus
 * will only have a limited number of skips and will have a list of ads assigned 
 * to them. They will also have the option to start to pay for the service. 
 * Outside of that it will share things from the account abstract class and user
 * interface. Namely the variables name, subtype, playlist, and the function delete account
 * from account class and the add to playlist function from the interface
 */
public class FreeUser extends account implements user{
	//constuctor that establishes this class as a free user
	public FreeUser() {
		super("", false);
	}
	//unlike the paid user subscription there will only be a limited amount of skips
	private int availableSkips = 3;
	//An array of strings that contain the various ads that will play
	//for a free user
	
	private String[] ads = {"toyota","snickers","insurance"}; 
	
	//this method sets the username
	public void setName(String name) {
		this.name = name;
	}

	
	@Override
	public void skip() {
		// TODO Auto-generated method stub
		
	}
	
	//this will turn your subscritpion into a paidtype
	public void cancelSub() {
		subType = true;
		
	}


}
