//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: Food Delivery
// Files: Student.java, FoodRobot.java, Delivery.java, DeliveryQueue.java
//////////////// sample.txt
// Course: CS 300, Spring 2020
//
// Author: Kenneth Ring
// Email: kgring@wisc.edu
// Lecturer's Name: Gary Dahl
//
//////////// PAIR PROGRAMMING (MAY SKIP WHEN WORKING INDIVIDUALLY) ////////////
//
// Partner Name:
// Partner Email:
// Partner Lecturer's Name:
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// x Write-up states that pair programming is allowed for this assignment.
// x We have both read and understood the course Pair Programming Policy.
// x We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Students who get help from sources other than their partner and the course
// staff must fully acknowledge and credit those sources here. If you did not
// receive any help of any kind from outside sources, explicitly indicate NONE
// next to each of the labels below.
//
// Persons: (identify each person and describe their help in detail)
// Online Sources: (identify each URL and describe their assistance in detail)
//
///////////////////////////////////////////////////////////////////////////////
public class Student {
  private int x; // x coordinate of the student
  private int y; // y coordinate of the student
  private int id; // unique number for the student

  /**
   * Simple constructor for a type Student object
   * 
   * @param int x is the x coordinate
   * @param int y is the y coordinate
   * @param int id is a unique id
   *
   */
  public Student(int x, int y, int id) {
    this.x = x;
    this.y = y;
    this.id = id;
  }

  /**
   * A simple getter method that returns the x coordinate of the student object
   * 
   * @return x
   *
   */
  public int getX() {
    return this.x;
  }

  /**
   * A simple getter method that returns the y coordinate of the student object
   * 
   * @return y
   *
   */
  public int getY() {
    return this.y;
  }

  /**
   * A simple getter method that returns the id of the student object
   * 
   * @return id
   *
   */
  public int getID() {
    return this.id;
  }

  /**
   * Converts the contents of the student object into a string in the following format id(x, y)
   * 
   * @return the string form of the object contents
   *
   */
  @Override
  public String toString() {
    String studentString = id + "(" + x + ", " + y + ")";
    return studentString;
  }

}
