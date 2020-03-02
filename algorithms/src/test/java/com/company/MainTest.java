package com.company;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.support.AnnotationConsumer;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static com.company.Main.countCandies;

class MainTest {

    static class ArrayArgumentsProvider implements
            ArgumentsProvider, AnnotationConsumer<ArraySources> {

        private List<int[]> arguments;

        public void accept(ArraySources source) {
            List<ArraySource> arrays = Arrays.asList(source.arrays());

            this.arguments = arrays
                .stream()
                .map(ArraySource::array)
                .collect(Collectors.toList());
        }

        public Stream<? extends Arguments> provideArguments(
                ExtensionContext context) {
            return this.arguments.stream().map(Arguments::of);
        }

    }

    @Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    @ArgumentsSource(ArrayArgumentsProvider.class)
    @interface ArraySources {
        ArraySource[] arrays();
    }

    @Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    @interface ArraySource {
        int[] array() default {};
    }

    @ParameterizedTest
    @ArraySources(arrays = {
        @ArraySource(array = {4, 10, 3, 3}),
        @ArraySource(array = {13, 35, 5, 2}),
        @ArraySource(array = {15, 250, 20, 4}),
        @ArraySource(array = {13, 84, 9, 3}),
        @ArraySource(array = {89, 90, 2, 2}),
        @ArraySource(array = {14, 53, 4, 10}),
        @ArraySource(array = {19, 230, 13, 8}),
        @ArraySource(array = {0, 10, 20, 30}),
        @ArraySource(array = {41, 100, 3, 5})
    })
    void candiesCheck(int... args) {
        assertEquals(args[0], countCandies(args[1], args[2], args[3]));
    }

    @ParameterizedTest
    @ArraySources(arrays = {
        @ArraySource(array = {10, 3, 1}),
        @ArraySource(array = {90, 2, 1}),
        @ArraySource(array = {250, 20, 1})
    })
    void wrongArgument(int... args) {
        assertThrows(IllegalArgumentException.class,
                     () -> countCandies(args[0], args[1],args[2]));
    }

}
