//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Dragon Adventure 2.0
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
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
import processing.core.PApplet ;
import processing.core.PImage;

public class DragonTreasureGame extends PApplet{
  
  private ArrayList<Room> roomList;
  private File roomInfo;
  private File mapInfo;
  private ArrayList<Character> characters;
  private boolean isDragonTurn = false;
  private int gameState = 0;
  
  private void loadCharacters() {
    System.out.println("Adding characters...");
    characters.add(new Character(getRoomByID(5),"KEYHOLDER"));
    characters.add(new Player(getRoomByID(1)));
    characters.add(new Dragon(getRoomByID(9)));
    }
  
  public static void main(String[] args) {
    PApplet.main("DragonTreasureGame");
}
  
  
  
  
  @Override
  public void settings() {
    size(800,600);
  }
  
  @Override
  public void setup() {

    this.getSurface().setTitle("Dragon Treasure Adventure"); // sets the title of the window
    this.imageMode(PApplet.CORNER); //Images are drawn using the x,y-coordinate
    //as the top-left corner
    this.rectMode(PApplet.CORNERS); //When drawing rectangles interprets args
    //as top-left corner and bottom-right corner respectively
    this.focused = true; // window will be active upon running program
    this.textAlign(CENTER); // sets the text alignment to center
    this.textSize(20); //sets the font size for the text
    roomList = new ArrayList<Room>();
    characters = new ArrayList<Character>();
    
    
    
    
    
    PImage portalB = loadImage("C:\\Users\\Bruno\\eclipse-workspace\\p05\\images\\portal.png");
    PortalRoom.setPortalImage(portalB);
    
    PImage treasureB = loadImage("C:\\Users\\Bruno\\eclipse-workspace\\p05\\images\\treasure.jpg");
    TreasureRoom.setTreasureBackground(treasureB);
    
    roomInfo = new File("roominfo.txt");
    loadRoomInfo();
    
    mapInfo = new File("map.txt");
    loadMap();
    loadCharacters();

    Room.setProcessing(this);
    
    
    
    
    
//    PImage temp = this.loadImage("C:\\Users\\Bruno\\eclipse-workspace\\p05\\images\\treasure.jpg");
//    Room add = new Room(1, "This is a test room", temp);
//    //roomList.add(add);
//    
//    StartRoom teststartroom = new StartRoom(2, temp);
//    //roomList.add(teststartroom);
//    
//    TreasureRoom.setTreasureBackground(temp);
//    TreasureRoom testtreasroom = new TreasureRoom(3);
//    //roomList.add(testtreasroom);
//    
//    PImage temp2 = this.loadImage("C:\\Users\\Bruno\\eclipse-workspace\\p05\\images\\portal.png");
//
//    PortalRoom.setPortalImage(temp2);
//    PortalRoom testporroom = new PortalRoom(4, PortalRoom.getPortalWarning(), temp);
//    //roomList.add(testporroom);
//    File tempfile = new File("C:\\Users\\Bruno\\eclipse-workspace\\p05\\roominfo.txt");
//    roomInfo = tempfile;
//    
//    File tempfile2 = new File("C:\\Users\\Bruno\\eclipse-workspace\\p05\\map.txt");
//    mapInfo = tempfile2;
    
    
    

  }
  
