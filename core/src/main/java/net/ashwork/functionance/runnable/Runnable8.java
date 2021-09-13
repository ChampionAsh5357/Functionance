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
import net.ashwork.functionance.partial.input.Input8;
import net.ashwork.functionance.partial.result.Chain;
import net.ashwork.functionance.partial.result.Default;
import net.ashwork.functionance.partial.task.Task8;
import net.ashwork.functionance.partial.transformer.Transformer1;

import java.util.Objects;

/**
 * Represents an operation that accepts eight arguments and returns no result.
 *
 * <p>This is a functional interface whose functional method is
 * {@link #run8(Object, Object, Object, Object, Object, Object, Object, Object)}.
 *
 * @param <T1> the type of the first argument to the operation
 * @param <T2> the type of the second argument to the operation
 * @param <T3> the type of the third argument to the operation
 * @param <T4> the type of the fourth argument to the operation
 * @param <T5> the type of the fifth argument to the operation
 * @param <T6> the type of the sixth argument to the operation
 * @param <T7> the type of the seventh argument to the operation
 * @param <T8> the type of the eighth argument to the operation
 * @since 1.0.0
 */
@FunctionalInterface
public interface Runnable8<T1, T2, T3, T4, T5, T6, T7, T8> extends Input8<T1, T2, T3, T4, T5, T6, T7, T8>, Task8<T1, T2, T3, T4, T5, T6, T7, T8>, Chain<Runnable8<T1, T2, T3, T4, T5, T6, T7, T8>>, Default<Runnable8<T1, T2, T3, T4, T5, T6, T7, T8>> {

    /**
     * @throws NullPointerException if the {@code before} transformer is {@code null}
     */
    @Override
    default <V> Runnable8<T1, T2, T3, T4, T5, T6, T7, V> compose8(final Transformer1<? super V, ? extends T8> before) {
        Objects.requireNonNull(before, "The before transformer cannot be null");
        return (t1, t2, t3, t4, t5, t6, t7, v) -> this.run8(t1, t2, t3, t4, t5, t6, t7, before.apply1(v));
    }

    /**
     * @throws NullPointerException if the {@code before} transformer is {@code null}
     */
    @Override
    default <V> Runnable8<T1, T2, T3, T4, T5, T6, V, T8> compose7(final Transformer1<? super V, ? extends T7> before) {
        Objects.requireNonNull(before, "The before transformer cannot be null");
        return (t1, t2, t3, t4, t5, t6, v, t8) -> this.run8(t1, t2, t3, t4, t5, t6, before.apply1(v), t8);
    }

    /**
     * @throws NullPointerException if the {@code before} transformer is {@code null}
     */
    @Override
    default <V> Runnable8<T1, T2, T3, T4, T5, V, T7, T8> compose6(final Transformer1<? super V, ? extends T6> before) {
        Objects.requireNonNull(before, "The before transformer cannot be null");
        return (t1, t2, t3, t4, t5, v, t7, t8) -> this.run8(t1, t2, t3, t4, t5, before.apply1(v), t7, t8);
    }

    /**
     * @throws NullPointerException if the {@code before} transformer is {@code null}
     */
    @Override
    default <V> Runnable8<T1, T2, T3, T4, V, T6, T7, T8> compose5(final Transformer1<? super V, ? extends T5> before) {
        Objects.requireNonNull(before, "The before transformer cannot be null");
        return (t1, t2, t3, t4, v, t6, t7, t8) -> this.run8(t1, t2, t3, t4, before.apply1(v), t6, t7, t8);
    }

    /**
     * @throws NullPointerException if the {@code before} transformer is {@code null}
     */
    @Override
    default <V> Runnable8<T1, T2, T3, V, T5, T6, T7, T8> compose4(final Transformer1<? super V, ? extends T4> before) {
        Objects.requireNonNull(before, "The before transformer cannot be null");
        return (t1, t2, t3, v, t5, t6, t7, t8) -> this.run8(t1, t2, t3, before.apply1(v), t5, t6, t7, t8);
    }

