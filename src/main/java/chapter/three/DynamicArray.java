package chapter.three;

import java.util.Optional;

/**
 * {@link DynamicArray} is a contiguous data structure that is discussed
 * in 3.1.1. At the moment, this implementation does
 */
public class DynamicArray<T> {
  private static final int DEFAULT_SIZE = 10;
  private T[] array;
  private int size;
  private int capacity;
  private int index;

  public DynamicArray() {
    this(10);
  }

  public DynamicArray(int arraySize) {
    size = (arraySize == 0) ? DEFAULT_SIZE : arraySize;
    capacity = size / 2;
    array = (T[]) new Object[size];
    index = 0;
  }

  public void append(T item) {
    ensureCapacity();
    array[index] = item;
    index++;
  }

  public void insert(T item, int atIndex) {
    ensureCapacity();
    if (atIndex < size) {
      for (int i = size - 1; i > atIndex; i--) {
        array[i] = array[i - 1];
      }
      array[atIndex] = item;
      index++;
    } else {
      System.out.println("Index out of bounds");
    }
  }

  public T remove() {
    T item = array[index];
    array[index] = null;
    if (index > 0) index--;
    return item;
  }

  public Optional<T> remove(int atIndex) {
    if (atIndex >= 0 && atIndex < size) {
      T item = array[atIndex];
      index--;
      array[atIndex] = null;
      return Optional.of(item);
    } else {
      System.out.println("Index out of bounds");
      return Optional.empty();
    }
  }

  public void ensureCapacity() {
    if (index >= capacity) {
      size = size * 2;
      T[] newArray = (T[]) new Object[size];
      for (int i = 0; i < array.length; i++) {
        newArray[i] = array[i];
      }
      array = newArray;
      capacity = size / 2;
    }
  }

  public int getSize() {
    return size;
  }

  public void display() {
    for (int i = 0; i < array.length; i++) {
      if (i == 0) {
        System.out.print(array[i]);
      } else if (i == array.length - 1) {
        System.out.println(" " + array[i]);
      } else {
        System.out.print(" " + array[i]);
      }
    }
  }
}
