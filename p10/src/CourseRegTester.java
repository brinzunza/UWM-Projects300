import java.util.NoSuchElementException;

//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    University Course Selector Program
// Course:   CS 300 Fall 2022
//
// Author:   Bruno Inzunza
// Email:    binzunza@wisc.edu
// Lecturer: Mouna Kacem
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

/**
 * This class implements unit test methods to check the correctness of Course,  CourseIterator, 
 * CourseQueue and CourseReg classes in P10.
 * 
 * Be aware that all methods in this class will be run against not only your code, but also our own
 * working and broken implementations to verify that your tests are working appropriately!
 */
public class CourseRegTester {
  
  /**
   * START HERE, and continue with testCompareTo() after this.
   * 
   * This method must test the Course constructor, accessor, and mutator methods, as well as its
   * toString() implementation. The compareTo() method will get its own test.
   * 
   * @see Course
   * @return true if the Course implementation is correct; false otherwise
   */
  public static boolean testCourse() {
   
      Course one = new Course("CS", 300, 3, 11);
      Course two = new Course("MATH", 200, 3, 10);
    try {
      Course one1 = new Course("", 300, 3, 11);
      return false;
    }
    catch(Exception e) {
      
    }
    if(one.getNumCredits() != 3) {
      return false;
    }
    if(one.equals(one) != true) {
      return false;
    }
    if(!(one.toString().equals("CS 300 (11 seats)"))) {
      return false;
    }
    one.setProfessor("Hobbes", 4);
    try {
      two.setProfessor(null, -1);
    }
    catch(Exception e) {
      return false;
    }
    if(!(one.toString().equals("CS 300 (11 seats) with Hobbes (4.0)"))) {
      return false;
    }
    one.setSeatsAvailable(5);
    if(!(one.toString().equals("CS 300 (5 seats) with Hobbes (4.0)"))) {
      return false;
    }
    return true;
  }
  
  /**
   * This method must test the Course compareTo() implementation. Be sure to test ALL FOUR levels
   * of the comparison here!
   * 
   * Once you complete this test, finish the Course implementation if you have not done so already,
   * then move to testCourseQueue() and testEnqueueDequeue().
   * 
   * @see Course#compareTo(Course)
   * @return true if the compareTo() implementation is correct; false otherwise
   */
  public static boolean testCompareTo() {
    Course one = new Course("CS", 300, 3, 10);
    Course two = new Course("MATH", 200, 4, 1);
    Course three = new Course("CS", 400, 3, 0);
    Course four = new Course("CS", 300, 4, 1);
    four.setProfessor("Bob", 3);
    Course five = new Course("CS", 300, 3, 1);
    five.setProfessor("Bob", 5);
    
    if(one.compareTo(two) != 1) {
      return false;
    }
    if(one.compareTo(three) != 1) {
      return false;
    }
    if(one.compareTo(four) != -1) {
      return false;
    }
    if(four.compareTo(five) != -1) {
      return false;
    }
    if(one.compareTo(one) != 0) {
      return false;
    }
    return true; 
  }
  
  /**
   * This method must test the other methods in CourseQueue (isEmpty, size, peek). Verify normal 
   * cases and error cases, as well as a filled and re-emptied queue.
   * 
   * Once you have completed this method, implement the required methods in CourseQueue and verify
   * that they work correctly.
   * 
   * @see CourseQueue
   * @return true if CourseQueue's other methods are implemented correctly; false otherwise
   */
  public static boolean testCourseQueue() {
    try {
      CourseQueue one = new CourseQueue(5);
      if (one.isEmpty() != true) {
        return false;
      }
      Course two = new Course("CS", 300, 3, 5);
      try {
        one.enqueue(two);
      } catch (NullPointerException e) {
        return false;
      }
      
      if (one.isEmpty() == true) {
        return false;
      }
      Course three = new Course("CS", 300, 3, 0);
      try {
        one.enqueue(three);
      } catch (NullPointerException e) {
        return false;
      }
      
      if (one.size() != 2) {
        return false;
      }
      if (one.peek() != two) {
        return false;
      }
      
      one.dequeue();
      if (one.size() != 1) {
        return false;
      }
      one.dequeue();
      if (one.isEmpty() != true) {
        return false;
      }
    } catch (Exception e) {
      return false;
    }

    return true;
  }
  
