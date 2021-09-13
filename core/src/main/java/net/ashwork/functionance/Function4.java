/*
 * Functionance
 * Copyright (c) 2021-2021 ChampionAsh5357.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package net.ashwork.functionance;

import net.ashwork.functionance.partial.input.Input4;
import net.ashwork.functionance.partial.result.Consume;
import net.ashwork.functionance.partial.result.Default;
import net.ashwork.functionance.partial.result.Result;
import net.ashwork.functionance.partial.transformer.Transformer1;
import net.ashwork.functionance.partial.transformer.Transformer4;
import net.ashwork.functionance.runnable.Runnable4;

import java.util.Objects;

/**
 * Represents a function that accepts four arguments and produces a result.
 *
 * <p>This is a functional interface whose functional method is
 * {@link #apply4(Object, Object, Object, Object)}.
 *
 * @param <T1> the type of the first argument to the function
 * @param <T2> the type of the second argument to the function
 * @param <T3> the type of the third argument to the function
 * @param <T4> the type of the fourth argument to the function
 * @param <R> the type of the result of the function
 * @since 1.0.0
 */
@FunctionalInterface
public interface Function4<T1, T2, T3, T4, R> extends Input4<T1, T2, T3, T4>, Transformer4<T1, T2, T3, T4, R>, Result<R>, Default<Function4<T1, T2, T3, T4, R>>, Consume<Runnable4<T1, T2, T3, T4>> {

    /**
     * @throws NullPointerException if the {@code before} transformer is {@code null}
     */
    @Override
    default <V> Function4<T1, T2, T3, V, R> compose4(final Transformer1<? super V, ? extends T4> before) {
        Objects.requireNonNull(before, "The before transformer cannot be null");
        return (t1, t2, t3, v) -> this.apply4(t1, t2, t3, before.apply1(v));
    }

    /**
     * @throws NullPointerException if the {@code before} transformer is {@code null}
     */
    @Override
    default <V> Function4<T1, T2, V, T4, R> compose3(final Transformer1<? super V, ? extends T3> before) {
        Objects.requireNonNull(before, "The before transformer cannot be null");
        return (t1, t2, v, t4) -> this.apply4(t1, t2, before.apply1(v), t4);
    }

    /**
     * @throws NullPointerException if the {@code before} transformer is {@code null}
     */
    @Override
    default <V> Function4<T1, V, T3, T4, R> compose2(final Transformer1<? super V, ? extends T2> before) {
        Objects.requireNonNull(before, "The before transformer cannot be null");
        return (t1, v, t3, t4) -> this.apply4(t1, before.apply1(v), t3, t4);
    }

    /**
     * @throws NullPointerException if the {@code before} transformer is {@code null}
     */
    @Override
    default <V> Function4<V, T2, T3, T4, R> compose1(final Transformer1<? super V, ? extends T1> before) {
        Objects.requireNonNull(before, "The before transformer cannot be null");
        return (v, t2, t3, t4) -> this.apply4(before.apply1(v), t2, t3, t4);
    }

    /**
     * @throws NullPointerException if the exception handler or defaulted function are {@code null}
     */
    @Override
    default Function4<T1, T2, T3, T4, R> handle(final Transformer1<Throwable, Function4<T1, T2, T3, T4, R>> exceptionHandler) {
        Objects.requireNonNull(exceptionHandler, "The exception handler of the function cannot be null");
        return (t1, t2, t3, t4) -> {
            try {
                return this.apply4(t1, t2, t3, t4);
            } catch (final Throwable t) {
                return Objects.requireNonNull(exceptionHandler.apply1(t), "The defaulted function cannot be null").apply4(t1, t2, t3, t4);
            }
        };
    }

    /**
     * @throws NullPointerException if the {@code after} transformer is {@code null}
     */
    @Override
    default <V> Function4<T1, T2, T3, T4, V> andThen(final Transformer1<? super R, ? extends V> after) {
        Objects.requireNonNull(after, "The after transformer cannot be null");
        return (t1, t2, t3, t4) -> after.apply1(this.apply4(t1, t2, t3, t4));
    }

