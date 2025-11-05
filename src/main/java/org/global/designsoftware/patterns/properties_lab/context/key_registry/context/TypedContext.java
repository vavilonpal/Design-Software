package org.global.designsoftware.patterns.properties_lab.context.key_registry.context;

import org.global.designsoftware.patterns.properties_lab.context.key_registry.TypedKey;

import java.util.HashMap;
import java.util.Map;

public final class TypedContext {
    private final Map<TypedKey<?>, Object> data = new HashMap<>();

    public <T> void put(TypedKey<T> key, T value) {
        if (value != null && !key.getType().isInstance(value)) {
            throw new IllegalArgumentException(
                    "Invalid value type for key " + key.getName() +
                            ": expected " + key.getType().getSimpleName() +
                            ", got " + value.getClass().getSimpleName());
        }
        data.put(key, value);
    }

    @SuppressWarnings("unchecked")
    public <T> T get(TypedKey<T> key) {
        return (T) data.get(key);
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
