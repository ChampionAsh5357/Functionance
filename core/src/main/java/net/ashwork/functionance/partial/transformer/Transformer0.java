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
 * Represents a transformer that accepts no arguments and produces a result.
 * This also can provide defaulting behavior for any higher arity transformers.
 *
 * <p>This is a functional interface whose functional method is
 * {@link #apply0()}.
 *
 * @param <R> the type of the result of the transformer
 * @since 1.0.0
 */
@FunctionalInterface
public interface Transformer0<R> extends Transformer1<Object, R> {

    /**
     * Applies this transformer.
     *
     * @return the transformer result
     */
    R apply0();

    @Override
    default R apply1(final Object o) {
        return this.apply0();
    }
}
