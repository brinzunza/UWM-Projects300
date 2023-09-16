//////////////// FILE HEADER //////////////////////////
//
// Title:    Vending Machine Tester File
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
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH true STATEMENT:
//   _X_ Write-up states that pair programming is allowed for this assignment.
//   _X_ We have both read and understand the course Pair Programming Policy.
//   _X_ We have registered our team prior to the team registration deadline.
//
///////////////////////////////////////////////////////////////////////////////
//
// Persons: none
// Online Sources:  none
//
///////////////////////////////////////////////////////////////////////////////

import java.util.Arrays;

/**
 * Tests the functionality of the VendingMachine class so that all tests and scenarios may be completed flawlessly.
 * 
 * @author Bruno Inzunza
 * 
 */
public class VendingMachineTester {

/*
 * Checks the correctness of getIndexNextItem defined in the VendingMachine class.
 * 
 * @return returns true if the test verifies a correct functionality and false if any bug is detected
 * 
 */
  public static boolean testGetIndexNextItem() {
    // Test scenarios normal and edge cases
    // Recall that the VendingMachine.getNextItem method gets the next item to be dispensed given
    // its description without removing it.

    // 1. Next item to be dispensed is NOT found: the expected output is -1
    {
      // define the vending machine
      String[][] items =
          new String[][] {{"Water", "15"}, {"Chocolate", "10"}, {"Juice", "20"}, null, null, null};
      int itemsCount = 3;

      // check the correctness of the output
      if (VendingMachine.getIndexNextItem("candy", items, itemsCount) != -1) {
        System.out.println(
            "testGetIndexNextItem-scenario 1. Problem detected: Your getIndexNextItem did not return "
                + "-1 when no match found.");
        return false;
      }
      // Check that the method did not make change to the contents of the array items passed as
      // input
      String[][] originalItems =
          new String[][] {{"Water", "15"}, {"Chocolate", "10"}, {"Juice", "20"}, null, null, null};
      if (!Arrays.deepEquals(items, originalItems)) {
        System.out.println(
            "testGetIndexNextItem-scenario 1. Problem detected: Your getIndexNextItem did make "
                + "changes to the content of the array passed as input.");
        return false;
      }
    }

    // 2. Next item to be dispensed is at index 0
    {
      String[][] items = new String[][] {{"Water", "1"}, {"Chocolate", "10"}, {"Juice", "20"},
          {"Water", "5"}, {"Candy", "30"}, {"Water", "15"}, {"Chocolate", "10"}, null, null};
      int itemsCount = 7;

      // check the correctness of the output
      if (VendingMachine.getIndexNextItem("Water", items, itemsCount) != 0) {
        System.out.println(
            "testGetIndexNextItem-scenario 2. Problem detected: Your getIndexNextItem did not return "
                + "the expected output when the vending machines contains multiple matches with the "
                + "provided item description and the matching item with the soonest expiration date "
                + "is at index 0.");
        return false;
      }
      // Check that the method did not make change to the contents of the array items passed as
      // input
      String[][] originalItems =
          new String[][] {{"Water", "1"}, {"Chocolate", "10"}, {"Juice", "20"}, {"Water", "5"},
              {"Candy", "30"}, {"Water", "15"}, {"Chocolate", "10"}, null, null};
      if (!Arrays.deepEquals(items, originalItems)) {
        System.out.println(
            "testGetIndexNextItem-scenario 2. Problem detected: Your getIndexNextItem did make "
                + "changes to the content of the array passed as input.");
        return false;
      }
    }

    // 3. Next item to be dispensed is at the end of the array
    {
      String[][] items = new String[][] {{"Water", "15"}, {"Chocolate", "20"}, {"Juice", "20"},
          {"Water", "5"}, {"Candy", "30"}, {"Water", "15"}, {"Chocolate", "10"}, null, null};
      int itemsCount = 7;

      // check the correctness of the output
      if (VendingMachine.getIndexNextItem("Chocolate", items, itemsCount) != 6) {
        System.out.println(
            "testGetIndexNextItem-scenario 3. Problem detected: Your getIndexNextItem did not return "
                + "the expected output when the vending machines contains multiple matches with the "
                + "provided item description and the matching item with the soonest expiration date "
                + "is at the end of the array");
        return false;
      }
      // Check that the method did not make change to the contents of the array items passed as
      // input
      String[][] originalItems =
          new String[][] {{"Water", "15"}, {"Chocolate", "20"}, {"Juice", "20"}, {"Water", "5"},
              {"Candy", "30"}, {"Water", "15"}, {"Chocolate", "10"}, null, null};
      if (!Arrays.deepEquals(items, originalItems)) {
        System.out.println(
            "testGetIndexNextItem-scenario 3. Problem detected: Your getIndexNextItem did make "
                + "changes to the content of the array passed as input.");
        return false;
      }
    }

    // 4. Next item to be dispensed is at the middle of the array
    {
      String[][] items = new String[][] {{"Water", "15"}, {"Chocolate", "10"}, {"Juice", "20"},
          {"Water", "5"}, {"Candy", "30"}, {"Water", "15"}, {"Chocolate", "10"}, null, null};
      int itemsCount = 7;

      // check the correctness of the output
      if (VendingMachine.getIndexNextItem("Water", items, itemsCount) != 3) {
        System.out.println(
            "testGetIndexNextItem-scenario 4. Problem detected: Your getIndexNextItem did not return "
                + "the expected output when the vending machines contains matches with the provided "
                + "item description with different expiration dates.");
        return false;
      }
      // Check that the method did not make change to the contents of the array items passed as
      // input
      String[][] originalItems =
          new String[][] {{"Water", "15"}, {"Chocolate", "10"}, {"Juice", "20"}, {"Water", "5"},
              {"Candy", "30"}, {"Water", "15"}, {"Chocolate", "10"}, null, null};
      if (!Arrays.deepEquals(items, originalItems)) {
        System.out.println(
            "testGetIndexNextItem-scenario 4. Problem detected: Your getIndexNextItem did make "
                + "changes to the content of the array passed as input.");
        return false;
      }
    }

    return true; // No bug detected
  }