  /**
   * This method must test the enqueue and dequeue methods in CourseQueue. Verify normal cases and
   * error cases, as well as filling and emptying the queue.
   * 
   * You may also test the percolate methods directly, though this is not required.
   * 
   * Once you have completed this method, implement the enqueue/dequeue and percolate methods in
   * CourseQueue and verify that they work correctly, then move on to testCourseIterator().
   * 
   * @see CourseQueue#enqueue(Course)
   * @see CourseQueue#dequeue()
   * @return true if the CourseQueue enqueue/dequeue implementations are correct; false otherwise
   */
  public static boolean testEnqueueDequeue() {
    try {
      CourseQueue courseOne = new CourseQueue(4);
      Course one = new Course("CS", 350, 3, 0);
      Course two = new Course("MATH", 300, 3, 0);
      Course three = new Course("CS", 300, 3, 2);
      Course four = new Course("CS", 300, 3, 4);
      Course five = new Course("CS", 300, 3, 4);
      CourseQueue courseTwo = new CourseQueue(4);
      Course one1 = new Course("CS", 351, 3, 0);
      Course one2 = new Course("CS", 350, 3, 0);
      one2.setProfessor("jeff", 3.3);
      Course one3 = new Course("MATH", 300, 3, 0);
      Course one4 = new Course("CS", 300, 3, 4);
      courseTwo.enqueue(one4);
      courseTwo.enqueue(one1); 
      courseTwo.enqueue(one2); 
      courseTwo.enqueue(one3);
      courseTwo.dequeue();  
      if (courseTwo.peek() != one2) {
        return false;
      }
      courseOne.enqueue(one);
      if (courseOne.peek() != one && courseOne.size() != 1) {
        return false;
      }
      courseOne.enqueue(two);
      if (courseOne.peek() != one) {
        return false;
      }
      courseOne.enqueue(three);
      courseOne.enqueue(four);
      try {
        courseOne.enqueue(five);
        return false;
      } catch (IllegalStateException e) {
      }
      if (courseOne.peek() != three && courseOne.size() != 4) {
        return false;
      }
      courseOne.dequeue();
      if (courseOne.peek() != one && courseOne.size() != 3) {
        return false;
      }
      courseOne.dequeue();
      if (courseOne.peek() != two && courseOne.size() != 2) {
        return false;
      }
      courseOne.dequeue();
      courseOne.dequeue();
      if (courseOne.size() != 0) {
        return false;
      }
      try {
        courseOne.peek();
        return false;
      } catch (NoSuchElementException e) {
      }
      return true;
    } catch (Exception e) {
      return false;
  }
  }
  
  /**
   * This method must test the CourseIterator class. The CourseIterator iterates through a deep copy
   * of a CourseQueue in decreasing order of priority, returning each Course object in turn.
   * 
   * Once you have completed this method, implement the CourseIterator class and make CourseQueue
   * into an Iterable class. Verify that this works correctly, and then move on to the final test
   * method: testCourseReg().
   * 
   * @see CourseIterator
   * @return true if the CourseIterator implementation is correct; false otherwise
   */
  public static boolean testCourseIterator() {
    try {
      CourseQueue courseTwo = new CourseQueue(4);
      Course one1 = new Course("CS", 351, 3, 0);
      Course one2 = new Course("CS", 350, 3, 0); 
      one2.setProfessor("jeff", 3.3);
      Course one3 = new Course("MATH", 300, 3, 0);
      Course one4 = new Course("CS", 300, 3, 4);
      try {
        courseTwo.iterator().next();
      }
      catch (NoSuchElementException e) {}
      catch (Exception e) {
        return false;
      }
      courseTwo.enqueue(one1);
      courseTwo.enqueue(one2);
      courseTwo.enqueue(one3);
      courseTwo.enqueue(one4);
      CourseIterator twoIterator = new CourseIterator(courseTwo);
      if (!(twoIterator.next().equals(one4))) {
        return false;
      }
      if (!(twoIterator.next().equals(one2))) {
        return false;
      }
      twoIterator.next();
      twoIterator.next();
      try {
        twoIterator.next();
        return false;
      } catch (Exception e) {
      }
    } catch (Exception e) {
      return false;
    } 
    return true;
  }
  
