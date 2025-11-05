package org.global.designsoftware.patterns.properties_lab.context.proect_A;

import org.global.designsoftware.patterns.properties_lab.context.key_registry.TypedKey;


public final class CommonKeys {
    //Give keys
    public static final TypedKey<String> USERNAME = TypedKey.of("username", String.class);
    public static final TypedKey<Integer> AGE = TypedKey.of("age", Integer.class);
}