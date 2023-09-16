//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Pokemon or should I rather say Chugimon
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
//   _X_ Write-up states that pair programming is allowed for this assignment.
//   _X_ We have both read and understand the course Pair Programming Policy.
//   ___ We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons:         (identify each by name and describe how they helped)
// Online Sources:  (identify each by URL and describe how it helped)
//
///////////////////////////////////////////////////////////////////////////////

import java.util.NoSuchElementException;

/**
 * This class checks the correctness of the implementation of the methods defined in the Chugimon
 * and ChugiTree classes.
 * 
 * @author TODO add your name(s)
 *
 */

public class ChugidexTester {


  /**
   * Checks the correctness of the implementation of both compareTo() and equals() methods defined
   * in the Chugimon class.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testChugimonCompareToEquals() {
    Chugimon one = new Chugimon(1, 2);
    Chugimon two = new Chugimon(2, 3);
    //System.out.println(one.getName());
    //System.out.println(two.getName());
    int temp = 0;
    if(one.compareTo(two) == -1) {
      if(two.compareTo(one) == 1) {
        if(one.compareTo(one) == 0) {
          temp++;
        }
      }
    }
    if(one.equals(two) == false) {
      if(one.equals(one) == true) {
        temp++;
      }
    }
    if(temp == 2) {
      return true;
    }
    else {
      return false;
    }
     // Default return statement added to resolve compiler errors
  }

  /**
   * Checks the correctness of the implementation of Chugimon.toString() method.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testChugimonToString() {
    Chugimon one = new Chugimon(1, 2);
    if(!(one.toString().equals("Bulbysaur#1.2"))) {
      return false;
    }
    return true; // Default return statement added to resolve compiler errors
  }

  /**
   * Checks the correctness of the implementation of ChugiTree.isValidBSTHelper() method. This
   * tester should consider at least three scenarios. (1) An empty tree whose root is null should be
   * a valid BST. (2) Consider a valid BST whose height is at least 3. Create the tree using the
   * constructors of the BSTNode and its setters methods, (3) Consider a NON-valid BST where the
   * search order property is violated at at least one internal node.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testIsValidBSTHelper() {
    Chugimon node1c = new Chugimon(1, 2);
    //System.out.println(node1c);
    BSTNode<Chugimon> node1 = new BSTNode<Chugimon>(node1c);
    Chugimon node2c = new Chugimon(1, 3);
    //System.out.println(node2c);
    BSTNode<Chugimon> node2 = new BSTNode<Chugimon>(node2c);
    Chugimon node3c = new Chugimon(1, 4);
    //System.out.println(node3c);
    BSTNode<Chugimon> node3 = new BSTNode<Chugimon>(node3c);
    Chugimon node4c = new Chugimon(1, 5);
    //System.out.println(node4c);
    BSTNode<Chugimon> node4 = new BSTNode<Chugimon>(node4c);
    Chugimon node5c = new Chugimon(1, 6);
    //System.out.println(node5c);
    BSTNode<Chugimon> node5 = new BSTNode<Chugimon>(node5c);
    Chugimon node6c = new Chugimon(1, 7);
    //System.out.println(node6c);
    BSTNode<Chugimon> node6 = new BSTNode<Chugimon>(node6c);
    
    node4.setLeft(node5);
    node5.setRight(node3);
    node4.setRight(node1);
    node1.setLeft(node2);
    //node4.setRight(node2);
    //node2.setLeft(node1);
    
    //Bulbizard#1.6 node5c
    //Bulbmander#1.4 node3c
    //Bulbmeleon#1.5 node4c
    //Bulbtle#1.7 node6c
    //Bulbusaur#1.3 node2c
    //Bulbysaur#1.2 node1c
    
    
    //System.out.println(node4.getRight().getLeft());
    //System.out.println(node4.getLeft().getRight());
    //System.out.println(ChugiTree.isValidBSTHelper(node4) + "this is the isvalidthings");
    if(!ChugiTree.isValidBSTHelper(node4)) {
      return false;
    }
    
    return true; // Default return statement added to resolve compiler errors
  }

  /**
   * Checks the correctness of the implementation of both add() and toString() methods implemented
   * in the ChugiTree class. This unit test considers at least the following scenarios. (1) Create a
   * new empty ChugiTree, and check that its size is 0, it is empty, and that its string
   * representation is an empty string "". (2) try adding one Chugimon and then check that the add()
   * method call returns true, the tree is not empty, its size is 1, and the toString() called on
   * the tree returns the expected output. (3) Try adding another Chugimon which is less than the
   * Chugimon at the root, (4) Try adding a third Chugimon which is greater than the one at the
   * root, (5) Try adding at least two further Chugimons such that one must be added at the left
   * subtree, and the other at the right subtree. For all the above scenarios, and more, double
   * check each time that size() method returns the expected value, the add method call returns
   * true, that the ChugiTree is a valid BST, and that the toString() method returns the expected
   * string representation of the contents of the binary search tree in an increasing order from the
   * smallest to the greatest Chugimon. (6) Try adding a Chugimon already stored in the tree. Make
   * sure that the add() method call returned false, and that the size of the tree did not change.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testAddToStringSize() {
    Chugimon node1c = new Chugimon(1, 2);
    //System.out.println(node1c);
    BSTNode<Chugimon> node1 = new BSTNode<Chugimon>(node1c);
    Chugimon node2c = new Chugimon(1, 3);
    //System.out.println(node2c);
    BSTNode<Chugimon> node2 = new BSTNode<Chugimon>(node2c);
    Chugimon node3c = new Chugimon(1, 4);
    //System.out.println(node3c);
    BSTNode<Chugimon> node3 = new BSTNode<Chugimon>(node3c);
    Chugimon node4c = new Chugimon(1, 5);
    //System.out.println(node4c);
    BSTNode<Chugimon> node4 = new BSTNode<Chugimon>(node4c);
    Chugimon node5c = new Chugimon(1, 6);
    //System.out.println(node5c);
    BSTNode<Chugimon> node5 = new BSTNode<Chugimon>(node5c);
    Chugimon node6c = new Chugimon(1, 7);
    //System.out.println(node6c);
    BSTNode<Chugimon> node6 = new BSTNode<Chugimon>(node6c);
    
//Bulbysaur#1.2
//Bulbusaur#1.3
//Bulbmander#1.4
//Bulbmeleon#1.5
//Bulbizard#1.6
//Bulbtle#1.7
    
    //Bulbizard#1.6 node5c
    //Bulbmander#1.4 node3c
    //Bulbmeleon#1.5 node4c
    //Bulbtle#1.7 node6c
    //Bulbusaur#1.3 node2c
    //Bulbysaur#1.2 node1c
    //Bulbizard#1.6Bulbmander#1.4Bulbmeleon#1.5Bulbtle#1.7Bulbusaur#1.3Bulbysaur#1.2
    
    ChugiTree empty = new ChugiTree();
    ChugiTree one = new ChugiTree();
    ChugiTree two = new ChugiTree();
    ChugiTree two2 = new ChugiTree();
    ChugiTree three = new ChugiTree();
    ChugiTree six = new ChugiTree();
    
    if(six.add(node4c) != true) {
      return false;
    }
    if(six.add(node6c) != true) {
      return false;
    }
    if(six.add(node2c) != true) {
      return false;
    }
    if(six.add(node1c) != true) {
      return false;
    }
    if(six.add(node3c) != true) {
      return false;
    }
    if(six.add(node5c) != true) {
      return false;
    }
    
    if(six.isValidBST() != true) {
      return false;
    }
    
    if(six.size() != 6) {
      return false;
    }
    
    
    if(!(six.toString().equals("Bulbizard#1.6,Bulbmander#1.4,,Bulbmeleon#1.5,Bulbtle#1.7,Bulbusaur#1.3,Bulbysaur#1.2"))) {
      return false;
    }
    
    if(six.add(node6c) != false) {
      return false;
    }
    if(six.size() != 6) {
      return false;
    }
    
    if(three.add(node6c) != true) {
      return false;
    }
    if(three.add(node2c) != true) {
      return false;
    }
    if(three.add(node1c) != true) {
      return false;
    }
    if(three.isValidBST() == false) {
      return false;
    }
    if(three.size() != 3) {
      return false;
    }
    if(!(three.toString().equals("Bulbtle#1.7,Bulbusaur#1.3,Bulbysaur#1.2"))) {
      return false;
    }

    if(two2.add(node6c) != true) {
      return false;
    }
    if(two2.add(node2c) != true) {
      return false;
    }

    if(two2.isValidBST() == false) {
     return false;
    }
    if(two2.size() != 2) {
      return false;
    }

    if(!(two2.toString().equals("Bulbtle#1.7,Bulbusaur#1.3"))) {
      return false;
    }

    if(two.add(node6c) != true) {
      return false;
    }
    if(two.add(node4c) != true) {
      return false;
    }

    if(two.isValidBST() == false) {
      return false;
    }
    if(two.size() != 2) {
      return false;
    }
    
    if(!(two.toString().equals("Bulbmeleon#1.5,Bulbtle#1.7,"))) {
      return false;
    }
      

    
    if(one.add(node1c) != true) {
      return false;
    }
    if(one.isValidBST() == false) {
      return false;
    }
    if(one.size() != 1) {
      return false;
    }
    if(!(one.toString().equals("Bulbysaur#1.2"))) {
      return false;
    }

    
    if(empty.size() != 0) {
      return false;
    }
    if(!(empty.toString().equals(""))){
      return false;
    }
    return true; // Default return statement added to resolve compiler errors
  }

  /**
   * This method checks mainly for the correctness of the ChugiTree.lookup() method. It must
   * consider at least the following test scenarios. (1) Create a new ChugiTree. Then, check that
   * calling the lookup() method on an empty ChugiTree returns false. (2) Consider a ChugiTree of
   * height 3 which contains at least 5 Chugimons. Then, try to call lookup() method to search for a
   * Chugimon having a match at the root of the tree. (3) Then, search for a Chugimon at the right
   * and left subtrees at different levels considering successful and unsuccessful search
   * operations. Make sure that the lookup() method returns the expected output for every method
   * call.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testLookup() {
    ChugiTree one = new ChugiTree();
    
    if(one.lookup(1, 2) != null) {
      System.out.println("WHY1");
      return false;
    }
    
    Chugimon node1c = new Chugimon(1, 2);
    //System.out.println(node1c);
    BSTNode<Chugimon> node1 = new BSTNode<Chugimon>(node1c);
    Chugimon node2c = new Chugimon(1, 3);
    //System.out.println(node2c);
    BSTNode<Chugimon> node2 = new BSTNode<Chugimon>(node2c);
    Chugimon node3c = new Chugimon(1, 4);
    //System.out.println(node3c);
    BSTNode<Chugimon> node3 = new BSTNode<Chugimon>(node3c);
    Chugimon node4c = new Chugimon(1, 5);
    //System.out.println(node4c);
    BSTNode<Chugimon> node4 = new BSTNode<Chugimon>(node4c);
    Chugimon node5c = new Chugimon(1, 6);
    //System.out.println(node5c);
    BSTNode<Chugimon> node5 = new BSTNode<Chugimon>(node5c);
    Chugimon node6c = new Chugimon(1, 7);
    //System.out.println(node6c);
    BSTNode<Chugimon> node6 = new BSTNode<Chugimon>(node6c);
    
    //Bulbizard#1.6 node5c
    //Bulbmander#1.4 node3c
    //Bulbmeleon#1.5 node4c
    //Bulbtle#1.7 node6c
    //Bulbusaur#1.3 node2c
    //Bulbysaur#1.2 node1c
    
    ChugiTree two = new ChugiTree();
    
    two.add(node4c);
    two.add(node2c);
    two.add(node3c);
    two.add(node1c);
    two.add(node5c);
    two.add(node6c);
    
    
    try {
    if(two.lookup(4, 3) != null) {
      System.out.println("WHY2");
      return false;
    }
    }
    catch(Exception e){
      return false;
    }
    try {
    if(two.lookup(1, 2) != null) {
        if(two.lookup(1, 2).compareTo(node1c) != 0) {
          System.out.println("WHY3");
          return false;
        }
    }
    else {
      return false;
    }
    if(two.lookup(1, 3) != null) {
      if(two.lookup(1, 3).compareTo(node2c) != 0) {
        System.out.println("WHY4");
        return false;
      }
    }
    if(two.lookup(1, 3) != null) {
      if(two.lookup(1, 3).compareTo(node6c) == 0) {
        System.out.println("WHY5");
        return false;
      }
    }
    if(two.lookup(1, 4) != null) {
      if(two.lookup(1, 4).compareTo(node3c) != 0) {
        System.out.println("WHY6");
        return false;
      }
    }
    if(two.lookup(1, 6) != null) {
      if(two.lookup(1, 6).compareTo(node5c) != 0) {
        return false;
      }
    }
    if(two.lookup(1, 6) != null) {
      if(two.lookup(1, 6).compareTo(node6c) == 0) {
        return false;
      }
    }
    if(two.lookup(1, 5) != null) {
      if(two.lookup(1, 5).compareTo(node6c) == 0) {
        return false;
      }
    }
    }
    catch(Exception e){
      return false;
    }
    
    return true; // Default return statement added to resolve compiler errors
  }

  /**
   * Checks for the correctness of ChugiTree.countType() method.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testCountType() {
    Chugimon node1c = new Chugimon(1, 2);
    //System.out.println(node1c.getPrimaryType());
    //System.out.println(node1c.getSecondaryType());
    BSTNode<Chugimon> node1 = new BSTNode<Chugimon>(node1c);
    Chugimon node2c = new Chugimon(1, 3);
    //System.out.println(node2c.getPrimaryType());
    //System.out.println(node2c.getSecondaryType());
    BSTNode<Chugimon> node2 = new BSTNode<Chugimon>(node2c);
    Chugimon node3c = new Chugimon(1, 4);
    //System.out.println(node3c.getPrimaryType());
    //System.out.println(node3c.getSecondaryType());
    BSTNode<Chugimon> node3 = new BSTNode<Chugimon>(node3c);
    Chugimon node4c = new Chugimon(1, 5);
    //System.out.println(node4c.getPrimaryType());
    //System.out.println(node4c.getSecondaryType());
    BSTNode<Chugimon> node4 = new BSTNode<Chugimon>(node4c);
    Chugimon node5c = new Chugimon(1, 6);
    //System.out.println(node5c.getPrimaryType());
    //System.out.println(node5c.getSecondaryType());
    BSTNode<Chugimon> node5 = new BSTNode<Chugimon>(node5c);
    Chugimon node6c = new Chugimon(1, 7);
    //System.out.println(node6c.getPrimaryType());
    //System.out.println(node6c.getSecondaryType());
    BSTNode<Chugimon> node6 = new BSTNode<Chugimon>(node6c);
    
    //Bulbizard#1.6 node5c
    //Bulbmander#1.4 node3c
    //Bulbmeleon#1.5 node4c
    //Bulbtle#1.7 node6c
    //Bulbusaur#1.3 node2c
    //Bulbysaur#1.2 node1c
    
    ChugiTree two = new ChugiTree();
    
    two.add(node4c);
    two.add(node2c);
    two.add(node3c);
    two.add(node1c);
    two.add(node5c);
    two.add(node6c);
    if(two.countType(node5c.getSecondaryType()) != 3) {
      return false;
    }
    if(two.countType(node4c.getPrimaryType()) != 6) {
      return false;
    }
    
    
    return true; // Default return statement added to resolve compiler errors
  }
  
  /**
   * Checks for the correctness of ChugiTree.height() method. This test must consider several
   * scenarios such as, (1) ensures that the height of an empty Chugimon tree is zero. (2) ensures
   * that the height of a tree which consists of only one node is 1. (3) ensures that the height of
   * a ChugiTree with four levels for instance, is 4.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testHeight() {
    Chugimon node1c = new Chugimon(1, 2);
    //System.out.println(node1c.getPrimaryType());
    //System.out.println(node1c.getSecondaryType());
    BSTNode<Chugimon> node1 = new BSTNode<Chugimon>(node1c);
    Chugimon node2c = new Chugimon(1, 3);
    //System.out.println(node2c.getPrimaryType());
    //System.out.println(node2c.getSecondaryType());
    BSTNode<Chugimon> node2 = new BSTNode<Chugimon>(node2c);
    Chugimon node3c = new Chugimon(1, 4);
    //System.out.println(node3c.getPrimaryType());
    //System.out.println(node3c.getSecondaryType());
    BSTNode<Chugimon> node3 = new BSTNode<Chugimon>(node3c);
    Chugimon node4c = new Chugimon(1, 5);
    //System.out.println(node4c.getPrimaryType());
    //System.out.println(node4c.getSecondaryType());
    BSTNode<Chugimon> node4 = new BSTNode<Chugimon>(node4c);
    Chugimon node5c = new Chugimon(1, 6);
    //System.out.println(node5c.getPrimaryType());
    //System.out.println(node5c.getSecondaryType());
    BSTNode<Chugimon> node5 = new BSTNode<Chugimon>(node5c);
    Chugimon node6c = new Chugimon(1, 7);
    //System.out.println(node6c.getPrimaryType());
    //System.out.println(node6c.getSecondaryType());
    BSTNode<Chugimon> node6 = new BSTNode<Chugimon>(node6c);
    
    //Bulbizard#1.6 node5c
    //Bulbmander#1.4 node3c
    //Bulbmeleon#1.5 node4c
    //Bulbtle#1.7 node6c
    //Bulbusaur#1.3 node2c
    //Bulbysaur#1.2 node1c
    
    ChugiTree empty = new ChugiTree();
    ChugiTree one = new ChugiTree();
    ChugiTree three = new ChugiTree();
    
    three.add(node6c);
    three.add(node3c);
    three.add(node4c);
    three.add(node2c);
    
    if(three.height() != 3) {
      return false;
    }
    
    one.add(node4c);
    
    if(one.height() != 1) {
      return false;
    }
    
    if(empty.height() != 0) {
      return false;
    }
    
    return true; // Default return statement added to resolve compiler errors
  }

  /**
   * Checks for the correctness of ChugiTree.getFirst() method.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testGetFirst() {
    Chugimon node1c = new Chugimon(1, 2);
    //System.out.println(node1c);
    BSTNode<Chugimon> node1 = new BSTNode<Chugimon>(node1c);
    Chugimon node2c = new Chugimon(1, 3);
    //System.out.println(node2c);
    BSTNode<Chugimon> node2 = new BSTNode<Chugimon>(node2c);
    Chugimon node3c = new Chugimon(1, 4);
    //System.out.println(node3c);
    BSTNode<Chugimon> node3 = new BSTNode<Chugimon>(node3c);
    Chugimon node4c = new Chugimon(1, 5);
    //System.out.println(node4c);
    BSTNode<Chugimon> node4 = new BSTNode<Chugimon>(node4c);
    Chugimon node5c = new Chugimon(1, 6);
    //System.out.println(node5c);
    BSTNode<Chugimon> node5 = new BSTNode<Chugimon>(node5c);
    Chugimon node6c = new Chugimon(1, 7);
    //System.out.println(node6c);
    BSTNode<Chugimon> node6 = new BSTNode<Chugimon>(node6c);
    
    node4.setLeft(node5);
    node5.setRight(node3);
    node4.setRight(node1);
    node1.setLeft(node2);
    node2.setLeft(node6);
    
    ChugiTree temp = new ChugiTree();
    ChugiTree empty = new ChugiTree();
    
    //Bulbizard#1.6 node5c
    //Bulbmander#1.4 node3c
    //Bulbmeleon#1.5 node4c
    //Bulbtle#1.7 node6c
    //Bulbusaur#1.3 node2c
    //Bulbysaur#1.2 node1c
    
    temp.add(node4c);
    temp.add(node2c);
    temp.add(node3c);
    temp.add(node1c);
    temp.add(node5c);
    temp.add(node6c);

    
    if(temp.getFirst().compareTo(node5c) != 0) {
      return false;
    }
    if(temp.getFirst().compareTo(node1c) == 0) {
      return false;
    }
    if(empty.getFirst() != null) {
      return false;
    }
    return true; // Default return statement added to resolve compiler errors
  }

  /**
   * Checks for the correctness of ChugiTree.getLast() method.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testGetLast() {
    Chugimon node1c = new Chugimon(1, 2);
    //System.out.println(node1c);
    BSTNode<Chugimon> node1 = new BSTNode<Chugimon>(node1c);
    Chugimon node2c = new Chugimon(1, 3);
    //System.out.println(node2c);
    BSTNode<Chugimon> node2 = new BSTNode<Chugimon>(node2c);
    Chugimon node3c = new Chugimon(1, 4);
    //System.out.println(node3c);
    BSTNode<Chugimon> node3 = new BSTNode<Chugimon>(node3c);
    Chugimon node4c = new Chugimon(1, 5);
    //System.out.println(node4c);
    BSTNode<Chugimon> node4 = new BSTNode<Chugimon>(node4c);
    Chugimon node5c = new Chugimon(1, 6);
    //System.out.println(node5c);
    BSTNode<Chugimon> node5 = new BSTNode<Chugimon>(node5c);
    Chugimon node6c = new Chugimon(1, 7);
    //System.out.println(node6c);
    BSTNode<Chugimon> node6 = new BSTNode<Chugimon>(node6c);
    
    node4.setLeft(node5);
    node5.setRight(node3);
    node4.setRight(node1);
    node1.setLeft(node2);
    node2.setLeft(node6);
    
    ChugiTree temp = new ChugiTree();
    ChugiTree empty = new ChugiTree();
    
    //Bulbizard#1.6 node5c
    //Bulbmander#1.4 node3c
    //Bulbmeleon#1.5 node4c
    //Bulbtle#1.7 node6c
    //Bulbusaur#1.3 node2c
    //Bulbysaur#1.2 node1c
    
    temp.add(node4c);
    temp.add(node2c);
    temp.add(node3c);
    temp.add(node1c);
    temp.add(node5c);
    temp.add(node6c);

    
    if(temp.getLast().compareTo(node1c) != 0) {
      return false;
    }
    if(temp.getLast().compareTo(node5c) == 0) {
      return false;
    }
    if(empty.getLast() != null) {
      return false;
    }
    return true; // Default return statement added to resolve compiler errors
  }

  /**
   * Checks for the correctness of ChugiTree.delete() method. This test must consider at least 3
   * test scenarios. (1) Remove a Chugimon that is at leaf node (2) Remove a Chugimon at non-leaf
   * node. For each of these scenarios, check that the size of the tree was decremented by one and
   * that the resulting ChugiTree is a valid BST, (3) ensures that the ChugiTree.delete() method
   * returns false when called on an Chugimon that is not present in the BST.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testDelete() {
    
    return false; // Default return statement added to resolve compiler errors
  }

  /**
   * Checks for the correctness of ChugiTree.next() method.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testNext() {
    ChugiTree temp = new ChugiTree();
    Chugimon one = new Chugimon(1, 7);
    Chugimon two = new Chugimon(1, 5);
    Chugimon three = new Chugimon(1, 9);
    Chugimon four = new Chugimon(1, 3);
    Chugimon five = new Chugimon(1, 8);
    Chugimon six = new Chugimon(10, 11);
    temp.add(one);
    temp.add(two);
    temp.add(three);
    temp.add(four);
    temp.add(five);
    temp.add(six);
    
    if(temp.next(two) != one) {
      return false;
    }
    
    
    return true; // Default return statement added to resolve compiler errors
  }

  /**
   * Checks for the correctness of ChugiTree.previous() method.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testPrevious() {
    ChugiTree temp = new ChugiTree();
    Chugimon one = new Chugimon(1, 7);
    Chugimon two = new Chugimon(1, 5);
    Chugimon three = new Chugimon(1, 9);
    Chugimon four = new Chugimon(1, 3);
    Chugimon five = new Chugimon(1, 8);
    Chugimon six = new Chugimon(10, 11);
    temp.add(one);
    temp.add(two);
    temp.add(three);
    temp.add(four);
    temp.add(five);
    temp.add(six);
    
    if(!temp.previous(one).equals(two)) {
      return false;
    }
    
    return true; // Default return statement added to resolve compiler errors
  }

  /**
   * Calls the test methods
   * 
   * @param args input arguments if any
   */
  public static void main(String[] args) {
    System.out.println("testChugimonCompareToEquals: " + testChugimonCompareToEquals());
    System.out.println("testChugimonToString(): " + testChugimonToString());
    System.out.println("testIsValidBSTHelper(): " + testIsValidBSTHelper());
    System.out.println("testAddToStringSize(): " + testAddToStringSize());
    System.out.println("testLookup(): " + testLookup());
    System.out.println("testHeight(): " + testHeight());
    System.out.println("testCountType(): " + testCountType());
    System.out.println("testGetFirst(): " + testGetFirst());
    System.out.println("testGetLast(): " + testGetLast());
    System.out.println("testDelete(): " + testDelete());
    System.out.println("testNext(): " + testNext());
    System.out.println("testPrevious(): " + testPrevious());
  }

}