  /**
   * This method must test the constructor and three methods of the CourseReg class (setCreditLoad,
   * add, and getRecommendedCourses). Verify normal cases and error cases.
   * 
   * Once you have completed this method, implement CourseReg and verify that it works correctly.
   * Then you're DONE! Save and submit to gradescope, and enjoy being DONE with programming
   * assignments in CS 300 !!!
   * 
   * @see CourseReg
   * @return true if CourseReg has been implemented correctly; false otherwise
   */
  public static boolean testCourseReg() {
    try {
      Course one = new Course("CS", 300, 3, 3);
      Course two = new Course("MATH", 300, 1, 3);
      Course three = new Course("CS", 302, 3, 3);
      Course four = new Course("CS", 303, 3, 5);
      try {
        CourseReg test = new CourseReg(-1, 5);
        return false;
      } catch (IllegalArgumentException e) {
      }
      try {
        CourseReg test = new CourseReg(5, -1);
        return false;
      } catch (IllegalArgumentException e) {
      }
      try {
        CourseReg test = new CourseReg(5, 5);
      } catch (Exception e) {
        return false;
      }
      CourseReg test = new CourseReg(3, 30);
      if (test.add(null)) {
        return false;
      }
      test.add(one);
      test.add(two);
      test.add(three);
      if (test.add(four)) {
        return false;
      }
      one.setProfessor("jeff", 4.4);
      CourseReg test1 = new CourseReg(3, 5);
      if (test1.add(null)) {
        return false;
      }
      test1.add(one);
      if (!test1.add(two)) {
        return false;
      }
      if (!test1.add(three)) {
        return false;
      }
      if (test1.add(four)) {
        return false;
      }
      if (!test1.getRecommendedCourses().trim().equals(one.toString())) {
        return false;
      }
      if (test1.getRecommendedCourses().trim().equals(two.toString())) {
        return false;
      }
      return true;
    } catch (Exception e) {
      return false;
    } 
  }
  
  /**
   * This method calls all test methods defined by us; you may add additional methods to this if
   * you like. All test methods must be public static boolean.
   * 
   * @return true if all tests in this class return true; false otherwise
   */
  public static boolean runAllTests() {
    boolean testVal = true;
    
    // test Course
    System.out.print("testCourse(): ");
    if (!testCourse()) {
      System.out.println("FAIL");
      testVal = false;
    } else { System.out.println("pass"); }
    
    // test compareTo
    System.out.print("testCompareTo(): ");
    if (!testCompareTo()) {
      System.out.println("FAIL");
      testVal = false;
    } else { System.out.println("pass"); }
    
    // test CourseIterator
    System.out.print("testCourseIterator(): ");
    if (!testCourseIterator()) {
      System.out.println("FAIL");
      testVal = false;
    } else { System.out.println("pass"); }
    
    // test CourseQueue enqueue/dequeue
    System.out.print("testEnqueueDequeue(): ");
    if (!testEnqueueDequeue()) {
      System.out.println("FAIL");
      testVal = false;
    } else { System.out.println("pass"); }
    
    // test CourseQueue
    System.out.print("testCourseQueue(): ");
    if (!testCourseQueue()) {
      System.out.println("FAIL");
      testVal = false;
    } else { System.out.println("pass"); }
    
    // test CourseReg
    System.out.print("testCourseReg(): ");
    if (!testCourseReg()) {
      System.out.println("FAIL");
      testVal = false;
    } else { System.out.println("pass"); }
    
    return testVal;
  }
  
  /**
   * Calls runAllTests() so you can verify your program
   * 
   * @param args input arguments if any.
   */
  public static void main(String[] args) {
    runAllTests();
  }
}
