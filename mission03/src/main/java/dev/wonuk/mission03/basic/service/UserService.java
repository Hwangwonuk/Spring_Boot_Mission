package dev.wonuk.mission03.basic.service;

import dev.wonuk.mission03.basic.repository.UserRepository;
import dev.wonuk.mission03.basic.dto.UserDTO;
import dev.wonuk.mission03.basic.entity.UserEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserEntity createUser(UserDTO dto) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUserId(dto.getUserId());
        userEntity.setPassword(dto.getPassword());
        return this.userRepository.save(userEntity);
    }

    public Optional<UserEntity> getUser(Long id) {
        return this.userRepository.findById(id);
    }

    public void updateUser(Long id, UserDTO dto) {
        Optional<UserEntity> targetEntity = this.userRepository.findById(id);
        if (targetEntity.isEmpty()) throw new RuntimeException("해당 유저가 없습니다.");
        UserEntity userEntity = targetEntity.get();
        userEntity.setUserId(dto.getUserId());
        userEntity.setPassword(dto.getPassword());
        this.userRepository.save(userEntity);
    }

    public void deleteUser(Long id) {
        this.userRepository.deleteById(id);
    }
}
