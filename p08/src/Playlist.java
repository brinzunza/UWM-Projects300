import java.util.Queue;

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
 * This playlist represents a FIFO linked queue of SongNodes
 * @author Theo Luo
 */
public class Playlist implements QueueADT<Song> {
  private SongNode first;
  private SongNode last;
  private int numSongs;
  /**
   * Constructs a new, empty playlist queue
   */
  public Playlist() {
    first = null;
    last = null;
    numSongs = 0;
  }
  /**
   * Adds a new song to the end of the queue
   * @param element the song to add to the Playlist
   */
  @Override
  public void enqueue(Song element) {
    SongNode node = new SongNode(element);
    if (isEmpty()) {
      first = node;
      last = node;
    }
    else {
      last.setNext(node);
      last = node;
    }
    numSongs++;
  }
  /**
   * Removes the song from the beginning of the queue
   * @returns the song that was removed from the queue, or null if the queue is empty
   */
  public Song dequeue() {
    if (isEmpty()) {
      return null;
    }
    Song returnValue = first.getSong();
    if (first.getNext() == null) {
      first = null;
      last = null;
      return returnValue;
    }
    first = first.getNext();
    numSongs--;
    return returnValue;
  }
  /**
   * Returns the song at the front of the queue without removing it
   * @return the song that is at the front of the queue, or null if the queue is empty
   */
  @Override
  public Song peek() {
    if (isEmpty()) {
      return null;
    }
    return first.getSong();
  }
  /**
   * Returns true if and only if there are no songs in this queue
   * @return true if this queue is empty, false otherwise
   */
  @Override
  public boolean isEmpty() {
    return first == null;
  }
  /**
   * Returns the number of songs in the queue
   * @return the number of songs in the queue
   */
  @Override
  public int size() {
    return numSongs;
  }
  /**
   * Creates and returns a formatted string representation of this playlist
   * @return the string representation of this playlist
   */
  @Override
  public String toString() {
    String returnValue = ""; 
    SongNode counter = first;
    while (counter != null) {
      returnValue += counter.getSong() + "\n";
      counter = counter.getNext();
    }
    return returnValue;
  }
}
