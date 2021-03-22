import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.PriorityQueue;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class PriorityQueueTest {
    public static Stream<Arguments> getParameters(){
        return Stream.of(
                arguments(new int[]{4,5,3,2,6},new int[]{2,3,4,5,6}),
                arguments(new int[]{9,-4,0,3,4},new int[]{-4,0,3,4,9}),
                arguments(new int[]{1,2,3,4,5},new int[]{1,2,3,4,5}),
                arguments(new int[]{3,2,1},new int[]{1,2,3}),
                arguments(new int[]{6,7,8,6,7,8},new int[]{6,6,7,7,8,8})
        );
    }

    @ParameterizedTest(name = "#{index} Test with Argument={0},{1}")
    @MethodSource("getParameters")
    public void parameterizedTest(int[] input,int[] expected){
        PriorityQueue pqInput = new PriorityQueue();
        for(int e : input){
            pqInput.offer(e);
        }
        for(int e : expected){
            assertEquals(e,pqInput.poll());
        }
    }

    @Test
    public void NegativeCapacityTest(){
        assertThrows(IllegalArgumentException.class,() ->{new PriorityQueue(-1);});
    }

    @Test
    public void WrongTypeOfferTest(){
        PriorityQueue testQ = new PriorityQueue();
        testQ.offer("cc");
        assertThrows(ClassCastException.class,() ->{testQ.offer(3);});
    }

    @Test
    public void AddNullTest(){
        assertThrows(NullPointerException.class,() ->{new PriorityQueue().offer(null);});
    }
}
