package no.itera.kotlin.examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Pavol Rajzak, Itera.
 */
public class SomeJavaClass {

    private Void mostUselessProperty;

    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(1, 123, 47, 63, 478, 234);

        intList.stream().filter(x -> x < 100).collect(Collectors.toList());
    }

    private static List<Integer> filterSmallerThanHundred(List<Integer> intList) {
        List<Integer> output = new ArrayList<>();

        for (Integer x : intList) {
            if (x < 100) {
                output.add(x);
            }
        }

        final List<Integer> immutableList = new ArrayList<>();
        List<Integer> mutableList = new ArrayList<>();

        return output;
    }

}
