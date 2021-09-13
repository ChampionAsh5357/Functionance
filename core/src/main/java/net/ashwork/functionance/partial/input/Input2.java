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
 * Defines that the implementing object takes in two arguments which
 * can be lazily operated on or swapped.
 *
 * @see Arity
 * @since 1.0.0
 */
public interface Input2<T1, T2> extends Input1<T1> {

    @Override
    default int arity() {
        return 2;
    }

    /**
     * Returns an object that applies the {@code before} transformer to the
     * second input lazily such that the resulting behavior is chained from
     * the new input type.
     *
     * @param before the transformer to apply before this object
     * @param <V> the type of the input to the {@code before} transformer, and
     *            then to the resulting object
     * @return an object whose second input is the new input type
     */
    <V> Input2<T1, V> compose2(final Transformer1<? super V, ? extends T2> before);

    @Override
    <V> Input2<V, T2> compose1(final Transformer1<? super V, ? extends T1> before);

    /**
     * Returns an object whose first and second inputs are swapped such that
     * the second input is now the first input and vice versa.
     *
     * @return an object whose first and second inputs are swapped
     */
    Input2<T2, T1> swap1();

    /**
     * Fixes the second input to some value to produce an object with one fewer
     * input.
     *
     * @param t2 the second input
     * @return an object with one fewer input
     * @see <a href="https://en.wikipedia.org/wiki/Partial_application">Partial Application</a>
     */
    Input1<T1> partial2(final T2 t2);

    @Override
    Input1<T2> partial1(final T1 t1);
}
