package refactoring.exercises;

import org.junit.Test;
import org.junit.runner.RunWith;
import refactoring.runner.ExampleRunner;

import java.util.function.LongUnaryOperator;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


@RunWith(ExampleRunner.class)
public class ExI_SummingRange {

    @ExampleRunner.Way
    public static long oldWay(long limit) {
        long result = 0;
        for (long i = 0; i < limit; i++) {
            result += i;
        }
        return result;
    }

    @Test
    public void is_0_for_limit_0(LongUnaryOperator f) {
        assertThat(f.applyAsLong(0), equalTo(0L));
    }

    @Test
    public void is_6_for_limit_4(LongUnaryOperator f) {
        assertThat(f.applyAsLong(4), equalTo(6L));
    }

    @Test
    public void is_big_for_MAX_VALUE(LongUnaryOperator f) {
        assertThat(f.applyAsLong(Integer.MAX_VALUE), equalTo(2305843005992468481L));
    }

}
