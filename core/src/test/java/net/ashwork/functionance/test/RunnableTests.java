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
import net.ashwork.functionance.partial.result.Chain;
import net.ashwork.functionance.partial.task.Task1;
import net.ashwork.functionance.partial.transformer.Transformer1;
import net.ashwork.functionance.runnable.Runnable0;
import org.junit.jupiter.api.Test;

public final class RunnableTests {

    @Test
    public void test() {

    }

    public static <V, R extends Runnable0> void testRunnable0(
            final R throwing,
            final R runnable,
            final Transformer1<? super Void, ? extends V> andThen,
            final R andThenRunnable
    ) {
        FunctionTests.testArity(throwing, 0);
        @SuppressWarnings("unchecked")
        final R handledRunnable = (R) FunctionTests.testHandle(throwing, Runnable0::apply0, runnable);
        handledRunnable.run0();
        FunctionTests.testAndThen(handledRunnable, andThen, r -> ((Function0<V>) r).apply0(), andThen.apply1(null));
        testAndThen(runnable, andThenRunnable, Runnable0::run0);
    }

    public static <C extends Chain<C>> void testAndThen(
            final C runnable,
            final C andThenRunnable,
            final Task1<C> task
    ) {
        task.apply1(runnable.andThen(andThenRunnable));
    }
}
