/*
 * Functionance
 * Copyright (c) 2021-2021 ChampionAsh5357.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package net.ashwork.functionance.partial.transformer;

/**
 * Represents a transformer that accepts five arguments and produces a result.
 * This also can provide defaulting behavior for any higher arity transformers
 * whose initial inputs are of the same type.
 *
 * <p>This is a functional interface whose functional method is
 * {@link #apply5(Object, Object, Object, Object, Object)}.
 *
 * @param <T1> the type of the first argument to the transformer
 * @param <T2> the type of the second argument to the transformer
 * @param <T3> the type of the third argument to the transformer
 * @param <T4> the type of the fourth argument to the transformer
 * @param <T5> the type of the fifth argument to the transformer
 * @param <R> the type of the result of the transformer
 * @since 1.0.0
 */
@FunctionalInterface
public interface Transformer5<T1, T2, T3, T4, T5, R> extends Transformer6<T1, T2, T3, T4, T5, Object, R> {

    /**
     * Apples this transformer to the given arguments.
     *
     * @param t1 the first transformer argument
     * @param t2 the second transformer argument
     * @param t3 the third transformer argument
     * @param t4 the fourth transformer argument
     * @param t5 the fifth transformer argument
     * @return the transformer result
     */
    R apply5(final T1 t1, final T2 t2, final T3 t3, final T4 t4, final T5 t5);

    @Override
    default R apply6(final T1 t1, final T2 t2, final T3 t3, final T4 t4, final T5 t5, final Object o) {
        return this.apply5(t1, t2, t3, t4, t5);
    }
}
