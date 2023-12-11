package application;

import java.util.ArrayList;
import java.util.List;

// Song class represents an individual song
class Song 
{
	//private variables for title, artist, genre, duration
    private String title;
    private String artist;
    private String genre;
    private int duration;

    public Song(String title, String artist, String genre, int duration) 
    {
        this.title = title;
        this.artist = artist;
        this.genre = genre;
        this.duration = duration;
    }

    //Gets the title of a song
    public String getTitle() 
    {
        return title;
    }

    //Returns the name of an artist
    public String getArtist() 
    {
        return artist;
    }

    //Returns the genre of a song
    public String getGenre() 
    {
        return genre;
    }

    //Returns the duration of a song
    public int getDuration() 
    {
        return duration;
    }

    //Returns all the strings for the songID
    public String toString()
    {
        return "Song: " + title + " by " + artist + " (" + genre + ", " + duration + "s)";
    }

    //Equals and hashCode will determine if a song is already in the playlist
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Song song = (Song) obj;
        return title.equals(song.title) && artist.equals(song.artist);
    }

    //This will return an integer value generated by a hashing algorithm
    @Override
    public int hashCode() 
    {
        return title.hashCode() + artist.hashCode();
    }
}

// Playlist class represents a collection of songs
class Playlist 
{
    private static String name;
    List<Song> songs;
    private String createdBy;

    public Playlist(String name, String createdBy) 
    {
        Playlist.name = name;
        this.createdBy = createdBy;
        songs = new ArrayList<>();
    }

    //This will get the name of the playlist
    public static String getName() 
    {
        return name;
    }

    //Returns the name of the creator of the playlist
    public String getCreatedBy() 
    {
        return createdBy;
    }

    //This wilil add a song to the playlist
    public void addSong(Song song) 
    {
    	//This will throw an exception if a song is already in the playlist
        if (songs.contains(song)) 
        {
            throw new IllegalArgumentException("Song already exists in the playlist");
        }
        songs.add(song);
    }

    //This will remove a song from the playlist
    public void removeSong(Song song) 
    {
        songs.remove(song);
    }

    //This will return the list of songs
    public List<Song> getSongs() 
    {
        return songs;
    }
}

//The SongPlayer class simulates playing songs from a playlist
class SongPlayer
{
    static List<Song> playlist;
    private static int currentSongIndex;
    static boolean isPlaying;

    public SongPlayer() 
    {
        SongPlayer.playlist = new ArrayList<>(); // Using ArrayList to allow modifications
        SongPlayer.currentSongIndex = 0;
    }

    //This will play the song
    public static void play(Song song)
    {
        isPlaying = true;
        System.out.println("Now playing: " + song);
    }

    //This will pause the song
    public static void pause() 
    {
        if (isPlaying) 
        {
            isPlaying = false;
            System.out.println("Paused: " + playlist.get(currentSongIndex));
        } 
        else
        {
            System.out.println("Already paused");
        }
    }

    //This will skip forwards
    public static void skipf() 
    {
        if (!playlist.isEmpty()) 
        {
            if (isPlaying) 
            {
                System.out.println("Skipping: " + playlist.get(currentSongIndex));
                currentSongIndex = (currentSongIndex + 1) % playlist.size();
                play(playlist.get(currentSongIndex));
            } 
            else 
            {
                System.out.println("Not currently playing. Cannot skip.");
            }
        } 
        else
        {
            System.out.println("Playlist is empty. Cannot skip.");
        }
    }
    
    //This will skip backwards
    public static void skipb() 
    {
        if (!playlist.isEmpty()) 
        {
            if (isPlaying) 
            {
                System.out.println("Skipping: " + playlist.get(currentSongIndex));
                currentSongIndex = (currentSongIndex - 1) % playlist.size();
                play(playlist.get(currentSongIndex));
            } 
            else 
            {
                System.out.println("Not currently playing. Cannot skip.");
            }
        } 
        else
        {
            System.out.println("Playlist is empty. Cannot skip.");
        }
    }

    public void playPlaylist(Playlist playlist) 
    {
        SongPlayer.playlist = playlist.getSongs();
        currentSongIndex = 0;

        if (!SongPlayer.playlist.isEmpty()) 
        {
            play(SongPlayer.playlist.get(currentSongIndex));
        } 
        else 
        {
            System.out.println("Playlist is empty. Cannot play.");
        }
    }


}

// Example usage
public class Songs
{
    public static void main(String[] args) 
    {
        //This will create the songs
        Song song1 = new Song("Song 1", "Jaden", "Rock", 180);
        Song song2 = new Song("Song 2", "Garreth", "City Pop", 210);
        Song song3 = new Song("Song 3", "Claude", "Jazz", 150);

        //This will create a playlist with a name and createdBy information
        Playlist playlist = new Playlist("THE Playlist", "Music Group");

        //This will add songs to the playlist
        playlist.addSong(song1);
        playlist.addSong(song2);
        playlist.addSong(song3);

        //This will create the SongPlayer
        SongPlayer songPlayer = new SongPlayer();

        //This will play the playlist
        songPlayer.playPlaylist(playlist);

        //This will pause, skip, stop the songs
        //songPlayer.pause();
        //songPlayer.skip();
        //songPlayer.stop();
    }
}