import java.io.File;

//////////////// FILE HEADER //////////////////////////
//
// Title:    P08 Music Player
// Course:   CS 300 Fall 2022
//
// Author:   Theo Luo
// Email:    tluo53@wisc.edu
// Lecturer: Mouna Kacem
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    Bruno Inzunza
// Partner Email:   binzunza@wisc.edu
// Partner Lecturer's Name: Mouna Kacem
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   X Write-up states that pair programming is allowed for this assignment.
//   X We have both read and understand the course Pair Programming Policy.
//   X We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons:         None
// Online Sources:  None
//
///////////////////////////////////////////////////////////////////////////////
/**
 * This class tests the implementation of MusicPlayer methods
 * @author Theo Luo
 */
public class MusicPlayerTester {
  
  public static boolean testYourMom() {
    MusicPlayer300 homo = new MusicPlayer300();
    try {
      homo.loadOneSong("gay", "theo is", "audio/1.mid");
    }
    catch (Exception e) {
      
    }
    return false;
  }
  
  /**
   * Tests the constructor of the Song class
   * @return true if no bugs detected, false otherwise
   */
  public static boolean testSongConstructor() {
    // invalid file
    try {
      Song invalidSong = new Song("Otra Atardecer", "Bad Bunny", "0.mid");
      System.out.println("Song constructor did not catch IllegalArgumentException when file is invalid.");
      return true;
    }
    catch (Exception e) {}
    // valid file
    try {
      Song validSong = new Song("Ojitos Lindos", "Bad Bunny", "audio/1.mid");
      // test getters
      if (!validSong.getTitle().equals("Ojitos Lindos")) {
        System.out.println("Song: getTitle() error");
        return false;
      }
      if (!validSong.getArtist().equals("Bad Bunny")) {
        System.out.println("Song: getArtist() error");
        return false;
      }
      if (!validSong.toString().equals("\""+"Ojitos Lindos"+"\"" + " (0:6) by Bad Bunny")) { //TODO
        System.out.println(validSong.toString());
        System.out.println("Song: toString() error");
        return false;
      }
    }
    catch (IllegalArgumentException e) {
      System.out.println("Failed to construct song with a valid file.");
      return false;
    }
    catch (Exception e) {
      e.printStackTrace();
    }
    return true; // no bug detected
  }
  /**
   * Tests the implementatin of the methods in the Song class
   * @return true if no bugs detected, false otherwise
   */
  public static boolean testSongPlayback() {
    try {
      Song validSong = new Song("Ojitos Lindos", "Bad Bunny", "audio/1.mid");
      validSong.play();
      Thread.sleep(1000);
      if (!validSong.isPlaying()) {
        System.out.println("Song: not playing after play() is called");
        return false;
      }
      validSong.stop();
      if (validSong.isPlaying()) {
        System.out.println("Song: did not stop after stop() is called");
        return false;
      }
      return true;
    }
    catch (IllegalArgumentException | InterruptedException e) {
      System.out.println("Song: failed to construct audioClip");
      return false;
    }
  }
  /**
   * Tests the methods in the SongNode class
   * @return true if no bugs detected, false otherwise
   */
  public static boolean testSongNode() {
    Song one = new Song("1", "one", "audio/1.mid");
    Song two = new Song("2", "two", "audio/2.mid");
    Song three = new Song("3", "three", "audio/3.mid");
    
    try {
      SongNode list = new SongNode(one);
      SongNode list2 = new SongNode(two, list);
      
      if(!list.getSong().equals(one)) {
        System.out.println("1");
        return false;
      }
      
      if(!list2.getNext().equals(list)) {
        System.out.println("2");
        return false;
      }
      
      list.setNext(list2);
      if(!list.getNext().equals(list2)) {
        System.out.println("4");
        return false;
      }
    }
    catch(Exception e) {
      return false;
    }
    return true;
  } 
  /**
   * Tests the enqueue() method in the Playlist class
   * @return true if no bugs detected, false otherwise
   */
  public static boolean testEnqueue() {
    Song song1 = new Song("Ojitos Lindos", "Bad Bunny", "audio/1.mid");
    Song song2 = new Song("Un Ratito", "Bad Bunny", "audio/2.mid");
    Song song3 = new Song("Yo No Soy Celoso", "Bad Bunny", "audio/3.mid");
    Playlist playlist = new Playlist();
    playlist.enqueue(song1);
    if (playlist.size() != 1 || !playlist.peek().equals(song1)) {
      System.out.println("Playlist: enqueue()");
      return false;
    }
    playlist.enqueue(song2);
    if (playlist.size() != 2) {
      System.out.println("Playlist: enqueue()");
      return false;
    }
    playlist.enqueue(song3);
    if (playlist.size() != 3) {
      System.out.println("Playlist: enqueue()");
      return false;
    }
    if (!playlist.dequeue().equals(song1)) {
      System.out.println("Playlist: dequeue() 1");
      return false;
    }
    if (playlist.size() != 2 || !playlist.peek().equals(song2)) {
      System.out.println("Playlist: dequeue() 2");
      return false;
    }
    if (!playlist.dequeue().equals(song2)) {
      System.out.println("Playlist: dequeue() 3");
      return false;
    }
    if (playlist.size() != 1 || playlist.peek().equals(song1)) {
      System.out.println("Playlist: dequeue() 4");
      return false;
    }
    if (!playlist.dequeue().equals(song3)) {
      System.out.println("Playlist: dequeue() 5");
      return false;
    }
    if (!playlist.isEmpty()) {
      System.out.println(playlist.dequeue());
      System.out.println("Playlist: dequeue() empty");
      return false;
    }
    if (playlist.dequeue() != null) {
      System.out.println("Playlist: dequeue() return null");
      return false;
    }
    return true; // no bugs detected
  }
  /**
   * Tests the dequeue() method in the Playlist class
   * @return true if no bugs detected, false otherwise
   */
  public static boolean testDequeue() {
    Song song1 = new Song("Ojitos Lindos", "Bad Bunny", "audio/1.mid");
    Song song2 = new Song("Un Ratito", "Bad Bunny", "audio/2.mid");
    Song song3 = new Song("Yo No Soy Celoso", "Bad Bunny", "audio/3.mid");
    Playlist playlist = new Playlist();
    playlist.enqueue(song1);
    if (playlist.size() != 1 || !playlist.peek().equals(song1)) {
      return false;
    }
    playlist.enqueue(song2);
    if (playlist.size() != 2) {
      return false;
    }
    playlist.enqueue(song3);
    if (playlist.size() != 3) {
      return false;
    }
    if (!playlist.dequeue().equals(song1)) {
      return false;
    }
    if (playlist.size() != 2 || !playlist.peek().equals(song2)) {
      return false;
    }
    if (!playlist.dequeue().equals(song2)) {
      return false;
    }
    if (playlist.size() != 1 || playlist.peek().equals(song1)) {
      return false;
    }
    if (!playlist.dequeue().equals(song3)) {
      return false;
    }
    if (!playlist.isEmpty()) {
      return false;
    }
    if (playlist.dequeue() != null) {
      return false;
    }
    return true; // no bugs detected
  }
  

  public static void main(String[] args) {
    System.out.println("Song constructor: " + testSongConstructor());
    System.out.println("Song playback: " + testSongPlayback());
    System.out.println("Song node: " + testSongNode());
    System.out.println("Enqueue: " + testEnqueue());
    System.out.println(testYourMom());
  }
}
