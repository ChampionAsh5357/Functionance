/*
 * Functionance
 * Copyright (c) 2021-2021 ChampionAsh5357.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package net.ashwork.functionance.runnable;

import net.ashwork.functionance.Function1;
import net.ashwork.functionance.partial.input.Input1;
import net.ashwork.functionance.partial.result.Chain;
import net.ashwork.functionance.partial.result.Default;
import net.ashwork.functionance.partial.task.Task1;
import net.ashwork.functionance.partial.transformer.Transformer1;

import java.util.Objects;

/**
 * Represents an operation that accepts one argument and returns no result.
 *
 * <p>This is a functional interface whose functional method is
 * {@link #run1(Object)}.
 *
 * @param <T1> the type of the first argument to the operation
 * @since 1.0.0
 */
@FunctionalInterface
public interface Runnable1<T1> extends Input1<T1>, Task1<T1>, Chain<Runnable1<T1>>, Default<Runnable1<T1>> {

    /**
     * @throws NullPointerException if the {@code before} transformer is {@code null}
     */
    @Override
    default <V> Runnable1<V> compose1(final Transformer1<? super V, ? extends T1> before) {
        Objects.requireNonNull(before, "The before transformer cannot be null");
        return v -> this.run1(before.apply1(v));
    }

    /**
     * @throws NullPointerException if the exception handler or defaulted operation are {@code null}
     */
    @Override
    default Runnable1<T1> handle(final Transformer1<Throwable, Runnable1<T1>> exceptionHandler) {
        Objects.requireNonNull(exceptionHandler, "The exception handler of the operation cannot be null");
        return t1 -> {
            try {
                this.run1(t1);
            } catch (final Throwable t) {
                Objects.requireNonNull(exceptionHandler.apply1(t), "The defaulted operation cannot be null").run1(t1);
            }
        };
    }

    /**
     * @throws NullPointerException if the {@code after} operation is {@code null}
     */
    @Override
    default Runnable1<T1> andThen(final Runnable1<T1> after) {
        Objects.requireNonNull(after, "The after operation cannot be null");
        return t1 -> {
            this.run1(t1);
            after.run1(t1);
        };
    }

    /**
     * @throws NullPointerException if the {@code after} transformer is {@code null}
     * @see Function1
     */
    @Override
    default <V> Function1<T1, V> andThen(final Transformer1<? super Void, ? extends V> after) {
        Objects.requireNonNull(after, "The after transformer cannot be null");
        return t1 -> after.apply1(this.apply1(t1));
    }

    @Override
    default Runnable0 partial1(final T1 t1) {
        return () -> this.run1(t1);
    }

    /**
     * Constructs an operation of one arity higher where this operation can be
     * arbitrarily executed within the new operation.
     *
     * @param addend the transformer to create the new operation from this operation
     * @param <T2> the type of the second argument to the new operation
     * @return an operation of one arity higher
     * @throws NullPointerException if the {@code addend} transformer is {@code null}
     * @see Runnable2
     */
    default <T2> Runnable2<T1, T2> append(final Transformer1<Runnable1<T1>, Runnable2<T1, T2>> addend) {
        Objects.requireNonNull(addend, "The addend transformer cannot be null");
        return addend.apply1(this);
    }
}
