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

//Utility methods for planning a trip through a grid of city intersections
public class PathUtils {
  
  public PathUtils() {
    
  }
  
  /**
   * Finds the number of valid Paths between the given start and end Intersections. If it is not possible to get from the start to the end intersection by moving up or right, then 0 should be returned.
   * @param start Intersection to start at
   * @param end  Intersection to end at
   * @return the number of valid Paths which start and end at the given Intersections
   */
  public static int countPaths(Intersection start, Intersection end) {
    if(start.getX() == end.getX() && start.getY() == end.getY()) {
      return 1;
    }
    if(end.getY() < start.getY()) {
      return 0; 
    }
    if(end.getX() < start.getX()) {
      return 0;
    }
    int total = 0;
    total += countPaths(start.goEast(), end);
        
    total += countPaths(start.goNorth(), end);
    
    return total;
  }
  
  
  /**
   * Finds all valid Paths between the given start and end Intersections. If it is not possible to get from the start to the end intersection by moving up or right, then an empty ArrayList should be returned.
   * @param start Intersection to start at
   * @param end  Intersection to end at
   * @return an ArrayList containing all valid Paths which start and end at the given Intersections
   */
  public static ArrayList<Path> findAllPaths(Intersection start, Intersection end) {
    
    ArrayList<Path> paths = new ArrayList<Path>();
    
    // cannot reach end from start
    if(end.getY() < start.getY()) {
      return paths; 
    }
    if(end.getX() < start.getX()) {
      return paths;
    }                                                                         
    
    // base case
    if(start.equals(end)) {
      Path currentPath = new Path();
      currentPath.addTail(start);
      paths.add(currentPath);
    }
    
    // recursive case
    if(!start.equals(end)) {
       ArrayList<Path> north = findAllPaths(start.goNorth(), end);
       ArrayList<Path> east = findAllPaths(start.goEast(), end);
       
       for(int i = 0; i < north.size(); i++) {
         north.get(i).addHead(start);
         paths.add(north.get(i));
       }
       for(int i = 0; i < east.size(); i++) {
         east.get(i).addHead(start);
         paths.add(east.get(i));
       }
    }
    return paths;
  }
}
