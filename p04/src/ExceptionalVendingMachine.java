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
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.zip.DataFormatException;
import java.util.Scanner;
import java.io.FileOutputStream;

// Add import statement to relevant exceptions and FilePrinter or FileWriter
import java.util.NoSuchElementException;
import java.util.zip.DataFormatException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;



/**
 * This class models a vending machine. When requested, the item with the soonest expiration date
 * will be dispensed first.
 *
 */
public class ExceptionalVendingMachine {
  private Item[] items; // array storing the items available within this vending machine
  private int size; // number of items available in this vending machine

  /**
   * Creates a new vending machine with a given capacity
   * 
   * @param capacity maximum number of items that can be held by this vending machine
   * @throws IllegalArgumentException with a descriptive error message if capacity is zero or
   *                                  negative
   */
  public ExceptionalVendingMachine(int capacity) throws IllegalArgumentException {
    // TODO complete the implementation of this method with respect to the details of its javadoc
    // comments
    if(capacity <= 0) {
      throw new IllegalArgumentException("Input Error: contructor could not make a new object");
    }

    items = new Item[capacity];
    size = 0; // optional since 0 is the default value for primitive type int
  }

  /**
   * Checks whether this vending machine is empty
   * 
   * @return true if this vending machine is empty, false otherwise
   */
  public boolean isEmpty() {
    // TODO implement this method
    if(this.size <= 0) {
      return true;
    }
    return false; // default return statement. Feel free to change it
  }

  /**
   * Checks whether this vending machine is full
   * 
   * @return true if this vending machine is full, false otherwise
   */
  public boolean isFull() {
    if (this.size == this.items.length) {
      return true;
    }
    return false;
  }

  /**
   * Returns the total number of items available in this vending machine
   * 
   * @return the size of this vending machine
   */
  public int size() {
    // TODO implement this method
    return this.size; // default return statement. Feel free to change it
  }

  /**
   * Appends an item defined by its description and expirationDate to this vending machine. The item
   * will be added to the end of the vending machine.
   * 
   * @param description    description of the item to be added to the vending machine
   * @param expirationDate a positive integer which represents the expiration date of the item.
   * @throws IllegalStateException    with a descriptive error message if the vending machine is
   *                                  full
   * @throws IllegalArgumentException with a descriptive error message if description is null or
   *                                  blank or if expirationDate is negative ( &lt; 0)
   */
  public void addItem(String description, int expirationDate) throws IllegalStateException{
    // TODO complete the implementation of this method with respect to its above specification
    if(description.trim().isBlank() || description == null || expirationDate < 0) {
      throw new IllegalStateException("Input error: the item was unable to be added to the vending machine");
    }
    if(this.isFull()) {
      throw new IllegalStateException("Vending machine is already full");
    }
    // create a new item and add it to the end of this vending machine
    items[size] = new Item(description, expirationDate);
    size++;
  }


  /**
   * Returns without removing the string representation of the item at the given index within the
   * vending machine
   * 
   * @param index index of an item within the vending machine
   * @return the string representation of the item stored at the given index within the vending
   *         machine defined by items and itemsCount. The returned string must have the following
   *         format: "description: expirationDate".
   * @throws IndexOutOfBoundsException with a descriptive error message if index &lt; 0 or index
   *                                   &gt;= size of the vending machine
   */
  public String getItemAtIndex(int index) throws IndexOutOfBoundsException {
    // TODO complete the implementation of this method with respect to its above specification
    if(index > items.length) {
      throw new IndexOutOfBoundsException("Could not get item: index was not in bounds of vernding machine");
    }
    return items[index].toString();
  }

  /**
   * Returns the number of occurrences of items with a given description within this vending machine
   * 
   * @param description description (name) of an item
   * @return the number of occurrences of items with a given description within the vending machine
   * @throws IllegalArgumentException with a descriptive error message if description is null or
   *                                  blank
   */
  public int getItemOccurrences(String description) throws IllegalArgumentException {
    // TODO: Complete the implementation of this method with respect to the above details
      if(description == null|| description.trim().isBlank()) {
        throw new IllegalArgumentException("Description was null or blank so occurrences not calculated");
      }
    int count = 0;
    for (int i = 0; i < size; i++) {
      if (description.equals(items[i].getDescription())) {
        count++;
      }
    }
    return count;
  }

