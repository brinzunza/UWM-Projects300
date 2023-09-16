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



public class Chugimon implements Comparable<Chugimon>{//this class models the chugion data type
  private final int FIRST_ID;//first ID of chugimon
  private final double HEIGHT;//height of the Chugimon in meters
  static final int MAX_ID = 151;//maximum ID number
  static final int MIN_ID = 1;//minimum ID number
  private final String NAME;//name of the chugimon
  private final ChugiType PRIMARY_TYPE;//primary type of the chugimon; cannot be null; cannot be the same as secondary type
  private final int SECOND_ID;//the second ID of the chugimon
  private final ChugiType SECONDARY_TYPE;//the secondary type of the chugimon; may be null; cannot be the same as primary type
  private final double WEIGHT;//the weight of the chugimon in kilograms
  
  /**
   * Creates a new Chugimon with specific first and second IDs and initializes all its data fields accordingly.
   * @param firstID the first ID of the Chugimon, between 1-151
   * @param secondID the second ID of the Chugimon, between 1-151
   * @throws IllegalArgumentException  if the first and second ID are out of bounds or equal to each other.
   */
  public Chugimon(int firstID, int secondID) throws IllegalArgumentException{
    if(firstID == secondID || firstID > 151 || firstID < 1 || secondID > 151 || secondID < 1) {
      throw new IllegalArgumentException("firstID or secondID are not valid");
    }
    FIRST_ID = firstID;
    SECOND_ID = secondID;
    HEIGHT = ChugidexUtility.getChugimonHeight(firstID, secondID);
    NAME = ChugidexUtility.getChugimonName(firstID, secondID);
    PRIMARY_TYPE = ChugidexUtility.getChugimonTypes(firstID, secondID)[0];
    SECONDARY_TYPE = ChugidexUtility.getChugimonTypes(firstID, secondID)[1];
    WEIGHT = ChugidexUtility.getChugimonWeight(firstID, secondID);
  }
  
  /**
   * Gets the name of this Chugimon
   * @return the name of the Chugimon
   */
  public String getName() {
    return this.NAME;
  }
  
  /**
   * Gets the first ID of this Chugimon
   * @return the first ID of the Chugimon
   */
  public int getFirstID() {
    return this.FIRST_ID;
  }
  
  /**
   * Gets the second ID of thid Chugimon
   * @return the second ID of the Chugimon
   */
  public int getSecondID() {
    return this.SECOND_ID;
  }
  
  /**
   * Gets the primary type of this Chugimon
   * @return the primary type of the Chugimon
   */
  public ChugiType getPrimaryType() {
    return this.PRIMARY_TYPE;
  }
  
  /**
   * Gets the secondary type of this Chugimon
   * @return the secondary type of the Chugimon
   */
  public ChugiType getSecondaryType() {
    return this.SECONDARY_TYPE;
  }
  
  /**
   * Gets the height of this Chugimon
   * @return the height of the Chugimon
   */
  public double getHeight() {
    return this.HEIGHT;
  }
  
  /**
   * Gets the the weight of the Chugimon.
   * @return the weight of the Chugimon.
   */
  public double getWeight() {
    return this.WEIGHT;
  }
  
  /**
   * Determines the ordering of Chugimon
   * @param otherChugi  the other Chugimon to compare this Chugimon to.
   * @return a negative int if this Chugimon is less than other, a positive int if this Chugimon is greater than other, or 0 if this and the other Chugimon are equal.
   */
  @Override
  public int compareTo(Chugimon otherChugi) {
    int compare = this.getName().compareTo(otherChugi.getName());
    if(compare < 0) {
      return -1;
    }
    else if(compare > 0) {
      return 1;
    }
    else {
      if(this.getFirstID() < otherChugi.getFirstID()) {
        return -1;
      }
      else if(this.getFirstID() > otherChugi.getFirstID()) {
        return 1;
      }
      else {
        if(this.getSecondID() < otherChugi.getSecondID()) {
          return -1;
        }
        else if(this.getSecondID() > otherChugi.getSecondID()) {
          return 1;
        }
        else {
          return 0;
        }
      }
    }
  }
  
  /**
   * A Chugimon's String representation is its name followed by "#FIRST_ID.SECOND_ID" -- Example: "Zapchu#145.25"
   * @return a String representation of this Chugimon
   */
  @Override
  public String toString() {
    return NAME + "#" + FIRST_ID + "." + SECOND_ID;
  }
  
  /**
   * Equals method for Chugimon. This Chugimon equals another object if other is a Chugimon with the exact same name, and their both first and second IDs match.
   * @param other Object to determine equality against this Chugimon
   * @return true if this Chugimon and other Object are equal, false otherwise
   */
  @Override
  public boolean equals(Object other) {
    if(other instanceof Chugimon) {
      Chugimon temp = (Chugimon)other;
      if(this.getName().equals(temp.getName()) && this.getFirstID() == temp.getFirstID() && this.getSecondID() == temp.getSecondID()) {
        return true;
      }
    }
    return false;
  }
}
