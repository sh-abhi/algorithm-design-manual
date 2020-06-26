package chapter.three;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class DynamicArrayStringTest {
  private DynamicArray<String> dynamicArray;

  @BeforeEach
  void setUp() {
    dynamicArray = new DynamicArray<>();
  }

  @AfterEach
  void tearDown() {
    dynamicArray = null;
  }

  @Test
  void append() {
    dynamicArray.append("a");
    dynamicArray.append("b");
    dynamicArray.append("c");
    dynamicArray.display();
  }

  @Test
  void insert() {
    dynamicArray.append("a");
    dynamicArray.append("b");
    dynamicArray.append("c");
    dynamicArray.display();

    dynamicArray.insert("insertion #1", 2);
    dynamicArray.insert("insertion #2", 0);
    dynamicArray.display();

    dynamicArray.insert("insertion #3", 10);
    dynamicArray.display();
  }

  @Test
  void remove() {
    String item = dynamicArray.remove();
    assertNull(item);

    dynamicArray.append("apple");
    dynamicArray.append("banana");
    dynamicArray.append("orange");
    dynamicArray.append("lemon");
    dynamicArray.insert("pear", 9);
    dynamicArray.insert("acorn", 0);
    dynamicArray.display();
    item = dynamicArray.remove();
    assertNull(item);
    dynamicArray.display();
  }

  @Test
  void removeAtIndex() {
    String item = dynamicArray.remove();
    assertNull(item);

    dynamicArray.append("apple");
    dynamicArray.append("banana");
    dynamicArray.append("orange");
    dynamicArray.append("lemon");
    dynamicArray.insert("pear", 9);
    dynamicArray.insert("acorn", 0);
    dynamicArray.display();
    Optional<String> optionalString = dynamicArray.remove(0);
    assertFalse(optionalString.isEmpty());
    String actual = optionalString.get();
    assertTrue("acorn".equals(actual));
    dynamicArray.display();
  }
}