  /*
   * Checks the correctness of containsItem defined in the VendingMachine class.
   * 
   * @return returns true if the test verifies a correct functionality and false if any bug is detected
   */
  public static boolean testContainsItem() {
    // Define at least two test scenarios: (1) successful search returning true and (2) unsuccessful
    // search returning false.
	  
	  //defining the vending machine
	  String[][] originalItems =
	          new String[][] {{"Water", "15"}, {"Chocolate", "10"}, {"Juice", "20"}, {"Water", "5"},
	              {"Candy", "30"}, {"Water", "15"}, {"Chocolate", "10"}, null, null};
	  int itemsCount = 7;
	  
	  // Test 1: successful search 
	  if(VendingMachine.containsItem("Water", originalItems, itemsCount) == true) {
		  return true;
		  }
	  if((VendingMachine.containsItem("Water", originalItems, itemsCount) == true) == false) {

		  System.out.println("testContainsItem - scenario 1. Problem Detected: method was unable to successfully search and return true.");
		return false;
	  }
	  
	  //Test 2: unsuccessfully search 
	  if(VendingMachine.containsItem("Soda", originalItems, itemsCount) == false) {
		  return true;
	  }
  	else {
  			System.out.println("testContainsItem - scenario 2. Problem Detected: method was unable to unsuccessfully search and return false.");
  			return false;
  		}
	              
	              

    
  }
/*
 * Checks the correctness of getItemAtIndex defined in the VendingMachine class.
 * 
 * @return returns true if the test verifies a correct functionality and false if any bug is detected
 * 
 */
  
