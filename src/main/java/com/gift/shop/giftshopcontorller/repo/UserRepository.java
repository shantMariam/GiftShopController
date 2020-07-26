package com.gift.shop.giftshopcontorller.repo;

import com.gift.shop.giftshopcontorller.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

@Repository
@NoRepositoryBean
public interface UserRepository extends JpaRepository<Users, Integer> {
}
