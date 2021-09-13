/*
 * Functionance
 * Copyright (c) 2021-2021 ChampionAsh5357.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package net.ashwork.functionance.partial.task;

import net.ashwork.functionance.partial.transformer.Transformer7;

/**
 * Represents a task that accepts seven arguments.
 * This also can provide defaulting behavior for any higher arity tasks
 * whose initial inputs are of the same type.
 *
 * <p>This is a functional interface whose functional method is
 * {@link #run7(Object, Object, Object, Object, Object, Object, Object)}.
 *
 * @param <T1> the type of the first argument to the task
 * @param <T2> the type of the second argument to the task
 * @param <T3> the type of the third argument to the task
 * @param <T4> the type of the fourth argument to the task
 * @param <T5> the type of the fifth argument to the task
 * @param <T6> the type of the sixth argument to the task
 * @param <T7> the type of the seventh argument to the task
 * @since 1.0.0
 */
@FunctionalInterface
public interface Task7<T1, T2, T3, T4, T5, T6, T7> extends Transformer7<T1, T2, T3, T4, T5, T6, T7, Void>, Task8<T1, T2, T3, T4, T5, T6, T7, Object> {

    /**
     * Performs this task on the given arguments.
     *
     * @param t1 the first task argument
     * @param t2 the second task argument
     * @param t3 the third task argument
     * @param t4 the fourth task argument
     * @param t5 the fifth task argument
     * @param t6 the sixth task argument
     * @param t7 the seventh task argument
     */
    void run7(final T1 t1, final T2 t2, final T3 t3, final T4 t4, final T5 t5, final T6 t6, final T7 t7);

    @Override
    default void run8(final T1 t1, final T2 t2, final T3 t3, final T4 t4, final T5 t5, final T6 t6, final T7 t7, final Object o) {
        this.run7(t1, t2, t3, t4, t5, t6, t7);
    }

    @Override
    default Void apply7(final T1 t1, final T2 t2, final T3 t3, final T4 t4, final T5 t5, final T6 t6, final T7 t7) {
        this.run7(t1, t2, t3, t4, t5, t6, t7);
        return null;
    }

    @Override
    default Void apply8(final T1 t1, final T2 t2, final T3 t3, final T4 t4, final T5 t5, final T6 t6, final T7 t7, final Object o) {
        return Transformer7.super.apply8(t1, t2, t3, t4, t5, t6, t7, o);
    }
}
