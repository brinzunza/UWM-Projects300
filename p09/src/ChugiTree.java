
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
 * This class implements a ChugidexStorage as a Binary Search Tree.
 * 
 * Notes: 1) You may NOT use any arrays or Collections objects (ArrayLists, etc)
 * in this class. 2)
 * You may NOT use any loops (for, while, etc) in this class. Recursive
 * strategies only.
 *
 */
public class ChugiTree implements ChugidexStorage {

  /**
   * The root of this ChugiTree. Set to null when tree is empty.
   */
  private BSTNode<Chugimon> root;

  /**
   * The size of this ChugiTree (total number of Chugimon stored in this BST)
   */
  private int size;

  /**
   * Constructor for Chugitree. Should set size to 0 and root to null.
   */
  public ChugiTree() {
    size = 0;
    root = null;
  }

  /**
   * Getter method for the Chugimon at the root of this BST.
   * 
   * @return the root of the BST.
   */
  public Chugimon getRoot() {
    return this.root.getData(); // default return statement
  }
  
  /**
   * A method for determining whether this ChugiTree is a valid BST. In
   * order to be a valid BST, the following must be true: For every internal
   * (non-leaf) node X of a binary tree, all the values in the node's left subtree
   * are less than the value in X, and all the values in the node's right subtree
   * are greater than the value in X.
   * 
   * @return true if this ChugiTree is a valid BST, false otherwise
   */
  public boolean isValidBST() {
    return isValidBSTHelper(root);
  }

  /**
   * A helper method for determining whether this ChugiTree is a valid BST. In
   * order to be a valid BST, the following must be true: For every internal
   * (non-leaf) node X of a binary tree, all the values in the node's left subtree
   * are less than the value in X, and all the values in the node's right subtree
   * are greater than the value in X.
   * 
   * @param node The root of the BST.
   * @return true if the binary tree rooted at node is a BST, false otherwise
   */
  public static boolean isValidBSTHelper(BSTNode<Chugimon> node) {
    //System.out.println(node.getData().toString());
    if(node == null) {
      return true;
    }
    if(getLastHelper(node.getLeft()) != null) {
      if(getLastHelper(node.getLeft()).compareTo(node.getData()) > 0) {
        return false;
      }
    }
    if(getFirstHelper(node.getRight()) != null) {
      if(getFirstHelper(node.getRight()).compareTo(node.getData()) < 0) {
        return false;
      }
    }
    
    
    if(node.getRight() != null && node.getData().compareTo(node.getRight().getData()) < 0) {
        return isValidBSTHelper(node.getRight());
    }
    if(node.getLeft() != null && node.getData().compareTo(node.getLeft().getData()) > 0) {
        return isValidBSTHelper(node.getLeft());
    }
    
    
    
    if(node.getLeft() == null && node.getRight() == null) {
      return true;
    }
   return false;
  }

  /**
   * Checks whether this ChugiTree is empty or not
   * 
   * @return true if this tree is empty, false otherwise
   */
  @Override
  public boolean isEmpty() {
    if(this.size() == 0) {
      return true;
    }
    return false; // default return statement
  }

  /**
   * Gets the size of this ChugiTree
   * 
   * @return the total number of Chugimons stored in this tree
   */
  @Override
  public int size() {
    return size; // default return statement
  }

  /**
   * Returns a String representation of all the Chugimons stored within this
   * ChugiTree in the
   * increasing order with respect to the result of Chugimon.compareTo() method.
   * The string should
   * be a comma-separated list of all the Chugimon toString() values. No spaces
   * are expected to be
   * in the resulting string. No comma should be at the end of the resulting
   * string. For instance,
   * 
   * "nameOne#12.25,nameTwo#12.56,nameTwo#89.27"
   * 
   * @return a string containing all of the Chugimon, in the increasing order.
   *         Returns an empty
   *         string "" if this BST is empty.
   * 
   */
  @Override
  public String toString() {
    String temp = "";
    temp += toStringHelper(root);
    return temp;
  }

