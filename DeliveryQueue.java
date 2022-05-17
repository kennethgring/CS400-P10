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
import java.util.NoSuchElementException;

public class DeliveryQueue {
  private static final int INITIAL_CAPACITY = 20;
  private Delivery[] heap;
  private int size;

  /**
   * A constructor that initializes the heap and size
   *
   *
   */
  public DeliveryQueue() {
    heap = new Delivery[INITIAL_CAPACITY];
    size = 0;
  }

  /**
   * Adds a delivery object to the queue which is sorted into the correct position
   *
   * @param delivery is the delivery object being added
   *
   */
  public void offerDelivery(Delivery delivery) {
    if (size % 20 == 0 && size > 0) {
      Delivery[] temp = new Delivery[size * 20];
      for (int i = 0; i < size; i++) {
        temp[i] = heap[i];
      }
      heap = temp;
    }
    heap[size] = delivery;
    ++size;
    percolateUp(size - 1);
  }

  /**
   * returns and removes the highest priority object and any duplicates within the array
   *
   * @return the highest priority object
   *
   */
  public Delivery pollBestDelivery() {
    if (isEmpty()) {
      throw new NoSuchElementException("Warning: Empty Heap!");
    }
    Delivery returnValue = heap[0];
    heap[0] = heap[size - 1];
    heap[size - 1] = null;
    --size;
    percolateDown(0);
    for (int i = 0; i < size; i++) {
      if (returnValue.equals(heap[i])) {
        heap[i] = null;
        for (int j = i; j < size - 1; j++) {
          heap[j] = heap[j + 1];
        }
        size--;
        i--;
      }
    }
    heapify();
    return returnValue;
  }

  /**
   * Sorts a node upward if appropriate
   *
   *
   */
  private void percolateUp(int index) {
    if (index == 0) {
      return;
    }
    int parentIndex = getParentIndex(index);
    if (heap[index].compareTo(heap[parentIndex]) < 0) {
      return;
    } else {
      swap(index, parentIndex);
      percolateUp(parentIndex);
    }
  }

  /**
   * Sorts a node downward if appropriate
   *
   *
   */
  private void percolateDown(int index) {
    if (getRightChildIndex(index) < size) {
      int maxIndex = 0;
      if (heap[getLeftChildIndex(index)].compareTo(heap[getRightChildIndex(index)]) < 0) {
        maxIndex = getLeftChildIndex(index);
      } else {
        maxIndex = getRightChildIndex(index);
      }
      if (heap[maxIndex].compareTo(heap[index]) < 0) {
        swap(maxIndex, index);
        percolateDown(maxIndex);
      } else if (heap[getLeftChildIndex(index)] != null && heap[getRightChildIndex(index)] != null
          && heap[getLeftChildIndex(index)].compareTo(heap[index]) < 0) {
        swap(getLeftChildIndex(index), index);
      }
    }
  }

  /**
   * Sorts the entire queue
   *
   *
   */
  private void heapify() {
    for (int i = 0; i < size / 2; i++) {
      percolateDown(i);
    }
  }

  /**
   * Returns the highest priority delivery without removing it
   *
   * @return the highest prioirty delivery
   *
   */
  public Delivery peek() {
    if (isEmpty()) {
      throw new NoSuchElementException("Warning: Empty Heap!");
    }
    return heap[0];
  }

  /**
   * A simple getter method that returns the size of the queue
   *
   * @return the size
   *
   */
  public int getSize() {
    return size;
  }

  /**
   * Checks if the queue is empty
   *
   * @return true if empty false if not
   *
   */
  public boolean isEmpty() {
    if (size == 0) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * Swaps the position of two objects within the queue
   *
   *
   */
  public void swap(int index1, int index2) {
    Delivery temp = heap[index1];
    heap[index1] = heap[index2];
    heap[index2] = temp;
  }

  /**
   * Returns the index of the right child of the parent
   * 
   * @param the index of the parent node
   *
   * @return the index of the right child
   *
   */
  public int getRightChildIndex(int index) {
    return 2 * index + 2;
  }

  /**
   * Returns the index of the left child of the parent
   * 
   * @param the index of the parent node
   *
   * @return the index of the left child
   *
   */
  public int getLeftChildIndex(int index) {
    return 2 * index + 1;
  }

  /**
   * Returns the index of the parent
   * 
   * @param the index of the child node
   *
   * @return the index of the parent
   *
   */
  public int getParentIndex(int index) {
    return Math.floorDiv((index - 1), 2);
  }

  /**
   * Converts the contents of the queue in the form of a string
   * 
   *
   * @return the string
   *
   */
  @Override
  public String toString() {
    String string = "This DeliveryQueue contains " + size + " elements";
    if (size == 0) {
      return string;
    }
    string += ": [ ";
    for (int i = 0; i < size; i++)
      string += "\n" + heap[i].toString();
    string += " ]\n";
    return string;
  }
}
