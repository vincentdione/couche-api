package org.ovd.mapper;

import org.mapstruct.Mapper;
import org.ovd.dto.OrderItemDTO;
import org.ovd.entities.OrderItem;

import java.util.List;

@Mapper(componentModel = "cdi")
public interface IOrderItemMapper {
    OrderItemDTO toOrderItemDTO(OrderItem orderItem);
    OrderItem toOrderItem(OrderItemDTO orderItemDTO);


    List<OrderItemDTO> toOrderItemDTOs(List<OrderItem> orderItems);
    List<OrderItem> toOrderItems(List<OrderItemDTO> orderItemDTOs);
}
