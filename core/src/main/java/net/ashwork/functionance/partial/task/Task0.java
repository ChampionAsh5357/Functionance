/*
 * Functionance
 * Copyright (c) 2021-2021 ChampionAsh5357.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package net.ashwork.functionance.partial.task;

import net.ashwork.functionance.partial.transformer.Transformer0;

/**
 * Represents a task that accepts no arguments.
 * This also can provide defaulting behavior for any higher arity tasks.
 *
 * <p>This is a functional interface whose functional method is
 * {@link #run0()}.
 *
 * @since 1.0.0
 */
@FunctionalInterface
public interface Task0 extends Transformer0<Void>, Task1<Object> {

    /**
     * Performs this task.
     */
    void run0();

    @Override
    default void run1(final Object o) {
        this.run0();
    }

    @Override
    default Void apply0() {
        this.run0();
        return null;
    }

    @Override
    default Void apply1(final Object o) {
        return Transformer0.super.apply1(o);
    }
}
