package org.example;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class HashSetTest {

    HashSet<Integer> hs;
    List<Integer> c;

    @BeforeEach
    void setUp() {
        hs = new HashSet<>();
        c = new ArrayList<>();
    }


    @Test
    void hashSetSizeLessThanCollectionSize() {
        hs.addAll(List.of(1,2,3,4));
        c.addAll(List.of(1,2,3,5,6,7,8,9));


        // True
        boolean actual = hs.removeAll(c);

        /*assertTrue(actual);
        assertEquals(1, hs.size());
        assertTrue(hs.contains(4));*/

        assertAll("hashset",
                () -> assertTrue(hs.contains(4)),
                () -> assertTrue(actual),
                () -> assertEquals(1, hs.size())
        );

    }

    @Test
    void hashSetSizeGreaterThanCollectionSize() {
        c.addAll(List.of(1,2,3,4));
        hs.addAll(List.of(1,2,3,5,6,7,8,9));


        // True
        boolean actual = hs.removeAll(c);

        assertTrue(actual);
        assertEquals(5, hs.size());
    }


    @ParameterizedTest
    @MethodSource("generateCollectionsWithElements")
    void testWhenBothCollectionsAreNotNull(List<Integer> hashSet,
                                                    List<Integer> c,
                                                    boolean expectedResult,
                                                    int sizeResult) {
            hs.addAll(hashSet);

            assertEquals(expectedResult, hs.removeAll(c));
            assertEquals(sizeResult, hs.size());

    }

    static Stream<Arguments> generateCollectionsWithElements(){
        return Stream.of(
                arguments(List.of(1,2,3,4), List.of(1,2,3,5,6,7,8), true, 1),
                arguments(List.of(1,2,3,5,6,7,8), List.of(1,2,3,4), true, 4),
                arguments(List.of(), List.of(1), false, 0),
                arguments(List.of(1,2,3,4), List.of(), false, 4)
        );
    }

    @Test
    void whenCollectionIsNull() {
        c = null;

        hs.addAll(List.of(1,2,3));

        assertThrows(NullPointerException.class, () -> {
            hs.removeAll(c);
        });

    }

    @AfterEach
    void tearDown() {
        hs = null;
        c = null;
    }



}
