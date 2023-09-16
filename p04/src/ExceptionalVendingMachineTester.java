//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    The Very Cool and Functional Vending Machine
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

// TODO import relevant exceptions here
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.zip.DataFormatException;
import java.util.Scanner;

/**
 * This class implements testers to check the correctness of the methods implemented in p04
 * Exceptional Vending Machine
 *
 */
@SuppressWarnings("unused")
public class ExceptionalVendingMachineTester {
  // TODO complete the implementation of all the public static tester methods defined below

  // It is recommended but NOT required to add additional tester methods to check the correctness
  // of loadItems and saveVendingMachineSumary defined in the ExceptionalVendingMachine class.

  /**
   * Checks the correctness of the constructor of the class Item when passed invalid inputs
   * 
   * @return true if the test verifies a correct functionality and false if any bug is detected
   */
  public static boolean testItemConstructorNotValidInput() {
    try {
      Item testnull = new Item(null, 5);
      System.out.println("null description fail");
      return false;
    }
    catch(IllegalArgumentException e){
    }
    catch(Exception e) {
      e.printStackTrace();
      return false;
    }
    try {
      Item testnegative = new Item("Bruno", -5);
      System.out.println("negative expirationDate fail");
    }
    catch(IllegalArgumentException e){
    }
    catch (Exception e){
      e.printStackTrace();
      return false;
    }
    
    try {
      Item testzero = new Item("Bruno", 0);
      System.out.println("zero expirationDate fail");
    }
    catch(IllegalArgumentException e){
    }
    catch (Exception e){
      e.printStackTrace();
      return false;
    }
    
    try {
      Item testblank = new Item("", 1);
      System.out.println("blank description");
      return false;
    }
    catch (IllegalArgumentException e) {}
    catch (Exception e) {
      e.printStackTrace();
      return false;
    }
    return true;//no buy detected
  }

  /**
   * Checks the correctness of the constructor of the class Item, Item.getDescription(),
   * Item.getExpirationDate(), Item.setDescription(), and Item.toString() when passed valid inputs
   * 
   * @return true if the test verifies a correct functionality and false if any bug is detected
   */
  public static boolean testItemConstructorGettersSetters() {
    Item test = new Item("Bruno", 5);
    if(!test.getDescription().equals("Bruno") && test.getExpirationDate() == 5) {
      System.out.println("setDescription fail");
    }
      test.setDescription("Inzunza");
      if(!test.getDescription().equals("Inzunza") && test.toString().equals("Inzunza: 3")) {
        System.out.println("setDescription/getExpirationDate fail");
        return false;
    }
    
    return true; // default return statement added to resolve compiler errors
  }

  /**
   * Checks the correctness of the Item.equals() method. You should consider at least the following
   * four scenarios. (1) Create an item with valid description and expiration date, comparing it to
   * itself should return true. (2) Two items having the same description but different expiration
   * dates should be equal. (3) Passing a null reference to the Item.equals() method should return
   * false. (4) An item MUST NOT be equal to an object NOT instance of the class Item, for instance
   * a string object.
   * 
   * @return true if the test verifies a correct functionality and false if any bug is detected
   */
  public static boolean testItemEquals() {
    Item test1 = new Item("Bruno", 5);
    Item test2 = new Item("Bruno", 4);
    
    if(test1.equals(test1)) {
      if(test1.equals(test2)) {
        if(test1.equals(null) == false) {
          if(test1.equals("Hello") == false) {
            return true;
          }
          System.out.println("NOT instance of class fail");
        }
        System.out.println("null reference fail");
      }
      System.out.println("Item equals another equal Item fail");
    }
    System.out.println("Item equals itself fail");
    return false; // default return statement added to resolve compiler errors
  }


