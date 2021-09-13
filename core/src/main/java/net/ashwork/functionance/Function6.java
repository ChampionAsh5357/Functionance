/*
 * Functionance
 * Copyright (c) 2021-2021 ChampionAsh5357.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package net.ashwork.functionance;

import net.ashwork.functionance.partial.input.Input6;
import net.ashwork.functionance.partial.result.Consume;
import net.ashwork.functionance.partial.result.Default;
import net.ashwork.functionance.partial.result.Result;
import net.ashwork.functionance.partial.transformer.Transformer1;
import net.ashwork.functionance.partial.transformer.Transformer6;
import net.ashwork.functionance.runnable.Runnable6;

import java.util.Objects;

/**
 * Represents a function that accepts six arguments and produces a result.
 *
 * <p>This is a functional interface whose functional method is
 * {@link #apply6(Object, Object, Object, Object, Object, Object)}.
 *
 * @param <T1> the type of the first argument to the function
 * @param <T2> the type of the second argument to the function
 * @param <T3> the type of the third argument to the function
 * @param <T4> the type of the fourth argument to the function
 * @param <T5> the type of the fifth argument to the function
 * @param <T6> the type of the sixth argument to the function
 * @param <R> the type of the result of the function
 * @since 1.0.0
 */
@FunctionalInterface
public interface Function6<T1, T2, T3, T4, T5, T6, R> extends Input6<T1, T2, T3, T4, T5, T6>, Transformer6<T1, T2, T3, T4, T5, T6, R>, Result<R>, Default<Function6<T1, T2, T3, T4, T5, T6, R>>, Consume<Runnable6<T1, T2, T3, T4, T5, T6>> {

    /**
     * @throws NullPointerException if the {@code before} transformer is {@code null}
     */
    @Override
    default <V> Function6<T1, T2, T3, T4, T5, V, R> compose6(final Transformer1<? super V, ? extends T6> before) {
        Objects.requireNonNull(before, "The before transformer cannot be null");
        return (t1, t2, t3, t4, t5, v) -> this.apply6(t1, t2, t3, t4, t5, before.apply1(v));
    }

    /**
     * @throws NullPointerException if the {@code before} transformer is {@code null}
     */
    @Override
    default <V> Function6<T1, T2, T3, T4, V, T6, R> compose5(final Transformer1<? super V, ? extends T5> before) {
        Objects.requireNonNull(before, "The before transformer cannot be null");
        return (t1, t2, t3, t4, v, t6) -> this.apply6(t1, t2, t3, t4, before.apply1(v), t6);
    }

    /**
     * @throws NullPointerException if the {@code before} transformer is {@code null}
     */
    @Override
    default <V> Function6<T1, T2, T3, V, T5, T6, R> compose4(final Transformer1<? super V, ? extends T4> before) {
        Objects.requireNonNull(before, "The before transformer cannot be null");
        return (t1, t2, t3, v, t5, t6) -> this.apply6(t1, t2, t3, before.apply1(v), t5, t6);
    }

    /**
     * @throws NullPointerException if the {@code before} transformer is {@code null}
     */
    @Override
    default <V> Function6<T1, T2, V, T4, T5, T6, R> compose3(final Transformer1<? super V, ? extends T3> before) {
        Objects.requireNonNull(before, "The before transformer cannot be null");
        return (t1, t2, v, t4, t5, t6) -> this.apply6(t1, t2, before.apply1(v), t4, t5, t6);
    }

    /**
     * @throws NullPointerException if the {@code before} transformer is {@code null}
     */
    @Override
    default <V> Function6<T1, V, T3, T4, T5, T6, R> compose2(final Transformer1<? super V, ? extends T2> before) {
        Objects.requireNonNull(before, "The before transformer cannot be null");
        return (t1, v, t3, t4, t5, t6) -> this.apply6(t1, before.apply1(v), t3, t4, t5, t6);
    }

    /**
     * @throws NullPointerException if the {@code before} transformer is {@code null}
     */
    @Override
    default <V> Function6<V, T2, T3, T4, T5, T6, R> compose1(final Transformer1<? super V, ? extends T1> before) {
        Objects.requireNonNull(before, "The before transformer cannot be null");
        return (v, t2, t3, t4, t5, t6) -> this.apply6(before.apply1(v), t2, t3, t4, t5, t6);
    }

    /**
     * @throws NullPointerException if the exception handler or defaulted function are {@code null}
     */
    @Override
    default Function6<T1, T2, T3, T4, T5, T6, R> handle(final Transformer1<Throwable, Function6<T1, T2, T3, T4, T5, T6, R>> exceptionHandler) {
        Objects.requireNonNull(exceptionHandler, "The exception handler of the function cannot be null");
        return (t1, t2, t3, t4, t5, t6) -> {
            try {
                return this.apply6(t1, t2, t3, t4, t5, t6);
            } catch (final Throwable t) {
                return Objects.requireNonNull(exceptionHandler.apply1(t), "The defaulted function cannot be null").apply6(t1, t2, t3, t4, t5, t6);
            }
        };
    }

    /**
     * @throws NullPointerException if the {@code after} transformer is {@code null}
     */
    @Override
    default <V> Function6<T1, T2, T3, T4, T5, T6, V> andThen(final Transformer1<? super R, ? extends V> after) {
        Objects.requireNonNull(after, "The after transformer cannot be null");
        return (t1, t2, t3, t4, t5, t6) -> after.apply1(this.apply6(t1, t2, t3, t4, t5, t6));
    }

    @Override
    default Function6<T1, T2, T3, T4, T6, T5, R> swap5() {
        return (t1, t2, t3, t4, t6, t5) -> this.apply6(t1, t2, t3, t4, t5, t6);
    }

