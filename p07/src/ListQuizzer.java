//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    (descriptive title of the program making use of this file)
// Course:   CS 300 Fall 2022
//
// Author:   (your name)
// Email:    (your @wisc.edu email address)
// Lecturer: (Mouna Kacem, Hobbes LeGault, or Jeff Nyhoff)
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    (name of your pair programming partner)
// Partner Email:   (email address of your programming partner)
// Partner Lecturer's Name: (name of your partner's lecturer)
// 
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   ___ Write-up states that pair programming is allowed for this assignment.
//   ___ We have both read and understand the course Pair Programming Policy.
//   ___ We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons:         (identify each by name and describe how they helped)
// Online Sources:  (identify each by URL and describe how it helped)
//
///////////////////////////////////////////////////////////////////////////////
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Arrays;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ListQuizzer {//This class models an iterable singly-linked list data structure which stores elements of type MultipleChoiceQuestion.

  private LinkedNode<MultipleChoiceQuestion> head; //head of this singly linked list
  private ListingMode listingMode; //The listing mode of this list quizzer which defines which questions are going to be listed while iterating through this list
  private int size; //Total number of MultipleChoiceQuestions stored in this ListQuizzer
  private LinkedNode<MultipleChoiceQuestion> tail; //Tail of this singly linked list
  
  /**
   * this constructor creates a new empty instance of ListQuizzer which contains zero elements and sets its listing mode to be ListingMode.ALL by default.
   */
  public ListQuizzer() {
    listingMode = ListingMode.ALL;
    head = null;
    tail = null;
    size = 0;
  }
  
  /**
   * Checks whether this list is empty
   * @return true if this list is empty and false otherwise
   */
  public boolean isEmpty() {
    if(head == null && tail == null) {
      return true;
    }
    else {
      return false;
    }
  }
  
  /**
   * Gets the size of this list
   * @return the size of this list
   */
  public int size() {
    return this.size;
  }
  
  /**
   * Sets the listing mode of this list to the one provided as input
   * @param listingMode listing mode to set
   */
  public void switchMode(ListingMode listingMode) {
    this.listingMode = listingMode;
  }
  
  /**
   * Adds a specific MultipleChoiceQuestion to a given position of this list
   * @param index position index where to add the newQuestion to this list
   * @param question some MultipleChoiceQuestion to add to this list
   * @throws NullPointerException - with a descriptive error message if newQuestion is null
   * @throws IndexOutOfBoundsException - with a descriptive error message if index is OUT of the range 0 .. size() inclusive
   */
  public void add(int index, MultipleChoiceQuestion question) throws NullPointerException, IndexOutOfBoundsException{
    
  }
  
  /**
   * Adds a specific MutlipleChoiceQuestion to the head of this list
   * @param question some MultipleChoiceQuestion to add to the head of this list
   * @throws NullPointerException with a descriptive error message if newQuestion is null
   */
  public void addFirst(MultipleChoiceQuestion question) throws NullPointerException{
    
  }
  
  /**
   * Adds a specific MutlipleChoiceQuestion to the tail of this list
   * @param question some MultipleChoiceQuestion to add to the tail of this list
   * @throws NullPointerException  with a descriptive error message if newQuestion is null
   */
  public void addLast(MultipleChoiceQuestion question) throws NullPointerException{
    
  }
  
  /*
   * This method removes all the question from this list
   */
  public void clear() {
    
  }
}
