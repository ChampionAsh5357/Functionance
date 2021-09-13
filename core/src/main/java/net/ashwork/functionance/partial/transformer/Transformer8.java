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
 * Represents a transformer that accepts eight arguments and produces a result.
 * This also can provide defaulting behavior for any higher arity transformers
 * whose initial inputs are of the same type.
 *
 * <p>This is a functional interface whose functional method is
 * {@link #apply8(Object, Object, Object, Object, Object, Object, Object, Object)}.
 *
 * @param <T1> the type of the first argument to the transformer
 * @param <T2> the type of the second argument to the transformer
 * @param <T3> the type of the third argument to the transformer
 * @param <T4> the type of the fourth argument to the transformer
 * @param <T5> the type of the fifth argument to the transformer
 * @param <T6> the type of the sixth argument to the transformer
 * @param <T7> the type of the seventh argument to the transformer
 * @param <T8> the type of the eighth argument to the transformer
 * @param <R> the type of the result of the transformer
 * @since 1.0.0
 */
@FunctionalInterface
public interface Transformer8<T1, T2, T3, T4, T5, T6, T7, T8, R> {

    /**
     * Apples this transformer to the given arguments.
     *
     * @param t1 the first transformer argument
     * @param t2 the second transformer argument
     * @param t3 the third transformer argument
     * @param t4 the fourth transformer argument
     * @param t5 the fifth transformer argument
     * @param t6 the sixth transformer argument
     * @param t7 the seventh transformer argument
     * @param t8 the eighth transformer argument
     * @return the transformer result
     */
    R apply8(final T1 t1, final T2 t2, final T3 t3, final T4 t4, final T5 t5, final T6 t6, final T7 t7, final T8 t8);
}