  /**
   * Recursive helper method which returns a String representation of the
   * ChugiTree rooted at node. An example of the String representation of the
   * contents of a ChugiTree storing three Chugimons is provided in the
   * description of the above toString() method.
   * 
   * @param node references the root of a subtree
   * @return a String representation of all the Chugimons stored in the sub-tree
   *         rooted at node in
   *         increasing order. Returns an empty String "" if current is null.
   */
  protected static String toStringHelper(BSTNode<Chugimon> node) {
//    String temp = "";
//    if(node == null) {
//      return temp;
//    }
//    if(node.getLeft() != null) {
//      temp += toStringHelper(node.getLeft());
//    }
//    if(node.getRight() != null) {
//      temp += toStringHelper(node.getRight());
//    }
//    return temp; // Default return statement added to resolve compiler errors
    String toReturn = "";
    // base case
    if (node == null) {
      return toReturn;
    }
    if (node.getLeft() != null) {
      toReturn += toStringHelper(node.getLeft()) + ",";
    }
    toReturn += node.getData();
    if (node.getLeft() != null || node.getRight() != null) {
      toReturn += ",";
    }
    if (node.getRight() != null) {
      toReturn += toStringHelper(node.getRight());
    }
    return toReturn;
  }

  /**
   * Adds a new Chugimon to this ChugiTree. Duplicate Chugimons are NOT allowed.
   * 
   * @param newChugimon Chugimon to add to this ChugiTree
   * @return true if if the newChugimon was successfully added to the ChugiTree,
   *         false if a match with newChugimon is already present in the tree.
   * @throws IllegalArgumentException with a descriptive error message if
   *                                  newChugimon is null.
   */
  @Override
  public boolean add(Chugimon newChugimon) throws IllegalArgumentException{
    if(newChugimon == null) {
      throw new IllegalArgumentException("new chugimon could not be added to tree as it is null");
    }
//    if((this.lookup(newChugimon.getFirstID(), newChugimon.getSecondID())) == null) {
//      if(addHelper(newChugimon, root)) {
//         size++;
//         return true;
//        }
//      }
//    return false;
//    }
    if (isEmpty()) {
      BSTNode<Chugimon> node = new BSTNode<Chugimon>(newChugimon);
      root = node;
      size++;
      return true;
    }
    else {
      if (addHelper(newChugimon, root)) {
        size++;
        return true;
      }
      return false;
    }
  }
  /**
   * Recursive helper method to insert a new Chugimon to a Pokedex rooted at node.
   * 
   * @param node        The "root" of the subtree we are inserting the new
   *                    Chugimon into.
   * @param newChugimon The Chugimon to be added to a BST rooted at node. We
   *                    assume that newChugimon is NOT null.
   * @return true if the newChugimon was successfully added to the ChugiTree,
   *         false if a match with
   *         newChugimon is already present in the subtree rooted at node.
   */
  protected static boolean addHelper(Chugimon newChugimon, BSTNode<Chugimon> node) {
//    BSTNode<Chugimon> temp = new BSTNode<Chugimon>(newChugimon);
//    if(node == null) {
//      node = temp;
//      return true;
//    }
//    if(newChugimon.compareTo(node.getData()) > 0) {
//      if(node.getRight() == null) {
//        node.setRight(temp);
//        return true;
//      }
//      else if(node.getRight() != null) {
//        return addHelper(newChugimon, node.getRight());
//      }
//    }
//    if(newChugimon.compareTo(node.getData()) < 0) {
//      if(node.getLeft() == null) {
//        node.setLeft(temp);
//        return true;
//      }
//      else if(node.getLeft() != null) {
//        return addHelper(newChugimon, node.getLeft());
//      }
//    }
//
//    return false; // default return statement
    int compareVal = newChugimon.compareTo(node.getData());
    if (compareVal == 0) {
      return false;
    }
    else if (compareVal < 0) {
      if (node.getLeft() == null) {
        node.setLeft(new BSTNode<Chugimon>(newChugimon));
      }
      else {
        return addHelper(newChugimon, node.getLeft());
      }
    }
    else {
      if (node.getRight() == null) {
        node.setRight(new BSTNode<Chugimon>(newChugimon));
      }
      else {
        return addHelper(newChugimon, node.getRight());
      }
    }
    return true;
  }

