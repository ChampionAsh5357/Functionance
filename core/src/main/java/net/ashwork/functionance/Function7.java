/*
 * Functionance
 * Copyright (c) 2021-2021 ChampionAsh5357.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package net.ashwork.functionance;

import net.ashwork.functionance.partial.input.Input7;
import net.ashwork.functionance.partial.result.Consume;
import net.ashwork.functionance.partial.result.Default;
import net.ashwork.functionance.partial.result.Result;
import net.ashwork.functionance.partial.transformer.Transformer1;
import net.ashwork.functionance.partial.transformer.Transformer7;
import net.ashwork.functionance.runnable.Runnable7;

import java.util.Objects;

/**
 * Represents a function that accepts seven arguments and produces a result.
 *
 * <p>This is a functional interface whose functional method is
 * {@link #apply7(Object, Object, Object, Object, Object, Object, Object)}.
 *
 * @param <T1> the type of the first argument to the function
 * @param <T2> the type of the second argument to the function
 * @param <T3> the type of the third argument to the function
 * @param <T4> the type of the fourth argument to the function
 * @param <T5> the type of the fifth argument to the function
 * @param <T6> the type of the sixth argument to the function
 * @param <T7> the type of the seventh argument to the function
 * @param <R> the type of the result of the function
 * @since 1.0.0
 */
@FunctionalInterface
public interface Function7<T1, T2, T3, T4, T5, T6, T7, R> extends Input7<T1, T2, T3, T4, T5, T6, T7>, Transformer7<T1, T2, T3, T4, T5, T6, T7, R>, Result<R>, Default<Function7<T1, T2, T3, T4, T5, T6, T7, R>>, Consume<Runnable7<T1, T2, T3, T4, T5, T6, T7>> {

    /**
     * @throws NullPointerException if the {@code before} transformer is {@code null}
     */
    @Override
    default <V> Function7<T1, T2, T3, T4, T5, T6, V, R> compose7(final Transformer1<? super V, ? extends T7> before) {
        Objects.requireNonNull(before, "The before transformer cannot be null");
        return (t1, t2, t3, t4, t5, t6, v) -> this.apply7(t1, t2, t3, t4, t5, t6, before.apply1(v));
    }

    /**
     * @throws NullPointerException if the {@code before} transformer is {@code null}
     */
    @Override
    default <V> Function7<T1, T2, T3, T4, T5, V, T7, R> compose6(final Transformer1<? super V, ? extends T6> before) {
        Objects.requireNonNull(before, "The before transformer cannot be null");
        return (t1, t2, t3, t4, t5, v, t7) -> this.apply7(t1, t2, t3, t4, t5, before.apply1(v), t7);
    }

    /**
     * @throws NullPointerException if the {@code before} transformer is {@code null}
     */
    @Override
    default <V> Function7<T1, T2, T3, T4, V, T6, T7, R> compose5(final Transformer1<? super V, ? extends T5> before) {
        Objects.requireNonNull(before, "The before transformer cannot be null");
        return (t1, t2, t3, t4, v, t6, t7) -> this.apply7(t1, t2, t3, t4, before.apply1(v), t6, t7);
    }

    /**
     * @throws NullPointerException if the {@code before} transformer is {@code null}
     */
    @Override
    default <V> Function7<T1, T2, T3, V, T5, T6, T7, R> compose4(final Transformer1<? super V, ? extends T4> before) {
        Objects.requireNonNull(before, "The before transformer cannot be null");
        return (t1, t2, t3, v, t5, t6, t7) -> this.apply7(t1, t2, t3, before.apply1(v), t5, t6, t7);
    }

    /**
     * @throws NullPointerException if the {@code before} transformer is {@code null}
     */
    @Override
    default <V> Function7<T1, T2, V, T4, T5, T6, T7, R> compose3(final Transformer1<? super V, ? extends T3> before) {
        Objects.requireNonNull(before, "The before transformer cannot be null");
        return (t1, t2, v, t4, t5, t6, t7) -> this.apply7(t1, t2, before.apply1(v), t4, t5, t6, t7);
    }

    /**
     * @throws NullPointerException if the {@code before} transformer is {@code null}
     */
    @Override
    default <V> Function7<T1, V, T3, T4, T5, T6, T7, R> compose2(final Transformer1<? super V, ? extends T2> before) {
        Objects.requireNonNull(before, "The before transformer cannot be null");
        return (t1, v, t3, t4, t5, t6, t7) -> this.apply7(t1, before.apply1(v), t3, t4, t5, t6, t7);
    }

