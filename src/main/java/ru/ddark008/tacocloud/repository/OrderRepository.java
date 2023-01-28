package ru.ddark008.tacocloud.repository;

import ru.ddark008.tacocloud.model.TacoOrder;

public interface OrderRepository {
    TacoOrder save(TacoOrder order);
}