  /**
   * Searches a Chugimon given its first and second identifiers.
   * 
   * @param firstId  First identifier of the Chugimon to find
   * @param secondId Second identifier of the Chugimon to find
   * @return the matching Chugimon if match found, null otherwise.
   */
  @Override
  public Chugimon lookup(int firstId, int secondId) {
    Chugimon temp = new Chugimon(firstId, secondId);
      return lookupHelper(temp, root);
  }

  /**
   * Recursive helper method to search and return a match with a given Chugimon in
   * the subtree rooted at node, if present.
   * 
   * @param toFind a Chugimon to be searched in the BST rooted at node. We assume
   *               that toFind is NOT null.
   * @param node   "root" of the subtree we are checking whether it contains a
   *               match to target.
   * @return a reference to the matching Chugimon if found, null otherwise.
   */
  protected static Chugimon lookupHelper(Chugimon toFind, BSTNode<Chugimon> node) {
    if(node == null) {
      return null;
    }
    if(toFind.compareTo(node.getData()) == 0) {
      return node.getData();
    }
    if(toFind.compareTo(node.getData()) < 0) {
      return lookupHelper(toFind, node.getLeft());
    }
    if(toFind.compareTo(node.getData()) > 0) {
      return lookupHelper(toFind, node.getRight());
    }
    return null;
  }

  /**
   * Computes and returns the height of this BST, counting the number of NODES
   * from root to the deepest leaf.
   * 
   * @return the height of this Binary Search Tree
   */
  public int height() {
    return heightHelper(root); // Default return statement
  }

  /**
   * Recursive helper method that computes the height of the subtree rooted at
   * node counting the number of nodes and NOT the number of edges from node to
   * the deepest leaf
   * 
   * @param node root of a subtree
   * @return height of the subtree rooted at node
   */
  protected static int heightHelper(BSTNode<Chugimon> node) {
    int temp = 0;
    if(node == null) {
      return 0;
    }
    
    int leftHeight = heightHelper(node.getLeft());
    int rightHeight = heightHelper(node.getRight());
    
    if(leftHeight > rightHeight) {
      temp = leftHeight;
    }
    else {
      temp = rightHeight;
    }
    
    return temp + 1; // Default return statement
  }

  /**
   * Recursive method to find and return the first Chugimon, in the increasing
   * order, within this ChugiTree (meaning the smallest element stored in the
   * tree).
   * 
   * @return the first element in the increasing order of this BST, and null if
   *         the tree is empty.
   */
  @Override
  public Chugimon getFirst() {

    // HINT: The smallest element in a non-empty BST is the left most element

    return getFirstHelper(root); // default return statement
  }

  /**
   * Recursive helper method for getFirst().
   * 
   * @param root the node from which to find the the minimum node
   * @return the minimum element in the increasing order from the node <b>root</b>
   */
  protected static Chugimon getFirstHelper(BSTNode<Chugimon> root) {
    if(root == null) {
      return null;
    }
    if(root.getLeft() == null) {
      return root.getData();
    }
    return getFirstHelper(root.getLeft());
  }

  /**
   * Recursive method to find and return the last Chugimon, in the increasing
   * order, within this ChugiTree (meaning the greatest element stored in the
   * tree).
   * 
   * @return the last element in the increasing order of this BST, and null if the
   *         tree is empty.
   */
  @Override
  public Chugimon getLast() {
    // HINT: The greatest element in a non-empty BST is the right most element
    return getLastHelper(root); // default return statement
  }

  /**
   * Recursive helper method for getLast().
   * 
   * @param root the node from which to find the the maximum node
   * @return the maximum element in the increasing order from the node <b>root</b>
   */
  protected static Chugimon getLastHelper(BSTNode<Chugimon> root) {
    if(root == null) {
      return null;
    }
    if(root.getRight() == null) {
      return root.getData();
    }
    return getLastHelper(root.getRight());
  }