    /**
     * @throws NullPointerException if the {@code before} transformer is {@code null}
     */
    @Override
    default <V> Runnable8<T1, T2, V, T4, T5, T6, T7, T8> compose3(final Transformer1<? super V, ? extends T3> before) {
        Objects.requireNonNull(before, "The before transformer cannot be null");
        return (t1, t2, v, t4, t5, t6, t7, t8) -> this.run8(t1, t2, before.apply1(v), t4, t5, t6, t7, t8);
    }

    /**
     * @throws NullPointerException if the {@code before} transformer is {@code null}
     */
    @Override
    default <V> Runnable8<T1, V, T3, T4, T5, T6, T7, T8> compose2(final Transformer1<? super V, ? extends T2> before) {
        Objects.requireNonNull(before, "The before transformer cannot be null");
        return (t1, v, t3, t4, t5, t6, t7, t8) -> this.run8(t1, before.apply1(v), t3, t4, t5, t6, t7, t8);
    }

    /**
     * @throws NullPointerException if the {@code before} transformer is {@code null}
     */
    @Override
    default <V> Runnable8<V, T2, T3, T4, T5, T6, T7, T8> compose1(final Transformer1<? super V, ? extends T1> before) {
        Objects.requireNonNull(before, "The before transformer cannot be null");
        return (v, t2, t3, t4, t5, t6, t7, t8) -> this.run8(before.apply1(v), t2, t3, t4, t5, t6, t7, t8);
    }

    /**
     * @throws NullPointerException if the exception handler or defaulted operation are {@code null}
     */
    @Override
    default Runnable8<T1, T2, T3, T4, T5, T6, T7, T8> handle(final Transformer1<Throwable, Runnable8<T1, T2, T3, T4, T5, T6, T7, T8>> exceptionHandler) {
        Objects.requireNonNull(exceptionHandler, "The exception handler of the operation cannot be null");
        return (t1, t2, t3, t4, t5, t6, t7, t8) -> {
            try {
                this.run8(t1, t2, t3, t4, t5, t6, t7, t8);
            } catch (final Throwable t) {
                Objects.requireNonNull(exceptionHandler.apply1(t), "The defaulted operation cannot be null").run8(t1, t2, t3, t4, t5, t6, t7, t8);
            }
        };
    }

    /**
     * @throws NullPointerException if the {@code after} operation is {@code null}
     */
    @Override
    default Runnable8<T1, T2, T3, T4, T5, T6, T7, T8> andThen(final Runnable8<T1, T2, T3, T4, T5, T6, T7, T8> after) {
        Objects.requireNonNull(after, "The after operation cannot be null");
        return (t1, t2, t3, t4, t5, t6, t7, t8) -> {
            this.run8(t1, t2, t3, t4, t5, t6, t7, t8);
            after.run8(t1, t2, t3, t4, t5, t6, t7, t8);
        };
    }

    /**
     * @throws NullPointerException if the {@code after} transformer is {@code null}
     * @see Function8
     */
    @Override
    default <V> Function8<T1, T2, T3, T4, T5, T6, T7, T8, V> andThen(final Transformer1<? super Void, ? extends V> after) {
        Objects.requireNonNull(after, "The after transformer cannot be null");
        return (t1, t2, t3, t4, t5, t6, t7, t8) -> after.apply1(this.apply8(t1, t2, t3, t4, t5, t6, t7, t8));
    }

    @Override
    default Runnable8<T1, T2, T3, T4, T5, T6, T8, T7> swap7() {
        return (t1, t2, t3, t4, t5, t6, t8, t7) -> this.run8(t1, t2, t3, t4, t5, t6, t7, t8);
    }

