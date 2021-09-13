/*
 * Functionance
 * Copyright (c) 2021-2021 ChampionAsh5357.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package net.ashwork.functionance;

import net.ashwork.functionance.partial.input.Input2;
import net.ashwork.functionance.partial.result.Consume;
import net.ashwork.functionance.partial.result.Default;
import net.ashwork.functionance.partial.result.Result;
import net.ashwork.functionance.partial.transformer.Transformer1;
import net.ashwork.functionance.partial.transformer.Transformer2;
import net.ashwork.functionance.runnable.Runnable2;

import java.util.Objects;

/**
 * Represents a function that accepts two arguments and produces a result.
 *
 * <p>This is a functional interface whose functional method is
 * {@link #apply2(Object, Object)}.
 *
 * @param <T1> the type of the first argument to the function
 * @param <T2> the type of the second argument to the function
 * @param <R> the type of the result of the function
 * @since 1.0.0
 */
@FunctionalInterface
public interface Function2<T1, T2, R> extends Input2<T1, T2>, Transformer2<T1, T2, R>, Result<R>, Default<Function2<T1, T2, R>>, Consume<Runnable2<T1, T2>> {

    /**
     * @throws NullPointerException if the {@code before} transformer is {@code null}
     */
    @Override
    default <V> Function2<T1, V, R> compose2(final Transformer1<? super V, ? extends T2> before) {
        Objects.requireNonNull(before, "The before transformer cannot be null");
        return (t1, v) -> this.apply2(t1, before.apply1(v));
    }

    /**
     * @throws NullPointerException if the {@code before} transformer is {@code null}
     */
    @Override
    default <V> Function2<V, T2, R> compose1(final Transformer1<? super V, ? extends T1> before) {
        Objects.requireNonNull(before, "The before transformer cannot be null");
        return (v, t2) -> this.apply2(before.apply1(v), t2);
    }

    /**
     * @throws NullPointerException if the exception handler or defaulted function are {@code null}
     */
    @Override
    default Function2<T1, T2, R> handle(final Transformer1<Throwable, Function2<T1, T2, R>> exceptionHandler) {
        Objects.requireNonNull(exceptionHandler, "The exception handler of the function cannot be null");
        return (t1, t2) -> {
            try {
                return this.apply2(t1, t2);
            } catch (final Throwable t) {
                return Objects.requireNonNull(exceptionHandler.apply1(t), "The defaulted function cannot be null").apply2(t1, t2);
            }
        };
    }

    /**
     * @throws NullPointerException if the {@code after} transformer is {@code null}
     */
    @Override
    default <V> Function2<T1, T2, V> andThen(final Transformer1<? super R, ? extends V> after) {
        Objects.requireNonNull(after, "The after transformer cannot be null");
        return (t1, t2) -> after.apply1(this.apply2(t1, t2));
    }

    @Override
    default Function2<T2, T1, R> swap1() {
        return (t2, t1) -> this.apply2(t1, t2);
    }

    /**
     * @see Runnable2
     */
    @Override
    default Runnable2<T1, T2> consume() {
        return this::apply2;
    }

    @Override
    default Function1<T1, R> partial2(final T2 t2) {
        return t1 -> this.apply2(t1, t2);
    }

    @Override
    default Function1<T2, R> partial1(final T1 t1) {
        return t2 -> this.apply2(t1, t2);
    }

    /**
     * Constructs a function of one arity higher where this function can be
     * arbitrarily executed within the new function.
     *
     * @param addend the transformer to create the new function from this function
     * @param <T3> the type of the third argument to the new function
     * @return a function of one arity higher
     * @throws NullPointerException if the {@code addend} transformer is {@code null}
     * @see Function3
     */
    default <T3> Function3<T1, T2, T3, R> append(final Transformer1<Function2<T1, T2, R>, Function3<T1, T2, T3, R>> addend) {
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
    default Function1<T1, Function1<T2, R>> curry() {
        return t1 -> t2 -> this.apply2(t1, t2);
    }
}
