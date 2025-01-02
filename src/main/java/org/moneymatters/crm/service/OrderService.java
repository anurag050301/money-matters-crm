package org.moneymatters.crm.service;

import org.moneymatters.crm.dto.OrderDto;
import org.moneymatters.crm.entity.Orders;

import java.util.Date;
import java.util.List;

public interface OrderService {

    public OrderDto toDto(Orders order);

    public Orders toEntity(OrderDto orderDto);

    public OrderDto addOrder(OrderDto orderDto, Long id);

    public List<OrderDto> allOrdersFromUser(Long id);

    public List<OrderDto> allOrders();

    public OrderDto findByOrderId(Long id);

    public List<OrderDto> orderSearch(String status, String amount, String date, String user_id);

    public OrderDto updateOrderDetail(OrderDto orderDto);

}
