/*
 * Functionance
 * Copyright (c) 2021-2021 ChampionAsh5357.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package net.ashwork.functionance.partial.task;

import net.ashwork.functionance.partial.transformer.Transformer3;

/**
 * Represents a task that accepts three arguments.
 * This also can provide defaulting behavior for any higher arity tasks
 * whose initial inputs are of the same type.
 *
 * <p>This is a functional interface whose functional method is
 * {@link #run3(Object, Object, Object)}.
 *
 * @param <T1> the type of the first argument to the task
 * @param <T2> the type of the second argument to the task
 * @param <T3> the type of the third argument to the task
 * @since 1.0.0
 */
@FunctionalInterface
public interface Task3<T1, T2, T3> extends Transformer3<T1, T2, T3, Void>, Task4<T1, T2, T3, Object> {

    /**
     * Performs this task on the given arguments.
     *
     * @param t1 the first task argument
     * @param t2 the second task argument
     * @param t3 the third task argument
     */
    void run3(final T1 t1, final T2 t2, final T3 t3);

    @Override
    default void run4(final T1 t1, final T2 t2, final T3 t3, final Object o) {
        this.run3(t1, t2, t3);
    }

    @Override
    default Void apply3(final T1 t1, final T2 t2, final T3 t3) {
        this.run3(t1, t2, t3);
        return null;
    }

    @Override
    default Void apply4(final T1 t1, final T2 t2, final T3 t3, final Object o) {
        return Task4.super.apply4(t1, t2, t3, o);
    }
}
