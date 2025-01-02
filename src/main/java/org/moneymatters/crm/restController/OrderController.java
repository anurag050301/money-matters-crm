package org.moneymatters.crm.restController;

import org.json.JSONObject;
import org.moneymatters.crm.dto.OrderDto;
import org.moneymatters.crm.dto.UserDto;
import org.moneymatters.crm.entity.Orders;
import org.moneymatters.crm.entity.Users;
import org.moneymatters.crm.service.OrderService;
import org.moneymatters.crm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;
    @Autowired
    private UserService userService;


    @GetMapping("/order/all")
    public ResponseEntity<?> getAllOrders() {
        List<OrderDto> allOrders = orderService.allOrders();
        return new ResponseEntity<>(allOrders, HttpStatus.OK);
    }

    @GetMapping("/{id}/user/orders")
    public ResponseEntity<?> getAllOrdersFromUser(@PathVariable Long id){
        List<OrderDto> orders = orderService.allOrdersFromUser(id);
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @PostMapping("/{id}/order/add")
    public ResponseEntity<?> addOrder(@RequestBody OrderDto orderDto, @PathVariable Long id){
        OrderDto dto = orderService.addOrder(orderDto, id);
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }
    @GetMapping("/order/{id}")
    public ResponseEntity<?> findOrderById(@PathVariable Long id){
        OrderDto dto = orderService.findByOrderId(id);
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }
    @GetMapping("/order/search")
    public ResponseEntity<?> findOrderByDate(@RequestBody String body){
        JSONObject obj = new JSONObject(body);
        String date = obj.getString("date");
        String user_id = obj.getString("userId");
        String amount = obj.getString("amount");
        String status = obj.getString("status");
        List<OrderDto> byDate = orderService.orderSearch(status, amount, date, user_id);
        return new ResponseEntity<>(byDate, HttpStatus.OK);
    }
}