  /**
   * Recursive method to get the number of Chugimon with a primary or secondary
   * type of the specified type, stored in this ChugiTree.
   * 
   * @param chugiType the type of Chugimons to count. We assume that chugiType is
   *                  NOT null.
   * @return the number of all the Chugimon objects with a primary or secondary
   *         type of the
   *         specified type stored in this ChugiTree.
   */
  public int countType(ChugiType chugiType) {
    
    return countTypeHelper(root, chugiType);
  }
  
  /**
   * Recursive method to get the number of Chugimon with a primary or secondary type of the specified type, stored in this ChugiTree
   * 
   * @param node the node from which to find if it follows the specified type
   * @return total the total amount of Chugimon that follow the specified type
   */
  private static int countTypeHelper(BSTNode<Chugimon> node, ChugiType chugiType) {
    int temp = 0;
    if(node == null) {
      return 0;
    }
    if(node.getData().getPrimaryType().equals(chugiType) || node.getData().getSecondaryType().equals(chugiType)) {
      temp++;
      if(node.getLeft() != null) {
        temp += countTypeHelper(node.getLeft(), chugiType);
      }
      if(node.getLeft() != null) {
        temp += countTypeHelper(node.getRight(), chugiType);
      }
    }
    return temp;
  }
  /**
   * Finds and returns the in-order successor of a specified Chugimon in this
   * ChugiTree
   * 
   * @param chugi the Chugimon to find its successor
   * @return the in-order successor of a specified Chugimon in this ChugiTree
   * 
   * @throws IllegalArgumentException with a descriptive error message if
   *                                  <b>chugi</b> is null
   * @throws NoSuchElementException   with a descriptive error message if the
   *                                  Chugimon provided as input has no in-order
   *                                  successor in this ChugiTree.
   */
  @Override
  public Chugimon next(Chugimon chugi) {
    if (chugi == null) {
      throw new IllegalArgumentException("Input must not be null");
    }
    return nextHelper(chugi, root, null);
  }

  /**
   * Recursive helper method to find and return the next Chugimon in the tree
   * rooted at node.
   * 
   * @param chugi a Chugimon to search its in-order successor. We assume that
   *              <b>chugi</b> is NOT
   *              null.
   * @param node  "root" of a subtree storing Chugimon objects
   * @param next  a BSTNode which stores a potentional candidate for next node
   * @return the next Chugimon in the tree rooted at node.
   * @throws NoSuchElementException with a descriptive error message if the
   *                                Chugimon provided as input has no in-order
   *                                successor in the subtree
   *                                rooted at node.
   */
  protected static Chugimon nextHelper(Chugimon chugi, BSTNode<Chugimon> node, BSTNode<Chugimon> next) {
    // TODO: Implement this method.
    // Hint: you will need to use getFirstHelper in this method. Below are
    // additional hints.

    // base case: node is null
    if (node == null) {
      throw new NoSuchElementException("No successor found");
    }
    // recursive cases:
    // (1) if chugi is found and if the right child is not null, use getFirstHelper
    // to find and
    // return the next chugimon. It should be the left most child of the right
    // subtree
    if (node.getData().equals(chugi)) {
      if (node.getRight() != null) {
        return getFirstHelper(node.getRight());
      }
      else {
        if (next == null) {
          throw new NoSuchElementException("No successor found.");
        }
        return next.getData();
      }
    }
    // (2) if chugi is less than the Chugimon at node, set next as the root node and
    // search
    // recursively into the left subtree
    int compareVal = chugi.compareTo(node.getData());
    if (compareVal < 0) {
      return nextHelper(chugi, node.getLeft(), node);
    }
    else {
      return nextHelper(chugi, node.getRight(), next);
    }
  }

  /**
   * Finds and returns the in-order predecessor of a specified Chugimon in this
   * ChugiTree
   * 
   * @param chugi the Chugimon to find its predecessor
   * @return the in-order predecessor of a specified Chugimon in this ChugiTree.
   * 
   * @throws IllegalArgumentException with a descriptive error message if
   *                                  <b>chugi</b> is null
   * @throws NoSuchElementException   if there is no Chugimon directly before the
   *                                  provided Chugimon
   */
  @Override
  public Chugimon previous(Chugimon chugi) {
    if (chugi == null) {
      throw new IllegalArgumentException("Input must not be null");
    }
    return previousHelper(chugi, root, null);
  }