    @Override
    default Runnable8<T1, T2, T3, T4, T5, T7, T6, T8> swap6() {
        return (t1, t2, t3, t4, t5, t7, t6, t8) -> this.run8(t1, t2, t3, t4, t5, t6, t7, t8);
    }

    @Override
    default Runnable8<T1, T2, T3, T4, T6, T5, T7, T8> swap5() {
        return (t1, t2, t3, t4, t6, t5, t7, t8) -> this.run8(t1, t2, t3, t4, t5, t6, t7, t8);
    }

    @Override
    default Runnable8<T1, T2, T3, T5, T4, T6, T7, T8> swap4() {
        return (t1, t2, t3, t5, t4, t6, t7, t8) -> this.run8(t1, t2, t3, t4, t5, t6, t7, t8);
    }

    @Override
    default Runnable8<T1, T2, T4, T3, T5, T6, T7, T8> swap3() {
        return (t1, t2, t4, t3, t5, t6, t7, t8) -> this.run8(t1, t2, t3, t4, t5, t6, t7, t8);
    }

    @Override
    default Runnable8<T1, T3, T2, T4, T5, T6, T7, T8> swap2() {
        return (t1, t3, t2, t4, t5, t6, t7, t8) -> this.run8(t1, t2, t3, t4, t5, t6, t7, t8);
    }

    @Override
    default Runnable8<T2, T1, T3, T4, T5, T6, T7, T8> swap1() {
        return (t2, t1, t3, t4, t5, t6, t7, t8) -> this.run8(t1, t2, t3, t4, t5, t6, t7, t8);
    }

    /**
     * Converts this operation into a sequence of operations that each take in
     * a single argument.
     *
     * @return a sequence of operations that each take in a single argument
     * @see <a href="https://en.wikipedia.org/wiki/Currying">Currying</a>
     */
    default Function1<T1, Function1<T2, Function1<T3, Function1<T4, Function1<T5, Function1<T6, Function1<T7, Runnable1<T8>>>>>>>> curry() {
        return t1 -> t2 -> t3 -> t4 -> t5 -> t6 -> t7 -> t8 -> this.run8(t1, t2, t3, t4, t5, t6, t7, t8);
    }

    /**
     * Converts this operation into a sequence of two operations with each taking
     * one or seven arguments respectively.
     *
     * @return a sequence of two operations
     * @see <a href="https://en.wikipedia.org/wiki/Currying">Currying</a>
     */
    default Function1<T1, Runnable7<T2, T3, T4, T5, T6, T7, T8>> curry1() {
        return t1 -> (t2, t3, t4, t5, t6, t7, t8) -> this.run8(t1, t2, t3, t4, t5, t6, t7, t8);
    }

    /**
     * Converts this operation into a sequence of two operations with each taking
     * two or six arguments respectively.
     *
     * @return a sequence of two operations
     * @see <a href="https://en.wikipedia.org/wiki/Currying">Currying</a>
     */
    default Function2<T1, T2, Runnable6<T3, T4, T5, T6, T7, T8>> curry2() {
        return (t1, t2) -> (t3, t4, t5, t6, t7, t8) -> this.run8(t1, t2, t3, t4, t5, t6, t7, t8);
    }

    /**
     * Converts this operation into a sequence of two operations with each taking
     * three or five arguments respectively.
     *
     * @return a sequence of two operations
     * @see <a href="https://en.wikipedia.org/wiki/Currying">Currying</a>
     */
    default Function3<T1, T2, T3, Runnable5<T4, T5, T6, T7, T8>> curry3() {
        return (t1, t2, t3) -> (t4, t5, t6, t7, t8) -> this.run8(t1, t2, t3, t4, t5, t6, t7, t8);
    }

    /**
     * Converts this operation into a sequence of two operations with each taking
     * four arguments respectively.
     *
     * @return a sequence of two operations
     * @see <a href="https://en.wikipedia.org/wiki/Currying">Currying</a>
     */
    default Function4<T1, T2, T3, T4, Runnable4<T5, T6, T7, T8>> curry5() {
        return (t1, t2, t3, t4) -> (t5, t6, t7, t8) -> this.run8(t1, t2, t3, t4, t5, t6, t7, t8);
    }

