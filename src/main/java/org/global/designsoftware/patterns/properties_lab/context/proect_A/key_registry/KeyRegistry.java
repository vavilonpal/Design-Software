package org.global.designsoftware.patterns.properties_lab.context.proect_A.key_registry;


import lombok.NoArgsConstructor;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


@NoArgsConstructor
public final class KeyRegistry {
    private static final Map<String, TypedKey<?>> registry = new ConcurrentHashMap<>();



    @SuppressWarnings("unchecked")
    public static synchronized <T> TypedKey<T> registerKey(String name, Class<T> type) {
        TypedKey<?> existing = registry.get(name);

        if (existing != null) {
            if (!existing.getType().equals(type)) {
                throw new IllegalArgumentException(
                        "Key conflict: key '" + name + "' already registered for type "
                                + existing.getType().getName()
                                + ", cannot register for type " + type.getName());
            }
            return (TypedKey<T>) existing;
        }

        TypedKey<T> newKey = new TypedKey<>(name, type);
        registry.put(name, newKey);
        return newKey;
    }

    public static Map<String, TypedKey<?>> getAllKeys() {
        return Map.copyOf(registry);
    }
}