  /**
   * Recursive helper method to find and return the previous Chugimon in the tree
   * rooted at node.
   * 
   * @param chugi a Chugimon to search its in-order predecessor. We assume that
   *              <b>chugi</b> is NOT
   *              null.
   * @param node  "root" of a subtree storing Chugimon objects
   * @param prev  a BSTNode which stores a potentional candidate for previous node
   * @return the previous Chugimon in the tree rooted at node.
   * @throws NoSuchElementException with a descriptive error message if the
   *                                Chugimon provided as input has no in-order
   *                                predecessor in the subtree rooted at node.
   */
  protected static Chugimon previousHelper(Chugimon chugi, BSTNode<Chugimon> node,
      BSTNode<Chugimon> prev) {
    // TODO Implement this method.
    // Hint: you will need to use getLastHelper in this method. Below are more
    // hints.

    // base case: node is null
    if (node == null) {
      throw new NoSuchElementException("No predecessor found");
    }
    // recursive cases:
    // (1) if chugi is found and if the left child is not null, use getLastHelper to
    // find and return
    // the previous chugimon. It should be the right most child of the left subtree
    if (node.getData().equals(chugi)) {
      if (node.getLeft() != null) {
        return getLastHelper(node.getLeft());
      }
      else {
        if (prev == null) {
          throw new NoSuchElementException("No predecessor found.");
        }
        return prev.getData();
      }
    }
    // (2) if chugi is greater than the Chugimon at node, set prev as the root node
    // and search
    // recursively into the right subtree
    int compareVal = chugi.compareTo(node.getData());
    if (compareVal > 0) {
      return previousHelper(chugi, node.getRight(), node);
    }
    else {
      return previousHelper(chugi, node.getLeft(), prev);
    }
  }
//  /**
//   * Finds and returns the in-order successor of a specified Chugimon in this
//   * ChugiTree
//   * 
//   * @param chugi the Chugimon to find its successor
//   * @return the in-order successor of a specified Chugimon in this ChugiTree
//   * 
//   * @throws IllegalArgumentException with a descriptive error message if
//   *                                  <b>chugi</b> is null
//   * @throws NoSuchElementException   with a descriptive error message if the
//   *                                  Chugimon provided as input has no in-order
//   *                                  successor in this ChugiTree.
//   */
//  @Override
//  public Chugimon next(Chugimon chugi) throws IllegalArgumentException, NoSuchElementException{
//    if(chugi == null) {
//      throw new IllegalArgumentException("next could not be found as chugi input is null");
//    }
//    if(nextHelper(chugi, root, root) == null) {
//      throw new NoSuchElementException("next could not be found as no inorder successor exists");
//    }
//    return nextHelper(chugi, root, root);
//  }
//  /**
//   * Recursive helper method to find and return the next Chugimon in the tree
//   * rooted at node.
//   * 
//   * @param chugi a Chugimon to search its in-order successor. We assume that
//   *              <b>chugi</b> is NOT
//   *              null.
//   * @param node  "root" of a subtree storing Chugimon objects
//   * @param next  a BSTNode which stores a potentional candidate for next node
//   * @return the next Chugimon in the tree rooted at node.
//   * @throws NoSuchElementException with a descriptive error message if the
//   *                                Chugimon provided as input has no in-order
//   *                                successor in the subtree
//   *                                rooted at node.
//   */
//  protected static Chugimon nextHelper(Chugimon chugi, BSTNode<Chugimon> node, BSTNode<Chugimon> next) {
//    if(node == null) {
//      return null;
//    }
//    if(chugi.compareTo(node.getData()) == 0) {
//      if(node.getRight() != null) {
//        return getFirstHelper(node);
//      }
//    }
//    if(chugi.compareTo(node.getData()) < 0) {
//      next = node;
//      return nextHelper(chugi, node.getLeft(), next);
//    }
//    
//    
//    // Hint: you will need to use getFirstHelper in this method. Below are
//    // additional hints.
//
//    // base case: node is null
//
//    // recursive cases:
//    // (1) if chugi is found and if the right child is not null, use getFirstHelper
//    // to find and
//    // return the next chugimon. It should be the left most child of the right
//    // subtree
//
//    // (2) if chugi is less than the Chugimon at node, set next as the root node and
//    // search
//    // recursively into the left subtree
//    return null;
//  }
//
//  /**
//   * Finds and returns the in-order predecessor of a specified Chugimon in this
//   * ChugiTree
//   * 
//   * @param chugi the Chugimon to find its predecessor
//   * @return the in-order predecessor of a specified Chugimon in this ChugiTree.
//   * 
//   * @throws IllegalArgumentException with a descriptive error message if
//   *                                  <b>chugi</b> is null
//   * @throws NoSuchElementException   if there is no Chugimon directly before the
//   *                                  provided Chugimon
//   */
//  @Override
//  public Chugimon previous(Chugimon chugi) {
//    return previousHelper(chugi, root, null);
//  }
//
//  /**
//   * Recursive helper method to find and return the previous Chugimon in the tree
//   * rooted at node.
//   * 
//   * @param chugi a Chugimon to search its in-order predecessor. We assume that
//   *              <b>chugi</b> is NOT
//   *              null.
//   * @param node  "root" of a subtree storing Chugimon objects
//   * @param prev  a BSTNode which stores a potentional candidate for previous node
//   * @return the previous Chugimon in the tree rooted at node.
//   * @throws NoSuchElementException with a descriptive error message if the
//   *                                Chugimon provided as input has no in-order
//   *                                predecessor in the subtree rooted at node.
//   */
//  protected static Chugimon previousHelper(Chugimon chugi, BSTNode<Chugimon> node, BSTNode<Chugimon> prev) {
//    if(node == null) {
//      return null;
//    }
//    
//    if(chugi.compareTo(node.getData()) == 0) {
//      if(node.getLeft() != null) {
//        return getLastHelper(node);
//      }
//    }
//    if(chugi.compareTo(node.getData()) > 0) {
//      prev = node;
//      return previousHelper(chugi, node.getRight(), prev);
//    }
//    // Hint: you will need to use getLastHelper in this method. Below are more
//    // hints.
//
//    // base case: node is null
//
//    // recursive cases:
//    // (1) if chugi is found and if the left child is not null, use getLastHelper to
//    // find and return
//    // the previous chugimon. It should be the right most child of the left subtree
//
//    // (2) if chugi is greater than the Chugimon at node, set prev as the root node
//    // and search
//    // recursively into the right subtree
//
//    return null;
//  }

