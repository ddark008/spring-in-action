package ru.ddark008.tacocloud.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.ddark008.tacocloud.model.TacoOrder;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderRepository extends CrudRepository<TacoOrder, Long> {
    List<TacoOrder> findByDeliveryZip(String deliveryZip);

    List<TacoOrder> readTacoOrdersByDeliveryZipAndPlacedAtBetween(String deliveryZip, LocalDateTime startDate, LocalDateTime endDate);

    List<TacoOrder> findByAllIgnoringCaseDeliveryNameAndDeliveryCity(String deliveryTo, String deliveryCity);

    List<TacoOrder> findByDeliveryCityOrderByDeliveryName(String city);

    @Query("select o from TacoOrder o where o.deliveryCity='Seattle'")
    List<TacoOrder> readOrdersDeliveredInSeattle();
}
