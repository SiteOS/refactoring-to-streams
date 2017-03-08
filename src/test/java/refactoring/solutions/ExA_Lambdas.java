package refactoring.solutions;

import org.junit.Test;
import org.junit.runner.RunWith;
import refactoring.runner.ExampleRunner;

import java.util.function.Function;
import java.util.function.Supplier;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


@RunWith(refactoring.runner.ExampleRunner.class)
public class ExA_Lambdas {

    @ExampleRunner.Way
    public static Function<String, Integer> anonymousClass() {
        return new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return Integer.parseInt(s);
            }
        };
    }

    @ExampleRunner.Way
    public static Function<String, Integer> lambda() {
        return s -> Integer.parseInt(s);
    }

    @ExampleRunner.Way
    public static Function<String, Integer> methodReference() {
        return Integer::parseInt;
    }

    @Test
    public void call_a_function(Supplier<Function<String, Integer>> f) {
        assertThat(f.get().apply("42"), equalTo(42));
    }

}
