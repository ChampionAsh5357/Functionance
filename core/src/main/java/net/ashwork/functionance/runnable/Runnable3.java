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
import net.ashwork.functionance.Function3;
import net.ashwork.functionance.partial.input.Input3;
import net.ashwork.functionance.partial.result.Chain;
import net.ashwork.functionance.partial.result.Default;
import net.ashwork.functionance.partial.task.Task3;
import net.ashwork.functionance.partial.transformer.Transformer1;

import java.util.Objects;

/**
 * Represents an operation that accepts three arguments and returns no result.
 *
 * <p>This is a functional interface whose functional method is
 * {@link #run3(Object, Object, Object)}.
 *
 * @param <T1> the type of the first argument to the operation
 * @param <T2> the type of the second argument to the operation
 * @param <T3> the type of the third argument to the operation
 * @since 1.0.0
 */
@FunctionalInterface
public interface Runnable3<T1, T2, T3> extends Input3<T1, T2, T3>, Task3<T1, T2, T3>, Chain<Runnable3<T1, T2, T3>>, Default<Runnable3<T1, T2, T3>> {

    /**
     * @throws NullPointerException if the {@code before} transformer is {@code null}
     */
    @Override
    default <V> Runnable3<T1, T2, V> compose3(final Transformer1<? super V, ? extends T3> before) {
        Objects.requireNonNull(before, "The before transformer cannot be null");
        return (t1, t2, v) -> this.run3(t1, t2, before.apply1(v));
    }

    /**
     * @throws NullPointerException if the {@code before} transformer is {@code null}
     */
    @Override
    default <V> Runnable3<T1, V, T3> compose2(final Transformer1<? super V, ? extends T2> before) {
        Objects.requireNonNull(before, "The before transformer cannot be null");
        return (t1, v, t3) -> this.run3(t1, before.apply1(v), t3);
    }

    /**
     * @throws NullPointerException if the {@code before} transformer is {@code null}
     */
    @Override
    default <V> Runnable3<V, T2, T3> compose1(final Transformer1<? super V, ? extends T1> before) {
        Objects.requireNonNull(before, "The before transformer cannot be null");
        return (v, t2, t3) -> this.run3(before.apply1(v), t2, t3);
    }

    /**
     * @throws NullPointerException if the exception handler or defaulted operation are {@code null}
     */
    @Override
    default Runnable3<T1, T2, T3> handle(final Transformer1<Throwable, Runnable3<T1, T2, T3>> exceptionHandler) {
        Objects.requireNonNull(exceptionHandler, "The exception handler of the operation cannot be null");
        return (t1, t2, t3) -> {
            try {
                this.run3(t1, t2, t3);
            } catch (final Throwable t) {
                Objects.requireNonNull(exceptionHandler.apply1(t), "The defaulted operation cannot be null").run3(t1, t2, t3);
            }
        };
    }

    /**
     * @throws NullPointerException if the {@code after} operation is {@code null}
     */
    @Override
    default Runnable3<T1, T2, T3> andThen(final Runnable3<T1, T2, T3> after) {
        Objects.requireNonNull(after, "The after operation cannot be null");
        return (t1, t2, t3) -> {
            this.run3(t1, t2, t3);
            after.run3(t1, t2, t3);
        };
    }

    /**
     * @throws NullPointerException if the {@code after} transformer is {@code null}
     * @see Function3
     */
    @Override
    default <V> Function3<T1, T2, T3, V> andThen(final Transformer1<? super Void, ? extends V> after) {
        Objects.requireNonNull(after, "The after transformer cannot be null");
        return (t1, t2, t3) -> after.apply1(this.apply3(t1, t2, t3));
    }

    @Override
    default Runnable3<T1, T3, T2> swap2() {
        return (t1, t3, t2) -> this.run3(t1, t2, t3);
    }

    @Override
    default Runnable3<T2, T1, T3> swap1() {
        return (t2, t1, t3) -> this.run3(t1, t2, t3);
    }

    @Override
    default Runnable2<T1, T2> partial3(final T3 t3) {
        return (t1, t2) -> this.run3(t1, t2, t3);
    }

    @Override
    default Runnable2<T1, T3> partial2(final T2 t2) {
        return (t1, t3) -> this.run3(t1, t2, t3);
    }

    @Override
    default Runnable2<T2, T3> partial1(final T1 t1) {
        return (t2, t3) -> this.run3(t1, t2, t3);
    }

    /**
     * Constructs an operation of one arity higher where this operation can be
     * arbitrarily executed within the new operation.
     *
     * @param addend the transformer to create the new operation from this operation
     * @param <T4> the type of the fourth argument to the new operation
     * @return an operation of one arity higher
     * @throws NullPointerException if the {@code addend} transformer is {@code null}
     * @see Runnable4
     */
    default <T4> Runnable4<T1, T2, T3, T4> append(final Transformer1<Runnable3<T1, T2, T3>, Runnable4<T1, T2, T3, T4>> addend) {
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
    default Function1<T1, Function1<T2, Runnable1<T3>>> curry() {
        return t1 -> t2 -> t3 -> this.run3(t1, t2, t3);
    }

    /**
     * Converts this operation into a sequence of two operations with each taking
     * one or two arguments respectively.
     *
     * @return a sequence of two operations
     * @see <a href="https://en.wikipedia.org/wiki/Currying">Currying</a>
     */
    default Function1<T1, Runnable2<T2, T3>> curry1() {
        return t1 -> (t2, t3) -> this.run3(t1, t2, t3);
    }

    /**
     * Converts this operation into a sequence of two operations with each taking
     * two or one arguments respectively.
     *
     * @return a sequence of two operations
     * @see <a href="https://en.wikipedia.org/wiki/Currying">Currying</a>
     */
    default Function2<T1, T2, Runnable1<T3>> curry2() {
        return (t1, t2) -> t3 -> this.run3(t1, t2, t3);
    }
}
