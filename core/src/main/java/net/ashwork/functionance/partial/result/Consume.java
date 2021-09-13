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
 * Defines that the implementing object has a result which can be neglected
 * or consumed.
 *
 * @param <R> the type of the consumed version of the implementing object
 * @since 1.0.0
 */
public interface Consume<R> {

    /**
     * Returns the consumed version of the implementing object.
     *
     * @return the consumed version of the implementing object.
     */
    R consume();
}
