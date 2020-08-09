package com.gift.shop.repo;

import com.gift.shop.models.user.UsersRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UsersRequest, Integer> {
    boolean existsByEmail(String email);
}
