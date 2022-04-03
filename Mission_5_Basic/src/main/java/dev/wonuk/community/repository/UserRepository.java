package dev.wonuk.community.repository;

import dev.wonuk.community.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
    Optional<UserEntity> findByUsername(String username);
}