    /**
     * @throws NullPointerException if the {@code before} transformer is {@code null}
     */
    @Override
    default <V> Function7<V, T2, T3, T4, T5, T6, T7, R> compose1(final Transformer1<? super V, ? extends T1> before) {
        Objects.requireNonNull(before, "The before transformer cannot be null");
        return (v, t2, t3, t4, t5, t6, t7) -> this.apply7(before.apply1(v), t2, t3, t4, t5, t6, t7);
    }

    /**
     * @throws NullPointerException if the exception handler or defaulted function are {@code null}
     */
    @Override
    default Function7<T1, T2, T3, T4, T5, T6, T7, R> handle(final Transformer1<Throwable, Function7<T1, T2, T3, T4, T5, T6, T7, R>> exceptionHandler) {
        Objects.requireNonNull(exceptionHandler, "The exception handler of the function cannot be null");
        return (t1, t2, t3, t4, t5, t6, t7) -> {
            try {
                return this.apply7(t1, t2, t3, t4, t5, t6, t7);
            } catch (final Throwable t) {
                return Objects.requireNonNull(exceptionHandler.apply1(t), "The defaulted function cannot be null").apply7(t1, t2, t3, t4, t5, t6, t7);
            }
        };
    }

    /**
     * @throws NullPointerException if the {@code after} transformer is {@code null}
     */
    @Override
    default <V> Function7<T1, T2, T3, T4, T5, T6, T7, V> andThen(final Transformer1<? super R, ? extends V> after) {
        Objects.requireNonNull(after, "The after transformer cannot be null");
        return (t1, t2, t3, t4, t5, t6, t7) -> after.apply1(this.apply7(t1, t2, t3, t4, t5, t6, t7));
    }

    @Override
    default Function7<T1, T2, T3, T4, T5, T7, T6, R> swap6() {
        return (t1, t2, t3, t4, t5, t7, t6) -> this.apply7(t1, t2, t3, t4, t5, t6, t7);
    }

    @Override
    default Function7<T1, T2, T3, T4, T6, T5, T7, R> swap5() {
        return (t1, t2, t3, t4, t6, t5, t7) -> this.apply7(t1, t2, t3, t4, t5, t6, t7);
    }

    @Override
    default Function7<T1, T2, T3, T5, T4, T6, T7, R> swap4() {
        return (t1, t2, t3, t5, t4, t6, t7) -> this.apply7(t1, t2, t3, t4, t5, t6, t7);
    }

    @Override
    default Function7<T1, T2, T4, T3, T5, T6, T7, R> swap3() {
        return (t1, t2, t4, t3, t5, t6, t7) -> this.apply7(t1, t2, t3, t4, t5, t6, t7);
    }

    @Override
    default Function7<T1, T3, T2, T4, T5, T6, T7, R> swap2() {
        return (t1, t3, t2, t4, t5, t6, t7) -> this.apply7(t1, t2, t3, t4, t5, t6, t7);
    }

    @Override
    default Function7<T2, T1, T3, T4, T5, T6, T7, R> swap1() {
        return (t2, t1, t3, t4, t5, t6, t7) -> this.apply7(t1, t2, t3, t4, t5, t6, t7);
    }

    /**
     * @see Runnable7
     */
    @Override
    default Runnable7<T1, T2, T3, T4, T5, T6, T7> consume() {
        return this::apply7;
    }

    @Override
    default Function6<T1, T2, T3, T4, T5, T6, R> partial7(final T7 t7) {
        return (t1, t2, t3, t4, t5, t6) -> this.apply7(t1, t2, t3, t4, t5, t6, t7);
    }

    @Override
    default Function6<T1, T2, T3, T4, T5, T7, R> partial6(final T6 t6) {
        return (t1, t2, t3, t4, t5, t7) -> this.apply7(t1, t2, t3, t4, t5, t6, t7);
    }

    @Override
    default Function6<T1, T2, T3, T4, T6, T7, R> partial5(final T5 t5) {
        return (t1, t2, t3, t4, t6, t7) -> this.apply7(t1, t2, t3, t4, t5, t6, t7);
    }

    @Override
    default Function6<T1, T2, T3, T5, T6, T7, R> partial4(final T4 t4) {
        return (t1, t2, t3, t5, t6, t7) -> this.apply7(t1, t2, t3, t4, t5, t6, t7);
    }

