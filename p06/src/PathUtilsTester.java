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
import java.util.Scanner;

public class PathUtilsTester {
  
  
  /**
   * Constructor
   */
  public PathUtilsTester() {
    
  }
  
  /**
   * Tests the case of countPaths() when there are no valid Paths
   * @return true if all test cases are passed
   */
  public static boolean testCountPathsNoPath() {
    Intersection test1 = new Intersection(1, 1);
    Intersection test2 = new Intersection(0, 1);
    if(PathUtils.countPaths(test1, test2) == 0) {
      return true;
    }
    return false;
  }
  
  /**
   * Tests the case of countPaths() when there is a single valid Path
   * @return true if all test cases are passed
   */
  public static boolean testCountPathsOnePath() {
    Intersection test1 = new Intersection(1, 1);
    Intersection test2 = new Intersection(1, 2);
    if(PathUtils.countPaths(test1, test2) == 1) {
      return true;
    }
    return false;
  }
  
  /**
   * Tests the case of countPaths() when there are multiple possible paths
   * @return true if all test cases are passed
   */
  public static boolean testCountPathsRecursive() {
    Intersection test1 = new Intersection(0, 0);
    Intersection test2 = new Intersection(1, 2);
    if(PathUtils.countPaths(test1, test2) == 3) {
      return true;
    }
    return false;
  }
  
  /**
   * Tests the case of findAllPaths() when there are no valid Paths.
   * @return true if all test cases are passed
   */
  public static boolean testFindAllPathsNoPath() {
    Intersection test1 = new Intersection(1, 1);
    Intersection test2 = new Intersection(0, 1);
    if(PathUtils.findAllPaths(test1, test2).size() == 0) {
      return true;
    }
    return false;
  }
  
  /**
   * Tests the case of findAllPaths() when there is a single valid Path
   * @return true if all test cases are passed
   */
  public static boolean testFindAllPathsOnePath() {
    Intersection test1 = new Intersection(1, 1);
    Intersection test2 = new Intersection(1, 2);
    Path expected = new Path();
    expected.addTail(test1);
    expected.addTail(test2);
    ArrayList<Path> expectedA = new ArrayList<Path>();
    expectedA.add(expected);
    if(PathUtils.findAllPaths(test1, test2).size() == 1) {
      if(PathUtils.findAllPaths(test1, test2).equals(expectedA)) {
        return true;
      }
    }
    return false;
  }
  
  /**
   * Tests the case of findAllPaths() when there are multiple possible paths.
   * @return true if all test cases are passed
   */
  public static boolean testFindAllPathsRecursive() {
    Intersection test1 = new Intersection(0, 1);
    Intersection test2 = new Intersection(1, 1);
    Intersection test3 = new Intersection(2, 1);
    Intersection test4 = new Intersection(3, 1);
    Intersection test5 = new Intersection(2, 2);
    Intersection test6 = new Intersection(1, 2);
    Intersection test7 = new Intersection(0, 2);
    Intersection test8 = new Intersection(3, 2);
    Path path1 = new Path();
    Path path2 = new Path();
    Path path3 = new Path();
    Path path4 = new Path();
    path1.addTail(test1);
    path1.addTail(test2);
    path1.addTail(test3);
    path1.addTail(test4);
    path1.addTail(test8);
    path2.addTail(test1);
    path2.addTail(test2);
    path2.addTail(test3);
    path2.addTail(test5);
    path2.addTail(test8);
    path3.addTail(test1);
    path3.addTail(test2);
    path3.addTail(test6);
    path3.addTail(test5);
    path3.addTail(test8);
    path4.addTail(test1);
    path4.addTail(test7);
    path4.addTail(test6);
    path4.addTail(test5);
    path4.addTail(test8);
    if(PathUtils.findAllPaths(test1, test8).size() == 4) {
      if(PathUtils.findAllPaths(test1, test6).contains(path1) && PathUtils.findAllPaths(test1, test6).contains(path2) && PathUtils.findAllPaths(test1, test6).contains(path3) && PathUtils.findAllPaths(test1, test6).contains(path4)) {
        return true;
      }
    }
    return false;
  }
  
  
  
  public static void main(String[] args) {
    try (Scanner keyboard = new Scanner(System.in)) {
      int startX, startY, endX, endY;
      String input = "Y";
      while (input.equalsIgnoreCase("Y")) {
      System.out.print("Enter starting X coordinate: ");
      startX = keyboard.nextInt();
      System.out.print("Enter starting Y coordinate: ");
      startY = keyboard.nextInt();
      System.out.print("Enter ending X coordinate: ");
      endX = keyboard.nextInt();
      System.out.print("Enter ending Y coordinate: ");
      endY = keyboard.nextInt();
      Intersection start = new Intersection(startX, startY);
      Intersection end = new Intersection(endX, endY);
      System.out.println("Number of paths from start to end: "
      + PathUtils.countPaths(start, end));
      System.out.println("List of possible paths:");
      for (Path p : PathUtils.findAllPaths(start, end)) {
        System.out.println(p);
      }
      do {
        System.out.print("Try another route? (Y/N): ");
        input = keyboard.next();
      } 
      while (!input.equalsIgnoreCase("Y") && !input.equalsIgnoreCase("N"));
      }
    }
  }

}

