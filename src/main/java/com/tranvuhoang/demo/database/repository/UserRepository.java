package com.tranvuhoang.demo.database.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tranvuhoang.demo.database.entity.lazy.User;

@Repository
public interface UserRepository extends JpaRepository<User, UUID>, UserRepositoryAdvanced {
}
