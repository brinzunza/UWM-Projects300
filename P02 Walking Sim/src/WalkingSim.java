
//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Visual Simulation of a walking character
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

import java.util.Random;
import java.io.File;
import processing.core.PImage;

public class WalkingSim {
	private static Random randGen;
	
	private static int bgColor;
	
//	private static PImage frame;
	
	private static PImage[] frames;
	
	private static Walker[] walkers;
	
	//Walker name = new Walker(randGen.nextFloat(Utility.width()), randGen.nextFloat(Utility.height()));
      
    
	
	

	public static void main(String args[]){
	  Utility.runApplication(); // starts the application
	}
	
	
	
	
	public static void setup() {
		randGen = new Random();
		bgColor = randGen.nextInt();
//		frame = Utility.loadImage("images" + File.separator + "walk-0.png");
		frames = new PImage[Walker.NUM_FRAMES];
		for(int i = 0; i < frames.length; i++) {
		  frames[i] = Utility.loadImage("images" + File.separator + "walk-" + i + ".png");
		}		
		walkers = new Walker[8];
		walkers[0] = new Walker();
		for(int i = 0; i < randGen.nextInt(1, walkers.length + 1); i++) {
		  walkers[i] = new Walker(randGen.nextInt(0, 800), randGen.nextInt(0, 600));
		}
	}
	public static void draw() {
	  Utility.background(bgColor);
	  for(int i = 0; i < walkers.length; i++) {
	    if(walkers[i] != null) {
	      Utility.image(frames[walkers[i].getCurrentFrame()], walkers[i].getPositionX(), walkers[i].getPositionY());
	      if(walkers[i].isWalking()) {
            walkers[i].update();
            if(walkers[i].getPositionX() < 797) {
              walkers[i].setPositionX(walkers[i].getPositionX()+3);
            }
            else {
              walkers[i].setPositionX(0);
            }
	      }
	  }
//	  for(int i = 0; i < walkers.length; i++) {
//	    if(walkers[i] != null) {
//	      if(isMouseOver(walkers[i])){
//	          System.out.println("Mouse is over a walker!");
//	        }
//	    }
//	  }
	  }
	}
	
	
	public static void mousePressed() {
      for(int i = 0; i < walkers.length; i++) {
        if(walkers[i] != null) {
          if(isMouseOver(walkers[i])) {
            walkers[i].setWalking(true); 
            break;
          }
        }
       
      }
    }
	
	public static boolean isMouseOver(Walker num) {
	  if(Utility.mouseX() < num.getPositionX()+frames[0].width/2 && Utility.mouseX() > num.getPositionX()-frames[0].width/2) {
	    if(Utility.mouseY() < num.getPositionY()+frames[0].height/2 && Utility.mouseY() > num.getPositionY()-frames[0].height/2) {
	      return true;
	    }
	  }
	  return false;
	}
	
	public static void keyPressed(char key) {
	  randGen = new Random();
	  if(key == 'a' || key == 'A') {
	    for(int i = 0; i < walkers.length; i++) {
	      if(walkers[i] == null) {
	        walkers[i] = new Walker(randGen.nextInt(800), randGen.nextInt(600));
	        Utility.image(frames[walkers[i].getCurrentFrame()], randGen.nextInt(800), randGen.nextInt(600));
	        break;
	      }
	    }
	  }
	  if(key == 's' || key == 'S') {
	    for(int i = 0; i < walkers.length; i++) {
	      if(walkers[i] != null) {
	         walkers[i].setWalking(false);
	      }
	    }
	  }
	}
	
	
}
