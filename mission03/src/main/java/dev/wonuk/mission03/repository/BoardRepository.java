package dev.wonuk.mission03.repository;

import dev.wonuk.mission03.entity.BoardEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends CrudRepository<BoardEntity, Long> {
}
