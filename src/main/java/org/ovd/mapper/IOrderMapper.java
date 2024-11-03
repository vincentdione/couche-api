package org.ovd.mapper;

import org.mapstruct.Mapper;
import org.ovd.dto.OrderDTO;
import org.ovd.entities.Order;

import java.util.List;

@Mapper(componentModel = "cdi")
public interface IOrderMapper {
    OrderDTO toOrderDTO(Order order);
    Order toOrder(OrderDTO orderDTO);


    List<OrderDTO> toOrderDTOs(List<Order> orders);
    List<Order> toOrders(List<OrderDTO> orderDTOs);

}
