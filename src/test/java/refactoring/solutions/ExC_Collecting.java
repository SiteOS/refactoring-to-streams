package refactoring.solutions;

import org.junit.Test;
import org.junit.runner.RunWith;
import refactoring.runner.ExampleRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


@RunWith(refactoring.runner.ExampleRunner.class)
public class ExC_Collecting {

    @ExampleRunner.Way
    public static List<String> oldWay(Iterable<String> things) {
        List<String> result = new ArrayList<>();
        for (String thing : things) {
            result.add(thing);
        }
        return result;
    }

    @ExampleRunner.Way
    public static List<String> step_1_iterate_a_stream(Iterable<String> things) {
        List<String> result = new ArrayList<>();
        StreamSupport.stream(things.spliterator(), false).forEach(result::add);
        return result;
    }

    @ExampleRunner.Way
    public static List<String> step_2_use_collector(Iterable<String> things) {
        return StreamSupport.stream(things.spliterator(), false).collect(Collectors.toList());
    }

    @Test
    public void test(Function<Iterable<String>, List<String>> f) {
        assertThat(f.apply(asList("one", "two", "three")), equalTo(asList("one", "two", "three")));
    }
}
