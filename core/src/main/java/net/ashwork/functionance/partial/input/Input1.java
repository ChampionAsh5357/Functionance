/*
 * Functionance
 * Copyright (c) 2021-2021 ChampionAsh5357.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package net.ashwork.functionance.partial.input;

import net.ashwork.functionance.partial.transformer.Transformer1;

/**
 * Defines that the implementing object takes in one argument which
 * can be lazily operated on.
 *
 * @see Arity
 * @since 1.0.0
 */
public interface Input1<T1> extends Input0 {

    @Override
    default int arity() {
        return 1;
    }

    /**
     * Returns an object that applies the {@code before} transformer to the
     * first input lazily such that the resulting behavior is chained from
     * the new input type.
     *
     * @param before the transformer to apply before this object
     * @param <V> the type of the input to the {@code before} transformer, and
     *            then to the resulting object
     * @return an object whose first input is the new input type
     */
    <V> Input1<V> compose1(final Transformer1<? super V, ? extends T1> before);

    /**
     * Fixes the first input to some value to produce an object with one fewer
     * input.
     *
     * @param t1 the first input
     * @return an object with one fewer input
     * @see <a href="https://en.wikipedia.org/wiki/Partial_application">Partial Application</a>
     */
    Input0 partial1(final T1 t1);
}