  public static boolean testGetItemAtIndex() {
    // Define at least two test scenarios: (1) the provided index is out of the range
    // 0..itemsCount-1, (2) the provided index is in bounds [0..itemsCount-1].
    // For each test scenario, ensure that the method returned the exact expected string output
    // without making any changes to the contents of the array.
	  
	  //setting up the vending machine
	  String[][] originalItems, items;
	          originalItems = new String[][] {{"Water", "15"}, {"Chocolate", "10"}, {"Juice", "20"}, {"Water", "5"}, {"Candy", "30"}, {"Water", "15"}, {"Chocolate", "10"}, null, null};
	          items = new String[][] {{"Water", "15"}, {"Chocolate", "10"}, {"Juice", "20"}, {"Water", "5"},{"Candy", "30"}, {"Water", "15"}, {"Chocolate", "10"}, null, null};
	  int itemsCount = 7;
	  
	  //test 1: provided index is out of range
	  if((VendingMachine.getItemAtIndex(100, originalItems, itemsCount).equals( "ERROR INVALID INDEX")) && Arrays.deepEquals(originalItems, items)) {
		  return true;
	  }
	  if(((VendingMachine.getItemAtIndex(100, originalItems, itemsCount).equals( "ERROR INVALID INDEX")) && Arrays.deepEquals(originalItems, items)) == false) {
		System.out.println("testGetItemAtIndex - scenario 1. Problem Detected: the provided index was out of range and did not return ERROR INVALID INDEX");
		return false;
	  }
	  
	  
		 //test 2: the provided index is in range
	  if(VendingMachine.getItemAtIndex(1, originalItems, itemsCount).equals("Chocolate 10") && Arrays.equals(originalItems, items)) {
		  return true;
	  }
	  else {
		System.out.println("testGetItemAtIndex - scenario 2. Problem Detected: the provided index is in bounds and did not return true.");
		return false;
	  }
	  
 // default return statement to let this incomplete code compiles with no errors.
  }

  /*
   * Checks the correctness of getItemOccurrences defined in the VendingMachine class.
   * 
   * @return returns true if the test verifies a correct functionality and false if any bug is detected
   * 
   */
  public static boolean testGetItemsOccurrences() {
    // Define at least two test scenarios: (1) no match found so that the method returns zero,
    // (2) the items array contains multiple occurrences of the provided item description.

    // For each test scenario, ensure that the method returned the expected output without making
    // any changes to the contents of the array.
	  
	//setting up the vending machine
	  String[][] originalItems, items;
	          originalItems = new String[][] {{"Water", "15"}, {"Chocolate", "10"}, {"Juice", "20"}, {"Water", "5"},
	              {"Candy", "30"}, {"Water", "15"}, {"Chocolate", "10"}, null, null};
	          items = new String[][] {{"Water", "15"}, {"Chocolate", "10"}, {"Juice", "20"}, {"Water", "5"},{"Candy", "30"}, {"Water", "15"}, {"Chocolate", "10"}, null, null};
	  int itemsCount = 7;
	  
	  //test 2: the items array contains multiple occurrences of the provided item description
	  if((VendingMachine.getItemOccurrences("Chocolate", originalItems, itemsCount) == 2) && Arrays.deepEquals(originalItems, items)) {
		  return true;
	  }
	  if(((VendingMachine.getItemOccurrences("Chocolate", originalItems, itemsCount) == 2) && Arrays.deepEquals(originalItems, items)) == false) {

		  System.out.println("testGetItemsOccurrences - scenario 2. Problem Detected: the items array contains multiple occurrences of the provided item description.");
		  return false;
	  }
	  
	  //test 1: no match found so that the method returns zero
	  if((VendingMachine.getItemOccurrences("Granola", originalItems, itemsCount) == 0) && Arrays.deepEquals(originalItems, items)) {
		  return true;
	  }
	  else {
		System.out.println("testGetItemsOccurrences - scenario 1. Problem Detected: no match found so that the method returns zero.");
		return false;  
	  }
 // default return statement to let this incomplete code compiles with no errors.
  }

