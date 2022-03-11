
import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TqsStackTest {

    private static TqsStack<String> testStack;

     @BeforeEach
     public void setUp(){
         testStack = new TqsStack<>(3);
     }


   @Test
   @DisplayName("stack is empty on construction")
    void emptyOnConstruction(){
       assertTrue(testStack.isEmpty());
   }

   @Test
   @DisplayName("stack has size 0 on construction")
    void sizeZeroOnConstruction(){
        assertEquals(0, testStack.size());
   }

   @Test
   @DisplayName("After n pushes to an empty stack the stack is not empty and its size is n")
    void sizeAfterPushes(){
         testStack.push("Um");
         testStack.push("Dois");
         testStack.push("Três");
         assertEquals(3, testStack.size());
         assertFalse(testStack.isEmpty());
   }

   @Test
    @DisplayName("If one pushes x then pops, the value popped is x")
    void valueAfterPushAndPop() {
         testStack.push("X");
         assertEquals("X", testStack.pop());

   }

   @Test
    @DisplayName("If one pushes x then peeks, the value returned is x, but the size stays the same")
    void valueAndSizeAfterPushAndPeek(){
        testStack.push("X");
        int stackSize = testStack.size();

        assertAll(
                () -> assertEquals("X", testStack.peek()),
                () -> assertEquals(stackSize, testStack.size()) );
   }

   @Test
    @DisplayName("if the size is n, then after n pops, the stack is empty and has a size 0")
    void isEmptyAndSizeAfterPops(){
         testStack.push("1");
         testStack.push("2");
         testStack.push("3");

       for (int i = 0; i < 3; i++) {
           testStack.pop();}

       assertEquals(0, testStack.size());
       assertTrue(testStack.isEmpty());
   }

   @Test
    @DisplayName("Popping from an empty stack does throw a NoSuchElementException ")
    void popEmptyStack(){
         assertThrows(NoSuchElementException.class, () -> {testStack.pop();});

   }

   @Test
    @DisplayName("Peeking into an empty stack does throw a NoSuchElementException")
    void peekEmptyStack(){
       assertThrows(NoSuchElementException.class, () -> {testStack.peek();});
   }

   @Test
   @DisplayName("For bounded stacks only: pushing onto a full stack does throw an IllegalStateException")
    void pushFullStack(){
       testStack = new TqsStack<>(3);
       testStack.push("1");
       testStack.push("2");
       testStack.push("3");

       assertThrows(IllegalStateException.class, () -> {testStack.push("4");});

   }


}