  /**
   * Checks whether the vending machine contains at least one item with the provided description
   * 
   * @param description description (name) of an item to search
   * @return true if there is a match with description in the vending machine, false otherwise
   * @throws IllegalArgumentException with a descriptive error message if description is null or
   *                                  blank
   */
  public boolean containsItem(String description) throws IllegalArgumentException {
    // TODO: Complete the implementation of this method with respect to the above details
    if(description == null || description.trim().isBlank()) {
      throw new IllegalArgumentException("Input error: could not check if it contains item blank or null");
    }
    
    return getItemOccurrences(description) != 0;
  }

  /**
   * Returns the number of items in the vending machine with a specific description and whose
   * expiration dates are greater or equal to a specific expiration date
   * 
   * @param description    description of the item to find its number of occurrences
   * @param expirationDate specific (earliest) expiration date
   * @return the number of items with a specific description and whose expiration date is greater or
   *         equal to the given one
   * @throws IllegalArgumentException with a descriptive error message if expirationDate is negative
   *                                  (less than zero) or description is null or blank
   */
  public int getItemOccurrencesByExpirationDate(String description, int expirationDate) throws IllegalArgumentException {
    // TODO: Complete the implementation of this method with respect to the above details

    if(description == null || description.trim().isBlank() || expirationDate < 0) {
      throw new IllegalArgumentException("Input error: the number of occurrences by expiratoin date could not be found");
    }

    
    int nbOccurrences = 0; // number of occurrences of the matching items
    // traverse the vending machine looking for matching items
    for (int i = 0; i < size; i++) {
      if (description.equals(items[i].getDescription())
          && items[i].getExpirationDate() >= expirationDate) {// match found
        nbOccurrences++;
      }
    }
    // return the number of occurrences of the matching items
    return nbOccurrences;
  }

  /**
   * Returns without removing the index of the item having the provided description and the smallest
   * expiration date within the vending machine.
   * 
   * @param description description of an item
   * @return the index of the next item, meaning the item with the given description and the
   *         smallest expiration date.
   * @throws IllegalArgumentException with a descriptive error message if description is null or
   *                                  blank
   * @throws NoSuchElementException   with a descriptive error message if no match found
   */
  public int getIndexNextItem(String description) throws IllegalArgumentException, NoSuchElementException{
    // TODO complete the implementation of this method with respect to the details provided above

    if(description == null || description.trim().isBlank()) {
      throw new IllegalArgumentException("Input error: could not get next item index");
    }
    
    int index = -1; // index of the search item
    int minExpirationDate = -1; // smallest expiration date of matching items

    // traverse the vending machine looking for the matching item with the smallest expiration date
    for (int i = 0; i < size; i++) {
      if (description.equals(items[i].getDescription())) {
        int itemExpirationDate = items[i].getExpirationDate();
        if (index == -1) { // first match found
          minExpirationDate = items[i].getExpirationDate();
          index = i;
        } else { // another match found
          if (itemExpirationDate < minExpirationDate) {
            // match with smaller (sooner) expiration date found
            minExpirationDate = itemExpirationDate; // update minimum expiration date
            index = i; // update the index of the next item
          }
        }
      }
    }
    if(index == -1) {
      throw new NoSuchElementException("Input error: vending machine does not have such description and could not find next item");
    }

    return index; // return the index of the item with the given description and the smallest
                  // expiration date if found
  }