  /**
   * Checks the correctness of the constructor of the ExceptionalVendingMachine when passed invalid
   * input
   * 
   * @return true if the test verifies a correct functionality and false if any bug is detected
   */
  public static boolean testExceptionalVendingMachineConstructor() {
    try {
      ExceptionalVendingMachine test = new ExceptionalVendingMachine(-1);
      System.out.println("ExceptionalVendingMachine negative size fail");
      return false;
    }
    catch(IllegalArgumentException e){
    }
    catch(Exception e) {
      e.printStackTrace();
      return false;
    }
    return true; // default return statement added to resolve compiler errors
  }

  /**
   * Checks the correctness of the following methods defined in the ExceptionalVendingMachine class
   * when an exception is expected to be thrown:
   * 
   * addItem(), containsItem(), getIndexNextItem(), getItemAtIndex(), getItemOccurrences(),
   * getItemOccurrencesByExpirationDate(), removeNextItem().
   * 
   * @return true if the test verifies a correct functionality and false if any bug is detected
   */
  public static boolean testExceptionalVendingMachineAddContainsRemoveGetters() {
    ExceptionalVendingMachine full = new ExceptionalVendingMachine(2);
      full.addItem("Hello", 2);
      full.addItem("World", 6);
    
    try {
      full.addItem("What", 8);
      System.out.println("ExceptionalVendingMachine full vending machine fail");
      return false;
    }
    catch(IllegalStateException e){
    }
    catch(Exception e) {
      e.printStackTrace();
      return false;
    }
    
    try {
      full.containsItem("");
      System.out.println("ExceptionalVendingMachine blank contains item fail");
      return false;
    }
    catch(IllegalArgumentException e){
    }
    catch(Exception e) {
      e.printStackTrace();
      return false;
    }
    
    try {
      full.containsItem(null);
      System.out.println("ExceptionalVendingMachine null contains item fail");
      return false;
    }
    catch(IllegalArgumentException e){
    }
    catch(Exception e) {
      e.printStackTrace();
      return false;
    }
    
    
    try {
      full.getIndexNextItem(null);
      System.out.println("ExceptionalVendingMachine null contains item fail");
      return false;
    }
    catch(IllegalArgumentException e){
    }
    catch(Exception e) {
      e.printStackTrace();
      return false;
    }
    
    try {
      full.containsItem("");
      System.out.println("ExceptionalVendingMachine blank contains item fail");
      return false;
    }
    catch(IllegalArgumentException e){
    }
    catch(Exception e) {
      e.printStackTrace();
      return false;
    }
    
    try {
    full.removeNextItem("Bruno");
    return false;
  }
  catch (NoSuchElementException e) {}
  catch (Exception e) {
    e.printStackTrace();
    return false;
  }
    
    try {
      full.getItemAtIndex(4);
      System.out.println("ExceptionalVendingMachine index greater than vending fail");
      return false;
    }
    catch(IndexOutOfBoundsException e){
    }
    catch(Exception e) {
      e.printStackTrace();
      return false;
    }
    
    try {
      full.getItemAtIndex(-1);
      System.out.println("ExceptionalVendingMachine index 0 fail");
      return false;
    }
    catch(IndexOutOfBoundsException e){
    }
    catch(Exception e) {
      e.printStackTrace();
      return false;
    }
    
    try {
      full.getItemOccurrences("");
      System.out.println("ExceptionalVendingMachine occurrences input blank fail");
      return false;
    }
    catch(IllegalArgumentException e){
    }
    catch(Exception e) {
      e.printStackTrace();
      return false;
    }
    
    try {
      full.getItemOccurrences(null);
      System.out.println("ExceptionalVendingMachine occurrences input null fail");
      return false;
    }
    catch(IllegalArgumentException e){
    }
    catch(Exception e) {
      e.printStackTrace();
      return false;
    }
    
    try {
      full.getItemOccurrencesByExpirationDate("", 1);
      System.out.println("ExceptionalVendingMachine occurrences by expdate input blank fail");
      return false;
    }
    catch(IllegalArgumentException e){
    }
    catch(Exception e) {
      e.printStackTrace();
      return false;
    }
    
    try {
      full.getItemOccurrencesByExpirationDate(null, 1);
      System.out.println("ExceptionalVendingMachine occurrences by expdate input null fail");
      return false;
    }
    catch(IllegalArgumentException e){
    }
    catch(Exception e) {
      e.printStackTrace();
      return false;
    }
    
    try {
      full.getItemOccurrencesByExpirationDate("Hello", -1);
      System.out.println("ExceptionalVendingMachine occurrences by expdate input negative fail");
      return false;
    }
    catch(IllegalArgumentException e){
    }
    catch(Exception e) {
      e.printStackTrace();
      return false;
    }
    
    try {
      full.removeNextItem("What");
      System.out.println("ExceptionalVendingMachine no such item exists for remove next item fail");
      return false;
    }
    catch(NoSuchElementException e){
    }
    catch(Exception e) {
      e.printStackTrace();
      return false;
    }
    
    try {
      full.removeNextItem("");
      System.out.println("ExceptionalVendingMachine blank remove next item input fail");
      return false;
    }
    catch(IllegalArgumentException e){
    }
    catch(Exception e) {
      e.printStackTrace();
      return false;
    }
    
    try {
      full.removeNextItem(null);
      System.out.println("ExceptionalVendingMachine null remove next item input fail");
      return false;
    }
    catch(IllegalArgumentException e){
    }
    catch(Exception e) {
      e.printStackTrace();
      return false;
    }
    return true; // default return statement added to resolve compiler errors
  }

