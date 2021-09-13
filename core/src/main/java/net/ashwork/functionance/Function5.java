/*
 * Functionance
 * Copyright (c) 2021-2021 ChampionAsh5357.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package net.ashwork.functionance;

import net.ashwork.functionance.partial.input.Input5;
import net.ashwork.functionance.partial.result.Consume;
import net.ashwork.functionance.partial.result.Default;
import net.ashwork.functionance.partial.result.Result;
import net.ashwork.functionance.partial.transformer.Transformer1;
import net.ashwork.functionance.partial.transformer.Transformer5;
import net.ashwork.functionance.runnable.Runnable5;

import java.util.Objects;

/**
 * Represents a function that accepts five arguments and produces a result.
 *
 * <p>This is a functional interface whose functional method is
 * {@link #apply5(Object, Object, Object, Object, Object)}.
 *
 * @param <T1> the type of the first argument to the function
 * @param <T2> the type of the second argument to the function
 * @param <T3> the type of the third argument to the function
 * @param <T4> the type of the fourth argument to the function
 * @param <T5> the type of the fifth argument to the function
 * @param <R> the type of the result of the function
 * @since 1.0.0
 */
@FunctionalInterface
public interface Function5<T1, T2, T3, T4, T5, R> extends Input5<T1, T2, T3, T4, T5>, Transformer5<T1, T2, T3, T4, T5, R>, Result<R>, Default<Function5<T1, T2, T3, T4, T5, R>>, Consume<Runnable5<T1, T2, T3, T4, T5>> {

    /**
     * @throws NullPointerException if the {@code before} transformer is {@code null}
     */
    @Override
    default <V> Function5<T1, T2, T3, T4, V, R> compose5(final Transformer1<? super V, ? extends T5> before) {
        Objects.requireNonNull(before, "The before transformer cannot be null");
        return (t1, t2, t3, t4, v) -> this.apply5(t1, t2, t3, t4, before.apply1(v));
    }

    /**
     * @throws NullPointerException if the {@code before} transformer is {@code null}
     */
    @Override
    default <V> Function5<T1, T2, T3, V, T5, R> compose4(final Transformer1<? super V, ? extends T4> before) {
        Objects.requireNonNull(before, "The before transformer cannot be null");
        return (t1, t2, t3, v, t5) -> this.apply5(t1, t2, t3, before.apply1(v), t5);
    }

    /**
     * @throws NullPointerException if the {@code before} transformer is {@code null}
     */
    @Override
    default <V> Function5<T1, T2, V, T4, T5, R> compose3(final Transformer1<? super V, ? extends T3> before) {
        Objects.requireNonNull(before, "The before transformer cannot be null");
        return (t1, t2, v, t4, t5) -> this.apply5(t1, t2, before.apply1(v), t4, t5);
    }

    /**
     * @throws NullPointerException if the {@code before} transformer is {@code null}
     */
    @Override
    default <V> Function5<T1, V, T3, T4, T5, R> compose2(final Transformer1<? super V, ? extends T2> before) {
        Objects.requireNonNull(before, "The before transformer cannot be null");
        return (t1, v, t3, t4, t5) -> this.apply5(t1, before.apply1(v), t3, t4, t5);
    }

    /**
     * @throws NullPointerException if the {@code before} transformer is {@code null}
     */
    @Override
    default <V> Function5<V, T2, T3, T4, T5, R> compose1(final Transformer1<? super V, ? extends T1> before) {
        Objects.requireNonNull(before, "The before transformer cannot be null");
        return (v, t2, t3, t4, t5) -> this.apply5(before.apply1(v), t2, t3, t4, t5);
    }

    /**
     * @throws NullPointerException if the exception handler or defaulted function are {@code null}
     */
    @Override
    default Function5<T1, T2, T3, T4, T5, R> handle(final Transformer1<Throwable, Function5<T1, T2, T3, T4, T5, R>> exceptionHandler) {
        Objects.requireNonNull(exceptionHandler, "The exception handler of the function cannot be null");
        return (t1, t2, t3, t4, t5) -> {
            try {
                return this.apply5(t1, t2, t3, t4, t5);
            } catch (final Throwable t) {
                return Objects.requireNonNull(exceptionHandler.apply1(t), "The defaulted function cannot be null").apply5(t1, t2, t3, t4, t5);
            }
        };
    }

    /**
     * @throws NullPointerException if the {@code after} transformer is {@code null}
     */
    @Override
    default <V> Function5<T1, T2, T3, T4, T5, V> andThen(final Transformer1<? super R, ? extends V> after) {
        Objects.requireNonNull(after, "The after transformer cannot be null");
        return (t1, t2, t3, t4, t5) -> after.apply1(this.apply5(t1, t2, t3, t4, t5));
    }