  /*
   * Checks the correctness of addItem defined in the VendingMachine class.
   * 
   * @return returns true if the test verifies a correct functionality and false if any bug is detected
   */
  public static boolean testAddItem() {
    // Define at least three test scenarios: (1) adding a new item to an empty vending machine whose
    // size is zero (provided itemsCount == 0), (2) adding a new item to a non-empty non-full
    // vending machine, and (3) adding a new item to a full vending machine where the provided
    // itemsCount equals the length of the provided items array.

    // For each tester scenario, check for the expected returned size of the vending machine and
    // the expected content of the items array after the method call returns.
	//setting up the vending machine
	  String[][] originalItems, items;
	          originalItems = new String[][] {null, null};
	          items = new String[][] {{"Soda", "100"}, null};
	  int itemsCount = 0;
	  //test 1: adding a new item to an empty vending machine whose size is zero
	  if(VendingMachine.addItem("Soda", "100", originalItems, itemsCount) == 1) {
		  if(Arrays.deepEquals(originalItems, items)) {
			  return true;
		  }
	  }
	  if(VendingMachine.addItem("Soda", "100", originalItems, itemsCount) == 1) { 
			  if((Arrays.deepEquals(originalItems, items)) == false) {		
		  		System.out.println("testAddItem - scenario 1. Problem Detected: adding a new item to an empty vending machine whose size is zero");
		  		return false;
	  }
	  }
	  
	  
	//setting up the vending machine
	          originalItems = new String[][] {{"Water", "15"}, {"Chocolate", "10"}, null, null};
	          items = new String[][] {{"Water", "15"}, {"Chocolate", "10"}, {"Soda", "100"}, null, null};
	  itemsCount = 2;
	  //test 2: adding a new item to a non-empty non-full vending machine
	  if((VendingMachine.addItem("Soda", "100", originalItems, itemsCount) == 3) && Arrays.deepEquals(originalItems, items)) {
		return true;  
	  }
	  if(((VendingMachine.addItem("Soda", "100", originalItems, itemsCount) == 3) && Arrays.deepEquals(originalItems, items)) == false) {
		System.out.println("testAddItem - scenario 2. Problem Detected: adding a new item to a non-empty non-full vending machine");
		return false;
	  }
	  
	  
	//setting up the vending machine
	          originalItems = new String[][] {{"Water", "15"}, {"Chocolate", "10"}, {"Juice", "20"}, {"Water", "5"},
	              {"Candy", "30"}, {"Water", "15"}, {"Chocolate", "10"}};
	          items = new String[][] {{"Water", "15"}, {"Chocolate", "10"}, {"Juice", "20"}, {"Water", "5"},{"Candy", "30"}, {"Water", "15"}, {"Chocolate", "10"}};
	  itemsCount = 7;
	  //scenario 3: adding a new item to a full vending machine where the provided itemsCount equals the length of the provided items array
	  if((VendingMachine.addItem("Soda", "100", originalItems, itemsCount) == 4) && Arrays.deepEquals(originalItems, items)) {
		return true;  
	  }
	  else {
		System.out.println("testAddItem - scenario 3. Problem Detected: adding a new item to a full vending machine where the provided itemsCount equals the length of the provided items array");
		return false;
	  }
 // default return statement to let this incomplete code compiles with no errors.
  }

