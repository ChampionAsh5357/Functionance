/*
 * Functionance
 * Copyright (c) 2021-2021 ChampionAsh5357.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

/**
 * Functionance is a project recreating Java functions to make them more
 * state-wise while still remaining completely typesafe. States can be tracked
 * via three identifiers: inputs, outputs, and transformers.
 *
 * <p>Input states represent the number of inputs the implementing object has
 * along with any transforms that can be performed on them. Each input can be
 * composed of a new input, swapped with an existing input, or fixed to create
 * an object with one less arity.
 *
 * <p>The output state represents the current output to the implementing object
 * itself. Any output can be chained to a new output or consumed to produce no
 * output.
 *
 * <p>Transformers are used to convert the inputs of an implementing object to
 * its output. Every transformer can operate on zero to all inputs it has access
 * to and provides the ability to handle any exception thrown. An extension done
 * by functions allows for new inputs to be appended onto the end of the existing
 * function or curry the function into some sequence of functions for execution.
 */
package net.ashwork.functionance;