  /**
   * Checks the correctness of isEmpty(), size(), and isFull() methods defined in the
   * ExceptionalVendingMachine class
   * 
   * @return true if the test verifies a correct functionality and false if any bug is detected
   */
  public static boolean testEmptySizeFullExceptionalVendingMachine() {
    ExceptionalVendingMachine vendingMachine = new ExceptionalVendingMachine(5);
    if (!vendingMachine.isEmpty()) {
      System.out.println("ExceptionalVendingMachine isEmpty 0 fail");
      return false;
    }
    if (vendingMachine.isFull()) {
      System.out.println("ExceptionalVendingMachine isFull 0 fail");
      return false;
    }
    if (vendingMachine.size() != 0) {
      System.out.println("ExceptionalVendingMachine size empty fail");
      return false;
    }
    vendingMachine.addItem("candy", 1);
    if (vendingMachine.size() != 1) {
      System.out.println("ExceptionalVendingMachine isEmpty 1 fail");
      return false;
    }
    vendingMachine.addItem("soda", 2);
    if (vendingMachine.isEmpty()) {
      System.out.println("ExceptionalVendingMachine isEmpty 2 fail");
      return false;
    }
    if (vendingMachine.isFull()) {
      System.out.println("ExceptionalVendingMachine isFull 2 fail");
      return false;
    }
    if (vendingMachine.size() != 2) {
      System.out.println("ExceptionalVendingMachine size 2 fail");
      return false;
    }
    return true; // no bug detected
  }

  /**
   * Checks the correctness of loadOneItem method with respect to its specification. Consider at
   * least the four following scenarios. (1) Successful scenario for loading one item with a valid
   * string representation to a non-full vending machine. (2) Unsuccessful scenario for passing null
   * or a blank string (for instance one space or empty string) to the loadOneItem() method call, an
   * IllegalArgumentEXception is expected to be thrown. (3) Unsuccessful scenario for passing a
   * badly formatted string to the loadOneItem method. A DataFormatException is expected to be
   * thrown. (4) Unsuccessful scenario for trying to load an item with a valid representation to a
   * full vending machine. An IllegalStateException is expected to be thrown.
   * 
   * @return true if the test verifies a correct functionality and false if any bug is detected
   */
  public static boolean testLoadOneItem() {
    {
      ExceptionalVendingMachine vendingMachine = new ExceptionalVendingMachine(2);
      try {
        vendingMachine.loadOneItem("candy: 5");
        if (!vendingMachine.containsItem("candy")) {
          return false;
        }
      } 
      catch (Exception e) {
        e.printStackTrace();
        return false;
      }
    }
    {
      ExceptionalVendingMachine vendingMachine = new ExceptionalVendingMachine(2);
      try {
        vendingMachine.loadOneItem(" ");
        return false;
      }
      catch (IllegalArgumentException e) {}
      catch (Exception e) {
        e.printStackTrace();
        return false;
      }
    }
    return true; // default return statement added to resolve compiler errors
  }

  
  
