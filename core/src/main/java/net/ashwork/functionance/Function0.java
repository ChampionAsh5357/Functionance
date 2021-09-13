/*
 * Functionance
 * Copyright (c) 2021-2021 ChampionAsh5357.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package net.ashwork.functionance;

import net.ashwork.functionance.partial.transformer.Transformer0;
import net.ashwork.functionance.partial.transformer.Transformer1;
import net.ashwork.functionance.partial.input.Input0;
import net.ashwork.functionance.partial.result.Consume;
import net.ashwork.functionance.partial.result.Default;
import net.ashwork.functionance.partial.result.Result;
import net.ashwork.functionance.runnable.Runnable0;

import java.util.Objects;

/**
 * Represents a function that accepts no arguments and produces a result.
 *
 * <p>This is a functional interface whose functional method is
 * {@link #apply0()}.
 *
 * @param <R> the type of the result of the function
 * @since 1.0.0
 */
@FunctionalInterface
public interface Function0<R> extends Input0, Transformer0<R>, Result<R>, Default<Function0<R>>, Consume<Runnable0> {

    /**
     * @throws NullPointerException if the exception handler or defaulted function are {@code null}
     */
    @Override
    default Function0<R> handle(final Transformer1<Throwable, Function0<R>> exceptionHandler) {
        Objects.requireNonNull(exceptionHandler, "The exception handler of the function cannot be null");
        return () -> {
            try {
                return this.apply0();
            } catch (final Throwable t) {
                return Objects.requireNonNull(exceptionHandler.apply1(t), "The defaulted function cannot be null").apply0();
            }
        };
    }

    /**
     * @throws NullPointerException if the {@code after} transformer is {@code null}
     */
    @Override
    default <V> Function0<V> andThen(final Transformer1<? super R, ? extends V> after) {
        Objects.requireNonNull(after, "The after transformer cannot be null");
        return () -> after.apply1(this.apply0());
    }

    /**
     * @see Runnable0
     */
    @Override
    default Runnable0 consume() {
        return this::apply0;
    }

    /**
     * Constructs a function of one arity higher where this function can be
     * arbitrarily executed within the new function.
     *
     * @param addend the transformer to create the new function from this function
     * @param <T1> the type of the first argument to the new function
     * @return a function of one arity higher
     * @throws NullPointerException if the {@code addend} transformer is {@code null}
     * @see Function1
     */
    default <T1> Function1<T1, R> append(final Transformer1<Function0<R>, Function1<T1, R>> addend) {
        Objects.requireNonNull(addend, "The addend transformer cannot be null");
        return addend.apply1(this);
    }
}
