package dev.wonuk.mission03.repository;

import dev.wonuk.mission03.entity.BoardEntity;
import dev.wonuk.mission03.entity.PostEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostRepository extends CrudRepository<PostEntity, Long> {
    List<PostEntity> findAllByWriter(String writer); // where writer = ?
    List<PostEntity> findAllByWriterAndBoardEntity(String writer, BoardEntity boardEntity); // where writer = ? and board_entity_id = ?
    List<PostEntity> findAllByWriterContaining(String writer);
}
