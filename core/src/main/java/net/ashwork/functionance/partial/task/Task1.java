/*
 * Functionance
 * Copyright (c) 2021-2021 ChampionAsh5357.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package net.ashwork.functionance.partial.task;

import net.ashwork.functionance.partial.transformer.Transformer1;

/**
 * Represents a task that accepts one argument.
 * This also can provide defaulting behavior for any higher arity tasks
 * whose initial inputs are of the same type.
 *
 * <p>This is a functional interface whose functional method is
 * {@link #run1(Object)}.
 *
 * @param <T1> the type of the first argument to the task
 * @since 1.0.0
 */
@FunctionalInterface
public interface Task1<T1> extends Transformer1<T1, Void>, Task2<T1, Object> {

    /**
     * Performs this task on the given argument.
     *
     * @param t1 the first task argument
     */
    void run1(final T1 t1);

    @Override
    default void run2(final T1 t1, final Object o) {
        this.run1(t1);
    }

    @Override
    default Void apply1(final T1 t1) {
        this.run1(t1);
        return null;
    }

    @Override
    default Void apply2(final T1 t1, final Object o) {
        return Transformer1.super.apply2(t1, o);
    }
}