    @Override
    default Function4<T1, T2, T4, T3, R> swap3() {
        return (t1, t2, t4, t3) -> this.apply4(t1, t2, t3, t4);
    }

    @Override
    default Function4<T1, T3, T2, T4, R> swap2() {
        return (t1, t3, t2, t4) -> this.apply4(t1, t2, t3, t4);
    }

    @Override
    default Function4<T2, T1, T3, T4, R> swap1() {
        return (t2, t1, t3, t4) -> this.apply4(t1, t2, t3, t4);
    }

    /**
     * @see Runnable4
     */
    @Override
    default Runnable4<T1, T2, T3, T4> consume() {
        return this::apply4;
    }

    @Override
    default Function3<T1, T2, T3, R> partial4(final T4 t4) {
        return (t1, t2, t3) -> this.apply4(t1, t2, t3, t4);
    }

    @Override
    default Function3<T1, T2, T4, R> partial3(final T3 t3) {
        return (t1, t2, t4) -> this.apply4(t1, t2, t3, t4);
    }

    @Override
    default Function3<T1, T3, T4, R> partial2(final T2 t2) {
        return (t1, t3, t4) -> this.apply4(t1, t2, t3, t4);
    }

    @Override
    default Function3<T2, T3, T4, R> partial1(final T1 t1) {
        return (t2, t3, t4) -> this.apply4(t1, t2, t3, t4);
    }

    /**
     * Constructs a function of one arity higher where this function can be
     * arbitrarily executed within the new function.
     *
     * @param addend the transformer to create the new function from this function
     * @param <T5> the type of the fifth argument to the new function
     * @return a function of one arity higher
     * @throws NullPointerException if the {@code addend} transformer is {@code null}
     * @see Function5
     */
    default <T5> Function5<T1, T2, T3, T4, T5, R> append(final Transformer1<Function4<T1, T2, T3, T4, R>, Function5<T1, T2, T3, T4, T5, R>> addend) {
        Objects.requireNonNull(addend, "The addend transformer cannot be null");
        return addend.apply1(this);
    }

    /**
     * Converts this function into a sequence of functions that each take in
     * a single argument.
     *
     * @return a sequence of functions that each take in a single argument
     * @see <a href="https://en.wikipedia.org/wiki/Currying">Currying</a>
     */
    default Function1<T1, Function1<T2, Function1<T3, Function1<T4, R>>>> curry() {
        return t1 -> t2 -> t3 -> t4 -> this.apply4(t1, t2, t3, t4);
    }

    /**
     * Converts this function into a sequence of two functions with each taking
     * one or three arguments respectively.
     *
     * @return a sequence of two functions
     * @see <a href="https://en.wikipedia.org/wiki/Currying">Currying</a>
     */
    default Function1<T1, Function3<T2, T3, T4, R>> curry1() {
        return t1 -> (t2, t3, t4) -> this.apply4(t1, t2, t3, t4);
    }

    /**
     * Converts this function into a sequence of two functions with each taking
     * two arguments respectively.
     *
     * @return a sequence of two functions
     * @see <a href="https://en.wikipedia.org/wiki/Currying">Currying</a>
     */
    default Function2<T1, T2, Function2<T3, T4, R>> curry2() {
        return (t1, t2) -> (t3, t4) -> this.apply4(t1, t2, t3, t4);
    }

    /**
     * Converts this function into a sequence of two functions with each taking
     * three or one argument respectively.
     *
     * @return a sequence of two functions
     * @see <a href="https://en.wikipedia.org/wiki/Currying">Currying</a>
     */
    default Function3<T1, T2, T3, Function1<T4, R>> curry3() {
        return (t1, t2, t3) -> t4 -> this.apply4(t1, t2, t3, t4);
    }
}
