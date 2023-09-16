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
import java.util.ArrayList;

public class Player {

  
  private Room currentRoom; //current location of the player
  
  /*
   * constructor for player object. Assigns values to all non-static fields
   * 
   * @param currentRoom the current location of the player
   */
  public Player(Room currentRoom) {
    this.currentRoom = currentRoom;
  }
  
  /*
   * Determines whether or not the player can move to the given destination room. A valid player move is only to adjacent rooms
   * 
   * @param room player wants to move to
   * @return true if it is a valid movement and false otherwise
   */
  public boolean canMoveTo(Room destination) {
    if(this.getAdjacentRoomsToPlayer().contains(destination)) {
      return true;
    }
    else {
      return false;
    }
  }
  
  /*
   * setter for this player's current room
   * @param the location that the player is moving to
   */
  public void changeRoom(Room newRoom) {
    this.currentRoom = newRoom;
  }
  
  /*
   * gets the list of rooms adjacent to where the player is currently at
   * 
   * @return list of rooms adjacent to the current room
   */
  public ArrayList<Room> getAdjacentRoomsToPlayer() {
    return this.getCurrentRoom().getAdjacentRooms();
  }
  
  /*
   * getter for this player's current room
   * 
   * @return the current location of the player
   */
  public Room getCurrentRoom() {
    return this.currentRoom;
  }
  
  /*
   * determines whether or not the given dragon is in a nearby room
   * 
   * @param the dragon to check if nearby
   * @return true if the dragon is nearby and false otherwise
   */
  public boolean isDragonNearby(Dragon d) {
    if(this.getAdjacentRoomsToPlayer().contains(d.getCurrentRoom())) {
      return true;
    }
    else {
      return false;
    }
  }
  
  /*
   * determines whether or not a portal room is in a nearby room
   * 
   * @return true if a portal room is nearby and false otherwise
   */
  public boolean isPortalNearby() {
    for(int i = 0; i < this.getAdjacentRoomsToPlayer().size(); i++) {
      if(this.getAdjacentRoomsToPlayer().get(i).getType().equals(RoomType.PORTAL)) {
        Room.getPortalWarning();
        return true;
      }
    }
     return false;
  }
  
  
  /*
   * determines whether or not the treasure room is in a nearby room
   * 
   * @return true if the treasure room is nearby, false otherwise
   */
  public boolean isTreasureNearby() {
    for(int i = 0; i < this.getAdjacentRoomsToPlayer().size(); i++) {
      if(this.getAdjacentRoomsToPlayer().get(i).getType().equals(RoomType.TREASURE)) {
        Room.getTreasureWarning();
        return true;
      }
    }
     return false;
  }
  
  /*
   * determines whether or not he player needs to teleport. PLayer teleport when their current room is of type PORTAL
   * 
   * @return true if they should telepolrt and false otherwise
   */
  public boolean shouldTeleport() {
    if(this.getCurrentRoom().getType().equals(RoomType.PORTAL)) {
      return true;
    }
    else {
      return false;
    }
  }
  
}
