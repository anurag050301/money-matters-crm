package org.moneymatters.crm.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private Long id;
    @Column(name = "date",nullable = false)
    private Date date;
    @Column(name = "status",nullable = false)
    private String status;
    @Column(name = "amount",nullable = false)
    private BigDecimal amount;
    @ManyToOne
    @JsonIgnore
//    @ToString.Exclude
    @JoinColumn(name = "user_id",nullable = false, foreignKey=@ForeignKey(name = "Fk_users_orders"))
    private Users users;
}