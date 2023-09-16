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

//This class represents a valid path through a grid of city intersections surrounded by streets
public class Path {

  private ArrayList<Intersection> intersections; //List of Intersections followed in this path
  
  /**
   * Initializes this Path to start as empty
   */
  public Path() {
    intersections = new ArrayList<Intersection>();
  }
  
  /**
   * Returns the number of Intersections in this Path
   * @return the number of Intersections in this Path
   */
  public int length() {
    return this.intersections.size();
  }
  
  /**
   * Returns the first Intersection in this Path, if it is not empty. Otherwise, throws a NoSuchElementException.
   * @return the first Intersection in this Path, if it is not empty
   * @throws NoSuchElementException - if this Path is empty
   */
  public Intersection getHead() throws NoSuchElementException{
    if(this.length() == 0) {
      throw new IllegalArgumentException("Not valid, tried to add Intersectio to head of Path "+this);
    }
    return this.intersections.get(0);
  }
  
  /**
   * Returns the last Intersection in this Path, if it is not empty. Otherwise, throws a NoSuchElementException.
   * @return the last Intersection in this Path, if it is not empty
   * @throws NoSuchElementException - if this Path is empty
   */
  public Intersection getTail() throws NoSuchElementException{
    if(this.length() == 0) {
      throw new NoSuchElementException("This path is empty, could not get tail");
    }
    return this.intersections.get(this.length());
  }
  
  /**
   * Adds the given Intersection to the end of this Path if it is a valid addition. A Intersection is a valid addition if the current Path is empty, or the Intersection to add is one step directly east, or one step directly north of the current tail Intersection in this Path. Should throw an IllegalArgumentException if the given Intersection is not a valid addition.
   * @param toAdd  Intersection to add to the end of this Path
   * @throws IllegalArgumentException - if the Intersection to add is not valid
   */
  public void addTail(Intersection toAdd) throws IllegalArgumentException{
    if(this.intersections.size() == 0) {
      intersections.add(toAdd);
    }
    else if(toAdd.equals(this.getTail().goEast()) || toAdd.equals(this.getTail().goNorth())) {
      intersections.add(toAdd);
    }
    else {
      throw new IllegalArgumentException("addHead did not work because input was invalid");
    }
  }
  
  /**
   * Adds the given Intersection to the front of this Path if it is a valid addition. A Intersection is a valid addition if the current Path is empty, or the Intersection to add is one step directly west, or one step directly south of the current head Intersection in this Path. Should throw an * IllegalArgumentException if the given Intersection is not a valid addition.
   * @param toAdd  Intersection to add to the beginning of this Path
   * @throws IllegalArgumentException - if the Intersection to add is not valid
   */
  public void addHead(Intersection toAdd) throws IllegalArgumentException{
    if(this.intersections.size() == 0) {
      intersections.add(toAdd);
    }
    else if(toAdd.equals(this.getHead().goWest()) || toAdd.equals(this.getHead().goSouth())) {
      intersections.add(0, toAdd);
    }
    else {
      throw new IllegalArgumentException("addHead did not work because input was invalid");
    }
  }
  
  /**
   * Returns a String representing the coordinates taken in this Path. An empty Path should return the String "Empty", while a non-empty Path should return the coordinates of the Intersections it visits separated by a "->". For example:
   * @return a String representing the coordinates followed by this Path
   */
  @Override
  public String toString() {
    String temp = "";
    for(int i = 0; i < this.length()-1; i++) {
      temp += this.intersections.get(i).toString() + "->";
    }
    temp += this.intersections.get(this.length()-1).toString();
    return temp;
  }
}