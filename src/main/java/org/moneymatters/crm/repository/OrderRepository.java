package org.moneymatters.crm.repository;

import org.moneymatters.crm.entity.Orders;
import org.moneymatters.crm.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Orders, Long> {

    List<Orders> findOrdersByUsers(Users users);

    @Query(value = "SELECT * FROM orders as o WHERE o.status = ?1 or o.date = ?2 or o.amount = ?3 or o.user_id = ?4", nativeQuery = true)
    List<Orders> findAllOrdersToUser(String status, String date, String amount, String userId);
}