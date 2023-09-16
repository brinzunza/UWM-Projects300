
//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Dragon Adventure 2.0
// Course:   CS 300 Fall 2022
//
// Author:   Bruno Inzunza
// Email:    binzunza@wisc.edu
// Lecturer: Mouna Kacem
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    Theo Luo
// Partner Email:   tluo53@wisc.edu
// Partner Lecturer's Name: Mouna Kacem
// 
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   _x_ Write-up states that pair programming is allowed for this assignment.
//   _x_ We have both read and understand the course Pair Programming Policy.
//   _x_ We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons:         none
// Online Sources:  none
//
///////////////////////////////////////////////////////////////////////////////import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
import processing.core.PApplet;
import processing.core.PImage;

public class Dragon extends Character implements Moveable {
  
  private Random randGen; //random num generator used for moving
  private static final String DRAGON_WARNING = "You hear a fire breathing nearby!\n";
  private static final String DRAGON_ENCOUNTER = "Oh no! You ran into the fire breathing dragon!\n";
  
  
  /**
   * Constructor for a Dragon object. Initializes all instance fields. The label should be "DRAGON" by default.
   * @param currentRoom  the room that the Dragon starts in
   * @throws IllegalArgumentException  with a descriptive message if currentRoom is not a TreasureRoom
   */
  public Dragon(Room currentRoom) throws IllegalArgumentException {
    super(currentRoom, "DRAGON");
    randGen = new Random();
    if(!(currentRoom instanceof TreasureRoom)) {
      throw new IllegalArgumentException("Dragon Object not made: current room is not treasure room");
    }
  }
  
  /**
   * Moves the Dragon to the destination room.
   * @param destination  the Room to change it to
   * @return true if the change was successful, false otherwise
   */
  public boolean changeRoom(Room destination) {
    if(this.canMoveTo(destination) && this.getCurrentRoom().getAdjacentRooms().contains(destination)) {
      this.setCurrentRoom(destination);
      if(this.getCurrentRoom().equals(destination)) {
        return true;
      }
    }
    return false;
  }
  
  /**
   * Checks if the dragon can move to the given destination. A valid move is the destination not a PortalRoom.
   * @param destination the room to check if the dragon can move towards
   * @return true if they can, false otherwise
   */
  public boolean canMoveTo(Room destination) {
    if(destination instanceof PortalRoom) {
      return false;
    }
    return true;
  }
  
  /**
   * Picks randomly ONCE an adjacent room to move into.
   * @return the room that this Dragon should try to move into
   */
  public Room pickRoom() {
    int randroom = randGen.nextInt(this.getAdjacentRooms().size());
    return this.getAdjacentRooms().get(randroom);
  }
  
  /**
   * Getter for DRAGON_WARNING.
   * @return the string for warning about a dragon being nearby.
   */
  public static String getDragonWarning() {
    return DRAGON_WARNING;
  }
  
  /**
   * Getter for DRAGON_ENCOUNTER.
   * @return the string for letting the player know they ran into the dragon
   */
  public static String getDragonEncounter() {
    return DRAGON_ENCOUNTER;
  }
}
