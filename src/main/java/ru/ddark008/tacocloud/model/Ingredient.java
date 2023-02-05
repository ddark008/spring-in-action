package ru.ddark008.tacocloud.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Ingredient {
    @Id
    String id;
    String name;
    Type type;
    public enum Type {
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }
}
