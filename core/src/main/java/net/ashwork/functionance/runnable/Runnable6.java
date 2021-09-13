/*
 * Functionance
 * Copyright (c) 2021-2021 ChampionAsh5357.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package net.ashwork.functionance.runnable;

import net.ashwork.functionance.*;
import net.ashwork.functionance.partial.input.Input6;
import net.ashwork.functionance.partial.result.Chain;
import net.ashwork.functionance.partial.result.Default;
import net.ashwork.functionance.partial.task.Task6;
import net.ashwork.functionance.partial.transformer.Transformer1;

import java.util.Objects;

/**
 * Represents an operation that accepts six arguments and returns no result.
 *
 * <p>This is a functional interface whose functional method is
 * {@link #run6(Object, Object, Object, Object, Object, Object)}.
 *
 * @param <T1> the type of the first argument to the operation
 * @param <T2> the type of the second argument to the operation
 * @param <T3> the type of the third argument to the operation
 * @param <T4> the type of the fourth argument to the operation
 * @param <T5> the type of the fifth argument to the operation
 * @param <T6> the type of the sixth argument to the operation
 * @since 1.0.0
 */
@FunctionalInterface
public interface Runnable6<T1, T2, T3, T4, T5, T6> extends Input6<T1, T2, T3, T4, T5, T6>, Task6<T1, T2, T3, T4, T5, T6>, Chain<Runnable6<T1, T2, T3, T4, T5, T6>>, Default<Runnable6<T1, T2, T3, T4, T5, T6>> {

    /**
     * @throws NullPointerException if the {@code before} transformer is {@code null}
     */
    @Override
    default <V> Runnable6<T1, T2, T3, T4, T5, V> compose6(final Transformer1<? super V, ? extends T6> before) {
        Objects.requireNonNull(before, "The before transformer cannot be null");
        return (t1, t2, t3, t4, t5, v) -> this.run6(t1, t2, t3, t4, t5, before.apply1(v));
    }

    /**
     * @throws NullPointerException if the {@code before} transformer is {@code null}
     */
    @Override
    default <V> Runnable6<T1, T2, T3, T4, V, T6> compose5(final Transformer1<? super V, ? extends T5> before) {
        Objects.requireNonNull(before, "The before transformer cannot be null");
        return (t1, t2, t3, t4, v, t6) -> this.run6(t1, t2, t3, t4, before.apply1(v), t6);
    }

    /**
     * @throws NullPointerException if the {@code before} transformer is {@code null}
     */
    @Override
    default <V> Runnable6<T1, T2, T3, V, T5, T6> compose4(final Transformer1<? super V, ? extends T4> before) {
        Objects.requireNonNull(before, "The before transformer cannot be null");
        return (t1, t2, t3, v, t5, t6) -> this.run6(t1, t2, t3, before.apply1(v), t5, t6);
    }

    /**
     * @throws NullPointerException if the {@code before} transformer is {@code null}
     */
    @Override
    default <V> Runnable6<T1, T2, V, T4, T5, T6> compose3(final Transformer1<? super V, ? extends T3> before) {
        Objects.requireNonNull(before, "The before transformer cannot be null");
        return (t1, t2, v, t4, t5, t6) -> this.run6(t1, t2, before.apply1(v), t4, t5, t6);
    }

    /**
     * @throws NullPointerException if the {@code before} transformer is {@code null}
     */
    @Override
    default <V> Runnable6<T1, V, T3, T4, T5, T6> compose2(final Transformer1<? super V, ? extends T2> before) {
        Objects.requireNonNull(before, "The before transformer cannot be null");
        return (t1, v, t3, t4, t5, t6) -> this.run6(t1, before.apply1(v), t3, t4, t5, t6);
    }

    /**
     * @throws NullPointerException if the {@code before} transformer is {@code null}
     */
    @Override
    default <V> Runnable6<V, T2, T3, T4, T5, T6> compose1(final Transformer1<? super V, ? extends T1> before) {
        Objects.requireNonNull(before, "The before transformer cannot be null");
        return (v, t2, t3, t4, t5, t6) -> this.run6(before.apply1(v), t2, t3, t4, t5, t6);
    }

    /**
     * @throws NullPointerException if the exception handler or defaulted operation are {@code null}
     */
    @Override
    default Runnable6<T1, T2, T3, T4, T5, T6> handle(final Transformer1<Throwable, Runnable6<T1, T2, T3, T4, T5, T6>> exceptionHandler) {
        Objects.requireNonNull(exceptionHandler, "The exception handler of the operation cannot be null");
        return (t1, t2, t3, t4, t5, t6) -> {
            try {
                this.run6(t1, t2, t3, t4, t5, t6);
            } catch (final Throwable t) {
                Objects.requireNonNull(exceptionHandler.apply1(t), "The defaulted operation cannot be null").run6(t1, t2, t3, t4, t5, t6);
            }
        };
    }

    /**
     * @throws NullPointerException if the {@code after} operation is {@code null}
     */
    @Override
    default Runnable6<T1, T2, T3, T4, T5, T6> andThen(final Runnable6<T1, T2, T3, T4, T5, T6> after) {
        Objects.requireNonNull(after, "The after operation cannot be null");
        return (t1, t2, t3, t4, t5, t6) -> {
            this.run6(t1, t2, t3, t4, t5, t6);
            after.run6(t1, t2, t3, t4, t5, t6);
        };
    }

    /**
     * @throws NullPointerException if the {@code after} transformer is {@code null}
     * @see Function6
     */
    @Override
    default <V> Function6<T1, T2, T3, T4, T5, T6, V> andThen(final Transformer1<? super Void, ? extends V> after) {
        Objects.requireNonNull(after, "The after transformer cannot be null");
        return (t1, t2, t3, t4, t5, t6) -> after.apply1(this.apply6(t1, t2, t3, t4, t5, t6));
    }

