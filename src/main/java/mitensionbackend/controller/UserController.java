package mitensionbackend.controller;

import lombok.RequiredArgsConstructor;
import mitensionbackend.model.dto.MeasureDTO;
import mitensionbackend.model.dto.UserDTO;
import mitensionbackend.model.entity.Measure;
import mitensionbackend.model.entity.User;
import mitensionbackend.mapper.MeasureMapper;
import mitensionbackend.mapper.UserMapper;
import mitensionbackend.service.UserService;
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
//        List<User> users = userService.getAllUsers();
//        return userMapper.toDtoList(users);
        return userService.getAllUsers();
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
