//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    City Route Planner
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
import java.util.NoSuchElementException;

public class Intersection {
  
  private final int x;
  private final int y;
  
  
  /**
   * Initializes this intersection with the given coordinates
   * @param x Horizontal position of this Intersection
   * @param y Vertical position of this Intersection
   */
  public Intersection(int x, int y) {
    this.x = x; 
    this.y = y;
  }
  
  /**
   * Returns the horizontal position of this Intersection
   * @return the horizontal position of this Intersection
   */
  public int getX() {
    return this.x;
  }
  
  /**
   * Returns the vertical position of this Intersection
   * @return the vertical position of this Intersection
   */
  public int getY() {
    return this.y;
  }
  
  /**
   * Returns a coordinate-pair representation of this Intersection in the form "(x,y)"
   * @return a coordinate-pair representation of this Intersection
   */
  @Override
  public String toString() {
    return ("(" + x + "," + y + ")");
  }
  
  /**
   * Returns true if the given Object is identical to this Intersection
   * @param o - object to compare for equality
   * @return true if the given Object is an Intersection object which has the same x and y coordinates as this Intersection
   */
  @Override
  public boolean equals(Object o) {
    if(o instanceof Intersection) {
      if(this.getX() == ((Intersection) o).getX() && this.getY() == ((Intersection) o).getY()) {
        return true;
      }
    }
    return false;
  }
  
  /**
   * Creates a new Intersection instance which is one step directly above this Intersection. Should not modify the original Intersection object.
   * @return a new Intersection instance which is one step directly above this Intersection
   */
  public Intersection goNorth() {
    Intersection north = new Intersection(this.getX(), this.getY() + 1);
    return north;
  }
  
  
  /**
   * Creates a new Intersection instance which is one step directly below this Intersection. Should not modify the original Intersection object.
   * @return a new Intersection instance which is one step directly below this Intersection
   */
  public Intersection goSouth() {
    Intersection south = new Intersection(this.getX(), this.getY() - 1);
    return south;
  }
  
  
  /**
   * Creates a new Intersection instance which is one step directly to the right of this Intersection. Should not modify the original Intersection object.
   * @return a new Intersection instance which is one step directly to the right of this Intersection
   */
  public Intersection goEast() {
    Intersection east = new Intersection(this.getX() + 1, this.getY());
    return east;
  }
  
  
  /**
   * Creates a new Intersection instance which is one step directly to the left of this Intersection. Should not modify the original Intersection object.
   * @return a new Intersection instance which is one step directly to the left of this Intersection
   */
  public Intersection goWest() {
    Intersection west = new Intersection(this.getX() - 1, this.getY());
    return west;
  }
}