  /**
   * Removes and returns the item having the provided description with the smallest expiration date
   * within the vending machine. This method should maintain the order of precedence of items in the
   * vending machine. This means that the remove operation involves a shift operation.
   * 
   * @param description description of the item to remove or dispense
   * @return The removed or dispensed item if it is available
   * @throws IllegalArgumentException with a descriptive error message if description is null or
   *                                  blank
   * @throws NoSuchElementException   with a descriptive error message if no match found
   * 
   */
  public Item removeNextItem(String description) throws IllegalArgumentException, NoSuchElementException{
    // get the index of the next item to dispense by this vending machine
    if(description == null || description.trim().isBlank()) {
      throw new IllegalArgumentException("Input error: could not removeNextItem");
    }
    if (!this.containsItem(description)) {
      throw new NoSuchElementException("Input error: no such element exists");
    }
    
    int index = getIndexNextItem(description); // exceptions throws by this method call should
                                               // propagate

    // save a copy of the item to dispense
    Item itemToDispense = items[index];

    // remove the item at index using a shift operation
    for (int i = index + 1; i < size; i++) {
      items[i - 1] = items[i];
    }
    items[size - 1] = null;
    size--;

    return itemToDispense; // return the removed item
  }

  /**
   * Returns a summary of the contents of this vending machine in the following format: Each line
   * contains the description or item name followed by one the number of occurrences of the item
   * name in the vending machine between parentheses. For instance, if the vending machine contains
   * five bottles of water, ten chocolates, and seven snacks, the summary description will be as
   * follows. water (5)\n chocolate (10)\n snack (7) If the vending machine is empty, this method
   * returns an empty string ""
   * 
   * @return a descriptive summary of the contents of the vending machine
   */
  public String getItemsSummary() {
    String summary = ""; // empty string

    // traverse the vending machine and build its items summary description
    for (int i = 0; i < size; i++) {
      // add the item's description and count if not yet processed
      if (!summary.contains(items[i].getDescription())) {
        summary = summary + items[i].getDescription() + " ("
            + getItemOccurrences(items[i].getDescription()) + ")\n";
      }
    }
    return summary.trim(); // return the items' summary
  }

  // TODO Implement the methods loadOneItem, loadItems, and saveItems
  

  /**
   * Helper method that sees if a String is parsable to a positive integer
   * @param input: the String to be checked
   * @return true if the String is parsable to a positive integer and false otherwise
   */
  private boolean containsNum(String input) {
    try {
      int intParsed = Integer.parseInt(input.trim());
      if (intParsed >= 0) {
        return true;
      }
      else {
        return false;
      }
    }
    catch (NumberFormatException e) {
      return false;
    }
  }


  /**
   * Parse an item's string representation and add the corresponding item to this vending machine
   * 
   * @param itemRepresentation a String representation of an item formatted as "description:
   *                           expirationDate". Extra spaces at the beginning and end of the item
   *                           description and expirationDate can be disregarded.
   * @throws IllegalArgumentException with a descriptive error message if itemRepresentation is null
   *                                  or blank
   * @throws DataFormatException      with a descriptive error message if the provided string is not
   *                                  correctly formatted. A correct format of the
   *                                  itemRepresentation is "description: expirationDate". The
   *                                  description must be a NOT blank string. The expirationDate
   *                                  must be a non-empty string parsable to a positive integer. The
   *                                  item's description and its expiration date must be separated
   *                                  by one colon ":". Extra whitespace at the beginning and end of
   *                                  description or expirationDate should be disregarded.
   * @throws IllegalStateException    with a descriptive error message if the vending machine is
   *                                  full
   */
  
