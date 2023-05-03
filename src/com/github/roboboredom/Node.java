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

/**
 * The Node class represents a Node in an unweighted graph There should be no need to alter this code to complete your
 * assignment If you do wish to add extra methods for some reason, that is OK, but do not alter any existing code.
 */
public class Node
{
    private String name;
    private ArrayList<Node> adjancencyList; // List of nodes that are adjacent to this node.

    /**
     * Constructor.
     * 
     * @param name The name of the node.
     */
    public Node(String name)
    {
        this.name = name;
        adjancencyList = new ArrayList<Node>(); // Create an empty adjacency list.
        // Adjacent nodes must be added to this list via addAdjacentNode(Node).
    }

    /**
     * @return The name of the node.
     */
    public String getName()
    {
        return name;
    }

    /**
     * @return An Array of Node objects that are adjacent to this Node object
     */
    public ArrayList<Node> getAdjacencyList()
    {
        return adjancencyList; // Shallow copy is fine.
    }

    /**
     * Adds a Node to the adjacency list of this Node.
     * 
     * @param n The Node to add to the adjacency list.
     */
    public void addAdjacentNode(Node n)
    {
        adjancencyList.add(n);
    }

    /**
     * Compares two Nodes for equality. Nodes are considered to be equal if they have the same name.
     * 
     * @return Returns true if the Nodes have the same name, false otherwise.
     */
    @Override
    public boolean equals(Object o)
    {
        if (!(o instanceof Node)) // Should handle differently, but this works for now.
        {
            return false;
        }
        Node n = (Node)o;
        return this.name.equalsIgnoreCase(n.name);
    }

    /**
     * @return A String representation of the Node.
     */
    public String toString()
    {
        String str = "Node: " + name + " Adjacency List:";
        for (Node a : adjancencyList)
        {
            str += " " + a.getName();
        }
        return str;
    }
}