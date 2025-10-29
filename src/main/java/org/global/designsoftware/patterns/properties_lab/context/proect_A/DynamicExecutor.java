package org.global.designsoftware.patterns.properties_lab.context.proect_A;

import java.util.Map;
import java.util.function.Function;

public class DynamicExecutor {

    // Map (emulation of User.class)
    public static Object execute(Map<String, Object> entity, Function<Map<String, Object>, Object> operation) {
        return operation.apply(entity);
    }

    // Example of operation
    public static boolean isAdult(Map<String, Object> entity) {
        Object age = entity.get("age");
        return age instanceof Number && ((Number) age).intValue() >= 18;
    }
}