    @Override
    default Function6<T1, T2, T3, T5, T4, T6, R> swap4() {
        return (t1, t2, t3, t5, t4, t6) -> this.apply6(t1, t2, t3, t4, t5, t6);
    }

    @Override
    default Function6<T1, T2, T4, T3, T5, T6, R> swap3() {
        return (t1, t2, t4, t3, t5, t6) -> this.apply6(t1, t2, t3, t4, t5, t6);
    }

    @Override
    default Function6<T1, T3, T2, T4, T5, T6, R> swap2() {
        return (t1, t3, t2, t4, t5, t6) -> this.apply6(t1, t2, t3, t4, t5, t6);
    }

    @Override
    default Function6<T2, T1, T3, T4, T5, T6, R> swap1() {
        return (t2, t1, t3, t4, t5, t6) -> this.apply6(t1, t2, t3, t4, t5, t6);
    }

    /**
     * @see Runnable6
     */
    @Override
    default Runnable6<T1, T2, T3, T4, T5, T6> consume() {
        return this::apply6;
    }

    @Override
    default Function5<T1, T2, T3, T4, T5, R> partial6(final T6 t6) {
        return (t1, t2, t3, t4, t5) -> this.apply6(t1, t2, t3, t4, t5, t6);
    }

    @Override
    default Function5<T1, T2, T3, T4, T6, R> partial5(final T5 t5) {
        return (t1, t2, t3, t4, t6) -> this.apply6(t1, t2, t3, t4, t5, t6);
    }

    @Override
    default Function5<T1, T2, T3, T5, T6, R> partial4(final T4 t4) {
        return (t1, t2, t3, t5, t6) -> this.apply6(t1, t2, t3, t4, t5, t6);
    }

    @Override
    default Function5<T1, T2, T4, T5, T6, R> partial3(final T3 t3) {
        return (t1, t2, t4, t5, t6) -> this.apply6(t1, t2, t3, t4, t5, t6);
    }

    @Override
    default Function5<T1, T3, T4, T5, T6, R> partial2(final T2 t2) {
        return (t1, t3, t4, t5, t6) -> this.apply6(t1, t2, t3, t4, t5, t6);
    }

    @Override
    default Function5<T2, T3, T4, T5, T6, R> partial1(final T1 t1) {
        return (t2, t3, t4, t5, t6) -> this.apply6(t1, t2, t3, t4, t5, t6);
    }

    /**
     * Constructs a function of one arity higher where this function can be
     * arbitrarily executed within the new function.
     *
     * @param addend the transformer to create the new function from this function
     * @param <T7> the type of the seventh argument to the new function
     * @return a function of one arity higher
     * @throws NullPointerException if the {@code addend} transformer is {@code null}
     * @see Function7
     */
    default <T7> Function7<T1, T2, T3, T4, T5, T6, T7, R> append(final Transformer1<Function6<T1, T2, T3, T4, T5, T6, R>, Function7<T1, T2, T3, T4, T5, T6, T7, R>> addend) {
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
    default Function1<T1, Function1<T2, Function1<T3, Function1<T4, Function1<T5, Function1<T6, R>>>>>> curry() {
        return t1 -> t2 -> t3 -> t4 -> t5 -> t6 -> this.apply6(t1, t2, t3, t4, t5, t6);
    }

    /**
     * Converts this function into a sequence of two functions with each taking
     * one or five arguments respectively.
     *
     * @return a sequence of two functions
     * @see <a href="https://en.wikipedia.org/wiki/Currying">Currying</a>
     */
    default Function1<T1, Function5<T2, T3, T4, T5, T6, R>> curry1() {
        return t1 -> (t2, t3, t4, t5, t6) -> this.apply6(t1, t2, t3, t4, t5, t6);
    }

    /**
     * Converts this function into a sequence of two functions with each taking
     * two or four arguments respectively.
     *
     * @return a sequence of two functions
     * @see <a href="https://en.wikipedia.org/wiki/Currying">Currying</a>
     */
    default Function2<T1, T2, Function4<T3, T4, T5, T6, R>> curry2() {
        return (t1, t2) -> (t3, t4, t5, t6) -> this.apply6(t1, t2, t3, t4, t5, t6);
    }

    /**
     * Converts this function into a sequence of two functions with each taking
     * three arguments respectively.
     *
     * @return a sequence of two functions
     * @see <a href="https://en.wikipedia.org/wiki/Currying">Currying</a>
     */
    default Function3<T1, T2, T3, Function3<T4, T5, T6, R>> curry3() {
        return (t1, t2, t3) -> (t4, t5, t6) -> this.apply6(t1, t2, t3, t4, t5, t6);
    }

    /**
     * Converts this function into a sequence of two functions with each taking
     * four or two arguments respectively.
     *
     * @return a sequence of two functions
     * @see <a href="https://en.wikipedia.org/wiki/Currying">Currying</a>
     */
    default Function4<T1, T2, T3, T4, Function2<T5, T6, R>> curry4() {
        return (t1, t2, t3, t4) -> (t5, t6) -> this.apply6(t1, t2, t3, t4, t5, t6);
    }

    /**
     * Converts this function into a sequence of two functions with each taking
     * five or one argument respectively.
     *
     * @return a sequence of two functions
     * @see <a href="https://en.wikipedia.org/wiki/Currying">Currying</a>
     */
    default Function5<T1, T2, T3, T4, T5, Function1<T6, R>> curry5() {
        return (t1, t2, t3, t4, t5) -> t6 -> this.apply6(t1, t2, t3, t4, t5, t6);
    }
}
