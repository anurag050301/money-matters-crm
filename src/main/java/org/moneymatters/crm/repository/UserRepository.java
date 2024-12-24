package org.moneymatters.crm.repository;

import org.moneymatters.crm.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {}
