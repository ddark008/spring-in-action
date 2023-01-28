package ru.ddark008.tacocloud.repository;

import org.springframework.data.repository.CrudRepository;
import ru.ddark008.tacocloud.model.Ingredient;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {
}
