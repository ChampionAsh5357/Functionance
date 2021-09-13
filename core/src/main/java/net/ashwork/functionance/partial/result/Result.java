/*
 * Functionance
 * Copyright (c) 2021-2021 ChampionAsh5357.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package net.ashwork.functionance.partial.result;

import net.ashwork.functionance.partial.transformer.Transformer1;

/**
 * Defines that the implementing object has a definite result as the output
 * of some algorithm.
 *
 * @param <R> the type of the result of the implementing object
 * @since 1.0.0
 */
public interface Result<R> {

    /**
     * Returns an object that applies {@code after} transformer to the result
     * lazily such that the resulting behavior is chained to the new result type.
     *
     * @param after the transformer to apply after this object
     * @param <V> the type of the result to the {@code after} transformer, and
     *            then to the resulting object
     * @return an object whose result is the new result type
     */
    <V> Result<V> andThen(final Transformer1<? super R, ? extends V> after);
}
