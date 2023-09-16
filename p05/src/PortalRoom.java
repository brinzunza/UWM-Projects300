
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

public class PortalRoom extends Room{

  private Random randGen; //random number generator for location picking
  private static final String PORTAL_WARNING = "You feel a distortion in space nearby.\n";
  private static final String TELEPORT_MESSAGE = "The space distortion teleported you to another room!\n";
  private static PImage portalImage; //image of a portal to be shown in all portal rooms
  
  
  /**
   * Constructor for a PortalRoom object. Initializes all instance data fields.
   * @param ID the ID that this PortalRoom should have
   * @param description  the verbal description this PortalRoom should have
   * @param image  the image that should be used as a background when drawing this PortalRoom.
   */
  PortalRoom(int ID, String description, processing.core.PImage image) {
    super(ID, description, image);
    randGen = new Random();
  }
  
  /**
   * Getter for PORTAL_WARNING.
   * @return the string for warning about a portal being nearby.
   */
  public static String getPortalWarning() {
    return PORTAL_WARNING;
  }
  
  /**
   * Getter for TELEPORT_MESSAGE.
   * @return the string for letting the player know they were teleported.
   */
  public static String getTeleportMessage() {
    return TELEPORT_MESSAGE;
  }
  
  /**
   * Picks an adjacent room at random for the player to teleport into.
   * @return The room that player should immediately be moved to
   */
  public Room getTeleportLocation() {
    ArrayList<Room> temp = this.getAdjacentRooms();
    int loc = randGen.nextInt(temp.size());
    System.out.println(loc);
    return temp.get(loc);
  }
  
  /**
   * Draws this PortalRoom to the window by drawing the background image, a rectangle, some text, and the portal image.
   */
  public void draw() {
    super.draw();
    processing.image(portalImage, 325, 225);
  }
  
  /**
   * Sets the portal image for the PortalRoom class.
   * @param portalImage  the image to represent the portal
   */
  public static void setPortalImage(PImage portalImage) {
    PortalRoom.portalImage = portalImage;
  }
}
