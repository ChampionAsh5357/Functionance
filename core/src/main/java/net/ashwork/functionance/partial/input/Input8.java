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
 * Defines that the implementing object takes in eight arguments which
 * can be lazily operated on or swapped.
 *
 * @see Arity
 * @since 1.0.0
 */
public interface Input8<T1, T2, T3, T4, T5, T6, T7, T8> extends Input7<T1, T2, T3, T4, T5, T6, T7> {

    @Override
    default int arity() {
        return 8;
    }

    /**
     * Returns an object that applies the {@code before} transformer to the
     * eighth input lazily such that the resulting behavior is chained from
     * the new input type.
     *
     * @param before the transformer to apply before this object
     * @param <V> the type of the input to the {@code before} transformer, and
     *            then to the resulting object
     * @return an object whose eighth input is the new input type
     */
    <V> Input8<T1, T2, T3, T4, T5, T6, T7, V> compose8(final Transformer1<? super V, ? extends T8> before);

    @Override
    <V> Input8<T1, T2, T3, T4, T5, T6, V, T8> compose7(final Transformer1<? super V, ? extends T7> before);

    @Override
    <V> Input8<T1, T2, T3, T4, T5, V, T7, T8> compose6(final Transformer1<? super V, ? extends T6> before);

    @Override
    <V> Input8<T1, T2, T3, T4, V, T6, T7, T8> compose5(final Transformer1<? super V, ? extends T5> before);

    @Override
    <V> Input8<T1, T2, T3, V, T5, T6, T7, T8> compose4(final Transformer1<? super V, ? extends T4> before);

    @Override
    <V> Input8<T1, T2, V, T4, T5, T6, T7, T8> compose3(final Transformer1<? super V, ? extends T3> before);

    @Override
    <V> Input8<T1, V, T3, T4, T5, T6, T7, T8> compose2(final Transformer1<? super V, ? extends T2> before);

    @Override
    <V> Input8<V, T2, T3, T4, T5, T6, T7, T8> compose1(final Transformer1<? super V, ? extends T1> before);

    /**
     * Returns an object whose seventh and eighth inputs are swapped such that
     * the eighth input is now the seventh input and vice versa.
     *
     * @return an object whose seventh and eighth inputs are swapped
     */
    Input8<T1, T2, T3, T4, T5, T6, T8, T7> swap7();

    @Override
    Input8<T1, T2, T3, T4, T5, T7, T6, T8> swap6();

    @Override
    Input8<T1, T2, T3, T4, T6, T5, T7, T8> swap5();

    @Override
    Input8<T1, T2, T3, T5, T4, T6, T7, T8> swap4();

    @Override
    Input8<T1, T2, T4, T3, T5, T6, T7, T8> swap3();

    @Override
    Input8<T1, T3, T2, T4, T5, T6, T7, T8> swap2();

    @Override
    Input8<T2, T1, T3, T4, T5, T6, T7, T8> swap1();

    /**
     * Fixes the eighth input to some value to produce an object with one fewer
     * input.
     *
     * @param t8 the eighth input
     * @return an object with one fewer input
     * @see <a href="https://en.wikipedia.org/wiki/Partial_application">Partial Application</a>
     */
    Input7<T1, T2, T3, T4, T5, T6, T7> partial8(final T8 t8);

    @Override
    Input7<T1, T2, T3, T4, T5, T6, T8> partial7(final T7 t7);

    @Override
    Input7<T1, T2, T3, T4, T5, T7, T8> partial6(final T6 t6);

    @Override
    Input7<T1, T2, T3, T4, T6, T7, T8> partial5(final T5 t5);

    @Override
    Input7<T1, T2, T3, T5, T6, T7, T8> partial4(final T4 t4);

    @Override
    Input7<T1, T2, T4, T5, T6, T7, T8> partial3(final T3 t3);

    @Override
    Input7<T1, T3, T4, T5, T6, T7, T8> partial2(final T2 t2);

    @Override
    Input7<T2, T3, T4, T5, T6, T7, T8> partial1(final T1 t1);
}