  @Override
  public void keyPressed() {
    Player player = (Player)characters.get(1);
    if(gameState == 0) {
      if(player.canMoveTo(getRoomByID(Integer.parseInt(String.valueOf(key))))) {
        player.changeRoom(getRoomByID(Integer.parseInt(String.valueOf(key))));
        isDragonTurn = true;
      }
      else {
        System.out.println("You must enter a valid room");
      }
    }
  }
  
  
  public void draw() {
    if(isDragonTurn == true) {
      Dragon drag = (Dragon)characters.get(2);
      Room tempRoom = drag.pickRoom();
      while(!drag.canMoveTo(tempRoom)) {
        tempRoom = drag.pickRoom();
      }
 //     System.out.println("Dragon moved to " + tempRoom.getID());
      drag.changeRoom(tempRoom);
      isDragonTurn = false;
    }
    if(isDragonTurn == false) {
    Player temp; 
    for(int i = 0; i < characters.size(); i++) {
      if(characters.get(i).getLabel().equals("PLAYER")) {
        temp = (Player)characters.get(i);
        characters.get(i).getCurrentRoom().draw();
        for(int j = 0; j < characters.get(i).getAdjacentRooms().size(); j++) {
          
          if(characters.get(i).getCurrentRoom().getAdjacentRooms().get(j) instanceof PortalRoom) {
            System.out.println(PortalRoom.getPortalWarning());
          }
          
          if(characters.get(i).getCurrentRoom().getAdjacentRooms().get(j) instanceof TreasureRoom) {
            System.out.println(TreasureRoom.getTreasureWarning());
          }
          
        }
        Player tempPlayer = (Player)characters.get(i);
        if(characters.get(i).getCurrentRoom() instanceof PortalRoom) {
          tempPlayer.teleport();
          System.out.println(PortalRoom.getTeleportMessage());
        }
        
        
        for(int k = 0; k < characters.size(); k++) {
          if(characters.get(k).getLabel().equals("DRAGON")) {
            if(characters.get(i).getCurrentRoom().equals(characters.get(k).getCurrentRoom())) {
              System.out.println(Dragon.getDragonWarning());
            }
            if(characters.get(i).getCurrentRoom().equals(characters.get(k).getCurrentRoom())) {
              System.out.println(Dragon.getDragonEncounter());
              System.out.println("YOU HAVE LOST!");
              gameState = 2;
            }
          }
        }
        
          if(characters.get(i).getCurrentRoom().getID() == 5) {
            temp.obtainKey();
            System.out.println("KEY OBTAINED");
        }
        if(characters.get(i).getCurrentRoom() instanceof TreasureRoom) {
          TreasureRoom tempTRoom = (TreasureRoom)characters.get(i).getCurrentRoom();
          Player tempPlayer2 = (Player)characters.get(i);
          for(int b = 0; b < roomList.size(); b++) {
            if(tempTRoom.playerCanGrabTreasure(tempPlayer2)) {
              gameState = 1; 
              System.out.println("YOU HAVE WON!");
            }
          }
        }
      }
    }
    
  }
  
  }
  
  /** Loads in room info using the file stored in roomInfo
   *  @author Michelle 
   */
  private void loadRoomInfo() {
    System.out.println("Loading rooms...");
    Scanner fileReader = null;
    try {
      
      //scanner to read from file
      fileReader= new Scanner(roomInfo);
      
      //read line by line until none left
      while(fileReader.hasNext()) {
        String nextLine = fileReader.nextLine();
        
        //parse info and create new room 
        String[] parts = nextLine.split(" \\| ");
        int ID = Integer.parseInt(parts[1].trim()); //get the room id
        String imageName = null;
        String description = null;
        PImage image = null;
        Room newRoom = null;
        
        if(parts.length >= 3) {
          imageName = parts[2].trim();
          image = this.loadImage("images" + File.separator + imageName);
         
        }
        
        if(parts.length == 4) {
          description = parts[3].trim(); //get the room description
        }
   
        switch(parts[0].trim()) {
          case "S":
            newRoom = new StartRoom(ID, image);
            break;
          case "R":
            newRoom = new Room(ID, description, image);
            break;
          case "P":
            newRoom = new PortalRoom(ID, description, image);
            break;
          case "T":
            newRoom = new TreasureRoom(ID);
            break;
          default:
            break;
        }  
        
        if(newRoom != null) {
          roomList.add(newRoom);
        }
      }
    }catch(IOException e) { //handle checked exception
      e.printStackTrace();
    }finally {
      if(fileReader != null)
        fileReader.close(); //close scanner regardless of what happened for security reasons :)
    }
  }
  
  /** Loads in room connections using the file stored in mapInfo
   *  @author Michelle 
   */
  private void loadMap() {
    System.out.println("Loading map...");
    Scanner fileReader = null;
    try {
          //scanner to read from file
          fileReader= new Scanner(mapInfo);
          
        //read line by line until none left
          while(fileReader.hasNext()) {
            
            //parse info
            String nextLine = fileReader.nextLine();
            String parts[] = nextLine.split(" ");
            int id = Integer.parseInt(parts[0]);
            
            Room toEdit = getRoomByID(id); //get the room we need to update info for adjacent rooms
            
            //add all the rooms to the adj room list of toEdit
            for(int i=1; i<parts.length; i++) {
              Room toAdjAdd = getRoomByID(Integer.parseInt(parts[i]));
              toEdit.addToAdjacentRooms(toAdjAdd);
            }
          }
        }catch(IOException e) { //handle checked exception
          e.printStackTrace();
        }finally {    //close scanner regardless of what happened for security reasons :)
          if(fileReader != null)
            fileReader.close();
        }
  }
  
  /**
   * Get the room objected associated with the given ID.
   * @param id the ID of the room to retrieve
   * @return the Room that corresponds to that id
   * @author Michelle
   */
  private Room getRoomByID(int id){
    int indexToEdit = roomList.indexOf(new Room(id,"dummy", null));
    Room toEdit = roomList.get(indexToEdit); 
    return toEdit;
  }
  
  
}
