package org.spaconference.rts;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.spaconference.rts.runner.ExampleRunner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.spaconference.rts.runner.ExampleRunner.Way;


@RunWith(ExampleRunner.class)
public class ExC_Mapping {

    @Way
    public static List<Integer> oldWay(List<String> strings) {
        List<Integer> result = new ArrayList<>();
        for (String string : strings) {
            result.add(Integer.parseInt(string));
        }
        return result;
    }

    @Way
    public static List<Integer> newWay(List<String> strings) {
        return Collections.emptyList();
    }


    @Test
    public void test(Function<List<String>, List<Integer>> f) {
        assertThat(f.apply(asList("2", "3", "5", "7")), equalTo(asList(2, 3, 5, 7)));
    }
}
