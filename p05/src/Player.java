
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

public class Player extends Character implements Moveable{
  private boolean hasKey;
  
  
  /**
   * Constructor for player object. The label should be "PLAYER" and not have a key by default.
   * @param currentRoom  the room that the player should start in
   * @throws IllegalArgumentException  if the currentRoom is not a StartRoom
   */
  public Player(Room currentRoom) throws IllegalArgumentException {
    super(currentRoom, "PLAYER");
    if(!(currentRoom instanceof StartRoom)) {
      throw new IllegalArgumentException("Player object not made: did not start in startroom");
    }
    hasKey = false;
  }
  
  /**
   * Determines if the player has the key.
   * @return true if the player has the key, false otherwise
   */
  public boolean hasKey() {
    return this.hasKey;
  }
  
  /**
   * Gives player the key
   */
  public void obtainKey() {
    this.hasKey = true;
  }
  
  /**
   * Moves the Player to the destination room.
   * @param destination  the Room to change it to
   * @return true if the change was successful, false otherwise
   */
  public boolean changeRoom(Room destination) {
    this.setCurrentRoom(destination);
    if(this.getCurrentRoom().equals(destination)) {
      return true;
    }
    return false;
  }
  
  /**
   * Checks if the player can move to the given destination. A valid move is the destination is a room adjacent to the player.
   * @param destination  the room to check if the player can move towards
   * @return true if they can, false otherwise
   */
  public boolean canMoveTo(Room destination) {
    if(this.getCurrentRoom().getAdjacentRooms().contains(destination)) {
      return true;
    }
    return false;
  }
  
  /**
   * Checks if the player needs to teleport and move them if needed.
   * @return true if a teleport occurred, false otherwise
   */
  public boolean teleport() {
    PortalRoom oroom = (PortalRoom)this.getCurrentRoom();
    if(this.getCurrentRoom() instanceof PortalRoom) {
      this.setCurrentRoom(oroom.getTeleportLocation());
      return true;
    }
    return false;
  }
  
  /**
   * Determines whether or not the given dragon is nearby. A dragon is considered nearby if it is in one of the adjacent rooms.
   * @param d the dragon to check if nearby
   * @return true if the dragon is nearby, false otherwise
   */
  public boolean isDragonNearby(Dragon d) {
    if(this.getCurrentRoom().getAdjacentRooms().contains(d.getCurrentRoom())) {
      return true;
    }
    return false;
  }
  
  /**
   * Determines whether or not a portal room is nearby. A portal room is considered nearby if it is one of the adjacent rooms.
   * @return true if a portal room is nearby, false otherwise
   */
  public boolean isPortalNearby() {
    for(int i = 0; i < this.getAdjacentRooms().size(); i++) {
      if(this.getAdjacentRooms().get(i) instanceof PortalRoom) {
        return true;
      }
    }
    return false;
  }
  
  /**
   * Determines whether or not the treasure room is nearby. The treasure room is considered nearby if it is one of the adjacent rooms.
   * @return true if the treasure room is nearby, false otherwise
   */
  public boolean isTreasureNearby() {
    for(int i = 0; i < this.getAdjacentRooms().size(); i++) {
      if(this.getAdjacentRooms().get(i) instanceof TreasureRoom)
        return true;
      }
    return false;
  }
}
