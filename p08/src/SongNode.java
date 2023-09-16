//////////////// FILE HEADER //////////////////////////
//
// Title:    P08 Music Player
// Course:   CS 300 Fall 2022
//
// Author:   Theo Luo
// Email:    tluo53@wisc.edu
// Lecturer: Mouna Kacem
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    Bruno Inzunza
// Partner Email:   binzunza@wisc.edu
// Partner Lecturer's Name: Mouna Kacem
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   X Write-up states that pair programming is allowed for this assignment.
//   X We have both read and understand the course Pair Programming Policy.
//   X We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons:         None
// Online Sources:  None
//
///////////////////////////////////////////////////////////////////////////////

/**
 * This class represents a singly-linked node for a linked queue, which contains a Song object
 * @author Theo Luo
 */
public class SongNode {
  private SongNode next;
  private Song song;
  /**
   * Constructs a single SongNode containing the given data, not linked to any other SongNodes
   * @param data the Song for this node
   * @throws IllegalArgumentException if data is null
   */
  public SongNode(Song data) throws IllegalArgumentException {
    this(data, null);
  }
  /**
   * Constructs a single SongNode containing the given data, linked to the specified SongNode
   * @param data the Song for this node
   * @param next the next node in the queue
   * @throws IllegalArgumentException if data is null
   */
  public SongNode(Song data, SongNode next) throws IllegalArgumentException {
    if (data == null) {
      throw new IllegalArgumentException("Song cannot be null.");
    }
    song = data;
    this.next = next;
  }
  /**
   * Accessor method for this node's data
   * @return the Song in this node
   */
  public Song getSong() {
    return song;
  }
  /**
   * Accessor method for the next node in the queue
   * @return the SongNode following this one, if any
   */
  public SongNode getNext() {
    return next;
  }
  /**
   * Changes the value of this SongNode's next data field to the given value
   * @param next the SongNode to follow this one; may be null
   */
  public void setNext(SongNode next) {
    this.next = next;
  }
}
