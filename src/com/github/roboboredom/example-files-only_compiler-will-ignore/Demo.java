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

import java.util.Scanner;

public class Demo
{
    public static void main(String[] args)
    {
        // Instantiate scanner for getting user input.
        Scanner scanner = new Scanner(System.in);
        
        boolean doLoop = true;
        String userInput = "";

        Playlist playlist = new Playlist();
        Song currentSong = null;

        // Main program loop.
        while (doLoop)
        {
            System.out.println("Select an action from the below menu by typing the corresponding number.");
            System.out.println("\t1. Add a song to the playlist.");
            System.out.println("\t2. Insert a new song after the song that is currently playing.");
            System.out.println("\t3. Print the contents of the playlist.");
            System.out.println("\t4. Display the currently playing song.");
            System.out.println("\t5. Remove the current song.");
            System.out.println("\t6. Skip to the next song.");
            System.out.println("\t7. Return to the previous song.");
            System.out.println("\t8. Exit program.");

            userInput = scanner.nextLine();

            if (userInput.equals("1"))
            {
                Song newSong = new Song();

                System.out.println("Enter the song name: "); newSong.setName(scanner.next());
                System.out.println("Enter the song artist: "); newSong.setArtist(scanner.next());
                System.out.println("Enter the song album: "); newSong.setAlbum(scanner.next());
                System.out.println("Enter the song length (in seconds): "); newSong.setLength(Integer.parseInt(scanner.next()));

                playlist.appendSong(newSong);

                if (playlist.getSize() == 1)
                {
                    currentSong = newSong;
                }
            }
            else if (userInput.equals("2"))
            {
                if (currentSong != null)
                {
                    Song newSong = new Song();

                    System.out.println("Enter the song name: "); newSong.setName(scanner.next());
                    System.out.println("Enter the song artist: "); newSong.setArtist(scanner.next());
                    System.out.println("Enter the song album: "); newSong.setAlbum(scanner.next());
                    System.out.println("Enter the song length (in seconds): "); newSong.setLength(Integer.parseInt(scanner.next())); 
                    System.out.println();
                    
                    playlist.insertSongAfterCurrentlyPlayingSong(newSong, currentSong);

                    if (playlist.getSize() == 1)
                    {
                        currentSong = newSong;
                    }
                }
                else
                {
                    System.out.println("There is no currently playing song.");
                }
            }
            else if (userInput.equals("3"))
            {
                if (playlist.getSize() != 0)
                {
                    System.out.println("\n" + playlist.toString());
                }
                else
                {
                    System.out.println("Playlist is currently empty. Please add song(s) first.");
                }
            }
            else if (userInput.equals("4"))
            {
                if (currentSong != null)
                {
                    System.out.println("Currently Playing Song Data: ");
                    System.out.println("\tSong Name: " + currentSong.getName());
                    System.out.println("\tSong Artist: " + currentSong.getArtist());
                    System.out.println("\tSong Album: " + currentSong.getAlbum());
                    System.out.println("\tSong Length (seconds): " + currentSong.getLength() + "\n");
                }
                else
                {
                    System.out.println("There is no currently playing song.");
                }
            }
            else if (userInput.equals("5"))
            {
                if (currentSong != null)
                {
                    if (currentSong.getNextSong().getNextSong() != null)
                    {
                        Song newCurrentSong = currentSong.getNextSong();
                        
                        playlist.deleteSong(currentSong);

                        currentSong = newCurrentSong;
                    }
                    else
                    {   
                        if (playlist.getSize() != 0)
                        {
                            Song newCurrentSong = playlist.getHeadNode().getNextSong();

                            playlist.deleteSong(currentSong);

                            currentSong = newCurrentSong;
                        }
                        else
                        {
                            playlist.deleteSong(currentSong);

                            currentSong = null;
                        }
                    }
                }
                else
                {
                    System.out.println("There is no currently playing song.");
                }
            }
            else if (userInput.equals("6"))
            {
                if (currentSong != null)
                {
                    if (currentSong.getNextSong().getNextSong() != null)
                    {
                        currentSong = currentSong.getNextSong();
                    }
                    else
                    {
                        if (playlist.getSize() != 0)
                        {
                            currentSong = playlist.getHeadNode().getNextSong();
                        }
                        else
                        {
                            currentSong = null;
                        }
                    }
                }
                else
                {
                    System.out.println("There is no currently playing song.");
                }
            }
            else if (userInput.equals("7"))
            {
                if (currentSong != null)
                {
                    if (currentSong.getPreviousSong().getPreviousSong() != null)
                    {
                        currentSong = currentSong.getPreviousSong();
                    }
                    else
                    {
                        if (playlist.getSize() != 0)
                        {
                            currentSong = playlist.getTailNode().getPreviousSong();
                        }
                        else
                        {
                            currentSong = null;
                        }
                    }
                }
                else
                {
                    System.out.println("There is no currently playing song.");
                }
            }
            else if (userInput.equals("8"))
            {
                System.out.println("Exiting program...");
                doLoop = false;
            }
            else
            {
                System.out.println("Unrecognized input, please try again.");
            }
        }

        // Close scanner instance to avoid resource leak.
        scanner.close();
    }
}
