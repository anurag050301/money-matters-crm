package org.moneymatters.crm.repository;

import org.moneymatters.crm.entity.Users;
import org.moneymatters.crm.entity.Users;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<Users, Long> {

    Users findByUsername(String username);

    Users findByEmail(String email);

    Users findByPhoneNumber(String phoneNumber);
}
