/*
 * Functionance
 * Copyright (c) 2021-2021 ChampionAsh5357.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package net.ashwork.functionance.partial.result;

/**
 * Defines that the implementing object has a type which can be continually
 * chained to itself.
 *
 * @param <C> the type of the implementing object
 * @since 1.0.0
 */
public interface Chain<C> extends Result<Void> {

    /**
     * Returns an object such that this object and the {@code after} task
     * can be performed in sequence.
     *
     * @param after the task to perform after this object
     * @return an object that performs, in sequence, this object followed by
     *         the {@code after} task
     */
    C andThen(final C after);
}
