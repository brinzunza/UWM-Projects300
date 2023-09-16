
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

public class Character {
  
  private Room currentRoom; //current room the character is in
  private String label; //a label giving a basic description of the character
  
  
  /**
   * Constructor for a Character object. Initializes all instance fields.
   * @param currentRoom the room that the Character is located in
   * @param label a descriptive label of this Character
   * @throws with a descriptive message if currentRoom is null.
   */
  public Character(Room currentRoom, String label) throws IllegalArgumentException {
    if(currentRoom == null) {
      throw new IllegalArgumentException("Character object not made: currentRoom is null");
    }
    this.currentRoom = currentRoom;
    this.label = label;
  }
  
  /**
   * Getter for the current room of this Character.
   * @return the room where the character is
   */
  public Room getCurrentRoom() {
    return this.currentRoom;
  }
  
  /**
   * Getter for the label of this Character.
   * @return this Character's descriptive label
   */
  public String getLabel() {
    return this.label;
  }
  
  /**
   * Gets the list of rooms adjacent to this Character.
   * @return an ArrayList of rooms adjacent to this character
   */
  public ArrayList<Room> getAdjacentRooms() {
    return currentRoom.getAdjacentRooms();
  }
  
  /**
   * Sets the current room to the one given.
   * @param newRoom  the room that should become the current room
   */
  public void setCurrentRoom(Room newRoom) {
    this.currentRoom = newRoom;
  }
  
  
}
