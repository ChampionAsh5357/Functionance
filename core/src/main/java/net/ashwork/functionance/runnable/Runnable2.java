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
import net.ashwork.functionance.Function2;
import net.ashwork.functionance.partial.input.Input2;
import net.ashwork.functionance.partial.result.Chain;
import net.ashwork.functionance.partial.result.Default;
import net.ashwork.functionance.partial.task.Task2;
import net.ashwork.functionance.partial.transformer.Transformer1;

import java.util.Objects;

/**
 * Represents an operation that accepts two arguments and returns no result.
 *
 * <p>This is a functional interface whose functional method is
 * {@link #run2(Object, Object)}.
 *
 * @param <T1> the type of the first argument to the operation
 * @param <T2> the type of the second argument to the operation
 * @since 1.0.0
 */
@FunctionalInterface
public interface Runnable2<T1, T2> extends Input2<T1, T2>, Task2<T1, T2>, Chain<Runnable2<T1, T2>>, Default<Runnable2<T1, T2>> {

    /**
     * @throws NullPointerException if the {@code before} transformer is {@code null}
     */
    @Override
    default <V> Runnable2<T1, V> compose2(final Transformer1<? super V, ? extends T2> before) {
        Objects.requireNonNull(before, "The before transformer cannot be null");
        return (t1, v) -> this.run2(t1, before.apply1(v));
    }

    /**
     * @throws NullPointerException if the {@code before} transformer is {@code null}
     */
    @Override
    default <V> Runnable2<V, T2> compose1(final Transformer1<? super V, ? extends T1> before) {
        Objects.requireNonNull(before, "The before transformer cannot be null");
        return (v, t2) -> this.run2(before.apply1(v), t2);
    }

    /**
     * @throws NullPointerException if the exception handler or defaulted operation are {@code null}
     */
    @Override
    default Runnable2<T1, T2> handle(final Transformer1<Throwable, Runnable2<T1, T2>> exceptionHandler) {
        Objects.requireNonNull(exceptionHandler, "The exception handler of the operation cannot be null");
        return (t1, t2) -> {
            try {
                this.run2(t1, t2);
            } catch (final Throwable t) {
                Objects.requireNonNull(exceptionHandler.apply1(t), "The defaulted operation cannot be null").run2(t1, t2);
            }
        };
    }

    /**
     * @throws NullPointerException if the {@code after} operation is {@code null}
     */
    @Override
    default Runnable2<T1, T2> andThen(final Runnable2<T1, T2> after) {
        Objects.requireNonNull(after, "The after operation cannot be null");
        return (t1, t2) -> {
            this.run2(t1, t2);
            after.run2(t1, t2);
        };
    }

    /**
     * @throws NullPointerException if the {@code after} transformer is {@code null}
     * @see Function2
     */
    @Override
    default <V> Function2<T1, T2, V> andThen(final Transformer1<? super Void, ? extends V> after) {
        Objects.requireNonNull(after, "The after transformer cannot be null");
        return (t1, t2) -> after.apply1(this.apply2(t1, t2));
    }

    @Override
    default Runnable2<T2, T1> swap1() {
        return (t2, t1) -> this.run2(t1, t2);
    }

    @Override
    default Runnable1<T1> partial2(final T2 t2) {
        return t1 -> this.run2(t1, t2);
    }

    @Override
    default Runnable1<T2> partial1(final T1 t1) {
        return t2 -> this.run2(t1, t2);
    }

    /**
     * Constructs an operation of one arity higher where this operation can be
     * arbitrarily executed within the new operation.
     *
     * @param addend the transformer to create the new operation from this operation
     * @param <T3> the type of the third argument to the new operation
     * @return an operation of one arity higher
     * @throws NullPointerException if the {@code addend} transformer is {@code null}
     * @see Runnable3
     */
    default <T3> Runnable3<T1, T2, T3> append(final Transformer1<Runnable2<T1, T2>, Runnable3<T1, T2, T3>> addend) {
        Objects.requireNonNull(addend, "The addend transformer cannot be null");
        return addend.apply1(this);
    }

    /**
     * Converts this operation into a sequence of operations that each take in
     * a single argument.
     *
     * @return a sequence of operations that each take in a single argument
     * @see <a href="https://en.wikipedia.org/wiki/Currying">Currying</a>
     */
    default Function1<T1, Runnable1<T2>> curry() {
        return t1 -> t2-> this.run2(t1, t2);
    }
}