    @Override
    default Function5<T1, T2, T3, T5, T4, R> swap4() {
        return (t1, t2, t3, t5, t4) -> this.apply5(t1, t2, t3, t4, t5);
    }

    @Override
    default Function5<T1, T2, T4, T3, T5, R> swap3() {
        return (t1, t2, t4, t3, t5) -> this.apply5(t1, t2, t3, t4, t5);
    }

    @Override
    default Function5<T1, T3, T2, T4, T5, R> swap2() {
        return (t1, t3, t2, t4, t5) -> this.apply5(t1, t2, t3, t4, t5);
    }

    @Override
    default Function5<T2, T1, T3, T4, T5, R> swap1() {
        return (t2, t1, t3, t4, t5) -> this.apply5(t1, t2, t3, t4, t5);
    }

    /**
     * @see Runnable5
     */
    @Override
    default Runnable5<T1, T2, T3, T4, T5> consume() {
        return this::apply5;
    }

    @Override
    default Function4<T1, T2, T3, T4, R> partial5(final T5 t5) {
        return (t1, t2, t3, t4) -> this.apply5(t1, t2, t3, t4, t5);
    }

    @Override
    default Function4<T1, T2, T3, T5, R> partial4(final T4 t4) {
        return (t1, t2, t3, t5) -> this.apply5(t1, t2, t3, t4, t5);
    }

    @Override
    default Function4<T1, T2, T4, T5, R> partial3(final T3 t3) {
        return (t1, t2, t4, t5) -> this.apply5(t1, t2, t3, t4, t5);
    }

    @Override
    default Function4<T1, T3, T4, T5, R> partial2(final T2 t2) {
        return (t1, t3, t4, t5) -> this.apply5(t1, t2, t3, t4, t5);
    }

    @Override
    default Function4<T2, T3, T4, T5, R> partial1(final T1 t1) {
        return (t2, t3, t4, t5) -> this.apply5(t1, t2, t3, t4, t5);
    }

    /**
     * Constructs a function of one arity higher where this function can be
     * arbitrarily executed within the new function.
     *
     * @param addend the transformer to create the new function from this function
     * @param <T6> the type of the sixth argument to the new function
     * @return a function of one arity higher
     * @throws NullPointerException if the {@code addend} transformer is {@code null}
     * @see Function6
     */
    default <T6> Function6<T1, T2, T3, T4, T5, T6, R> append(final Transformer1<Function5<T1, T2, T3, T4, T5, R>, Function6<T1, T2, T3, T4, T5, T6, R>> addend) {
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
    default Function1<T1, Function1<T2, Function1<T3, Function1<T4, Function1<T5, R>>>>> curry() {
        return t1 -> t2 -> t3 -> t4 -> t5 -> this.apply5(t1, t2, t3, t4, t5);
    }

    /**
     * Converts this function into a sequence of two functions with each taking
     * one or four arguments respectively.
     *
     * @return a sequence of two functions
     * @see <a href="https://en.wikipedia.org/wiki/Currying">Currying</a>
     */
    default Function1<T1, Function4<T2, T3, T4, T5, R>> curry1() {
        return t1 -> (t2, t3, t4, t5) -> this.apply5(t1, t2, t3, t4, t5);
    }

    /**
     * Converts this function into a sequence of two functions with each taking
     * two or three arguments respectively.
     *
     * @return a sequence of two functions
     * @see <a href="https://en.wikipedia.org/wiki/Currying">Currying</a>
     */
    default Function2<T1, T2, Function3<T3, T4, T5, R>> curry2() {
        return (t1, t2) -> (t3, t4, t5) -> this.apply5(t1, t2, t3, t4, t5);
    }

    /**
     * Converts this function into a sequence of two functions with each taking
     * three or two arguments respectively.
     *
     * @return a sequence of two functions
     * @see <a href="https://en.wikipedia.org/wiki/Currying">Currying</a>
     */
    default Function3<T1, T2, T3, Function2<T4, T5, R>> curry3() {
        return (t1, t2, t3) -> (t4, t5) -> this.apply5(t1, t2, t3, t4, t5);
    }

    /**
     * Converts this function into a sequence of two functions with each taking
     * four or one argument respectively.
     *
     * @return a sequence of two functions
     * @see <a href="https://en.wikipedia.org/wiki/Currying">Currying</a>
     */
    default Function4<T1, T2, T3, T4, Function1<T5, R>> curry4() {
        return (t1, t2, t3, t4) -> t5 -> this.apply5(t1, t2, t3, t4, t5);
    }
}