  /**
   * Deletes a specific Chugimon from this ChugiTree.
   * 
   * @param chugi the Chugimon to delete
   * @return true if the specific Chugimon is successfully deleted, false if no
   *         match found with any
   *         Chugimon in this tree.
   * @throws IllegalArgumentException with a descriptive error message if
   *                                  <b>chugi</b> is null
   */
  @Override
  public boolean delete(Chugimon chugi) {
    if(deleteChugimonHelper(chugi, root) == null) {
      return false;
    }
    return true; // default return statement
  }

  /**
   * Recursive helper method to search and delete a specific Chugimon from the BST
   * rooted at node
   * 
   * @param target a reference to a Chugimon to delete from the BST rooted at
   *               node. We assume that target is NOT null.
   * @param node   "root" of the subtree we are checking whether it contains a
   *               match with the target Chugimon.
   * 
   * 
   * @return the new "root" of the subtree we are checking after trying to remove
   *         target
   * @throws NoSuchElementException with a descriptive error message if there is
   *                                no Chugimon matching target in the BST rooted
   *                                at <b>node</b>
   */
  protected static BSTNode<Chugimon> deleteChugimonHelper(Chugimon target, BSTNode<Chugimon> node) {
 // TODO complete the implementation of this method. Problem decomposition and
    // hints are provided in the comments below

    // if node == null (empty subtree rooted at node), no match found, throw an
    // exception
    if (node == null) {
      throw new NoSuchElementException("No Chugimon matching target in the BST rooted at the inputted node");
    }
    // Compare the target to the data at node and proceed accordingly
    // Recurse on the left or right subtree with respect to the comparison result
    // Make sure to use the output of the recursive call to appropriately set the
    // left or the right child of node accordingly
    if (node.getLeft() == null || node.getRight() == null) {
      throw new NoSuchElementException("No Chugimon matching target in the BST rooted at the inputted node");
    }
    int compareVal = target.compareTo(node.getData());
    // if match with target found, three cases should be considered. Feel free to
    // organize the order of these cases at your choice.
    if (compareVal < 0) {
      System.out.println(node.getData());
      if (node.getLeft().getData().equals(target)) {
        // Case 1: leaf (no children)
        if (node.getLeft().getLeft() == null && node.getLeft().getRight() == null) {
          node.setLeft(null);
          return null;
        }
        // Case 2: node may have only one child, set node to that child (whether left or
        // right child)
        else if (node.getLeft().getLeft() != null && node.getLeft().getRight() == null) {
          BSTNode<Chugimon> returnVal = node.getLeft();
          node.setLeft(node.getLeft().getLeft());
          return returnVal;
        }
        else if (node.getLeft().getRight() != null && node.getLeft().getLeft() == null) {
          BSTNode<Chugimon> returnVal = node.getLeft();
          node.setLeft(node.getLeft().getRight());
          return returnVal;
        }
        // Case 3
        else if (node.getLeft().getLeft() != null && node.getLeft().getRight() != null) {
          // find successor
          Chugimon successor = nextHelper(node.getLeft().getData(), node.getLeft(), null);
          BSTNode<Chugimon> successorNode = new BSTNode<Chugimon>(successor);
          // delete successor
          deleteChugimonHelper(successor, node);
          // set successor left and right
          successorNode.setLeft(node.getLeft().getLeft());
          successorNode.setRight(node.getLeft().getRight());
          // replace node with successor
          node.setLeft(successorNode);  
          return successorNode;
        }
      }
      else {
        return deleteChugimonHelper(target, node.getLeft());
      }
    }
    else if (compareVal > 0) {
      if (node.getRight().getData().equals(target)) {
        // Case 1: leaf (no children)
        if (node.getRight().getLeft() == null && node.getRight().getRight() == null) {
          node.setRight(null);
          return null;
        }
        // Case 2: node may have only one child, set node to that child (whether left or
        // right child)
        else if (node.getRight().getLeft() != null && node.getRight().getRight() == null) {
          BSTNode<Chugimon> returnVal = node.getRight();
          node.setRight(node.getRight().getLeft());
          return returnVal;
        }
        else if (node.getRight().getRight() != null && node.getRight().getLeft() == null) {
          BSTNode<Chugimon> returnVal = node.getRight();
          node.setRight(node.getRight().getRight());
          return returnVal;
        }
        // Case 3
        else if (node.getRight().getLeft() != null && node.getRight().getRight() != null) {
          // find successor
          Chugimon successor = nextHelper(node.getRight().getData(), node.getRight(), null);
          BSTNode<Chugimon> successorNode = new BSTNode<Chugimon>(successor);
          // delete successor
          deleteChugimonHelper(successor, node);
          // set successor left and right
          successorNode.setRight(node.getRight().getRight());
          successorNode.setLeft(node.getRight().getLeft());
          // replace node with successor
          node.setLeft(successorNode);  
          return successorNode;
        }
      }
      else {
        return deleteChugimonHelper(target, node.getRight());
      }
    }
    // Case 1: node may be a leaf (has no children), set node to null.

    // Case 2: node may have only one child, set node to that child (whether left or
    // right child)

    // Case 3: node may have two children,
    // Replace node with a new BSTNode whose data field value is the successor of
    // target in the tree, and having the same left and right children as node.
    // Notice carefully that you cannot set the data of a BSTNode. Hint: The
    // successor is the smallest element at the right subtree of node
    //
    // Then, remove the successor from the right subtree. The successor must have up
    // to one child.

    // Make sure to return node (the new root to this subtree) at the end of each
    // case or at the end of the method.
    return node;
  }

}
