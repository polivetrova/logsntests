package task14;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static task14.ArraysMain.checkArray;
import static task14.ArraysMain.cutArrayAfterLastFour;

public class ArraysMainTest {

    @ParameterizedTest
    @MethodSource
    void shouldReturnNumbersAfterLast4(ArrayList<Integer> expected, int[] value){
        Assertions.assertEquals(expected, cutArrayAfterLastFour(value));
    }

    private static Stream<Arguments> shouldReturnNumbersAfterLast4() {
        return Stream.of(
                Arguments.arguments(new ArrayList<>(List.of(1,7)), new int[]{1, 2, 4, 4, 2, 3, 4, 1, 7}),
                Arguments.arguments(new ArrayList<>(List.of(1,5,8,82)), new int[]{1, 2, 6, 3, 4, 1, 5, 8, 82}),
                Arguments.arguments(new ArrayList<>(List.of(0)), new int[]{1, 2, 4, 3, 4, 0})
        );
    }

    @Test
    void shouldThrowExceptionIfNo4(){
        Assertions.assertThrows(RuntimeException.class, () -> cutArrayAfterLastFour(new int[]{1, 2, 3, 6, 2, 3, 7, 1, 7}));
    }

    @ParameterizedTest
    @MethodSource
    void shouldCheckArrayFor1And4(int[] value){
        Assertions.assertFalse(checkArray(value));
    }

    private static Stream<Arguments> shouldCheckArrayFor1And4() {
        return Stream.of(
                Arguments.arguments(new int[]{1, 1, 1, 1, 1}),
                Arguments.arguments(new int[]{1, 2, 4, 1, 1, 1, 1, 4}),
                Arguments.arguments(new int[]{4, 4, 4, 4}),
                Arguments.arguments(new int[]{4, 1, 1, 1, 4, 1, 4, 4}) // should fail
                );
    }
}