  /*
   * Checks the correctness of removeNextItem defined in the VendingMachine class.
   * 
   * @return returns true if the test verifies a correct functionality and false if any bug is detected
   */
  public static boolean testRemoveNextItem() {
    // Define at least four test scenarios: (1) trying to remove a non-existing item from a vending
    // machine (the vending machine can be empty or not), (2) the next item to be removed matching
    // the provided description is at index 0 of the array, (3) the next item to be removed is at
    // index itemsCount of the array (at the end of the array), and (4) the next item to be removed
    // is at a middle index of the provided items array.

    // For each tester scenario, check for the expected returned size of the vending machine and
    // the expected content of the items array after the method call returns.
	  
	//setting up the vending machine
	  String[][] originalItems, items;
	          originalItems = new String[][] {{"Water", "15"}, {"Chocolate", "10"}, {"Juice", "20"}, {"Water", "5"}, {"Candy", "30"}, {"Water", "15"}, {"Chocolate", "10"}};
	          items = new String[][] {{"Water", "15"}, {"Chocolate", "10"}, {"Juice", "20"}, {"Water", "5"},{"Candy", "30"}, {"Water", "15"}, {"Chocolate", "10"}};
	  int itemsCount = 7;
	  
	  //test 1: trying to remove a non-existing item from a vending machine
	  if((VendingMachine.removeNextItem("Soda", originalItems, itemsCount) == 7) && Arrays.deepEquals(originalItems, items)) {
		return true;  
	  }
	  if(((VendingMachine.removeNextItem("Soda", originalItems, itemsCount) == 7) && Arrays.deepEquals(originalItems, items)) == false) {

		  System.out.println("testRemoveNextItem - scenario 1. Problem Detected: trying to remove a non-existing item from a vending machine");
		return false;  
	  }
	  
	//setting up the vending machine
	 originalItems = new String[][] {{"Water", "15"}, {"Chocolate", "10"}, {"Juice", "20"}, {"Water", "5"}, {"Candy", "30"}, {"Water", "15"}, {"Chocolate", "10"}};
	          items = new String[][] {{"Chocolate", "10"}, {"Juice", "20"}, {"Water", "5"},{"Candy", "30"}, {"Water", "15"}, {"Chocolate", "10"}};
	  itemsCount = 7;
	  
	  //test 2: the next item to be removed matching the provided description is at index 0 of the array
	  if((VendingMachine.removeNextItem("Water", originalItems, itemsCount) == 6) && Arrays.deepEquals(originalItems, items)) {
		return true;  
	  }
	  if(((VendingMachine.removeNextItem("Water", originalItems, itemsCount) == 6) && Arrays.deepEquals(originalItems, items)) == false) {

		  System.out.println("testRemoveNextItem - scenario 2. Problem Detected: the next item to be removed matching the provided description is at index 0 of the array ");
		return false;  
	  }
	  
	//setting up the vending machine
	          originalItems = new String[][] {{"Water", "15"}, {"Chocolate", "10"}, {"Juice", "20"}, {"Water", "5"},
	              {"Candy", "30"}, {"Water", "15"}, {"Chocolate", "10"}};
	          items = new String[][] {{"Water", "15"}, {"Chocolate", "10"}, {"Juice", "20"}, {"Water", "5"},{"Candy", "30"}, {"Water", "15"}};
	  itemsCount = 7;
	  
	  //test 3: the next item to be removed is at index itemsCount of the array
	  if((VendingMachine.removeNextItem("Chocolate", originalItems, itemsCount) == 6) && Arrays.deepEquals(originalItems, items)) {
		return true;  
	  }
	  if(((VendingMachine.removeNextItem("Chocolate", originalItems, itemsCount) == 6) && Arrays.deepEquals(originalItems, items)) == false) {

		  System.out.println("testRemoveNextItem - scenario 3. Problem Detected: the next item to be removed is at index itemsCount of the array");
		return false;  
	  }
	  
	//setting up the vending machine
	          originalItems = new String[][] {{"Water", "15"}, {"Chocolate", "10"}, {"Juice", "20"}, {"Water", "5"}, {"Candy", "30"}, {"Water", "15"}, {"Chocolate", "10"}};
	          items = new String[][] {{"Water", "15"}, {"Chocolate", "10"}, {"Juice", "20"}, {"Water", "5"}, {"Water", "15"}, {"Chocolate", "10"}};
	  itemsCount = 7;
	  
	  //test 4: the next item to be removed is at a middle index of the provided items array
	  if((VendingMachine.removeNextItem("Candy", originalItems, itemsCount) == 6) && Arrays.deepEquals(originalItems, items)) {
		return true;  
	  }
	  else {
		  System.out.println("testRemoveNextItem - scenario 4. Problem Detected: the next item to be removed is at a middle index of the provided items array");
		return false;  
	  }
	  
 // default return statement to let this incomplete code compiles with no errors.
  }

