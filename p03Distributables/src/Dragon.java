//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Indiana Jones v Dragon Adventure
// Course:   CS 300 Fall 2022
//
// Author:   Bruno Inzunza
// Email:    binzunza@wisc.edu
// Lecturer: Mouna Kacem
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    none
// Partner Email:   none
// Partner Lecturer's Name: none
// 
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   ___ Write-up states that pair programming is allowed for this assignment.
//   ___ We have both read and understand the course Pair Programming Policy.
//   ___ We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons:         none
// Online Sources:  none
//
///////////////////////////////////////////////////////////////////////////////
import java.util.Random;

public class Dragon {
  private Room currentRoom; //current location of the dragon
  private Random randGen; //random num generator used for moving
  private static final String DRAGON_WARNING = "You hear a fire breathing nearby!\n";
  
  
  /*
   * Constructor for the dragon object. Assigns values to all non-static fields
   * 
   * @param currentRoom the current location of the dragon
   */
  public Dragon(Room currentRoom) {
    this.currentRoom = currentRoom;
    randGen = new Random();
  }
  
  /*
   * Getter for this Dragon's currentRoom
   * 
   * @return this dragon's current room
   */
  public Room getCurrentRoom() {
    return this.currentRoom;
  }
  
  /*
   * Dragon picks one of the rooms at random and moves there if possible. If it is not a valid move, then it will pick again. Dragons abide by the follow rules when moving: 1) The dragon can only move into rooms that are adjacent to it. 2) The dragon CANNOT move into portal rooms.
   * 
   */
  public void changeRoom() {
    int n = randGen.nextInt(this.getCurrentRoom().getAdjacentRooms().size());
    while(this.getCurrentRoom().getAdjacentRooms().get(n).getType().equals(RoomType.PORTAL)) {
      n = randGen.nextInt(this.getCurrentRoom().getAdjacentRooms().size());
    }
    this.currentRoom = this.getCurrentRoom().getAdjacentRooms().get(n);
  }
  
  /*
   * Returns the string that is the dragon class's warning, indicating that there is one nearby.
   * 
   * @return the dragon warning message string
   */
  public static String getDragonWarning() {
    return DRAGON_WARNING;
  }
}
