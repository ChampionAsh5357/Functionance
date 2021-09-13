/*
 * Functionance
 * Copyright (c) 2021-2021 ChampionAsh5357.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package net.ashwork.functionance.partial.input;

/**
 * Defines that the implementing object takes in a certain number of
 * arguments or operands.
 *
 * @since 1.0.0
 */
public interface Arity {

    /**
     * Returns the number of arguments or operands of the implementing
     * object.
     *
     * @return the number of arguments or operands of the implementing
     *         object
     */
    int arity();
}
