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
 * Defines that the implementing object takes in seven arguments which
 * can be lazily operated on or swapped.
 *
 * @see Arity
 * @since 1.0.0
 */
public interface Input7<T1, T2, T3, T4, T5, T6, T7> extends Input6<T1, T2, T3, T4, T5, T6> {

    @Override
    default int arity() {
        return 7;
    }

    /**
     * Returns an object that applies the {@code before} transformer to the
     * seventh input lazily such that the resulting behavior is chained from
     * the new input type.
     *
     * @param before the transformer to apply before this object
     * @param <V> the type of the input to the {@code before} transformer, and
     *            then to the resulting object
     * @return an object whose seventh input is the new input type
     */
    <V> Input7<T1, T2, T3, T4, T5, T6, V> compose7(final Transformer1<? super V, ? extends T7> before);

    @Override
    <V> Input7<T1, T2, T3, T4, T5, V, T7> compose6(final Transformer1<? super V, ? extends T6> before);

    @Override
    <V> Input7<T1, T2, T3, T4, V, T6, T7> compose5(final Transformer1<? super V, ? extends T5> before);

    @Override
    <V> Input7<T1, T2, T3, V, T5, T6, T7> compose4(final Transformer1<? super V, ? extends T4> before);

    @Override
    <V> Input7<T1, T2, V, T4, T5, T6, T7> compose3(final Transformer1<? super V, ? extends T3> before);

    @Override
    <V> Input7<T1, V, T3, T4, T5, T6, T7> compose2(final Transformer1<? super V, ? extends T2> before);

    @Override
    <V> Input7<V, T2, T3, T4, T5, T6, T7> compose1(final Transformer1<? super V, ? extends T1> before);

    /**
     * Returns an object whose sixth and seventh inputs are swapped such that
     * the seventh input is now the sixth input and vice versa.
     *
     * @return an object whose sixth and seventh inputs are swapped
     */
    Input7<T1, T2, T3, T4, T5, T7, T6> swap6();

    @Override
    Input7<T1, T2, T3, T4, T6, T5, T7> swap5();

    @Override
    Input7<T1, T2, T3, T5, T4, T6, T7> swap4();

    @Override
    Input7<T1, T2, T4, T3, T5, T6, T7> swap3();

    @Override
    Input7<T1, T3, T2, T4, T5, T6, T7> swap2();

    @Override
    Input7<T2, T1, T3, T4, T5, T6, T7> swap1();

    /**
     * Fixes the seventh input to some value to produce an object with one fewer
     * input.
     *
     * @param t7 the seventh input
     * @return an object with one fewer input
     * @see <a href="https://en.wikipedia.org/wiki/Partial_application">Partial Application</a>
     */
    Input6<T1, T2, T3, T4, T5, T6> partial7(final T7 t7);

    @Override
    Input6<T1, T2, T3, T4, T5, T7> partial6(final T6 t6);

    @Override
    Input6<T1, T2, T3, T4, T6, T7> partial5(final T5 t5);

    @Override
    Input6<T1, T2, T3, T5, T6, T7> partial4(final T4 t4);

    @Override
    Input6<T1, T2, T4, T5, T6, T7> partial3(final T3 t3);

    @Override
    Input6<T1, T3, T4, T5, T6, T7> partial2(final T2 t2);

    @Override
    Input6<T2, T3, T4, T5, T6, T7> partial1(final T1 t1);
}