  /**
   * Checks the correctness of the loadItems method
   * @return true if no bugs were detected and false otherwise
   */
//  public static boolean testLoadItems() {
//    ExceptionalVendingMachine vendingMachine = new ExceptionalVendingMachine(10);
//    File invalidFile = new File("invalidFile.txt");
//    try {
//      vendingMachine.loadItems(invalidFile);
//      System.out.println("invalid file");
//      return false;
//    }
//    catch (FileNotFoundException e) {}
//    File file = new File("vending.txt");
//    try {
//      if (vendingMachine.loadItems(file) != 4) {
//        System.out.println("incorrect newItems");
//        return false;
//      }
//    } 
//    catch (Exception e) {
//      e.printStackTrace();
//      return false;
//    }
//    try {
//      vendingMachine.loadItems(file);
//    }
//    catch (Exception e) {
//      e.printStackTrace();
//      return false;
//    }
//    return true; // no bug detected
//  }
  
  
  /**
   * Checks the correctness of the saveVendingMachineSummary method 
   * @return true if no bugs were detected and false otherwise
   */
  public static boolean testSaveVendingMachineSummary() {
    ExceptionalVendingMachine vendingMachine = new ExceptionalVendingMachine(10);
    File file = new File("vending.txt");
    try {
      vendingMachine.loadItems(file);
    }
    catch (Exception e) {
      e.printStackTrace();
      return false;
    }
    File emptyFile = new File("emptyFile.txt");
    vendingMachine.saveVendingMachineSummary(emptyFile);
    
    String summary = "";
    Scanner fileReader;
    try {
      fileReader = new Scanner(emptyFile);
    } catch (FileNotFoundException e1) {
      e1.printStackTrace();
      return false;
    }
    int newItems = 0;
    String data;
    while (fileReader.hasNextLine()) {
      try {
        data = fileReader.nextLine();
        summary += data + "\n";
      }
      catch (IllegalStateException e) {
        System.out.println("Vending Machine FULL");
      }
      catch (Exception e) {}
    }
    fileReader.close();
    String expectedOutput = vendingMachine.getItemsSummary();
    if (!summary.trim().equals(expectedOutput)) {
      return false;
    }
    return true; // no bug detected
  }
  
  /**
   * Invokes all the public tester methods implemented in this class
   * 
   * @return true if all testers pass with no errors, and false if any of the tester fails.
   */
  public static boolean runAllTests() {
    if (!testItemConstructorNotValidInput()) {
      System.out.println("testItemConstructorNotValidInput fail");
      return false;
    }
    if (!testItemConstructorGettersSetters()) {
      System.out.println("testItemConstructorGettersSetters fail");
      return false;
    }
    if (!testItemEquals()) {
      System.out.println("testItemEquals fail");
      return false;
    }
    if (!testExceptionalVendingMachineConstructor()) {
      System.out.println("testExceptionalVendingMachineConstructor fail");
      return false;
    }
    if (!testExceptionalVendingMachineAddContainsRemoveGetters()) {
      System.out.println("testExceptionalVendingMachineAddContainsRemoveGetters fail");
      return false;
    }
    if (!testEmptySizeFullExceptionalVendingMachine()) {
      System.out.println("testEmptySizeFullExceptionalVendingMachine fail");
      return false;
    }
    if (!testLoadOneItem()) {
      System.out.println("testLoadOneItem fail");
      return false;
    }
    return true; // default return statement added to resolve compiler errors
  }

  /**
   * Main method for the tester class
   * 
   * @param args list of input arguments if any
   */
  public static void main(String[] args) {
    System.out.println("Run all tests: " + runAllTests());
  }

}
