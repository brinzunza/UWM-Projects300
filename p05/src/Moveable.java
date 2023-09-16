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
import java.util.ArrayList;

/**
 * Interface for things that can move between rooms in the DragonTreasureGame.
 * @author Michelle
 *
 */
public interface Moveable {
	/**
	 * Changes the room where the object is.
	 * @param destination, the Room to change it to
	 * @return true if the change is successful (a valid move), and false otherwise
	 */
	public boolean changeRoom(Room destination);
	
	/**
	 * Gets the list of rooms adjacent to this movable object.
	 * @return an ArrayList of rooms adjacent to the object
	 */
	public ArrayList<Room> getAdjacentRooms();
	
	/**
	 * Checks whether or not this object can move to that room.
	 * @param destination, the Room to check if it can move to
	 * @return true if it can move there (a valid move), and false otherwise
	 */
	public boolean canMoveTo(Room destination);
}
