package ru.ddark008.tacocloud.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Ingredient implements Persistable<String> {
    @Id
    String id;
    String name;
    Type type;

    // Need for ru.ddark008.tacocloud.configuration.H2Database.dataLoader
    // Because by default if Id not null CrudRepository will be merged not persisted
    // https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.entity-persistence.saving-entites
    @Override
    public boolean isNew() {
        return true;
    }

    public enum Type {
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }
}
