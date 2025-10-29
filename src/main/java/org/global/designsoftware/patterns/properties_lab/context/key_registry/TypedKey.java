package org.global.designsoftware.patterns.properties_lab.context.key_registry;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public final class TypedKey<T> {
    private final String name;
    private final Class<T> type;

    // фабричный метод через реестр
    public static <T> TypedKey<T> of(String name, Class<T> type) {
        return KeyRegistry.registerKey(name, type);
    }

    @Override
    public String toString() {
        return "TypedKey(" + name + ", " + type.getSimpleName() + ")";
    }
}