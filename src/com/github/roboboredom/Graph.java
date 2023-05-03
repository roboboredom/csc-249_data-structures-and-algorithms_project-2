/* Date: 5/2/2023.
 * 
 * Author: Willem Dawson Gray.
 * Original Author: Dr. Ann Aksut.
 * 
 * Class: CSC-249 Data Structures and Algorithms.
 * 
 * Assignment: Programming Project 2.
 * Description:
 *     Use the provided source code as a starting point
 *     to implement the BFS and DFS algorithms for traversing a graph.
 *     When finished, the program  will read the graph from the GraphInfo.txt
 *     file and perform a BFS and DFS on it, outputting the results. */
 
/* NOTE: My edits to the original code are marked by surrounding 
 * comments labeled "START STUDENT CODE" and "END STUDENT CODE", 
 * respectively. All other changes are purely formatting, and 
 * do not change the function of the original code whatsoever. */

/* START STUDENT CODE */
package com.github.roboboredom;
/* END STUDENT CODE */

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

// Hint: Might be useful for BFS. See: https://docs.oracle.com/javase/8/docs/api/java/util/Queue.html
//import java.util.Queue; 

// Hint: Might be useful for BFS. See: https://docs.oracle.com/javase/8/docs/api/java/util/LinkedList.html
//import java.util.LinkedList; 

// Hint: Might be useful for DFS. See: https://docs.oracle.com/javase/8/docs/api/java/util/Stack.html
//import java.util.Stack; 

/**
 * This class will be a driver class that demonstrates graph traversal algorithms.
 * You must implement the breadthFirstSearch and depthFirstSearch methods contained in this class.
 */
public class Graph
{
    public static void main(String[] args) throws IOException
    {
        // An ArrayList of Nodes, where each node contains an adjacency list of all nodes adjacent to it
        ArrayList<Node> graph = createGraph();

        /* You can call displayGraph to have it print out the information in the graph.
         * This is just provided to help you visualize each node in the graph, along with it's adjacent nodes. */
        displayGraph(graph);

        /* Call BFS and DFS here to have them print out their traversals.
         * YOU MUST IMPLEMENT THESE METHODS!
         * The definitions are already done for you towards the end of this file, you just need to add the code to the body. */
        breadthFirstSearch(graph);
        depthFirstSearch(graph);
    }

    /*
     * Creates an ArrayList of Node objects that represent a graph
     * 
     * Graph information is read from a GraphInfo.txt file contained in the same directory as this code Each line of the
     * text file will contain information about a specific node and the nodes that are adjacent to it The nodes are
     * delimited by a comma Example line of GraphInfo.txt: A,B,D A - the starting Node B D - nodes that are adjacent to
     * A This means that there is an edge from A to B and an edge from A to D This is an unweighted graph, so no need to
     * worry about weights on the edges
     * 
     * @return graph The graph
     */
    public static ArrayList<Node> createGraph() throws IOException
    {
        ArrayList<Node> graph = new ArrayList<Node>();

        File file = new File("./assets/GraphInfo.txt");
        /* START STUDENT CODE */
        @SuppressWarnings("resource") // Supress resource leak warning about inputFile never being closed, as it does not matter.
        /* END STUDENT CODE */
        Scanner inputFile = new Scanner(file);

        // Read in the information from each line of the text file.
        while (inputFile.hasNext())
        {
            String line = inputFile.nextLine();
            String[] tokens = line.split(","); // Split the line of input on the delimiter (a comma).

            // make sure there is at least one node worth of information
            if (tokens.length > 0)
            {
                Node n = new Node(tokens[0]); // Create a new Node object.
                int nodeIndex = graph.indexOf(n);
                if (nodeIndex != -1) // Node is already in the graph, retrieve a reference to it.
                {
                    n = graph.get(nodeIndex);
                }
                else // Add it to the graph as a new node.
                {
                    graph.add(n);
                } 
                // If there are any adjacent nodes, create them (or find them in the graph) and add them as an adjacent node.
                for (int i = 1; i < tokens.length; i++)
                {
                    Node adj = new Node(tokens[i]);
                    int adjNodeIndex = graph.indexOf(adj);
                    if (adjNodeIndex != -1) // Adjacent node is already in the graph, retrieve a reference to it.\
                    {
                        adj = graph.get(adjNodeIndex);
                    }
                    else // Add it to the graph as a new node.
                    {
                        graph.add(adj);
                    }
                    n.addAdjacentNode(adj);
                }
            }
        }
        return graph;
    }

    /**
     * Displays all Node information for each Node in the graph
     * 
     * @param graph The graph
     */
    public static void displayGraph(ArrayList<Node> graph)
    {
        for (Node n : graph)
        {
            System.out.println(n);
        }
    }

    /**
     * Implement this method This method will perform a Breadth First Search traversal starting with the first
     * Node contained in the graph Follow the algorithm described in 13.5.5 of your zyBook At the end of the method, you
     * should display the contents of discoveredSet, which will be the traversal of the graph
     * 
     * @param graph An ArrayList of Node objects representing a graph
     */
    public static void breadthFirstSearch(ArrayList<Node> graph)
    {
        // perform a breadth first traversal from the first Node in the graph (graph.get(0))
        // Follow the algorithm described in 13.5.5 of your zyBook
        // It lays out the entire algorithm in psuedocode - you just need to convert it into java code
        // WRITE YOUR CODE HERE

        /* START STUDENT CODE */
        
        /* END STUDENT CODE */

        System.out.println("BFS:");
        // print out the contents of discoveredSet - meaning the name of each node (don't use the toString() method
        // since it includes the adjacency list)
        System.out.println();
    }

    /**
     * Implement this method This method will perform a Depth First Search traversal starting with the first Node
     * contained in the graph Follow the algorithm described in 13.6.3 of your zyBook At the end of the method, you
     * should display the contents of visitedSet, which will be the traversal of the graph
     * 
     * @param graph An ArrayList of Node objects representing a graph
     */
    public static void depthFirstSearch(ArrayList<Node> graph)
    {

        // perform a depth first traversal from the first Node in the graph (graph.get(0))
        // Follow the algorithm described in 13.5.5 of your zyBook
        // It lays out the entire algorithm in psuedocode - you just need to convert it into java code
        // WRITE YOUR CODE HERE

        /* START STUDENT CODE */

        /* END STUDENT CODE */

        System.out.println("DFS:");
        // print out the contents of visitedSet - meaning the name of each node (don't use the toString() method since
        // it includes the adjacency list)
        System.out.println();
    }
}