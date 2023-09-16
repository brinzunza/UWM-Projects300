
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

public class Item {
  private String description;
  private int expirationDate;
  
/**
 * creates a new Item Object readable description of this item
 * @param description
 * @param expirationDate
 * @throws IllegalArgumentException
 */
  public Item(String description, int expirationDate) throws IllegalArgumentException {
    if(description == null || expirationDate <= 0 || description.trim().isBlank()) {
      throw new IllegalArgumentException("Input Error: Constructor could not make a new object");
    }
    this.description = description;
    this.expirationDate = expirationDate;
  }
  
  /**
   * Gets the description of this item
   * @return the description of this item
   */
  public String getDescription() {
    return(this.description);
  }
  
  /**
   * changes the description of this item
   * @param description
   * @throws IllegalArgumentException
   */
  public void setDescription(String description) throws IllegalArgumentException {
    if(description == null || description.trim().isBlank()) {
      throw new IllegalArgumentException("Input Exception: description could not be changed");
    }
    this.description = description;
  }
  
  /**
   * gets the expiration date of this item
   * @return the expiration date of this item
   */
  public int getExpirationDate() {
    return(this.expirationDate);
  }
  
  /**
   * returns a string representation of this item formatted as "description:expirationDate"
   * @return a string representation of this item
   */
  @Override
  public String toString() {
    return(getDescription() + ": " + getExpirationDate());
  }
  
  /**
   * checks whether this item equals another object passed as input
   * 
   * @return true if other is instance of Item and has the same description as this item, false otherwise
   */
  @Override
  public boolean equals(Object object) {
    if(object instanceof Item) {
      Item otherItem = (Item)object;
      if (otherItem.description.equals(this.description)) {
        return true;
      }
    }
    return false;
  }
}