    @Override
    default Runnable6<T1, T2, T3, T4, T6, T5> swap5() {
        return (t1, t2, t3, t4, t6, t5) -> this.run6(t1, t2, t3, t4, t5, t6);
    }

    @Override
    default Runnable6<T1, T2, T3, T5, T4, T6> swap4() {
        return (t1, t2, t3, t5, t4, t6) -> this.run6(t1, t2, t3, t4, t5, t6);
    }

    @Override
    default Runnable6<T1, T2, T4, T3, T5, T6> swap3() {
        return (t1, t2, t4, t3, t5, t6) -> this.run6(t1, t2, t3, t4, t5, t6);
    }

    @Override
    default Runnable6<T1, T3, T2, T4, T5, T6> swap2() {
        return (t1, t3, t2, t4, t5, t6) -> this.run6(t1, t2, t3, t4, t5, t6);
    }

    @Override
    default Runnable6<T2, T1, T3, T4, T5, T6> swap1() {
        return (t2, t1, t3, t4, t5, t6) -> this.run6(t1, t2, t3, t4, t5, t6);
    }

    @Override
    default Runnable5<T1, T2, T3, T4, T5> partial6(final T6 t6) {
        return (t1, t2, t3, t4, t5) -> this.run6(t1, t2, t3, t4, t5, t6);
    }

    @Override
    default Runnable5<T1, T2, T3, T4, T6> partial5(final T5 t5) {
        return (t1, t2, t3, t4, t6) -> this.run6(t1, t2, t3, t4, t5, t6);
    }

    @Override
    default Runnable5<T1, T2, T3, T5, T6> partial4(final T4 t4) {
        return (t1, t2, t3, t5, t6) -> this.run6(t1, t2, t3, t4, t5, t6);
    }

    @Override
    default Runnable5<T1, T2, T4, T5, T6> partial3(final T3 t3) {
        return (t1, t2, t4, t5, t6) -> this.run6(t1, t2, t3, t4, t5, t6);
    }

    @Override
    default Runnable5<T1, T3, T4, T5, T6> partial2(final T2 t2) {
        return (t1, t3, t4, t5, t6) -> this.run6(t1, t2, t3, t4, t5, t6);
    }

    @Override
    default Runnable5<T2, T3, T4, T5, T6> partial1(final T1 t1) {
        return (t2, t3, t4, t5, t6) -> this.run6(t1, t2, t3, t4, t5, t6);
    }

    /**
     * Constructs an operation of one arity higher where this operation can be
     * arbitrarily executed within the new operation.
     *
     * @param addend the transformer to create the new operation from this operation
     * @param <T7> the type of the seventh argument to the new operation
     * @return an operation of one arity higher
     * @throws NullPointerException if the {@code addend} transformer is {@code null}
     * @see Runnable7
     */
    default <T7> Runnable7<T1, T2, T3, T4, T5, T6, T7> append(final Transformer1<Runnable6<T1, T2, T3, T4, T5, T6>, Runnable7<T1, T2, T3, T4, T5, T6, T7>> addend) {
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
    default Function1<T1, Function1<T2, Function1<T3, Function1<T4, Function1<T5, Runnable1<T6>>>>>> curry() {
        return t1 -> t2 -> t3 -> t4 -> t5 -> t6 -> this.run6(t1, t2, t3, t4, t5, t6);
    }

    /**
     * Converts this operation into a sequence of two operations with each taking
     * one or five arguments respectively.
     *
     * @return a sequence of two operations
     * @see <a href="https://en.wikipedia.org/wiki/Currying">Currying</a>
     */
    default Function1<T1, Runnable5<T2, T3, T4, T5, T6>> curry1() {
        return t1 -> (t2, t3, t4, t5, t6) -> this.run6(t1, t2, t3, t4, t5, t6);
    }

    /**
     * Converts this operation into a sequence of two operations with each taking
     * two or four arguments respectively.
     *
     * @return a sequence of two operations
     * @see <a href="https://en.wikipedia.org/wiki/Currying">Currying</a>
     */
    default Function2<T1, T2, Runnable4<T3, T4, T5, T6>> curry2() {
        return (t1, t2) -> (t3, t4, t5, t6) -> this.run6(t1, t2, t3, t4, t5, t6);
    }

    /**
     * Converts this operation into a sequence of two operations with each taking
     * three arguments respectively.
     *
     * @return a sequence of two operations
     * @see <a href="https://en.wikipedia.org/wiki/Currying">Currying</a>
     */
    default Function3<T1, T2, T3, Runnable3<T4, T5, T6>> curry3() {
        return (t1, t2, t3) -> (t4, t5, t6) -> this.run6(t1, t2, t3, t4, t5, t6);
    }

    /**
     * Converts this operation into a sequence of two operations with each taking
     * four or two arguments respectively.
     *
     * @return a sequence of two operations
     * @see <a href="https://en.wikipedia.org/wiki/Currying">Currying</a>
     */
    default Function4<T1, T2, T3, T4, Runnable2<T5, T6>> curry5() {
        return (t1, t2, t3, t4) -> (t5, t6) -> this.run6(t1, t2, t3, t4, t5, t6);
    }

    /**
     * Converts this operation into a sequence of two operations with each taking
     * five or one argument respectively.
     *
     * @return a sequence of two operations
     * @see <a href="https://en.wikipedia.org/wiki/Currying">Currying</a>
     */
    default Function5<T1, T2, T3, T4, T5, Runnable1<T6>> curry6() {
        return (t1, t2, t3, t4, t5) -> t6 -> this.run6(t1, t2, t3, t4, t5, t6);
    }
}
