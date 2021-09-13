/*
 * Functionance
 * Copyright (c) 2021-2021 ChampionAsh5357.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package net.ashwork.functionance.test;

import net.ashwork.functionance.Function0;
import net.ashwork.functionance.partial.input.Arity;
import net.ashwork.functionance.partial.result.Default;
import net.ashwork.functionance.partial.result.Result;
import net.ashwork.functionance.partial.transformer.Transformer1;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public final class FunctionTests {

    public static final int NUM_OF_TESTS = 100;

    @Test
    public void test() {
        Generators.RANDOM.ints(NUM_OF_TESTS, 50, 100)
                .forEach(i -> {
                    final String s = Generators.string(i);
                    testFunction0(
                            () -> {
                                throw new RuntimeException();
                            },
                            () -> s,
                            s,
                            String::length
                    );
                });
    }

    public static <R, V, F extends Function0<R>> void testFunction0(
            final F throwing,
            final F function,
            final R expected,
            final Transformer1<? super R, ? extends V> andThen
            ) {
        testArity(function, 0);
        @SuppressWarnings("unchecked")
        final F handledFunction = (F) testHandle(throwing, Function0::apply0, function);
        Assertions.assertEquals(expected, handledFunction.apply0());
        testAndThen(handledFunction, andThen, r -> ((Function0<V>) r).apply0(), andThen.apply1(expected));
        Assertions.assertDoesNotThrow(handledFunction.consume()::run0);
    }

    public static <R, F extends Default<F>> F testHandle(
            final F function,
            final Transformer1<F, R> apply,
            final F handlerFunction
    ) {
        Assertions.assertThrows(Throwable.class, () -> apply.apply1(function));
        final F handledFunction = handlerFunction.handle(t -> handlerFunction);
        Assertions.assertDoesNotThrow(() -> apply.apply1(handledFunction));
        return handledFunction;
    }

    public static <R, V, F extends Result<R>> void testAndThen(
            final F function,
            final Transformer1<? super R, ? extends V> andThen,
            final Transformer1<Result<V>, V> apply,
            final V expected
    ) {
        Assertions.assertEquals(expected, apply.apply1(function.andThen(andThen)));
    }

    public static <A extends Arity> void testArity(
            final A arity,
            final int expected
    ) {
        Assertions.assertEquals(expected, arity.arity());
    }
}
