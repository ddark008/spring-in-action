package ru.ddark008.tacocloud.model;

import lombok.Data;
import org.springframework.lang.NonNull;

import java.util.ArrayList;
import java.util.List;

@Data
public class TacoOrder {
    private String deliveryName;
    private String deliveryStreet;
    private String deliveryCity;
    private String deliveryState;
    private String deliveryZip;
    private String ccNumber;
    private String ccExpiration;
    private String ccCVV;
    private final List<Taco> tacos = new ArrayList<>();
    public void addTaco(@NonNull Taco taco){
        tacos.add(taco);
    }
}
