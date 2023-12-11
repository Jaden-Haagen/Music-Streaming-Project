package application;

import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.List;

//The Song class will have ID for a single song
class Song 
{
    //Declaring privage variables
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
    public boolean equals(Object obj) 
    {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Song song = (Song) obj;
        return title.equals(song.title) && artist.equals(song.artist);
    }

    @Override
    public int hashCode() {
        return title.hashCode() + artist.hashCode();
    }
}

// Playlist class represents a collection of songs
class Playlist 
{
    private String name;
    private List<Song> songs;
    private String createdBy;

    public Playlist(String name, String createdBy) 
    {
        this.name = name;
        this.createdBy = createdBy;
        songs = new ArrayList<>();
    }

    //This will get the name of the playlist
    public String getName() 
    {
        return name;
    }

    //Returns the name of the creator of the playlist
    public String getCreatedBy() 
    {
        return createdBy;
    }

    //This will add a song to the playlist
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

// SongPlayer class simulates playing songs from a playlist
class SongPlayer
{
    private List<Song> playlist;
    private int currentSongIndex;
    private boolean isPlaying;

    public SongPlayer() 
    {
        this.playlist = new ArrayList<>(); // Using ArrayList to allow modifications
        this.currentSongIndex = 0;
    }

    //This will play the song
    public void play(Song song)
    {
        isPlaying = true;
        System.out.println("Now playing: " + song);
    }

    //This will pause the song
    public void pause() 
    {
        //if else statement if a song is playing or not
        if (isPlaying) 
        {
            isPlaying = false;
            System.out.println("Paused: " + playlist.get(currentSongIndex));
        }
        //
        else
        {
            System.out.println("Already paused");
        }
    }

    //This will skip the song
    public void skip() 
    {
        if (!playlist.isEmpty()) 
        {
            //This will see if a song is currently playing and then skip it
            if (isPlaying) 
            {
                System.out.println("Skipping: " + playlist.get(currentSongIndex));
                currentSongIndex = (currentSongIndex + 1) % playlist.size();
                play(playlist.get(currentSongIndex));
            } 
            //This will print out if there is no song currently playing
            else 
            {
                System.out.println("Not currently playing. Cannot skip.");
            }
        } 
        //This will print out the if the playlist is empty
        else
        {
            System.out.println("Playlist is empty. Cannot skip.");
        }
    }

    //This will stop the current song
    public void stop() 
    {
        if (isPlaying)
        {
            isPlaying = false;
            System.out.println("Stopped: " + playlist.get(currentSongIndex));
        } 
        else
        {
            System.out.println("Already stopped");
        }
    }

    public void playPlaylist(Playlist playlist) 
    {
        stop();

        this.playlist = playlist.getSongs();
        currentSongIndex = 0;

        if (!this.playlist.isEmpty()) 
        {
            play(this.playlist.get(currentSongIndex));
        } 
        else 
        {
            System.out.println("Playlist is empty. Cannot play.");
        }
    }


}

//main class
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
        playlist.addSong(song2);
        playlist.addSong(song1);
        playlist.addSong(song3);
    }
}
