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
 * Represents a transformer that accepts three arguments and produces a result.
 * This also can provide defaulting behavior for any higher arity transformers
 * whose initial inputs are of the same type.
 *
 * <p>This is a functional interface whose functional method is
 * {@link #apply3(Object, Object, Object)}.
 *
 * @param <T1> the type of the first argument to the transformer
 * @param <T2> the type of the second argument to the transformer
 * @param <T3> the type of the third argument to the transformer
 * @param <R> the type of the result of the transformer
 * @since 1.0.0
 */
@FunctionalInterface
public interface Transformer3<T1, T2, T3, R> {

    /**
     * Apples this transformer to the given arguments.
     *
     * @param t1 the first transformer argument
     * @param t2 the second transformer argument
     * @param t3 the third transformer argument
     * @return the transformer result
     */
    R apply3(final T1 t1, final T2 t2, final T3 t3);
}
