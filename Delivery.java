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
public class Delivery implements Comparable<Delivery> {
  private int studentId; // id for the student object
  private String robotName; // name for the FoodRobot object
  private int distance; // the Manhattan distance between a student and FoodRobot object

  /**
   * A simple constructor that sets the private variables to the values provided in the argument.
   * The distance is calculated using the Manhattan distance formula
   * 
   * @param student is a Student type object
   * @param robot   is a FoodRobot type object
   * 
   *
   */
  public Delivery(Student student, FoodRobot robot) {
    studentId = student.getID();
    robotName = robot.getName();
    distance = (Math.abs(student.getX() - robot.getX()) + Math.abs(student.getY() - robot.getY()));
  }

  /**
   * Converts the contents of the Delivery object into a string
   * 
   * @return the string form of the object contents
   *
   */
  @Override
  public String toString() {
    return "The distance between " + studentId + " and " + robotName + " is " + distance;
  }

  /**
   * Compares the priority status of two delivery type objects based on their distance, and if that
   * value is equal, their studentId or robotName
   * 
   * @param other is the Delivery object being compared to this one
   * 
   * @return -1 if the other has a higher priority, 1 if this object has the higher priority
   *
   */
  @Override
  public int compareTo(Delivery other) {
    if (this.distance == other.distance) {
      if (this.studentId < other.studentId) {
        return -1;
      } else if (other.studentId < this.studentId) {
        return 1;
      }
      if (this.robotName.compareTo(other.robotName) < 0) {
        return -1;
      } else if (this.robotName.compareTo(other.robotName) > 0) {
        return 1;
      }
    }
    if (this.distance > other.distance) {
      return -1;
    } else {
      return 1;
    }

  }

  /**
   * This method checks if A Delivery object and one other object of either type Delivery, Student,
   * or FoodRobot are equal. Each object type is given a seperate set of parameters that defiens
   * what is "equal"
   * 
   * @param object is the miscellaneous object being compared to
   * 
   * @return true if they are equal, false if not
   *
   */
  @Override
  public boolean equals(Object object) {
    if (object instanceof Delivery) {
      Delivery d = (Delivery) object;
      if (this.studentId == d.studentId) {
        return true;
      }
      if (this.robotName == d.robotName) {
        return true;
      } else {
        return false;
      }
    }
    if (object instanceof Student) {
      Student s = (Student) object;
      if (this.studentId == s.getID()) {
        return true;
      } else {
        return false;
      }
    }
    if (object instanceof FoodRobot) {
      FoodRobot f = (FoodRobot) object;
      if (this.robotName.equals(f.getName())) {
        return true;
      } else {
        return false;
      }
    }
    return false;
  }

}
