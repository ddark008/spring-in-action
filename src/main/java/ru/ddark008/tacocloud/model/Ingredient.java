package ru.ddark008.tacocloud.model;

public record Ingredient(String id, String name, Type type) {
    public enum Type {
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }
}