    @Override
    default Function6<T1, T2, T4, T5, T6, T7, R> partial3(final T3 t3) {
        return (t1, t2, t4, t5, t6, t7) -> this.apply7(t1, t2, t3, t4, t5, t6, t7);
    }

    @Override
    default Function6<T1, T3, T4, T5, T6, T7, R> partial2(final T2 t2) {
        return (t1, t3, t4, t5, t6, t7) -> this.apply7(t1, t2, t3, t4, t5, t6, t7);
    }

    @Override
    default Function6<T2, T3, T4, T5, T6, T7, R> partial1(final T1 t1) {
        return (t2, t3, t4, t5, t6, t7) -> this.apply7(t1, t2, t3, t4, t5, t6, t7);
    }

    /**
     * Constructs a function of one arity higher where this function can be
     * arbitrarily executed within the new function.
     *
     * @param addend the transformer to create the new function from this function
     * @param <T8> the type of the eighth argument to the new function
     * @return a function of one arity higher
     * @throws NullPointerException if the {@code addend} transformer is {@code null}
     * @see Function8
     */
    default <T8> Function8<T1, T2, T3, T4, T5, T6, T7, T8, R> append(final Transformer1<Function7<T1, T2, T3, T4, T5, T6, T7, R>, Function8<T1, T2, T3, T4, T5, T6, T7, T8, R>> addend) {
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
    default Function1<T1, Function1<T2, Function1<T3, Function1<T4, Function1<T5, Function1<T6, Function1<T7, R>>>>>>> curry() {
        return t1 -> t2 -> t3 -> t4 -> t5 -> t6 -> t7 -> this.apply7(t1, t2, t3, t4, t5, t6, t7);
    }

    /**
     * Converts this function into a sequence of two functions with each taking
     * one or six arguments respectively.
     *
     * @return a sequence of two functions
     * @see <a href="https://en.wikipedia.org/wiki/Currying">Currying</a>
     */
    default Function1<T1, Function6<T2, T3, T4, T5, T6, T7, R>> curry1() {
        return t1 -> (t2, t3, t4, t5, t6, t7) -> this.apply7(t1, t2, t3, t4, t5, t6, t7);
    }

    /**
     * Converts this function into a sequence of two functions with each taking
     * two or five arguments respectively.
     *
     * @return a sequence of two functions
     * @see <a href="https://en.wikipedia.org/wiki/Currying">Currying</a>
     */
    default Function2<T1, T2, Function5<T3, T4, T5, T6, T7, R>> curry2() {
        return (t1, t2) -> (t3, t4, t5, t6, t7) -> this.apply7(t1, t2, t3, t4, t5, t6, t7);
    }

    /**
     * Converts this function into a sequence of two functions with each taking
     * three or four arguments respectively.
     *
     * @return a sequence of two functions
     * @see <a href="https://en.wikipedia.org/wiki/Currying">Currying</a>
     */
    default Function3<T1, T2, T3, Function4<T4, T5, T6, T7, R>> curry3() {
        return (t1, t2, t3) -> (t4, t5, t6, t7) -> this.apply7(t1, t2, t3, t4, t5, t6, t7);
    }

    /**
     * Converts this function into a sequence of two functions with each taking
     * four or three arguments respectively.
     *
     * @return a sequence of two functions
     * @see <a href="https://en.wikipedia.org/wiki/Currying">Currying</a>
     */
    default Function4<T1, T2, T3, T4, Function3<T5, T6, T7, R>> curry4() {
        return (t1, t2, t3, t4) -> (t5, t6, t7) -> this.apply7(t1, t2, t3, t4, t5, t6, t7);
    }

    /**
     * Converts this function into a sequence of two functions with each taking
     * five or two arguments respectively.
     *
     * @return a sequence of two functions
     * @see <a href="https://en.wikipedia.org/wiki/Currying">Currying</a>
     */
    default Function5<T1, T2, T3, T4, T5, Function2<T6, T7, R>> curry5() {
        return (t1, t2, t3, t4, t5) -> (t6, t7) -> this.apply7(t1, t2, t3, t4, t5, t6, t7);
    }

    /**
     * Converts this function into a sequence of two functions with each taking
     * six or one argument respectively.
     *
     * @return a sequence of two functions
     * @see <a href="https://en.wikipedia.org/wiki/Currying">Currying</a>
     */
    default Function6<T1, T2, T3, T4, T5, T6, Function1<T7, R>> curry6() {
        return (t1, t2, t3, t4, t5, t6) -> t7 -> this.apply7(t1, t2, t3, t4, t5, t6, t7);
    }
}
