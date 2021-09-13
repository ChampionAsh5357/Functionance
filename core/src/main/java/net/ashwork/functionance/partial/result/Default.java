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
 * Defines that the implementing object can handle and default to some behavior
 * when an exception is thrown.
 *
 * @param <H> the type of the implementing object which can default when necessary
 * @since 1.0.0
 */
public interface Default<H> {

    /**
     * Returns an object that handles a {@link Throwable} thrown by this
     * object if it cannot safely execute or perform its task.
     *
     * @param exceptionHandler the defaulting object to apply if a
     *                         {@link Throwable} is thrown
     * @return an object which can default when necessary
     */
    H handle(final Transformer1<Throwable, H> exceptionHandler);
}
