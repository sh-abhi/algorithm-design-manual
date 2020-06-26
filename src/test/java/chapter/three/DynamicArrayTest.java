package chapter.three;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DynamicArrayTest {

    private DynamicArray<Integer> dynamicArray;

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
        dynamicArray.append(1);
        dynamicArray.append(2);
        dynamicArray.append(3);
        dynamicArray.display();
    }

    @Test
    void insert() {
        dynamicArray.append(1);
        dynamicArray.append(2);
        dynamicArray.append(3);
        dynamicArray.display();

        dynamicArray.insert(15, 2);
        dynamicArray.insert(-5, 0);
        dynamicArray.display();

        dynamicArray.insert(21, 10);
        dynamicArray.display();
    }

    @Test
    void remove() {
        Integer item = dynamicArray.remove();
        assertNull(item);

        dynamicArray.append(46);
        dynamicArray.append(88);
        dynamicArray.append(99);
        dynamicArray.append(39);
        dynamicArray.insert(15, 9);
        dynamicArray.insert(7, 0);
        dynamicArray.display();
        item = dynamicArray.remove();
        assertNull(item);
        dynamicArray.display();
    }

    @Test
    void removeAtIndex() {
        Integer item = dynamicArray.remove();
        assertNull(item);

        dynamicArray.append(46);
        dynamicArray.append(88);
        dynamicArray.append(99);
        dynamicArray.append(39);
        dynamicArray.insert(15, 9);
        dynamicArray.insert(7, 0);
        dynamicArray.display();
        dynamicArray.remove(0);
        dynamicArray.display();
    }
}