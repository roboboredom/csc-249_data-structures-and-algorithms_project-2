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

public class Playlist
{
    /*
     * Declare private variables:
     * 
     * The "m_" prefix denotes a variable as class member, 
     * avoiding name collsion with variables outside the class. 
     */
    private Song m_head; // Reference to dummy Song object at the head of the list.
    private Song m_tail; // Reference to dummy Song object at the tail of the list.
    private int m_size; // Number of non-null references to non-dummy Song objects in the list.

    /*
     * Declare methods
     */
    public void appendSong(Song s) // Accepts a Song object reference and inserts it before the tail dummy node.
    {   
        // Get the nodes that will be before and after the new node once it is inserted.
        Song nodeToInsertNewNodeAfter = m_tail.getPreviousSong();
        Song nodeToInsertNewNodeBefore = m_tail;

        // Link the pointers of the new node to its surrounding nodes.
        s.setNextSong(nodeToInsertNewNodeBefore);
        s.setPreviousSong(nodeToInsertNewNodeAfter);

        // Link the pointers of the nodes surrounding the new node to it.
        nodeToInsertNewNodeAfter.setNextSong(s);
        nodeToInsertNewNodeBefore.setPreviousSong(s);

        // Increment number of non-null references to non-dummy Song objects in the list by 1.
        m_size++;
    }

    // Accepts 2 Song object references. Inserts the 1st (parameter "s") after the position of the 2nd (parameter "currentlyPlayingSong").
    public void insertSongAfterCurrentlyPlayingSong(Song s, Song currentlyPlayingSong)
    {
        // Get the 2 nodes that will surround the new node after it's insertion between them.
        Song nodeToInsertNewNodeAfter = currentlyPlayingSong;
        Song nodeToInsertNewNodeBefore = currentlyPlayingSong.getNextSong();

        // Link the pointers of the new node to its surrounding nodes.
        s.setNextSong(nodeToInsertNewNodeBefore);
        s.setPreviousSong(nodeToInsertNewNodeAfter);

        // Link the pointers of the nodes surrounding the new node to it.
        nodeToInsertNewNodeAfter.setNextSong(s);
        nodeToInsertNewNodeBefore.setPreviousSong(s);

        // Increment number of non-null references to non-dummy Song objects in the list by 1.
        m_size++;
    }

    public void deleteSong(Song s) // Accepts a Song object reference and deletes any nodes that match it's name field.
    {
        /* 
         * Traverse through all non-dummy non-null nodes, deleting any matches.
         * If the next node after the current node is null, stop (as it means the current node is the tail dummy node).
         */
        Song currentNode = m_head.getNextSong(); // Start at node after head dummy node.
        
        while(currentNode.getNextSong() != null)
        {
            // Check for matching name field.
            if (currentNode.getName().equals(s.getName())) 
            {
                // Save next node temporarily...
                Song nextNodeToCheck = currentNode.getNextSong();
                
                // Link nodes surrounding currentNode together...
                currentNode.getNextSong().setPreviousSong(currentNode.getPreviousSong());
                currentNode.getPreviousSong().setNextSong(currentNode.getNextSong());

                // Unlink the Song object currentNode points to from the list entirely. The garbage collector will automatically delete it.
                currentNode.setNextSong(null);
                currentNode.setPreviousSong(null);

                // Decrement number of non-null references to non-dummy Song objects in the list by 1.
                m_size--;

                // ...change current node to temporarily saved next node
                currentNode = nextNodeToCheck;
            }
            else 
            {
                // Change current node to next node.
                currentNode = currentNode.getNextSong();
            }
        }
    }

    public String toString() // Return a string containing playlist info: the contents of the playlist, the number of songs, and the total length in minutes and seconds.
    {
        String playlistInfo = "Current Playlist Data:\nSongs:\n";

        int totalPlaylistTime = 0; // Total length of the playlist in seconds.

        /* 
         * Traverse through all non-dummy non-null nodes, gathering song data.
         * If the next node after the current node is null, stop (as it means the current node is the tail dummy node).
         */
        Song currentNode = m_head.getNextSong(); // Start at node after head dummy node.

        while(currentNode.getNextSong() != null)
        {
            playlistInfo += "\tSong Name: " + currentNode.getName() + "\n";
            playlistInfo += "\tSong Artist: " + currentNode.getArtist() + "\n";
            playlistInfo += "\tSong Album: " + currentNode.getAlbum() + "\n";
            playlistInfo += "\tSong Length (seconds): " + currentNode.getLength() + "\n\n";
            
            // Add song length to running total.
            totalPlaylistTime += currentNode.getLength();

            // Change current node to next node.
            currentNode = currentNode.getNextSong();
        }

        playlistInfo += "Total Playlist Length (seconds): " + totalPlaylistTime + "\n";
        playlistInfo += "Total Playlist Length (minutes): " + totalPlaylistTime / 60 + "\n\n";
        
        playlistInfo += "Total Number of Songs: " + m_size + "\n\n";

        return playlistInfo;
    }

    public int getSize() // Get the current number of non-null references to non-dummy Song objects in the list.
    {
        return m_size;
    }

    public Song getHeadNode()
    {
        return m_head;
    }

    public Song getTailNode()
    {
        return m_tail;
    }

    /* 
     * Declare constructors: 
     */
    public Playlist() // No-arg constructor.
    {
        // Instantiate new Song object to function as the head dummy node.
        m_head = new Song();

        // Instantiate new Song object to function as the tail dummy node.
        m_tail = new Song();

        // Link the head and tail dummy nodes.
        m_head.setNextSong(m_tail);
        m_tail.setPreviousSong(m_head);

        // Intialize to zero as there are no non-null references to non-dummy Song objects in the list yet.
        m_size = 0;
    }
}