    /**
     * Converts this operation into a sequence of two operations with each taking
     * five or three arguments respectively.
     *
     * @return a sequence of two operations
     * @see <a href="https://en.wikipedia.org/wiki/Currying">Currying</a>
     */
    default Function5<T1, T2, T3, T4, T5, Runnable3<T6, T7, T8>> curry6() {
        return (t1, t2, t3, t4, t5) -> (t6, t7, t8) -> this.run8(t1, t2, t3, t4, t5, t6, t7, t8);
    }

    /**
     * Converts this operation into a sequence of two operations with each taking
     * six or two arguments respectively.
     *
     * @return a sequence of two operations
     * @see <a href="https://en.wikipedia.org/wiki/Currying">Currying</a>
     */
    default Function6<T1, T2, T3, T4, T5, T6, Runnable2<T7, T8>> curry7() {
        return (t1, t2, t3, t4, t5, t6) -> (t7, t8) -> this.run8(t1, t2, t3, t4, t5, t6, t7, t8);
    }

    @Override
    default Runnable7<T1, T2, T3, T4, T5, T6, T7> partial8(final T8 t8) {
        return (t1, t2, t3, t4, t5, t6, t7) -> this.run8(t1, t2, t3, t4, t5, t6, t7, t8);
    }

    @Override
    default Runnable7<T1, T2, T3, T4, T5, T6, T8> partial7(final T7 t7) {
        return (t1, t2, t3, t4, t5, t6, t8) -> this.run8(t1, t2, t3, t4, t5, t6, t7, t8);
    }

    @Override
    default Runnable7<T1, T2, T3, T4, T5, T7, T8> partial6(final T6 t6) {
        return (t1, t2, t3, t4, t5, t7, t8) -> this.run8(t1, t2, t3, t4, t5, t6, t7, t8);
    }

    @Override
    default Runnable7<T1, T2, T3, T4, T6, T7, T8> partial5(final T5 t5) {
        return (t1, t2, t3, t4, t6, t7, t8) -> this.run8(t1, t2, t3, t4, t5, t6, t7, t8);
    }

    @Override
    default Runnable7<T1, T2, T3, T5, T6, T7, T8> partial4(final T4 t4) {
        return (t1, t2, t3, t5, t6, t7, t8) -> this.run8(t1, t2, t3, t4, t5, t6, t7, t8);
    }

    @Override
    default Runnable7<T1, T2, T4, T5, T6, T7, T8> partial3(final T3 t3) {
        return (t1, t2, t4, t5, t6, t7, t8) -> this.run8(t1, t2, t3, t4, t5, t6, t7, t8);
    }

    @Override
    default Runnable7<T1, T3, T4, T5, T6, T7, T8> partial2(final T2 t2) {
        return (t1, t3, t4, t5, t6, t7, t8) -> this.run8(t1, t2, t3, t4, t5, t6, t7, t8);
    }

    @Override
    default Runnable7<T2, T3, T4, T5, T6, T7, T8> partial1(final T1 t1) {
        return (t2, t3, t4, t5, t6, t7, t8) -> this.run8(t1, t2, t3, t4, t5, t6, t7, t8);
    }

    /**
     * Converts this operation into a sequence of two operations with each taking
     * seven or one argument respectively.
     *
     * @return a sequence of two operations
     * @see <a href="https://en.wikipedia.org/wiki/Currying">Currying</a>
     */
    default Function7<T1, T2, T3, T4, T5, T6, T7, Runnable1<T8>> curry8() {
        return (t1, t2, t3, t4, t5, t6, t7) -> t8 -> this.run8(t1, t2, t3, t4, t5, t6, t7, t8);
    }
}
