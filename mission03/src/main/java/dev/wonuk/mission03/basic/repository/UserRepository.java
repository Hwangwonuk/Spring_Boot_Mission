package dev.wonuk.mission03.basic.repository;

import dev.wonuk.mission03.basic.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Long> {

}
