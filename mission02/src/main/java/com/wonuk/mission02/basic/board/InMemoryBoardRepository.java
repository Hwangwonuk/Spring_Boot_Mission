package com.wonuk.mission02.basic.board;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class InMemoryBoardRepository implements BoardRepository{
    private Long lastIndex = 0L;
    private final Map<Long, BoardDto> memory = new HashMap<>();

    @Override
    public BoardDto create(BoardDto dto) {
        lastIndex++;
        dto.setId(lastIndex);
        memory.put(lastIndex, dto);
        return memory.get(lastIndex);
    }

    @Override
    public BoardDto read(Long id) {
        return memory.getOrDefault(id, null);
    }

    @Override
    public Collection<BoardDto> readAll() {
        return memory.values();
    }

    @Override
    public boolean update(Long id, BoardDto dto) {
        if (memory.containsKey(id)) {
            dto.setId(id);
            memory.put(id, dto);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Long id) {
        if (memory.containsKey(id)) {
            memory.remove(id);
            return true;
        }
        return false;
    }
}
