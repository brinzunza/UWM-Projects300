
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

public class TreasureRoom extends Room{
  
  private static final String TREASURE_WARNING = "You sense that there is treasure nearby.\n";
  private static PImage treasureBackground; //the image ALWAYS used for treasure rooms
  
  
  /**
   * Constructor for a TresureRoom object and have a description of "In the back of this room, you spot a treasure chest. It is locked...". Intializes all instance data fields.
   * @param ID  the ID to give to this object
   */
  public TreasureRoom(int ID) {
    super(ID, TREASURE_WARNING, treasureBackground);

  }
  
  /**
   * Getter for TREASURE_WARNING.
   * @return the string for warning about treasure being nearby.
   */
  public static String getTreasureWarning() {
    return TREASURE_WARNING;
  }
  
  /**
   * Determines whether or not the player can open the treasure chest in the room.
   * @param p  the Player to check if they can open the chest
   * @return true if the player has the key and is in this TreasureRoom, false otherwise
   */
  public boolean playerCanGrabTreasure(Player p) {
    if(p.hasKey() && p.getCurrentRoom() instanceof TreasureRoom) {
      return true;
    }
    return false;
  }
  
  /**
   * Sets the background image for the TreasureRoom class.
   * @param treasureBackground the image to be the background
   */
  public static void setTreasureBackground(processing.core.PImage treasureBackground) {
    TreasureRoom.treasureBackground = treasureBackground;
  }

}
