package com.wonuk.mission02.challenge.board;

import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class InMemoryBoardRepositoryC implements BoardRepositoryC {
    private Long lastIndex = 0L;
    private final Map<Long, BoardDtoC> memory = new HashMap<>();

    @Override
    public BoardDtoC create(BoardDtoC dto) {
        lastIndex++;
        dto.setId(lastIndex);
        memory.put(lastIndex, dto);
        return memory.get(lastIndex);
    }

    @Override
    public BoardDtoC read(Long id) {
        return memory.getOrDefault(id, null);
    }

    @Override
    public Collection<BoardDtoC> readAll() {
        return memory.values();
    }

    @Override
    public boolean update(Long id, BoardDtoC dto) {
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
