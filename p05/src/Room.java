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
///////////////////////////////////////////////////////////////////////////////
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
import processing.core.PApplet ;
import processing.core.PImage;

public class Room {
  private String description; //verbal description of the room
  private ArrayList<Room> adjRooms; //list of all rooms directly connect
  private final int ID; // a "unique" identifier for each room
  protected static PApplet processing; //PApplet object which the rooms will use to
  //draw stuff to the GUI
  private PImage image; //stores the image that corresponds to the background of a room
  
  /**
   * Constructor for a Room object. Initializes all instance data fields.
   * @param ID the ID that this Room should have
   * @param description  the verbal description this Room should have
   * @param image the image that should be used as a background when drawing this Room.
   */
  public Room(int ID, String description, PImage image) {
    this.adjRooms = new ArrayList<Room>();
    this.ID = ID;
    this.description = description;
    this.image = image;
  }
  
  /**
   * Getter for ID
   * @return ID the ID of this Room
   */
  public int getID() {
    return this.ID;
  }
  
  /**
   * Getter for description
   * @return description the verbal description of this Room
   */
  public String getDescription() {
    return this.description;
  }
  
  /**
   * Getter for the list of adjacentRooms
   * @return adjRooms the list of adjacent rooms
   */
  public ArrayList<Room> getAdjacentRooms() {
    return this.adjRooms;
  }
  
  /**
   * Sets the processing for the class
   * @param processing  the PApplet that this room will use to draw to the window
   */
  public static void setProcessing(PApplet processing) {
    Room.processing = processing;
  }
  
  /**
   * Adds the given room to the list of rooms adjacent to this room
   * @param toAdd  the room to be added
   */
  public void addToAdjacentRooms(Room toAdd) {
    adjRooms.add(toAdd);
  }
  
  /**
   * Checks whether or not the given room is adjacent to this room.
   * @param r
   * @return true if it is adjacent, false otherwise
   */
  public boolean isAdjacent(Room r) {
    if (this.adjRooms.contains(r)) {
      return true;
    }
    return false;
  }
  
  /**
   * Overrides Object.equals(). Determines if two objects are equal.
   * @param other the object to check against this Room
   * @return boolean true if other is of type Room and has the same ID, false otherwise
   */
  @Override
  public boolean equals(Object other) {
    if(other instanceof Room) {
      Room otherRoom = (Room)other;
      return this.getID() == otherRoom.getID();
    }
    return false;
  }
  
  /**
   * Overrides Object.toString(). Returns a string representation of a Room object.
   * @return Returns a string in the form of "<ID>: <description>\n Adjacent Rooms: <r1's ID> <r2's ID>" list of adjacent room IDs continues for all rooms adjacent to this Room.
   */
  @Override
  public String toString() {
    String all = this.ID + ": " + this.getDescription() + "\nAdjacent Rooms: ";
    for(int i = 0; i < adjRooms.size(); i++) {
      all += adjRooms.get(i).ID + " ";
    }
    return all;
//    return getID() + ":" + getDescription() + "\n Adjacent Rooms:" + this.getAdjacentRooms().get(0) + " " + this.getAdjacentRooms().get(1);
  }
  
  /**
   * Draws this Room to the window by drawing the background image, a rectangle, and some text.
   */
  public void draw() {
    processing.image(image, 0, 0);
    processing.fill(-7028);
    processing.rect(0, 500, 800, 600);
    processing.fill(0);
    processing.text(this.toString(), 300, 525);
  }
}