  public void loadOneItem(String itemRepresentation) throws IllegalArgumentException, DataFormatException, IllegalStateException {
    if (itemRepresentation == null || itemRepresentation.trim().isBlank()) {
      throw new IllegalArgumentException("Fail: description is null or blank");
    }
    if (!itemRepresentation.contains(":")) {
      throw new DataFormatException("itemRepresentation must be a string with a colon");
    }
    String[] elems = itemRepresentation.trim().split(":", 2);
    if (elems[0].isBlank() || elems[1].isBlank()) {
      throw new DataFormatException("itemDescription must contain description and expdate");
    }
    if (!containsNum(elems[1])) {
      throw new DataFormatException("Expdate must be a string that can be converted to int");
    }
    if (this.isFull()) {
      throw new IllegalStateException("The vending machine is already full, cannot load oneItem");
    }
    int expirationDate = Integer.parseInt(elems[1].trim());
    this.addItem(elems[0].trim(), expirationDate);
  }
//  public void loadOneItem(String itemRepresentation) throws IllegalArgumentException, DataFormatException, IllegalStateException {
//    // TODO Complete the implementation of this method with respect to the details provided above
//    // TODO Add throws declarations to the method signature as required
//    if (itemRepresentation == null || itemRepresentation.trim().isBlank()) {
//      throw new IllegalArgumentException("Description must not be null or blank.");
//    }
//    if(this.isFull()) {
//      throw new IllegalStateException("Full vending error: the vending machine is already full");
//    }
//    String[] elems = itemRepresentation.trim().split(":", 2);
//    if (elems[0].isBlank() || elems[1].isBlank()) {
//      throw new DataFormatException("Description and expirationDate canot be blank or empty strings.");
//    }
//    if (!containsNum(elems[1])) {
//      throw new DataFormatException("The expirationDate must be a non-empty string parsable to a positive integer.");
//    }
//    
//    String description;
//    String expDate;
//    itemRepresentation.trim();
//    
//    String[] split = itemRepresentation.split(":");
//    description = split[0];
//    expDate = split[1];
//    addItem(description, Integer.parseInt(expDate));
    

    // [HINT] Use String.split() and String.trim() methods to help parsing the itemRepresentation
    // This method MUST call addItem(String, int) to try adding the parsed item to the vending
    // machine

    // This is a complex method. Try to decompose it into steps. We highly recommend breaking its
    // functionality down the way that you see fits using private helper methods.

  


  /**
   * Reads and parses the file passed as input line by line and loads the corresponding items to the
   * vending machine. Each line in the file represents an item description formatted as
   * "description: expirationDate". Blank and badly formatted lines must be skipped.
   * 
   * Displays "Vending machine FULL. No more items can be loaded." when trying to load a new item to
   * the vending machine if it is or becomes full.
   * 
   * @param file file to load items from
   * @return the total number of new items loaded to this vending machine
   * @throws FileNotFoundException if the file object does not correspond to an actual file within
   *                               the file system.
   */
  public int loadItems(File file) throws FileNotFoundException {
    if (!file.exists() || !file.canRead()) {
      throw new FileNotFoundException("File can not be found or read");
    }
    Scanner fileReader = new Scanner(file);
    int newItems = 0;
    String data;
    while (fileReader.hasNextLine()) {
      try {
        data = fileReader.nextLine();
        this.loadOneItem(data);
        newItems++;
      }
      catch (IllegalStateException e) {
        System.out.println("Vending machine is already full");
      }
      catch (Exception e) {}
    }
    try {
      newItems += 0;
    }
    finally {
      if (fileReader != null) {
        fileReader.close();
      }
    }
    return newItems;
  }
    
    
    
    // TODO Add throws declarations to the method signature as required


    
    // Create and use a java.util.Scanner object to open and read the file
    // This method MUST call the loadOneItem(String) method to operate while parsing each line

    // Notice carefully that this method does not throw any exception if the vending machine is full
    // or becomes full while trying to lead an item.

  /**
   * Saves the summary of this vending machine to the file object passed as input
   * 
   * @param file file object where the vending machine summary will be saved
   */
  public void saveVendingMachineSummary(File file) {
    // TODO Complete the implementation of this method with respect to the details provided above

    // You can use either a java.io.PrintWriter or a java.io.FileWriter to write into the file

    // This method MUST call the getItemsSummary() to get the summary of this vending machine to be
    // saved to the file

    // This method MUST NOT throw any exception
    FileOutputStream fileOutStream;
    PrintWriter fwrite = null;
    
    try {      
      // Open output file
      fileOutStream = new FileOutputStream(file);
      fwrite = new PrintWriter(fileOutStream);
      
      fwrite.println(this.getItemsSummary());
      
    }
    catch (FileNotFoundException e) {
      System.out.println("Failed to open file");
    }
    catch (Exception e) {
      e.printStackTrace();
    }
    finally {
      if (fwrite != null) {
        fwrite.close();
      }
    }

  }

}
