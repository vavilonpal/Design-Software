package org.global.designsoftware.patterns.properties_lab.context.procet_B;



import org.global.designsoftware.patterns.properties_lab.context.proect_A.DynamicExecutor;

import java.util.*;


public class Main {
    public static void main(String[] args) {
        Map<String, Object> user = new HashMap<>();
        user.put("name", "Alice");
        user.put("age", 22);
        user.put("role", "Admin");


        boolean adult = DynamicExecutor.isAdult(user);
        System.out.println("Is adult: " + adult);

        Object result = DynamicExecutor.execute(user, u -> u.get("name") + " has role " + u.get("role"));

        System.out.println(result);
    }
}