  /*
   * Checks the correctness of getItemsSummary defined in the VendingMachine class.
   * 
   * @return returns true if the test verifies a correct functionality and false if any bug is detected
   */
  public static boolean testGetItemsSummary() {
    // Define at least three scenarios: (1) the vending machine is empty, (2) the vending machine
    // contains non duplicate items (no multiple items with the same description), (3) the vending
    // machine contains multiple items with the same description at various index locations.
	  
	  //setting up the vending machine
	  String[][] items = new String[][] {null, null};
	  int itemsCount = 0;
	  //test 1: the vending machine is empty
	  if(VendingMachine.getItemsSummary(items, itemsCount).equals("null")) {
		return true;  
	  }
	  if((VendingMachine.getItemsSummary(items, itemsCount).equals("null")) == false) {

		System.out.println("testGetItemsSummary - scenario 1. Problem Detected: the vending machine is empty");
		return false;
	  }
	  
	//setting up the vending machine
	  String[][] items1 = new String[][] {{"Water", "15"}, {"Chocolate", "10"}, {"Juice", "20"}};
	  itemsCount = 3;
	  //test 2: the vending machine contains non duplicate items (no multiple items with the same description)
	  if(VendingMachine.getItemsSummary(items1, itemsCount).equals("Water 1\nChocolate 1\nJuice 1")) {
			return true;  
		  }
	  if((VendingMachine.getItemsSummary(items1, itemsCount).equals("Water 1\nChocolate 1\nJuice 1")) == false) {

			System.out.println("testGetItemsSummary - scenario 2. Problem Detected: the vending machine contains non duplicate items (no multiple items with the same description");
			return false;
		  }
	  
	//setting up the vending machine
	  items = new String[][] {{"Water", "15"}, {"Chocolate", "10"}, {"Juice", "20"}, {"Water", "5"}, {"Water", "15"}, {"Chocolate", "10"}};
	  itemsCount = 7;
	  
	//test 3: the vending machine contains multiple items with the same description at various index locations
	  if(VendingMachine.getItemsSummary(items, itemsCount).equals("Water 3\nChocolate 2\nJuice 1")) {
			return true;  
		  }
		  else {
			System.out.println("testGetItemsSummary - scenario 3. Problem Detected: the vending machine contains multiple items with the same description at various index locations");
			return false;
		  }
 // default return statement to let this incomplete code compiles with no errors.
  }

  // This method returns false if any of the tester methods defined in this class fails, and true
  // if no bug detected.
  public static boolean runAllTests() {
	  if(VendingMachineTester.testGetIndexNextItem() && VendingMachineTester.testContainsItem() && VendingMachineTester.testGetItemAtIndex() && VendingMachineTester.testGetItemsOccurrences() && VendingMachineTester.testAddItem() && VendingMachineTester.testRemoveNextItem() && VendingMachineTester.testGetItemsSummary() == true) {
		return true;  
	  }
	System.out.println("Problem Detected: runAllTests");
    return false; // default return statement to let this incomplete code compiles with no errors.
  }

  // main method to call the tester methods defined in this class
  public static void main(String[] args) {
    System.out.println("testGetIndexNextItem(): " + testGetIndexNextItem());
    System.out.println("runAllTests(): " + runAllTests());
  }

}
