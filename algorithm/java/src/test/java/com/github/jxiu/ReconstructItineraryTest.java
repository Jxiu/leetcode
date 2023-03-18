package com.github.jxiu;

import com.github.jxiu.ReconstructItinerary;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class ReconstructItineraryTest {

    @ParameterizedTest
    @MethodSource()
    public void successTest(List<List<String>> in, List<String> expected){
        ReconstructItinerary problem = new ReconstructItinerary();
        List<String> out = problem.findItinerary(in);
        Assertions.assertEquals(expected, out);
    }

    static Stream<Arguments> successTest(){
        return Stream.of(
//            Arguments.of(Arrays.asList(
//                    Arrays.asList("MUC","LHR"),
//                    Arrays.asList("JFK","MUC"),
//                    Arrays.asList("SFO","SJC"),
//                    Arrays.asList("LHR","SFO")
//            ),Arrays.asList("JFK","MUC","LHR","SFO","SJC")),
//                Arguments.of(Arrays.asList(
//                        Arrays.asList("JFK","SFO"),
//                        Arrays.asList("JFK","ATL"),
//                        Arrays.asList("SFO","ATL"),
//                        Arrays.asList("ATL","JFK"),
//                        Arrays.asList("ATL","SFO")
//                ),Arrays.asList("JFK","ATL","JFK","SFO","ATL","SFO")),
        Arguments.of(Arrays.asList(
                Arrays.asList("JFK","SFO"),
                Arrays.asList("JFK","ATL"),
                Arrays.asList("SFO","ATL"),
                Arrays.asList("ATL","JFK"),
//                Arrays.asList("ATL","SFO")

                Arrays.asList("F","SFO"),
                Arrays.asList("SFO","F")
        ),Arrays.asList("JFK","ATL","JFK","SFO","F","SFO","ATL"))
        );

    }
}