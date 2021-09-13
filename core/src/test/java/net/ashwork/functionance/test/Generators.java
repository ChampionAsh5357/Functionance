/*
 * Functionance
 * Copyright (c) 2021-2021 ChampionAsh5357.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package net.ashwork.functionance.test;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public final class Generators {

    public static final Random RANDOM = ThreadLocalRandom.current();

    public static String string(final int maxLength) {
        return RANDOM.ints(RANDOM.nextInt(maxLength) + 1, 97, 123)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    public static String[] strings(final int size, final int maxLength) {
        return IntStream.range(0, size).mapToObj(i -> string(maxLength)).toArray(String[]::new);
    }
}
