/*
 * Functionance
 * Copyright (c) 2021-2021 ChampionAsh5357.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package net.ashwork.functionance.partial.task;

import net.ashwork.functionance.partial.transformer.Transformer4;

/**
 * Represents a task that accepts four arguments.
 * This also can provide defaulting behavior for any higher arity tasks
 * whose initial inputs are of the same type.
 *
 * <p>This is a functional interface whose functional method is
 * {@link #run4(Object, Object, Object, Object)}.
 *
 * @param <T1> the type of the first argument to the task
 * @param <T2> the type of the second argument to the task
 * @param <T3> the type of the third argument to the task
 * @param <T4> the type of the fourth argument to the task
 * @since 1.0.0
 */
@FunctionalInterface
public interface Task4<T1, T2, T3, T4> extends Transformer4<T1, T2, T3, T4, Void>, Task5<T1, T2, T3, T4, Object> {

    /**
     * Performs this task on the given arguments.
     *
     * @param t1 the first task argument
     * @param t2 the second task argument
     * @param t3 the third task argument
     * @param t4 the fourth task argument
     */
    void run4(final T1 t1, final T2 t2, final T3 t3, final T4 t4);

    @Override
    default void run5(final T1 t1, final T2 t2, final T3 t3, final T4 t4, final Object o) {
        this.run4(t1, t2, t3, t4);
    }

    @Override
    default Void apply4(final T1 t1, final T2 t2, final T3 t3, final T4 t4) {
        this.run4(t1, t2, t3, t4);
        return null;
    }

    @Override
    default Void apply5(final T1 t1, final T2 t2, final T3 t3, final T4 t4, final Object o) {
        return Transformer4.super.apply5(t1, t2, t3, t4, o);
    }
}
