package org.global.designsoftware.patterns.properties_lab.context.proect_A;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class User {
    private final String name;
    private final int age;
    private final String role;
}
