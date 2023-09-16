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
import java.io.IOException;
/**
 * This class represents a single song
 * @author Theo Luo
 */
public class Song {
  private String artist;
  private AudioUtility audioClip;
  private int duration;
  private String title;
  /**
   * Intializes all instance data fields according to the provided values
   * @param title the title of this song
   * @param artist the artist of this song
   * @param filepath the full relative path to the song file
   * @throws IllegalArgumentException if the song file cannot be read
   */
  public Song(String title, String artist, String filepath) throws IllegalArgumentException {
    if (title == null) this.title = "";
    else this.title = title;
    if (artist == null) this.artist = "";
    else this.artist = artist;
    try {
      audioClip = new AudioUtility(filepath);
    }
    catch (IOException e) {
      throw new IllegalArgumentException("Song file cannot be read.");
    }
    duration = audioClip.getClipLength();
  }
  /**
   * Accessor method for the song's title
   * @return the title of this song
   */
  public String getTitle() {
    return title;
  }
  /**
   * Uses the AudioUtility to start playback of this song, reopening the clip for playback if necessary
   */
  public void play() {
    if (!audioClip.isReadyToPlay()) {
      audioClip.reopenClip();
    }
    audioClip.startClip();
    System.out.println("Playing..." + this.toString());
  }
  /**
   * Uses the AudioUtility to stop playback of this song
   */
  public void stop() {
    audioClip.stopClip();
  }
  /**
   * Accessor method for the song's artist
   * @return the artist of this song
   */
  public String getArtist() {
    return artist;
  }
  /**
   * Tests whether this song is currently playing 
   * @return true if the song is playing, false otherwise
   */
  public boolean isPlaying() {
    return audioClip.isRunning();
  }
  
  /**
   * Creates and returns a string representation of this Song
   * @return a formatted string representation of this song
   */
  @Override
  public String toString() {
    int min = duration / 60;
    int sec = duration % 60;
    String secString = "";
    if (sec < 10) {
      secString = "0" + sec;
    }
    else {
      secString += sec;
    }
    return "\"" + title + "\"" + " (" + min + ":" + secString +") by " + artist;
  }
}
