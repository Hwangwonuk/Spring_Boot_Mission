package dev.wonuk.community.repository;

import dev.wonuk.community.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
  UserEntity findByUsername(String username);
}
