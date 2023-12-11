/**
 * This is an interface that will defy the functionality of a user
 * 
 */
public interface user {
	//Sets a user name
	abstract void setName(String name);
	//this will wipe all of the information within an account
	void deleteAccount();
	//allows you to put a name of a song into a playlist/array
	public static String[] addToPlaylist(String[] array, String song) {
		//here we create a array that is one size greater than the original
		String[] newArray = new String[array.length + 1];
		//than we copy the current information into the new array
		System.arraycopy(array, 0, newArray, 0, array.length);
		//then we put the new song into the new array
		newArray[newArray.length -1] = song;
		//return the array
		return newArray;
	}
	
	//this will allow a user to skip a song in a playlist
	abstract void skip();
	
	

}
