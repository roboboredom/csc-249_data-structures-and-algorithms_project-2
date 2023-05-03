/*
 * Date: 3/14/2023
 * Author: Willem Dawson Gray.
 * Class: CSC-249 Data Structures and Algorithms.
 * Assignment: Programming Project 1.
 * Description: 
 *     In this program, the Playlist class will function as a doubly-linked 
 *     list that contains Song objects. The Demo class will be used to make 
 *     modifications to the Playlist atthe command of the user, such as adding 
 *     or removing Song objects, etc.
 */

package com.github.roboboredom;

public class Song
{
    /*
     * Declare private variables:
     * 
     * The "m_" prefix denotes a variable as class member, 
     * avoiding name collsion with variables outside the class. 
     */
    private String m_name; // Name of the song.
    private String m_artist; // Name of the song's artist.
    private String m_album; // Name of the song's album.
    
    private int m_length; // Length of the song in seconds.
    
    private Song m_next; // Reference to the next Song object in the list.
    private Song m_previous; // Reference to the previous Song object in the list.

    /*
     * Declare setters for private variables:
     */
    public void setName(String name) // Set the name of the song.
    {
        m_name = name;
    }

    public void setArtist(String artist) // Set the name of the song's artist.
    {
        m_artist = artist;
    }

    public void setAlbum(String album) // Set the name of the song's album.
    {
        m_album = album;
    }

    public void setLength(int length) // Set the length of the song in seconds.
    {
        m_length = length;
    }
    
    public void setNextSong(Song s) // Set a reference to the next Song object in the list, or null if there is none.
    {
        m_next = s;
    }

    public void setPreviousSong(Song s) // Set a reference to the previous Song object in the list, or null if there is none.
    {
        m_previous = s;
    }

    /* 
     * Declare getters for private variables: 
     */
    public String getName() // Get the name of the song.
    {
        return m_name;
    }

    public String getArtist() // Get the name of the song's artist.
    {
        return m_artist;
    }

    public String getAlbum() // Get the name of the song's album.
    {
        return m_album;
    }

    public int getLength() // Get the length of the song in seconds.
    {
        return m_length;
    }

    public Song getNextSong() // Get a reference to the next Song object in the list, or null if there is none.
    {
        return m_next;
    }

    public Song getPreviousSong() // Get a reference to the previous Song object in the list, or null if there is none.
    {
        return m_previous;
    }

    /* 
     * Declare constructors: 
     */
    public Song() // No-arg constructor.
    {
        // Intialize private variables to default/placeholder values.
        m_name = "Song Name Here";
        m_artist = "Artist Name Here";
        m_album = "Album Name Here";

        m_length = 0;

        // Intialize next and previous node references to null. This node is not in a list yet.
        m_next = null;
        m_previous = null;
    }

    public Song(String name, String artist, String album, int length) // Arg constructor.
    {
        m_name = name;
        m_artist = artist;
        m_album = album;

        m_length = length;

        // Intialize next and previous node references to null. This node is not in a list yet.
        m_next = null;
        m_previous = null;
    }
}
