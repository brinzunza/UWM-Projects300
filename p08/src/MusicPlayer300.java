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
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 * This class represnts a linked-queue based music player
 * @author Theo Luo
 */
public class MusicPlayer300 {
  private String filterArtist;
  private boolean filterPlay;
  private Playlist playlist;
  /**
   * Creates a new MusicPlayer300 with an empty playlist
   */
  public MusicPlayer300() {
    filterArtist = null;
    filterPlay = false;
    playlist = new Playlist();
  }
  /**
   * Stops any song that is playing and clears out the playlist
   */
  public void clear() {
    while (!playlist.isEmpty()) {
      if (playlist.peek().isPlaying()) {
        playlist.peek().stop();
      }
      playlist.dequeue();
    }
  }
  /**
   * Stops playback of the current song (if one is playing) and advances to the next song in the playlist
   * @throws IllegalStateException if the playlist is null or empty, or becomes empty at any time during this method
   */
  public void playNextSong() throws IllegalStateException {
    
    if (playlist == null || playlist.isEmpty()) {
      throw new IllegalStateException("Playlist is null or empty.");
    }
    
    if (playlist.peek().isPlaying()) {
      playlist.peek().stop();
    }
    
    if(filterPlay == true) {
      while(!playlist.peek().getArtist().equals(filterArtist)) {
        playlist.dequeue();
        if (playlist.isEmpty() || playlist == null) {
          throw new IllegalStateException("Playlist is empty.");
        }
        System.out.println(playlist.peek());
        
      }
    }
    if(filterPlay == false){
      playlist.dequeue();
      if (playlist.isEmpty() || playlist == null) {
        throw new IllegalStateException("Playlist is empty.");
      }
    }
    playlist.peek().play();
  }
  /**
   * Loads a single song to the end of the playlist given the title, artist, and filepath
   * @param title the title of the song
   * @param artist the artist of the song
   * @param filepath the full relative path to the song file
   * @throws FilelNotFoundException if the song file cannot be read
   */
  public void loadOneSong(String title, String artist, String filepath) throws FileNotFoundException {
    Song song = new Song(title, artist, filepath);
    playlist.enqueue(song);
  }
  /**
   * Loads a playlist from a provided file
   * @param file the File object to load
   * @throws FileNotFoundException if the playlist file cannot be loaded
   */
  public void loadPlaylist(File file) throws FileNotFoundException {
    //TODO
    if (!file.exists() || !file.canRead()) {
      throw new FileNotFoundException("The file object does not correspond to an actual file within the file system.");
    }
    Scanner fileReader = new Scanner(file);
    int numSongs = 0;
    String data;
    while (fileReader.hasNextLine()) {
        data = fileReader.nextLine();
        String[] line = data.split(",");
        try {
          System.out.println("Loading");
          loadOneSong(line[0], line[1], line[2]);
          numSongs++;
        }
        catch (Exception e){
          System.out.println("X");
        }
    }
    fileReader.close();
  }
  
  /**
   * Provides a string representation of all songs in the current playlist
   * @return a string representation of all songs in the current playlist
   */
  public String printPlaylist() {
    return playlist.toString();
  }
  
  /**
   * Creates and returns the menu of options for the interactive console program.
   * @return the formatted menu String
   */
  public String getMenu() {
    return("Enter one of the following options:\n"
        + "[A <filename>] to enqueue a new song file to the end of this playlist\n"
        + "[F <filename>] to load a new playlist from the given file\n"
        + "[L] to list all songs in the current playlist\n"
        + "[P] to start playing ALL songs in the playlist from the beginning\n"
        + "[P -t <Title>] to play all songs in the playlist starting from <Title>\n"
        + "[P -a <Artist>] to start playing only the songs in the playlist by Artist\n"
        + "[N] to play the next song\n"
        + "[Q] to stop playing music and quit the program");
        
  }
  
  /**
   * Interactive method to display the MusicPlayer300 menu and get keyboard input from the user.
   * @param in
   */
  public void runMusicPlayer300(Scanner in) {
    while(true) {
    System.out.println(getMenu());
    System.out.print(">");
    Scanner input = new Scanner(System.in);
    String stringInput = input.nextLine();
    String[] parts = stringInput.split(" ");
    File file = new File(parts[1]);
    if(parts[0] == "A") {
      System.out.println("Please enter title and artist (title,artist,filepath)");
      String input2 = input.nextLine();
      String[] titleartist = input2.split(",");
      playlist.enqueue(new Song(titleartist[0], titleartist[1], titleartist[2]));
    }
    if(parts[0] == "F") {
      try {
      loadPlaylist(file);
      }
      catch (Exception e) {
        
      }
    }
    if(parts[0] == "L") {
      this.printPlaylist();
    }
    if(parts[0] == "P") {
      if(parts[1] == "-t") {
        while(!playlist.peek().getTitle().equals(parts[2])) {
          playlist.dequeue();
        }
        playlist.peek().play();
      }
      if(parts[1] == "-a") {
        filterPlay = true;
        filterArtist = parts[2];
        while(!playlist.peek().getArtist().equals(filterArtist)) {
          playlist.dequeue();
        }
      }
      playlist.dequeue().play();
    }
    if(parts[0] == "N") {
      this.playNextSong();
    }
    if(parts[0] == "Q") {
      clear();
      System.out.println("Goodbye!");
      break;
    }
    else {
      System.out.println("I don't know how to do that");
    }
    input.close();
  }
  }
  
}
