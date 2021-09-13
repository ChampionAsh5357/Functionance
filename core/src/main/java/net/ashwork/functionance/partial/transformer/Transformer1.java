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
 * Represents a transformer that accepts one argument and produces a result.
 * This also can provide defaulting behavior for any higher arity transformers
 * whose initial inputs are of the same type.
 *
 * <p>This is a functional interface whose functional method is
 * {@link #apply1(Object)}.
 *
 * @param <T1> the type of the first argument to the transformer
 * @param <R> the type of the result of the transformer
 * @since 1.0.0
 */
@FunctionalInterface
public interface Transformer1<T1, R> extends Transformer2<T1, Object, R> {

    /**
     * Apples this transformer to the given argument.
     *
     * @param t1 the first transformer argument
     * @return the transformer result
     */
    R apply1(final T1 t1);

    @Override
    default R apply2(final T1 t1, final Object o) {
        return this.apply1(t1);
    }
}
