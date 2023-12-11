package application;

import java.util.ArrayList;
import java.util.List;

// Song class represents an individual song
class Song {
    private String title;
    private String artist;

    public Song(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    @Override
    public java.lang.String toString() {
        return "Song: " + title + " by " + artist;
    }

    // Override equals and hashCode to compare songs based on title and artist
    @Override
    public boolean equals(Object obj) {
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
class Playlist {
    private String name;
    private List<Song> songs;

    public Playlist(String name) {
        this.name = name;
        songs = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addSong(Song song) {
        if (songs.contains(song)) {
            throw new IllegalArgumentException("Song already exists in the playlist");
        }
        songs.add(song);
    }

    public void removeSong(Song song) {
        songs.remove(song);
    }

    public List<Song> getSongs() {
        return songs;
    }
}

// SongPlayer class simulates playing songs from a playlist
class SongPlayer {
    public void playSong(Song song) {
        System.out.println("Now playing: " + song);
    }

    public void playPlaylist(Playlist playlist) {
        List<Song> songs = playlist.getSongs();
        System.out.println("Playlist: " + playlist.getName());
        for (Song song : songs) {
            playSong(song);
        }
    }
}

// Example usage
public class Songs {
    public static void main(String[] args) {
        // Create songs
        Song song1 = new Song("Song 1", "Artist 1");
        Song song2 = new Song("Song 2", "Artist 2");
        Song song3 = new Song("Song 3", "Artist 3");

        // Create a playlist with a name
        Playlist playlist = new Playlist("My Playlist");

        // Add songs to the playlist
        playlist.addSong(song1);
        playlist.addSong(song2);
        playlist.addSong(song3);

        // Try to add a duplicate song (comment out this line to avoid the exception)
        try {
            playlist.addSong(new Song("Song 1", "Artist 1"));
        } catch (IllegalArgumentException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        // Create a SongPlayer and play the playlist
        SongPlayer songPlayer = new SongPlayer();
        songPlayer.playPlaylist(playlist);
    }
}