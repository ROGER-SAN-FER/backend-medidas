package medidasBackend.controller;

import lombok.RequiredArgsConstructor;
import medidasBackend.dto.MeasureDTO;
import medidasBackend.dto.UserDTO;
import medidasBackend.entity.Measure;
import medidasBackend.entity.User;
import medidasBackend.mapper.MeasureMapper;
import medidasBackend.mapper.UserMapper;
import medidasBackend.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;
    private final MeasureMapper measureMapper;

    @GetMapping
    public List<UserDTO> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return userMapper.toDtoList(users);
    }

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO dto) {
        User created = userService.registerUser(userMapper.toEntity(dto));
        return ResponseEntity.ok(userMapper.toDto(created));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUser(
            @PathVariable Long id,
            @RequestBody UserDTO dto) {
        dto.setId(id);
        User updated = userService.updateUser(userMapper.toEntity(dto));
        return ResponseEntity.ok(userMapper.toDto(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        return ResponseEntity.ok(userService.deleteUser(id));
    }

    @GetMapping("/{id}/measures")
    public List<MeasureDTO> getMeasuresByUser(@PathVariable Long id) {
        List<Measure> measures = userService.getAllMeasuresByUser(id);
        return measures.stream()
                .map(measureMapper::toDto)
                .toList();
    }
}
