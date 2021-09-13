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
 * Defines that the implementing object takes in four arguments which
 * can be lazily operated on or swapped.
 *
 * @see Arity
 * @since 1.0.0
 */
public interface Input4<T1, T2, T3, T4> extends Input3<T1, T2, T3> {

    @Override
    default int arity() {
        return 4;
    }

    /**
     * Returns an object that applies the {@code before} transformer to the
     * fourth input lazily such that the resulting behavior is chained from
     * the new input type.
     *
     * @param before the transformer to apply before this object
     * @param <V> the type of the input to the {@code before} transformer, and
     *            then to the resulting object
     * @return an object whose fourth input is the new input type
     */
    <V> Input4<T1, T2, T3, V> compose4(final Transformer1<? super V, ? extends T4> before);

    @Override
    <V> Input4<T1, T2, V, T4> compose3(final Transformer1<? super V, ? extends T3> before);

    @Override
    <V> Input4<T1, V, T3, T4> compose2(final Transformer1<? super V, ? extends T2> before);

    @Override
    <V> Input4<V, T2, T3, T4> compose1(final Transformer1<? super V, ? extends T1> before);

    /**
     * Returns an object whose third and fourth inputs are swapped such that
     * the fourth input is now the third input and vice versa.
     *
     * @return an object whose third and fourth inputs are swapped
     */
    Input4<T1, T2, T4, T3> swap3();

    @Override
    Input4<T1, T3, T2, T4> swap2();

    @Override
    Input4<T2, T1, T3, T4> swap1();

    /**
     * Fixes the fourth input to some value to produce an object with one fewer
     * input.
     *
     * @param t4 the fourth input
     * @return an object with one fewer input
     * @see <a href="https://en.wikipedia.org/wiki/Partial_application">Partial Application</a>
     */
    Input3<T1, T2, T3> partial4(final T4 t4);

    @Override
    Input3<T1, T2, T4> partial3(final T3 t3);

    @Override
    Input3<T1, T3, T4> partial2(final T2 t2);

    @Override
    Input3<T2, T3, T4> partial1(final T1 t1);
}
