package org.moneymatters.crm.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.moneymatters.crm.entity.Orders;
import org.moneymatters.crm.entity.Users;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    private Long id;
    @NotBlank(message = "Date cannot be Blank")
    private Date date;
    @NotBlank(message = "Order Status cannot be Blank")
    private String status;
    @NotBlank(message = "Order Amount cannot be Blank")
    private BigDecimal amount;
    private Long userId;

    public OrderDto(Orders order){
        this.id = order.getId();
        this.amount = order.getAmount();
        this.date = order.getDate();
        this.status = order.getStatus();
        this.userId = order.getUsers().getId();
    }
}
