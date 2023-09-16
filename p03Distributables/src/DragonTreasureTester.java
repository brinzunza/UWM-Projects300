//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Indiana Jones v Dragon Adventure
// Course:   CS 300 Fall 2022
//
// Author:   Bruno Inzunza
// Email:    binzunza@wisc.edu
// Lecturer: Mouna Kacem
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    none
// Partner Email:   none
// Partner Lecturer's Name: none
// 
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   ___ Write-up states that pair programming is allowed for this assignment.
//   ___ We have both read and understand the course Pair Programming Policy.
//   ___ We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons:         none
// Online Sources:  none
//
///////////////////////////////////////////////////////////////////////////////
import java.util.ArrayList;


public class DragonTreasureTester {
  
/*
 * Checks the correctness of all instance methods including the constructor for the Room class (8 total)
 * 
 * @returns true or false depending on if all the instance methods pass the tests
 */
public static boolean testRoomInstanceMethods() {
  try {
  Room test = new Room(5, "This is a normal room");
  if(test.getID() == 5 && test.getRoomDescription().equals("This is a normal room") && test.getType().equals(RoomType.NORMAL) && test.getAdjacentRooms().size() == 0) {

    Room test2 = new Room(6, "This is another normal room");
    Room test3 = new Room(8, "This should be a portal room");
    test.addToAdjacentRooms(test2);
    test3.setRoomType(RoomType.PORTAL);
    
    if(test.isAdjacent(test2) && test3.getType().equals(RoomType.PORTAL)) {
      return true;
    }
  }
  return false;
  }
  catch(NullPointerException e){
    return false;
  }
}

/*
 * Checks the correctness of all static methods for the Room class (4 total)
 * 
 * @return returns true if static methods methods pass the tests and false otherwise
 */
public static boolean testRoomStaticMethods() {
  Room.assignTeleportLocation(10);
  if(Room.getTeleportationRoom() == 10 && Room.getPortalWarning().equals("You feel a distortion in space nearby.\n") && Room.getTreasureWarning().equals("You sense that there is treasure nearby.\n")) {
    return true;
  }
  return false;
}

/*
 * This method checks for the correctness of the canMoveTo() method
 * 
 * @return returns true if player can move to a room and false otherwise
 */
public static boolean testPlayerCanMoveTo() {
  Room test = new Room(1, "This is a normal room");
  Room test2 = new Room(2, "This is another normal room");
  Room test3 = new Room(3, "This should be a portal room");
  test2.addToAdjacentRooms(test3);
  test2.addToAdjacentRooms(test);
  
  Room test4 = new Room(4, "This is a normal room");
  Room test5 = new Room(5, "This is another normal room");
  
  Player you = new Player(test2);
  Player you2 = new Player(test4);
  if(you.canMoveTo(test3) && you2.canMoveTo(test5) == false) {
    return true;
  }
  else {
    return false;
  }
}

/*
 * This method checks for the correctness of the shouldTeleport() method
 * 
 * @return returns true if shouldTeleport method works and false otherwise
 */
public static boolean testPlayerShouldTeleport() {
  Room wrong = new Room(1, "This should be a normal room");
  Room right = new Room(2, "This should be a portal room");
  Player testwrong = new Player(wrong);
  Player testright = new Player(right);
  
  if(testwrong.shouldTeleport() == false && testright.shouldTeleport() ==  true) {
    return true;
  }
  else {
    return false;
  }
}

/*
 * This method checks for the correctness of both the isPortalNearby() and isTreasureNearby() methods
 * 
 * @return true if both isPortalNearby and isTreasureNearby methods work and false otherwise
 */
public static boolean testPlayerDetectNearbyRooms() {
  Room port = new Room(1, "This should be a portal room");
  Room treas = new Room(2, "This should be a treasure room");
  Room right = new Room(4, "This is a normal room near treausre and portal");
  Room norm = new Room(3, "This should be a normal room");
  treas.setRoomType(RoomType.TREASURE);
  port.setRoomType(RoomType.PORTAL);
  right.addToAdjacentRooms(port);
  right.addToAdjacentRooms(treas);
  Player testwrong = new Player(norm);
  Player testright = new Player(right);
  
  if(testwrong.isPortalNearby() == false && testwrong.isTreasureNearby() == false && testright.isPortalNearby() && testright.isTreasureNearby()) {
    return true;
  }
  else {
    return false;
  }
}

/*
 * This method checks the correctness of the changeRooms() method
 * 
 * @return true if the dragon's room correctly changes and false otherwise
 */
public static boolean testDragonChangeRooms() {
  Room test1 = new Room(1, "This should be the normal room where dragon starts");
  Room test2 = new Room(2, "This should be a normal room");
  Room test3 = new Room(3, "This should be a portal room");
  
  test1.addToAdjacentRooms(test2);
  test1.addToAdjacentRooms(test3);
  
  Dragon drag = new Dragon(test1);
  
  drag.changeRoom();
  
  if(drag.getCurrentRoom().equals(test2)) {
    return true;
  }
  else {
    return false;
  }
}
}
