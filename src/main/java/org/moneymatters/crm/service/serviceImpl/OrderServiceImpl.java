package org.moneymatters.crm.service.serviceImpl;

import org.modelmapper.ModelMapper;
import org.moneymatters.crm.dto.OrderDto;
import org.moneymatters.crm.entity.Orders;
import org.moneymatters.crm.entity.Users;
import org.moneymatters.crm.repository.OrderRepository;
import org.moneymatters.crm.repository.UserRepository;
import org.moneymatters.crm.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    final
    OrderRepository orderRepo;

    final
    ModelMapper orderMapper;

    final UserRepository userRepository;

    public OrderServiceImpl(OrderRepository orderRepo, ModelMapper orderMapper, UserRepository userRepository) {
        this.orderRepo = orderRepo;
        this.orderMapper = orderMapper;
        this.userRepository = userRepository;
    }


    @Override
    public OrderDto toDto(Orders order) {
        OrderDto orderDto = orderMapper.map(order, OrderDto.class);
        return orderDto;
    }

    @Override
    public Orders toEntity(OrderDto orderDto) {
        Orders order = orderMapper.map(orderDto, Orders.class);
        return order;
    }

    @Override
    public OrderDto addOrder(OrderDto orderDto, Long id) {
        Users user  = userRepository.findById(id).orElse(null);
        Orders order = this.toEntity(orderDto);
        order.setUsers(user);
        Orders orders = orderRepo.save(order);
        orderDto = this.toDto(orders);
        return orderDto;
    }

    @Override
    public List<OrderDto> allOrdersFromUser(Long id) {
        Users user = userRepository.findById(id).orElse(null);
        List<Orders> orders = orderRepo.findOrdersByUsers(user);
        List<OrderDto> allDto =new ArrayList<>();
        for(Orders order: orders ){
            allDto.add(this.toDto(order));
        }
        return allDto;
    }

    @Override
    public List<OrderDto> allOrders() {
        List<Orders> orders = orderRepo.findAll();
        List<OrderDto> allDto = new ArrayList<>();
        for(Orders order : orders){
            allDto.add(this.toDto(order));
        }
        return allDto;
    }

    @Override
    public OrderDto findByOrderId(Long id){
        Orders orders = orderRepo.findById(id).orElse(null);
        OrderDto orderDto = this.toDto(orders);
        return orderDto;
    }

    @Override
    public List<OrderDto> orderSearch(String status, String amount, String date, String userId) {
        List<OrderDto> allDto = new ArrayList<>();
        List<Orders> orders = orderRepo.findAllOrdersToUser(status, date, amount, userId);
        for(Orders order : orders)
            allDto.add(new OrderDto(order));
        return allDto;
    }

    @Override
    public OrderDto updateOrderDetail(OrderDto orderDto) {
        return null;
    }

}
