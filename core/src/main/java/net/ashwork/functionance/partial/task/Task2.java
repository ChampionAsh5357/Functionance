/*
 * Functionance
 * Copyright (c) 2021-2021 ChampionAsh5357.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package net.ashwork.functionance.partial.task;

import net.ashwork.functionance.partial.transformer.Transformer2;

/**
 * Represents a task that accepts two arguments.
 * This also can provide defaulting behavior for any higher arity tasks
 * whose initial inputs are of the same type.
 *
 * <p>This is a functional interface whose functional method is
 * {@link #run2(Object, Object)}.
 *
 * @param <T1> the type of the first argument to the task
 * @param <T2> the type of the second argument to the task
 * @since 1.0.0
 */
@FunctionalInterface
public interface Task2<T1, T2> extends Transformer2<T1, T2, Void>, Task3<T1, T2, Object> {

    /**
     * Performs this task on the given arguments.
     *
     * @param t1 the first task argument
     * @param t2 the second task argument
     */
    void run2(final T1 t1, final T2 t2);

    @Override
    default void run3(final T1 t1, final T2 t2, final Object o) {
        this.run2(t1, t2);
    }

    @Override
    default Void apply2(final T1 t1, final T2 t2) {
        this.run2(t1, t2);
        return null;
    }

    @Override
    default Void apply3(final T1 t1, final T2 t2, final Object o) {
        return Transformer2.super.apply3(t1, t2, o);
    }
}
