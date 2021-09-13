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
import net.ashwork.functionance.Function4;
import net.ashwork.functionance.partial.input.Input4;
import net.ashwork.functionance.partial.result.Chain;
import net.ashwork.functionance.partial.result.Default;
import net.ashwork.functionance.partial.task.Task4;
import net.ashwork.functionance.partial.transformer.Transformer1;

import java.util.Objects;

/**
 * Represents an operation that accepts four arguments and returns no result.
 *
 * <p>This is a functional interface whose functional method is
 * {@link #run4(Object, Object, Object, Object)}.
 *
 * @param <T1> the type of the first argument to the operation
 * @param <T2> the type of the second argument to the operation
 * @param <T3> the type of the third argument to the operation
 * @param <T4> the type of the fourth argument to the operation
 * @since 1.0.0
 */
@FunctionalInterface
public interface Runnable4<T1, T2, T3, T4> extends Input4<T1, T2, T3, T4>, Task4<T1, T2, T3, T4>, Chain<Runnable4<T1, T2, T3, T4>>, Default<Runnable4<T1, T2, T3, T4>> {

    /**
     * @throws NullPointerException if the {@code before} transformer is {@code null}
     */
    @Override
    default <V> Runnable4<T1, T2, T3, V> compose4(final Transformer1<? super V, ? extends T4> before) {
        Objects.requireNonNull(before, "The before transformer cannot be null");
        return (t1, t2, t3, v) -> this.run4(t1, t2, t3, before.apply1(v));
    }

    /**
     * @throws NullPointerException if the {@code before} transformer is {@code null}
     */
    @Override
    default <V> Runnable4<T1, T2, V, T4> compose3(final Transformer1<? super V, ? extends T3> before) {
        Objects.requireNonNull(before, "The before transformer cannot be null");
        return (t1, t2, v, t4) -> this.run4(t1, t2, before.apply1(v), t4);
    }

    /**
     * @throws NullPointerException if the {@code before} transformer is {@code null}
     */
    @Override
    default <V> Runnable4<T1, V, T3, T4> compose2(final Transformer1<? super V, ? extends T2> before) {
        Objects.requireNonNull(before, "The before transformer cannot be null");
        return (t1, v, t3, t4) -> this.run4(t1, before.apply1(v), t3, t4);
    }

    /**
     * @throws NullPointerException if the {@code before} transformer is {@code null}
     */
    @Override
    default <V> Runnable4<V, T2, T3, T4> compose1(final Transformer1<? super V, ? extends T1> before) {
        Objects.requireNonNull(before, "The before transformer cannot be null");
        return (v, t2, t3, t4) -> this.run4(before.apply1(v), t2, t3, t4);
    }

    /**
     * @throws NullPointerException if the exception handler or defaulted operation are {@code null}
     */
    @Override
    default Runnable4<T1, T2, T3, T4> handle(final Transformer1<Throwable, Runnable4<T1, T2, T3, T4>> exceptionHandler) {
        Objects.requireNonNull(exceptionHandler, "The exception handler of the operation cannot be null");
        return (t1, t2, t3, t4) -> {
            try {
                this.run4(t1, t2, t3, t4);
            } catch (final Throwable t) {
                Objects.requireNonNull(exceptionHandler.apply1(t), "The defaulted operation cannot be null").run4(t1, t2, t3, t4);
            }
        };
    }

    /**
     * @throws NullPointerException if the {@code after} operation is {@code null}
     */
    @Override
    default Runnable4<T1, T2, T3, T4> andThen(final Runnable4<T1, T2, T3, T4> after) {
        Objects.requireNonNull(after, "The after function operation be null");
        return (t1, t2, t3, t4) -> {
            this.run4(t1, t2, t3, t4);
            after.run4(t1, t2, t3, t4);
        };
    }

    /**
     * @throws NullPointerException if the {@code after} transformer is {@code null}
     * @see Function4
     */
    @Override
    default <V> Function4<T1, T2, T3, T4, V> andThen(final Transformer1<? super Void, ? extends V> after) {
        Objects.requireNonNull(after, "The after transformer cannot be null");
        return (t1, t2, t3, t4) -> after.apply1(this.apply4(t1, t2, t3, t4));
    }

    @Override
    default Runnable4<T1, T2, T4, T3> swap3() {
        return (t1, t2, t4, t3) -> this.run4(t1, t2, t3, t4);
    }

    @Override
    default Runnable4<T1, T3, T2, T4> swap2() {
        return (t1, t3, t2, t4) -> this.run4(t1, t2, t3, t4);
    }

    @Override
    default Runnable4<T2, T1, T3, T4> swap1() {
        return (t2, t1, t3, t4) -> this.run4(t1, t2, t3, t4);
    }

    @Override
    default Runnable3<T1, T2, T3> partial4(final T4 t4) {
        return (t1, t2, t3) -> this.run4(t1, t2, t3, t4);
    }

    @Override
    default Runnable3<T1, T2, T4> partial3(final T3 t3) {
        return (t1, t2, t4) -> this.run4(t1, t2, t3, t4);
    }

    @Override
    default Runnable3<T1, T3, T4> partial2(final T2 t2) {
        return (t1, t3, t4) -> this.run4(t1, t2, t3, t4);
    }

    @Override
    default Runnable3<T2, T3, T4> partial1(final T1 t1) {
        return (t2, t3, t4) -> this.run4(t1, t2, t3, t4);
    }

    /**
     * Constructs an operation of one arity higher where this operation can be
     * arbitrarily executed within the new operation.
     *
     * @param addend the transformer to create the new operation from this operation
     * @param <T5> the type of the fifth argument to the new operation
     * @return an operation of one arity higher
     * @throws NullPointerException if the {@code addend} transformer is {@code null}
     * @see Runnable5
     */
    default <T5> Runnable5<T1, T2, T3, T4, T5> append(final Transformer1<Runnable4<T1, T2, T3, T4>, Runnable5<T1, T2, T3, T4, T5>> addend) {
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
    default Function1<T1, Function1<T2, Function1<T3, Runnable1<T4>>>> curry() {
        return t1 -> t2 -> t3 -> t4 -> this.run4(t1, t2, t3, t4);
    }

    /**
     * Converts this operation into a sequence of two operations with each taking
     * one or three arguments respectively.
     *
     * @return a sequence of two operations
     * @see <a href="https://en.wikipedia.org/wiki/Currying">Currying</a>
     */
    default Function1<T1, Runnable3<T2, T3, T4>> curry1() {
        return t1 -> (t2, t3, t4) -> this.run4(t1, t2, t3, t4);
    }

    /**
     * Converts this operation into a sequence of two operations with each taking
     * two arguments respectively.
     *
     * @return a sequence of two operations
     * @see <a href="https://en.wikipedia.org/wiki/Currying">Currying</a>
     */
    default Function2<T1, T2, Runnable2<T3, T4>> curry2() {
        return (t1, t2) -> (t3, t4) -> this.run4(t1, t2, t3, t4);
    }

    /**
     * Converts this operation into a sequence of two operations with each taking
     * three or one argument respectively.
     *
     * @return a sequence of two operations
     * @see <a href="https://en.wikipedia.org/wiki/Currying">Currying</a>
     */
    default Function3<T1, T2, T3, Runnable1<T4>> curry3() {
        return (t1, t2, t3) -> t4 -> this.run4(t1, t2, t3, t4);
    }
}
