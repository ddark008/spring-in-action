package ru.ddark008.tacocloud.repository;

import org.springframework.data.repository.CrudRepository;
import ru.ddark008.tacocloud.model.TacoOrder;

public interface OrderRepository extends CrudRepository<TacoOrder, Long> {
}
